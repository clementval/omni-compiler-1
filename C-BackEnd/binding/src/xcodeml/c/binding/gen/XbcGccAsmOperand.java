/*
 * The Relaxer artifact
 * Copyright (c) 2000-2003, ASAMI Tomoharu, All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * - Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer. 
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package xcodeml.c.binding.gen;

import xcodeml.binding.*;

import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URL;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;

/**
 * <b>XbcGccAsmOperand</b> is generated from XcodeML_C.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element java:extends="xcodeml.c.obj.XmcObj" name="gccAsmOperand">
 *   <optional>
 *     <attribute name="match">
 *       <data type="string"/>
 *     </attribute>
 *   </optional>
 *   <attribute name="constraint">
 *     <data type="string"/>
 *   </attribute>
 *   <ref name="expressions"/>
 * </element>
 * -->
 * <!-- for javadoc -->
 * <pre> &lt;element java:extends="xcodeml.c.obj.XmcObj" name="gccAsmOperand"&gt;
 *   &lt;optional&gt;
 *     &lt;attribute name="match"&gt;
 *       &lt;data type="string"/&gt;
 *     &lt;/attribute&gt;
 *   &lt;/optional&gt;
 *   &lt;attribute name="constraint"&gt;
 *     &lt;data type="string"/&gt;
 *   &lt;/attribute&gt;
 *   &lt;ref name="expressions"/&gt;
 * &lt;/element&gt;
 * </pre>
 *
 * @version XcodeML_C.rng (Thu Feb 02 16:55:19 JST 2012)
 * @author  Relaxer 1.0 (http://www.relaxer.org)
 */
public class XbcGccAsmOperand extends xcodeml.c.obj.XmcObj implements java.io.Serializable, Cloneable, IRVisitable, IRNode {
    private String match_;
    private String constraint_;
    private IXbcExpressionsChoice expressions_;
    private IRNode parentRNode_;

    /**
     * Creates a <code>XbcGccAsmOperand</code>.
     *
     */
    public XbcGccAsmOperand() {
        constraint_ = "";
    }

    /**
     * Creates a <code>XbcGccAsmOperand</code>.
     *
     * @param source
     */
    public XbcGccAsmOperand(XbcGccAsmOperand source) {
        setup(source);
    }

    /**
     * Creates a <code>XbcGccAsmOperand</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public XbcGccAsmOperand(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>XbcGccAsmOperand</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public XbcGccAsmOperand(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>XbcGccAsmOperand</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public XbcGccAsmOperand(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>XbcGccAsmOperand</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public XbcGccAsmOperand(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>XbcGccAsmOperand</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public XbcGccAsmOperand(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>XbcGccAsmOperand</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public XbcGccAsmOperand(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>XbcGccAsmOperand</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public XbcGccAsmOperand(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>XbcGccAsmOperand</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public XbcGccAsmOperand(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>XbcGccAsmOperand</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public XbcGccAsmOperand(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>XbcGccAsmOperand</code> by the XbcGccAsmOperand <code>source</code>.
     *
     * @param source
     */
    public void setup(XbcGccAsmOperand source) {
        int size;
        setMatch(source.getMatch());
        setConstraint(source.getConstraint());
        if (source.expressions_ != null) {
            setExpressions((IXbcExpressionsChoice)source.getExpressions().clone());
        }
    }

