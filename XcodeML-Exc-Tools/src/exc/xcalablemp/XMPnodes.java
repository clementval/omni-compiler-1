/*
 * $TSUKUBA_Release: $
 * $TSUKUBA_Copyright:
 *  $
 */

package exc.xcalablemp;

import exc.block.*;
import exc.object.*;
import java.util.Vector;

public class XMPnodes extends XMPobject {
  public final static int INHERIT_NULL		= -1;
  public final static int INHERIT_GLOBAL	= 10;
  public final static int INHERIT_EXEC		= 11;
  public final static int INHERIT_NODES		= 12;

  private Vector<Xobject> _rankVector;

  public XMPnodes(String name, int dim, Ident descId) {
    super(XMPobject.NODES, name, dim, descId);
    _rankVector = new Vector<Xobject>();

    for (int i = 0; i < dim; i++) {
      this.addLower(Xcons.IntConstant(1));
    }
  }

  public Xobject getSizeAt(int index) {
    return getUpperAt(index);
  }

  public void addRank(Xobject rank) {
    _rankVector.add(rank);
  }

  public Xobject getRankAt(int index) {
    return _rankVector.get(index);
  }

  public static void translateNodes(XobjList nodesDecl, XMPglobalDecl globalDecl,
                                    boolean isLocalPragma, PragmaBlock pb) throws XMPexception {
    // local parameters
    BlockList funcBlockList = null;
    XMPsymbolTable localXMPsymbolTable = null;
    if (isLocalPragma) {
      funcBlockList = XMPlocalDecl.findParentFunctionBlock(pb).getBody();
      localXMPsymbolTable = XMPlocalDecl.declXMPsymbolTable(pb);
    }

    // check name collision
    String nodesName = nodesDecl.getArg(0).getString();
    if (isLocalPragma) {
      XMPlocalDecl.checkObjectNameCollision(nodesName, funcBlockList, localXMPsymbolTable);
    } else {
      globalDecl.checkObjectNameCollision(nodesName);
    }

    // declare nodes desciptor
    Ident nodesDescId = null;
    if (isLocalPragma) {
      nodesDescId = XMPlocalDecl.addObjectId(XMP.DESC_PREFIX_ + nodesName, pb);
    } else {
      nodesDescId = globalDecl.declStaticIdent(XMP.DESC_PREFIX_ + nodesName, Xtype.voidPtrType);
    }

    // declare nodes object
    int nodesDim = 0;
    for (XobjArgs i = nodesDecl.getArg(1).getArgs(); i != null; i = i.nextArgs()) nodesDim++;
    if (nodesDim > XMP.MAX_DIM) {
      throw new XMPexception("nodes dimension should be less than " + (XMP.MAX_DIM + 1));
    }

    XMPnodes nodesObject = new XMPnodes(nodesName, nodesDim, nodesDescId);
    if (isLocalPragma) {
      localXMPsymbolTable.putXMPobject(nodesObject);
    } else {
      globalDecl.putXMPobject(nodesObject);
    }

    // create function call
    XobjList nodesArgs = Xcons.List(nodesDescId.getAddr(), Xcons.IntConstant(nodesDim));

    XobjList inheritDecl = (XobjList)nodesDecl.getArg(2);
    XMPpair<String, XobjList> inheritInfo = getInheritInfo(inheritDecl, globalDecl, localXMPsymbolTable);
    nodesArgs.mergeList(inheritInfo.getSecond());

    String allocType = "STATIC";
    for (XobjArgs i = nodesDecl.getArg(1).getArgs(); i != null; i = i.nextArgs()) {
      Xobject nodesSize = i.getArg();
      if (nodesSize == null) {
        allocType = "DYNAMIC";

        Ident nodesSizeId = null;
        if (isLocalPragma) {
          nodesSizeId = XMPlocalDecl.addObjectId(XMP.NODES_SIZE_PREFIX_ + nodesName, Xtype.intType, pb);
        } else {
          nodesSizeId = globalDecl.declStaticIdent(XMP.NODES_SIZE_PREFIX_ + nodesName, Xtype.intType);
        }

        nodesArgs.add(Xcons.Cast(Xtype.Pointer(Xtype.intType), nodesSizeId.getAddr()));
        nodesSize = nodesSizeId.Ref();
      } else {
        nodesArgs.add(Xcons.Cast(Xtype.intType, nodesSize));
      }

      nodesObject.addUpper(nodesSize);
    }

    for (int i = 0; i < nodesDim; i++) {
      Ident nodesRankId = null;
      if (isLocalPragma) {
        nodesRankId = XMPlocalDecl.addObjectId(XMP.NODES_RANK_PREFIX_ + nodesName + "_" + i, Xtype.intType, pb);
      } else {
        nodesRankId = globalDecl.declStaticIdent(XMP.NODES_RANK_PREFIX_ + nodesName + "_" + i, Xtype.intType);
      }

      nodesArgs.add(Xcons.Cast(Xtype.Pointer(Xtype.intType), nodesRankId.getAddr()));
      nodesObject.addRank(nodesRankId.Ref());
    }

    // add constructor call
    String initFuncName = null;
    initFuncName = new String("_XMP_init_nodes_" + allocType + "_" + inheritInfo.getFirst());

    if (isLocalPragma) {
      XMPlocalDecl.addConstructorCall(initFuncName, nodesArgs, globalDecl, pb);
      XMPlocalDecl.insertDestructorCall("_XMP_finalize_nodes", Xcons.List(nodesDescId.Ref()), globalDecl, pb);
    }
    else {
      globalDecl.addGlobalInitFuncCall(initFuncName, nodesArgs);
    }
  }

