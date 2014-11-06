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
package xcodeml.f.binding.gen;

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
 * <b>XbfFdeallocateStatement</b> is generated from XcodeML_F.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element java:extends="xcodeml.f.XmfObj" java:implements="xcodeml.binding.IXbStatement" name="FdeallocateStatement">
 *   <ref name="defAttrSourceLine"/>
 *   <ref name="defAttrStatName"/>
 *   <oneOrMore>
 *     <ref name="alloc"/>
 *   </oneOrMore>
 * </element>
 * -->
 * <!-- for javadoc -->
 * <pre> &lt;element java:extends="xcodeml.f.XmfObj" java:implements="xcodeml.binding.IXbStatement" name="FdeallocateStatement"&gt;
 *   &lt;ref name="defAttrSourceLine"/&gt;
 *   &lt;ref name="defAttrStatName"/&gt;
 *   &lt;oneOrMore&gt;
 *     &lt;ref name="alloc"/&gt;
 *   &lt;/oneOrMore&gt;
 * &lt;/element&gt;
 * </pre>
 *
 * @version XcodeML_F.rng (Mon Jan 23 20:53:33 JST 2012)
 * @author  Relaxer 1.0 (http://www.relaxer.org)
 */
public class XbfFdeallocateStatement extends xcodeml.f.XmfObj implements java.io.Serializable, Cloneable, xcodeml.binding.IXbStatement, IRVisitable, IRNode, IXbfDefModelStatementChoice {
    private String lineno_;
    private String endlineno_;
    private String rawlineno_;
    private String file_;
    private String statName_;
    // List<XbfAlloc>
    private java.util.List alloc_ = new java.util.ArrayList();
    private IRNode parentRNode_;

    /**
     * Creates a <code>XbfFdeallocateStatement</code>.
     *
     */
    public XbfFdeallocateStatement() {
    }

    /**
     * Creates a <code>XbfFdeallocateStatement</code>.
     *
     * @param source
     */
    public XbfFdeallocateStatement(XbfFdeallocateStatement source) {
        setup(source);
    }

    /**
     * Creates a <code>XbfFdeallocateStatement</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public XbfFdeallocateStatement(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>XbfFdeallocateStatement</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public XbfFdeallocateStatement(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>XbfFdeallocateStatement</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public XbfFdeallocateStatement(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>XbfFdeallocateStatement</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public XbfFdeallocateStatement(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>XbfFdeallocateStatement</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public XbfFdeallocateStatement(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>XbfFdeallocateStatement</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public XbfFdeallocateStatement(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>XbfFdeallocateStatement</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public XbfFdeallocateStatement(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>XbfFdeallocateStatement</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public XbfFdeallocateStatement(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>XbfFdeallocateStatement</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public XbfFdeallocateStatement(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>XbfFdeallocateStatement</code> by the XbfFdeallocateStatement <code>source</code>.
     *
     * @param source
     */
    public void setup(XbfFdeallocateStatement source) {
        int size;
        setLineno(source.getLineno());
        setEndlineno(source.getEndlineno());
        setRawlineno(source.getRawlineno());
        setFile(source.getFile());
        setStatName(source.getStatName());
        this.alloc_.clear();
        size = source.alloc_.size();
        for (int i = 0;i < size;i++) {
            addAlloc((XbfAlloc)source.getAlloc(i).clone());
        }
    }

    /**
     * Initializes the <code>XbfFdeallocateStatement</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>XbfFdeallocateStatement</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>XbfFdeallocateStatement</code> by the Stack <code>stack</code>
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
        IXcodeML_FFactory factory = XcodeML_FFactory.getFactory();
        RStack stack = new RStack(element);
        lineno_ = URelaxer.getAttributePropertyAsString(element, "lineno");
        endlineno_ = URelaxer.getAttributePropertyAsString(element, "endlineno");
        rawlineno_ = URelaxer.getAttributePropertyAsString(element, "rawlineno");
        file_ = URelaxer.getAttributePropertyAsString(element, "file");
        statName_ = URelaxer.getAttributePropertyAsString(element, "stat_name");
        alloc_.clear();
        while (true) {
            if (XbfAlloc.isMatch(stack)) {
                addAlloc(factory.createXbfAlloc(stack));
            } else {
                break;
            }
        }
    }

    /**
     * @return Object
     */
    public Object clone() {
        IXcodeML_FFactory factory = XcodeML_FFactory.getFactory();
        return (factory.createXbfFdeallocateStatement(this));
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
        Element element = doc.createElement("FdeallocateStatement");
        int size;
        if (this.lineno_ != null) {
            URelaxer.setAttributePropertyByString(element, "lineno", this.lineno_);
        }
        if (this.endlineno_ != null) {
            URelaxer.setAttributePropertyByString(element, "endlineno", this.endlineno_);
        }
        if (this.rawlineno_ != null) {
            URelaxer.setAttributePropertyByString(element, "rawlineno", this.rawlineno_);
        }
        if (this.file_ != null) {
            URelaxer.setAttributePropertyByString(element, "file", this.file_);
        }
        if (this.statName_ != null) {
            URelaxer.setAttributePropertyByString(element, "stat_name", this.statName_);
        }
        size = this.alloc_.size();
        for (int i = 0;i < size;i++) {
            XbfAlloc value = (XbfAlloc)this.alloc_.get(i);
            value.makeElement(element);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>XbfFdeallocateStatement</code> by the File <code>file</code>.
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
     * Initializes the <code>XbfFdeallocateStatement</code>
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
     * Initializes the <code>XbfFdeallocateStatement</code> by the URL <code>url</code>.
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
     * Initializes the <code>XbfFdeallocateStatement</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>XbfFdeallocateStatement</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>XbfFdeallocateStatement</code> by the Reader <code>reader</code>.
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
     * Gets the String property <b>lineno</b>.
     *
     * @return String
     */
    public final String getLineno() {
        return (lineno_);
    }

    /**
     * Sets the String property <b>lineno</b>.
     *
     * @param lineno
     */
    public final void setLineno(String lineno) {
        this.lineno_ = lineno;
    }

    /**
     * Gets the String property <b>endlineno</b>.
     *
     * @return String
     */
    public final String getEndlineno() {
        return (endlineno_);
    }

    /**
     * Sets the String property <b>endlineno</b>.
     *
     * @param endlineno
     */
    public final void setEndlineno(String endlineno) {
        this.endlineno_ = endlineno;
    }

    /**
     * Gets the String property <b>rawlineno</b>.
     *
     * @return String
     */
    public final String getRawlineno() {
        return (rawlineno_);
    }

    /**
     * Sets the String property <b>rawlineno</b>.
     *
     * @param rawlineno
     */
    public final void setRawlineno(String rawlineno) {
        this.rawlineno_ = rawlineno;
    }

    /**
     * Gets the String property <b>file</b>.
     *
     * @return String
     */
    public final String getFile() {
        return (file_);
    }

    /**
     * Sets the String property <b>file</b>.
     *
     * @param file
     */
    public final void setFile(String file) {
        this.file_ = file;
    }

    /**
     * Gets the String property <b>statName</b>.
     *
     * @return String
     */
    public final String getStatName() {
        return (statName_);
    }

    /**
     * Sets the String property <b>statName</b>.
     *
     * @param statName
     */
    public final void setStatName(String statName) {
        this.statName_ = statName;
    }

    /**
     * Gets the XbfAlloc property <b>alloc</b>.
     *
     * @return XbfAlloc[]
     */
    public final XbfAlloc[] getAlloc() {
        XbfAlloc[] array = new XbfAlloc[alloc_.size()];
        return ((XbfAlloc[])alloc_.toArray(array));
    }

    /**
     * Sets the XbfAlloc property <b>alloc</b>.
     *
     * @param alloc
     */
    public final void setAlloc(XbfAlloc[] alloc) {
        this.alloc_.clear();
        for (int i = 0;i < alloc.length;i++) {
            addAlloc(alloc[i]);
        }
        for (int i = 0;i < alloc.length;i++) {
            alloc[i].rSetParentRNode(this);
        }
    }

    /**
     * Sets the XbfAlloc property <b>alloc</b>.
     *
     * @param alloc
     */
    public final void setAlloc(XbfAlloc alloc) {
        this.alloc_.clear();
        addAlloc(alloc);
        if (alloc != null) {
            alloc.rSetParentRNode(this);
        }
    }

    /**
     * Adds the XbfAlloc property <b>alloc</b>.
     *
     * @param alloc
     */
    public final void addAlloc(XbfAlloc alloc) {
        this.alloc_.add(alloc);
        if (alloc != null) {
            alloc.rSetParentRNode(this);
        }
    }

    /**
     * Adds the XbfAlloc property <b>alloc</b>.
     *
     * @param alloc
     */
    public final void addAlloc(XbfAlloc[] alloc) {
        for (int i = 0;i < alloc.length;i++) {
            addAlloc(alloc[i]);
        }
        for (int i = 0;i < alloc.length;i++) {
            alloc[i].rSetParentRNode(this);
        }
    }

    /**
     * Gets number of the XbfAlloc property <b>alloc</b>.
     *
     * @return int
     */
    public final int sizeAlloc() {
        return (alloc_.size());
    }

    /**
     * Gets the XbfAlloc property <b>alloc</b> by index.
     *
     * @param index
     * @return XbfAlloc
     */
    public final XbfAlloc getAlloc(int index) {
        return ((XbfAlloc)alloc_.get(index));
    }

    /**
     * Sets the XbfAlloc property <b>alloc</b> by index.
     *
     * @param index
     * @param alloc
     */
    public final void setAlloc(int index, XbfAlloc alloc) {
        this.alloc_.set(index, alloc);
        if (alloc != null) {
            alloc.rSetParentRNode(this);
        }
    }

    /**
     * Adds the XbfAlloc property <b>alloc</b> by index.
     *
     * @param index
     * @param alloc
     */
    public final void addAlloc(int index, XbfAlloc alloc) {
        this.alloc_.add(index, alloc);
        if (alloc != null) {
            alloc.rSetParentRNode(this);
        }
    }

    /**
     * Remove the XbfAlloc property <b>alloc</b> by index.
     *
     * @param index
     */
    public final void removeAlloc(int index) {
        this.alloc_.remove(index);
    }

    /**
     * Remove the XbfAlloc property <b>alloc</b> by object.
     *
     * @param alloc
     */
    public final void removeAlloc(XbfAlloc alloc) {
        this.alloc_.remove(alloc);
    }

    /**
     * Clear the XbfAlloc property <b>alloc</b>.
     *
     */
    public final void clearAlloc() {
        this.alloc_.clear();
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
        buffer.append("<FdeallocateStatement");
        if (lineno_ != null) {
            buffer.append(" lineno=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getLineno())));
            buffer.append("\"");
        }
        if (endlineno_ != null) {
            buffer.append(" endlineno=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getEndlineno())));
            buffer.append("\"");
        }
        if (rawlineno_ != null) {
            buffer.append(" rawlineno=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getRawlineno())));
            buffer.append("\"");
        }
        if (file_ != null) {
            buffer.append(" file=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getFile())));
            buffer.append("\"");
        }
        if (statName_ != null) {
            buffer.append(" stat_name=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getStatName())));
            buffer.append("\"");
        }
        buffer.append(">");
        size = this.alloc_.size();
        for (int i = 0;i < size;i++) {
            XbfAlloc value = (XbfAlloc)this.alloc_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.append("</FdeallocateStatement>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     * @exception IOException
     */
    public void makeTextElement(Writer buffer) throws IOException {
        int size;
        buffer.write("<FdeallocateStatement");
        if (lineno_ != null) {
            buffer.write(" lineno=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getLineno())));
            buffer.write("\"");
        }
        if (endlineno_ != null) {
            buffer.write(" endlineno=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getEndlineno())));
            buffer.write("\"");
        }
        if (rawlineno_ != null) {
            buffer.write(" rawlineno=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getRawlineno())));
            buffer.write("\"");
        }
        if (file_ != null) {
            buffer.write(" file=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getFile())));
            buffer.write("\"");
        }
        if (statName_ != null) {
            buffer.write(" stat_name=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getStatName())));
            buffer.write("\"");
        }
        buffer.write(">");
        size = this.alloc_.size();
        for (int i = 0;i < size;i++) {
            XbfAlloc value = (XbfAlloc)this.alloc_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.write("</FdeallocateStatement>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(PrintWriter buffer) {
        int size;
        buffer.print("<FdeallocateStatement");
        if (lineno_ != null) {
            buffer.print(" lineno=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getLineno())));
            buffer.print("\"");
        }
        if (endlineno_ != null) {
            buffer.print(" endlineno=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getEndlineno())));
            buffer.print("\"");
        }
        if (rawlineno_ != null) {
            buffer.print(" rawlineno=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getRawlineno())));
            buffer.print("\"");
        }
        if (file_ != null) {
            buffer.print(" file=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getFile())));
            buffer.print("\"");
        }
        if (statName_ != null) {
            buffer.print(" stat_name=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getStatName())));
            buffer.print("\"");
        }
        buffer.print(">");
        size = this.alloc_.size();
        for (int i = 0;i < size;i++) {
            XbfAlloc value = (XbfAlloc)this.alloc_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.print("</FdeallocateStatement>");
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
    public String getLinenoAsString() {
        return (URelaxer.getString(getLineno()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getEndlinenoAsString() {
        return (URelaxer.getString(getEndlineno()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getRawlinenoAsString() {
        return (URelaxer.getString(getRawlineno()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getFileAsString() {
        return (URelaxer.getString(getFile()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getStatNameAsString() {
        return (URelaxer.getString(getStatName()));
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setLinenoByString(String string) {
        setLineno(string);
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setEndlinenoByString(String string) {
        setEndlineno(string);
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setRawlinenoByString(String string) {
        setRawlineno(string);
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setFileByString(String string) {
        setFile(string);
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setStatNameByString(String string) {
        setStatName(string);
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
        classNodes.addAll(alloc_);
        IRNode[] nodes = new IRNode[classNodes.size()];
        return ((IRNode[])classNodes.toArray(nodes));
    }

    /**
     * Tests if a Element <code>element</code> is valid
     * for the <code>XbfFdeallocateStatement</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer.isTargetElement(element, "FdeallocateStatement")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        if (!XbfAlloc.isMatchHungry(target)) {
            return (false);
        }
        $match$ = true;
        while (true) {
            if (!XbfAlloc.isMatchHungry(target)) {
                break;
            }
            $match$ = true;
        }
        if (!target.isEmptyElement()) {
            return (false);
        }
        return (true);
    }

    /**
     * Tests if elements contained in a Stack <code>stack</code>
     * is valid for the <code>XbfFdeallocateStatement</code>.
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
     * is valid for the <code>XbfFdeallocateStatement</code>.
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