    /**
     * Initializes the <code>XbcGccAsmOperand</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>XbcGccAsmOperand</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>XbcGccAsmOperand</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public void setup(RStack stack) {
        init(stack.popElement());
    }

    /**
     * @param element
     */
    private void init(Element element) {
        IXcodeML_CFactory factory = XcodeML_CFactory.getFactory();
        RStack stack = new RStack(element);
        match_ = URelaxer.getAttributePropertyAsString(element, "match");
        constraint_ = URelaxer.getAttributePropertyAsString(element, "constraint");
        if (XbcBuiltinOp.isMatch(stack)) {
            setExpressions(factory.createXbcBuiltinOp(stack));
        } else if (XbcSubArrayRef.isMatch(stack)) {
            setExpressions(factory.createXbcSubArrayRef(stack));
        } else if (XbcArrayRef.isMatch(stack)) {
            setExpressions(factory.createXbcArrayRef(stack));
        } else if (XbcFunctionCall.isMatch(stack)) {
            setExpressions(factory.createXbcFunctionCall(stack));
        } else if (XbcGccCompoundExpr.isMatch(stack)) {
            setExpressions(factory.createXbcGccCompoundExpr(stack));
        } else if (XbcCoArrayRef.isMatch(stack)) {
            setExpressions(factory.createXbcCoArrayRef(stack));
        } else if (XbcCastExpr.isMatch(stack)) {
            setExpressions(factory.createXbcCastExpr(stack));
        } else if (XbcCoArrayAssignExpr.isMatch(stack)) {
            setExpressions(factory.createXbcCoArrayAssignExpr(stack));
        } else if (XbcStringConstant.isMatch(stack)) {
            setExpressions(factory.createXbcStringConstant(stack));
        } else if (XbcVar.isMatch(stack)) {
            setExpressions(factory.createXbcVar(stack));
        } else if (XbcVarAddr.isMatch(stack)) {
            setExpressions(factory.createXbcVarAddr(stack));
        } else if (XbcArrayAddr.isMatch(stack)) {
            setExpressions(factory.createXbcArrayAddr(stack));
        } else if (XbcCompoundValueExpr.isMatch(stack)) {
            setExpressions(factory.createXbcCompoundValueExpr(stack));
        } else if (XbcCompoundValueAddrExpr.isMatch(stack)) {
            setExpressions(factory.createXbcCompoundValueAddrExpr(stack));
        } else if (XbcAddrOfExpr.isMatch(stack)) {
            setExpressions(factory.createXbcAddrOfExpr(stack));
        } else if (XbcXmpDescOf.isMatch(stack)) {
            setExpressions(factory.createXbcXmpDescOf(stack));
        } else if (XbcMinusExpr.isMatch(stack)) {
            setExpressions(factory.createXbcMinusExpr(stack));
        } else if (XbcLshiftExpr.isMatch(stack)) {
            setExpressions(factory.createXbcLshiftExpr(stack));
        } else if (XbcRshiftExpr.isMatch(stack)) {
            setExpressions(factory.createXbcRshiftExpr(stack));
        } else if (XbcAsgMulExpr.isMatch(stack)) {
            setExpressions(factory.createXbcAsgMulExpr(stack));
        } else if (XbcAsgModExpr.isMatch(stack)) {
            setExpressions(factory.createXbcAsgModExpr(stack));
        } else if (XbcAsgBitOrExpr.isMatch(stack)) {
            setExpressions(factory.createXbcAsgBitOrExpr(stack));
        } else if (XbcAsgBitXorExpr.isMatch(stack)) {
            setExpressions(factory.createXbcAsgBitXorExpr(stack));
        } else if (XbcLogNEQExpr.isMatch(stack)) {
            setExpressions(factory.createXbcLogNEQExpr(stack));
        } else if (XbcLogGEExpr.isMatch(stack)) {
            setExpressions(factory.createXbcLogGEExpr(stack));
        } else if (XbcLogGTExpr.isMatch(stack)) {
            setExpressions(factory.createXbcLogGTExpr(stack));
        } else if (XbcLogOrExpr.isMatch(stack)) {
            setExpressions(factory.createXbcLogOrExpr(stack));
        } else if (XbcIntConstant.isMatch(stack)) {
            setExpressions(factory.createXbcIntConstant(stack));
        } else if (XbcFloatConstant.isMatch(stack)) {
            setExpressions(factory.createXbcFloatConstant(stack));
        } else if (XbcLonglongConstant.isMatch(stack)) {
            setExpressions(factory.createXbcLonglongConstant(stack));
        } else if (XbcMoeConstant.isMatch(stack)) {
            setExpressions(factory.createXbcMoeConstant(stack));
        } else if (XbcFuncAddr.isMatch(stack)) {
            setExpressions(factory.createXbcFuncAddr(stack));
        } else if (XbcSizeOfExpr.isMatch(stack)) {
            setExpressions(factory.createXbcSizeOfExpr(stack));
        } else if (XbcGccAlignOfExpr.isMatch(stack)) {
            setExpressions(factory.createXbcGccAlignOfExpr(stack));
        } else if (XbcGccLabelAddr.isMatch(stack)) {
            setExpressions(factory.createXbcGccLabelAddr(stack));
        } else if (XbcAssignExpr.isMatch(stack)) {
            setExpressions(factory.createXbcAssignExpr(stack));
        } else if (XbcPlusExpr.isMatch(stack)) {
            setExpressions(factory.createXbcPlusExpr(stack));
        } else if (XbcMulExpr.isMatch(stack)) {
            setExpressions(factory.createXbcMulExpr(stack));
        } else if (XbcDivExpr.isMatch(stack)) {
            setExpressions(factory.createXbcDivExpr(stack));
        } else if (XbcModExpr.isMatch(stack)) {
            setExpressions(factory.createXbcModExpr(stack));
        } else if (XbcBitAndExpr.isMatch(stack)) {
            setExpressions(factory.createXbcBitAndExpr(stack));
        } else if (XbcBitOrExpr.isMatch(stack)) {
            setExpressions(factory.createXbcBitOrExpr(stack));
        } else if (XbcBitXorExpr.isMatch(stack)) {
            setExpressions(factory.createXbcBitXorExpr(stack));
        } else if (XbcAsgPlusExpr.isMatch(stack)) {
            setExpressions(factory.createXbcAsgPlusExpr(stack));
        } else if (XbcAsgMinusExpr.isMatch(stack)) {
            setExpressions(factory.createXbcAsgMinusExpr(stack));
        } else if (XbcAsgDivExpr.isMatch(stack)) {
            setExpressions(factory.createXbcAsgDivExpr(stack));
        } else if (XbcAsgLshiftExpr.isMatch(stack)) {
            setExpressions(factory.createXbcAsgLshiftExpr(stack));
        } else if (XbcAsgRshiftExpr.isMatch(stack)) {
            setExpressions(factory.createXbcAsgRshiftExpr(stack));
        } else if (XbcAsgBitAndExpr.isMatch(stack)) {
            setExpressions(factory.createXbcAsgBitAndExpr(stack));
        } else if (XbcLogEQExpr.isMatch(stack)) {
            setExpressions(factory.createXbcLogEQExpr(stack));
        } else if (XbcLogLEExpr.isMatch(stack)) {
            setExpressions(factory.createXbcLogLEExpr(stack));
        } else if (XbcLogLTExpr.isMatch(stack)) {
            setExpressions(factory.createXbcLogLTExpr(stack));
        } else if (XbcLogAndExpr.isMatch(stack)) {
            setExpressions(factory.createXbcLogAndExpr(stack));
        } else if (XbcCondExpr.isMatch(stack)) {
            setExpressions(factory.createXbcCondExpr(stack));
        } else if (XbcMemberAddr.isMatch(stack)) {
            setExpressions(factory.createXbcMemberAddr(stack));
        } else if (XbcMemberRef.isMatch(stack)) {
            setExpressions(factory.createXbcMemberRef(stack));
        } else if (XbcMemberArrayRef.isMatch(stack)) {
            setExpressions(factory.createXbcMemberArrayRef(stack));
        } else if (XbcMemberArrayAddr.isMatch(stack)) {
            setExpressions(factory.createXbcMemberArrayAddr(stack));
        } else if (XbcPointerRef.isMatch(stack)) {
            setExpressions(factory.createXbcPointerRef(stack));
        } else if (XbcUnaryMinusExpr.isMatch(stack)) {
            setExpressions(factory.createXbcUnaryMinusExpr(stack));
        } else if (XbcBitNotExpr.isMatch(stack)) {
            setExpressions(factory.createXbcBitNotExpr(stack));
        } else if (XbcLogNotExpr.isMatch(stack)) {
            setExpressions(factory.createXbcLogNotExpr(stack));
        } else if (XbcCommaExpr.isMatch(stack)) {
            setExpressions(factory.createXbcCommaExpr(stack));
        } else if (XbcPostIncrExpr.isMatch(stack)) {
            setExpressions(factory.createXbcPostIncrExpr(stack));
        } else if (XbcPostDecrExpr.isMatch(stack)) {
            setExpressions(factory.createXbcPostDecrExpr(stack));
        } else if (XbcPreIncrExpr.isMatch(stack)) {
            setExpressions(factory.createXbcPreIncrExpr(stack));
        } else if (XbcPreDecrExpr.isMatch(stack)) {
            setExpressions(factory.createXbcPreDecrExpr(stack));
        } else {
            throw (new IllegalArgumentException());
        }
    }