  public static XMPpair<String, XobjList> getInheritInfo(XobjList inheritDecl,
                                                         XMPglobalDecl globalDecl,
                                                         XMPsymbolTable localXMPsymbolTable) throws XMPexception {
    String inheritType = null;
    XobjList nodesArgs = Xcons.List();

    switch (inheritDecl.getArg(0).getInt()) {
      case INHERIT_GLOBAL:
        inheritType = "GLOBAL";
        break;
      case INHERIT_EXEC:
        inheritType = "EXEC";
        break;
      case INHERIT_NODES:
        {
          inheritType = "NODES";

          XobjList nodesRef = (XobjList)inheritDecl.getArg(1);
          if (nodesRef.getArg(0) == null) {
            inheritType += "_NUMBER";

            XobjList nodeNumberTriplet = (XobjList)nodesRef.getArg(1);
            // lower
            if (nodeNumberTriplet.getArg(0) == null) nodesArgs.add(Xcons.IntConstant(1));
            else nodesArgs.add(nodeNumberTriplet.getArg(0));
            // upper
            if (nodeNumberTriplet.getArg(1) == null) nodesArgs.add(globalDecl.getWorldSizeId().Ref());
            else nodesArgs.add(nodeNumberTriplet.getArg(1));
            // stride
            if (nodeNumberTriplet.getArg(2) == null) nodesArgs.add(Xcons.IntConstant(1));
            else nodesArgs.add(nodeNumberTriplet.getArg(2));
          } else {
            XMPnodes nodesRefObject = null;
            inheritType += "_NAMED";

            String nodesRefName = nodesRef.getArg(0).getString();

            nodesRefObject = globalDecl.getXMPnodes(nodesRefName, localXMPsymbolTable);
            if (nodesRefObject == null) {
              throw new XMPexception("cannot find nodes '" + nodesRefName + "'");
            }

            nodesArgs.add(nodesRefObject.getDescId().Ref());

            int nodesRefDim = nodesRefObject.getDim();
            XobjList subscriptList = (XobjList)nodesRef.getArg(1);
            if (subscriptList == null) {
              for (int nodesRefIndex = 0; nodesRefIndex < nodesRefDim; nodesRefIndex++) {
                // lower
                nodesArgs.add(Xcons.Cast(Xtype.intType, nodesRefObject.getLowerAt(nodesRefIndex)));
                // upper
                nodesArgs.add(Xcons.Cast(Xtype.intType, nodesRefObject.getUpperAt(nodesRefIndex)));
                // stride
                nodesArgs.add(Xcons.Cast(Xtype.intType, Xcons.IntConstant(1)));
              }
            }
            else {
              int nodesRefIndex = 0;
              for (XobjArgs i = subscriptList.getArgs(); i != null; i = i.nextArgs()) {
                if (nodesRefIndex == nodesRefDim)
                  throw new XMPexception("wrong nodes dimension indicated, too many");

                XobjList subscriptTriplet = (XobjList)i.getArg();
                if (subscriptTriplet == null) {
                  nodesArgs.add(Xcons.Cast(Xtype.intType, Xcons.IntConstant(1)));
                } else {
                  nodesArgs.add(Xcons.Cast(Xtype.intType, Xcons.IntConstant(0)));

                  // lower
                  if (subscriptTriplet.getArg(0) == null) {
                    nodesArgs.add(Xcons.Cast(Xtype.intType, nodesRefObject.getLowerAt(nodesRefIndex)));
                  } else {
                    nodesArgs.add(Xcons.Cast(Xtype.intType, subscriptTriplet.getArg(0)));
                  }
                  // upper
                  if (subscriptTriplet.getArg(1) == null) {
                    nodesArgs.add(Xcons.Cast(Xtype.intType, nodesRefObject.getUpperAt(nodesRefIndex)));
                  }
                  else nodesArgs.add(Xcons.Cast(Xtype.intType, subscriptTriplet.getArg(1)));
                  // stride
                  if (subscriptTriplet.getArg(2) == null) nodesArgs.add(Xcons.Cast(Xtype.intType, Xcons.IntConstant(1)));
                  else nodesArgs.add(Xcons.Cast(Xtype.intType, subscriptTriplet.getArg(2)));
                }

                nodesRefIndex++;
              }

              if (nodesRefIndex != nodesRefDim)
                throw new XMPexception("the number of <nodes-subscript> should be the same with the nodes dimension");
            }
          }
          break;
        }
      default:
        throw new XMPexception("cannot create sub node set, unknown operation in nodes directive");
    }

    return new XMPpair<String, XobjList>(inheritType, nodesArgs);
  }
}
