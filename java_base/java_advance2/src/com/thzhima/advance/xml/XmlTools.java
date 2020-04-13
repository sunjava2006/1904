package com.thzhima.advance.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlTools {

	public static void write() throws ParserConfigurationException, TransformerException{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.newDocument();
		
		// 创建班级节点
		Element classNode = doc.createElement("班1904");
		doc.appendChild(classNode); // 挂载节点
		
		Element stuListNode = doc.createElement("student_list");
		classNode.appendChild(stuListNode);
		
		Element stu1Node = doc.createElement("student");
//		stu1Node.setAttribute("id", "s01");
		Attr idAttr = doc.createAttribute("ID");
		idAttr.setValue("stu1");
		stu1Node.setAttributeNode(idAttr);
		System.out.println(idAttr.isId());
		stuListNode.appendChild(stu1Node);
		
		Element nameNode = doc.createElement("name");
		nameNode.appendChild(doc.createTextNode("林益"));
		Element genderNode = doc.createElement("gender");
		genderNode.appendChild(doc.createTextNode("男"));
		stu1Node.appendChild(nameNode);
		stu1Node.appendChild(genderNode);
		
		// 输出转换
		
		TransformerFactory transfactory = TransformerFactory.newInstance();
		Transformer transformer = transfactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
		transformer.setOutputProperty(OutputKeys.INDENT,"yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
		
		DOMSource xmlSource = new DOMSource(doc);
		StreamResult outputTarget = new StreamResult(new File("d:/class.xml"));
		transformer.transform(xmlSource, outputTarget);

	}
	
	public static void main(String[] args) throws TransformerException, ParserConfigurationException  {
		write();
		
		TransformerFactory transfactory = TransformerFactory.newInstance();
		Transformer transformer = transfactory.newTransformer();
		StreamSource xmlSource = new StreamSource(new File("d:/class.xml"));
		DOMResult outputTarget = new DOMResult();
		transformer.transform(xmlSource, outputTarget);
		
		Document doc = (Document) outputTarget.getNode();
		
		Element stu01 = doc.getElementById("stu1");
//		Element stu01 = (Element)doc.getElementsByTagName("student").item(0);
		if(stu01.hasChildNodes()) {
			NodeList list = stu01.getChildNodes();
			for(int i=0;i<list.getLength();i++) {
				Node n = list.item(i);
				if(n.getNodeType()==Node.ELEMENT_NODE) {
					Element e = (Element)n;
					System.out.println(e.getTextContent());
				}
				
			}
		}
	}
}