    /**
     * @return Object
     */
    public Object clone() {
        IXcodeML_CFactory factory = XcodeML_CFactory.getFactory();
        return (factory.createXbcGccAsmOperand(this));
    }

    /**
     * Creates a DOM representation of the object.
     * Result is appended to the Node <code>parent</code>.
     *
     * @param parent
     */
    public void makeElement(Node parent) {
        Document doc;
        if (parent instanceof Document) {
            doc = (Document)parent;
        } else {
            doc = parent.getOwnerDocument();
        }
        Element element = doc.createElement("gccAsmOperand");
        int size;
        if (this.match_ != null) {
            URelaxer.setAttributePropertyByString(element, "match", this.match_);
        }
        if (this.constraint_ != null) {
            URelaxer.setAttributePropertyByString(element, "constraint", this.constraint_);
        }
        this.expressions_.makeElement(element);
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>XbcGccAsmOperand</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public void setup(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file.toURL());
    }

    /**
     * Initializes the <code>XbcGccAsmOperand</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public void setup(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(UJAXP.getDocument(uri, UJAXP.FLAG_NONE));
    }

    /**
     * Initializes the <code>XbcGccAsmOperand</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public void setup(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(UJAXP.getDocument(url, UJAXP.FLAG_NONE));
    }

    /**
     * Initializes the <code>XbcGccAsmOperand</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public void setup(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(UJAXP.getDocument(in, UJAXP.FLAG_NONE));
    }

    /**
     * Initializes the <code>XbcGccAsmOperand</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public void setup(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(UJAXP.getDocument(is, UJAXP.FLAG_NONE));
    }

    /**
     * Initializes the <code>XbcGccAsmOperand</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public void setup(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(UJAXP.getDocument(reader, UJAXP.FLAG_NONE));
    }

    /**
     * Creates a DOM document representation of the object.
     *
     * @exception ParserConfigurationException
     * @return Document
     */
    public Document makeDocument() throws ParserConfigurationException {
        Document doc = UJAXP.makeDocument();
        makeElement(doc);
        return (doc);
    }

