package com.thzhima.advance.xml;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class MySaxParser {

	public static void main(String[] args) throws SAXException, IOException {
		XMLReader reader = XMLReaderFactory.createXMLReader();
		
		
		
		reader.setContentHandler(new DefaultHandler() {
			boolean yes = false;
			boolean isName  = false;
			boolean isGender = false;
			@Override
			public void startElement(String uri, String localName, String qName, Attributes attributes)
					throws SAXException {
				
				if("student".equals(localName)) {
					if("stu1".equals(attributes.getValue("ID"))) {
						yes = true;
					}
				}
				if("name".equals(localName) && yes) {
					System.out.println("是名字");
					isName = true;
				}
				else if("gender".equals(localName) && yes) {
					System.out.println("是gender");
					isGender = true;
				}
				
			}

			@Override
			public void endElement(String uri, String localName, String qName) throws SAXException {
				if("student".equals(localName)) {
					
						yes = false;
					
				}
				if("name".equals(localName) && yes) {
					System.out.println("名字结束");
					isName = false;
				}
				else if("gender".equals(localName) && yes) {
					System.out.println("gender结束");
					isGender = false;
				}
			}

			@Override
			public void characters(char[] ch, int start, int length) throws SAXException {
				System.out.println(new String(ch, start, length));
			}
			
		} );
		
		InputStreamReader r = new InputStreamReader(new FileInputStream("d:/class.xml"), "utf-8");
		
		InputSource input = new InputSource(r);
		reader.parse(input);
	}
}
