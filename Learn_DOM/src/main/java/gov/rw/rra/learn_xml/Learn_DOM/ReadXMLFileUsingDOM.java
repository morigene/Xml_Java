package gov.rw.rra.learn_xml.Learn_DOM;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXMLFileUsingDOM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			File xmlDoc = new File("/home/morigene/java/eclipse-workspace/Learn_DOM/src/main/java/gov/rw/rra/learn_xml/Learn_DOM/Student.xml");
			// for traversing DOM
			DocumentBuilderFactory dbFact = DocumentBuilderFactory.newInstance();
			//create an BUILDER OBJECT by using factor
			DocumentBuilder dBuild = dbFact.newDocumentBuilder();
		     //use document builder to parse  FILE TO xml standards
			Document doc = dBuild.parse(xmlDoc);
			
			// read root element
			//                                    doc locate root           give me its name
			System.out.println( " Root Element: "+doc.getDocumentElement().getNodeName());
			// read array of student element   . this array is claled NodeList
			NodeList nList = doc.getElementsByTagName("student");
			for(int i = 0; i < nList.getLength();i++) {
				// note item(i.e 3 for student)
				Node nNode =nList.item(i);
				System.out.println(" Node Name "+nNode.getNodeName() + " "+( i + 1));
			
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					
					Element el  = (Element)nNode;
					System.out.println("Student ID#: "+el.getAttribute("idno]"));
					System.out.println( "Firstname: "+el.getElementsByTagName("firstname").item(0).getTextContent());
					System.out.println( "Lastname: "+el.getElementsByTagName("lastname").item(0).getTextContent());
					System.out.println( "Score: "+el.getElementsByTagName("score").item(0).getTextContent());
					System.out.println( "__________________________________________________________________________________");
					
				}
			}
			
		}catch(Exception e) {
			
			
		}
	

	}

}