    /**
     * Gets the String property <b>match</b>.
     *
     * @return String
     */
    public final String getMatch() {
        return (match_);
    }

    /**
     * Sets the String property <b>match</b>.
     *
     * @param match
     */
    public final void setMatch(String match) {
        this.match_ = match;
    }

    /**
     * Gets the String property <b>constraint</b>.
     *
     * @return String
     */
    public final String getConstraint() {
        return (constraint_);
    }

    /**
     * Sets the String property <b>constraint</b>.
     *
     * @param constraint
     */
    public final void setConstraint(String constraint) {
        this.constraint_ = constraint;
    }

    /**
     * Gets the IXbcExpressionsChoice property <b>expressions</b>.
     *
     * @return IXbcExpressionsChoice
     */
    public final IXbcExpressionsChoice getExpressions() {
        return (expressions_);
    }

    /**
     * Sets the IXbcExpressionsChoice property <b>expressions</b>.
     *
     * @param expressions
     */
    public final void setExpressions(IXbcExpressionsChoice expressions) {
        this.expressions_ = expressions;
        if (expressions != null) {
            expressions.rSetParentRNode(this);
        }
    }

    /**
     * Makes an XML text representation.
     *
     * @return String
     */
    public String makeTextDocument() {
        StringBuffer buffer = new StringBuffer();
        makeTextElement(buffer);
        return (new String(buffer));
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(StringBuffer buffer) {
        int size;
        buffer.append("<gccAsmOperand");
        if (match_ != null) {
            buffer.append(" match=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getMatch())));
            buffer.append("\"");
        }
        if (constraint_ != null) {
            buffer.append(" constraint=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getConstraint())));
            buffer.append("\"");
        }
        expressions_.makeTextAttribute(buffer);
        buffer.append(">");
        expressions_.makeTextElement(buffer);
        buffer.append("</gccAsmOperand>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     * @exception IOException
     */
    public void makeTextElement(Writer buffer) throws IOException {
        int size;
        buffer.write("<gccAsmOperand");
        if (match_ != null) {
            buffer.write(" match=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getMatch())));
            buffer.write("\"");
        }
        if (constraint_ != null) {
            buffer.write(" constraint=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getConstraint())));
            buffer.write("\"");
        }
        expressions_.makeTextAttribute(buffer);
        buffer.write(">");
        expressions_.makeTextElement(buffer);
        buffer.write("</gccAsmOperand>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(PrintWriter buffer) {
        int size;
        buffer.print("<gccAsmOperand");
        if (match_ != null) {
            buffer.print(" match=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getMatch())));
            buffer.print("\"");
        }
        if (constraint_ != null) {
            buffer.print(" constraint=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getConstraint())));
            buffer.print("\"");
        }
        expressions_.makeTextAttribute(buffer);
        buffer.print(">");
        expressions_.makeTextElement(buffer);
        buffer.print("</gccAsmOperand>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextAttribute(StringBuffer buffer) {
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     * @exception IOException
     */
    public void makeTextAttribute(Writer buffer) throws IOException {
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextAttribute(PrintWriter buffer) {
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getMatchAsString() {
        return (URelaxer.getString(getMatch()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getConstraintAsString() {
        return (URelaxer.getString(getConstraint()));
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setMatchByString(String string) {
        setMatch(string);
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setConstraintByString(String string) {
        setConstraint(string);
    }

    /**
     * Returns a String representation of this object.
     * While this method informs as XML format representaion, 
     *  it's purpose is just information, not making 
     * a rigid XML documentation.
     *
     * @return String
     */
    public String toString() {
        try {
            return (makeTextDocument());
        } catch (Exception e) {
            return (super.toString());
        }
    }

    /**
     * Accepts the Visitor for enter behavior.
     *
     * @param visitor
     * @return boolean
     */
    public boolean enter(IRVisitor visitor) {
        return (visitor.enter(this));
    }

    /**
     * Accepts the Visitor for leave behavior.
     *
     * @param visitor
     */
    public void leave(IRVisitor visitor) {
        visitor.leave(this);
    }

    /**
     * Gets the IRNode property <b>parentRNode</b>.
     *
     * @return IRNode
     */
    public final IRNode rGetParentRNode() {
        return (parentRNode_);
    }

    /**
     * Sets the IRNode property <b>parentRNode</b>.
     *
     * @param parentRNode
     */
    public final void rSetParentRNode(IRNode parentRNode) {
        this.parentRNode_ = parentRNode;
    }

    /**
     * Gets child RNodes.
     *
     * @return IRNode[]
     */
    public IRNode[] rGetRNodes() {
        java.util.List classNodes = new java.util.ArrayList();
        if (expressions_ != null) {
            classNodes.add(expressions_);
        }
        IRNode[] nodes = new IRNode[classNodes.size()];
        return ((IRNode[])classNodes.toArray(nodes));
    }

    /**
     * Tests if a Element <code>element</code> is valid
     * for the <code>XbcGccAsmOperand</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer.isTargetElement(element, "gccAsmOperand")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        if (!URelaxer.hasAttributeHungry(target, "constraint")) {
            return (false);
        }
        $match$ = true;
        if (XbcBuiltinOp.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcSubArrayRef.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcArrayRef.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcFunctionCall.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcGccCompoundExpr.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcCoArrayRef.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcCastExpr.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcCoArrayAssignExpr.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcStringConstant.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcVar.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcVarAddr.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcArrayAddr.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcCompoundValueExpr.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcCompoundValueAddrExpr.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcAddrOfExpr.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcXmpDescOf.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcMinusExpr.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcLshiftExpr.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcRshiftExpr.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcAsgMulExpr.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcAsgModExpr.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcAsgBitOrExpr.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcAsgBitXorExpr.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcLogNEQExpr.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcLogGEExpr.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcLogGTExpr.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcLogOrExpr.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcIntConstant.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcFloatConstant.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcLonglongConstant.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcMoeConstant.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcFuncAddr.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcSizeOfExpr.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcGccAlignOfExpr.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcGccLabelAddr.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcAssignExpr.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcPlusExpr.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcMulExpr.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcDivExpr.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcModExpr.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcBitAndExpr.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcBitOrExpr.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcBitXorExpr.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcAsgPlusExpr.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcAsgMinusExpr.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcAsgDivExpr.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcAsgLshiftExpr.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcAsgRshiftExpr.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcAsgBitAndExpr.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcLogEQExpr.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcLogLEExpr.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcLogLTExpr.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcLogAndExpr.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcCondExpr.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcMemberAddr.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcMemberRef.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcMemberArrayRef.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcMemberArrayAddr.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcPointerRef.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcUnaryMinusExpr.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcBitNotExpr.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcLogNotExpr.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcCommaExpr.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcPostIncrExpr.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcPostDecrExpr.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcPreIncrExpr.isMatchHungry(target)) {
            $match$ = true;
        } else if (XbcPreDecrExpr.isMatchHungry(target)) {
            $match$ = true;
        } else {
            return (false);
        }
        if (!target.isEmptyElement()) {
            return (false);
        }
        return (true);
    }

    /**
     * Tests if elements contained in a Stack <code>stack</code>
     * is valid for the <code>XbcGccAsmOperand</code>.
     * This mehtod is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     * @return boolean
     */
    public static boolean isMatch(RStack stack) {
        Element element = stack.peekElement();
        if (element == null) {
            return (false);
        }
        return (isMatch(element));
    }

    /**
     * Tests if elements contained in a Stack <code>stack</code>
     * is valid for the <code>XbcGccAsmOperand</code>.
     * This method consumes the stack contents during matching operation.
     * This mehtod is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     * @return boolean
     */
    public static boolean isMatchHungry(RStack stack) {
        Element element = stack.peekElement();
        if (element == null) {
            return (false);
        }
        if (isMatch(element)) {
            stack.popElement();
            return (true);
        } else {
            return (false);
        }
    }
}