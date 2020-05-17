package org.initial.io;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class XMLParser {

	private static final Logger LOG = Logger.getLogger(XMLParser.class.getName());

	/**
	 * Lecture d'un fichier XML
	 * @param filePath
	 */
	public static void parseXmlFile(String filePath) {
		
		File xmlFile = new File(filePath);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

		try {
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);

			LOG.info("Root element :" + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("CD");
			LOG.info("----------------------------");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				LOG.info("\nCurrent Element :" + nNode.getNodeName());
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					LOG.info("TITLE: " + eElement.getElementsByTagName("TITLE").item(0).getTextContent());
					LOG.info("ARTIST: " + eElement.getElementsByTagName("ARTIST").item(0).getTextContent());
					LOG.info("COUNTRY: " + eElement.getElementsByTagName("COUNTRY").item(0).getTextContent());
					LOG.info("COMPANY: " + eElement.getElementsByTagName("COMPANY").item(0).getTextContent());
					LOG.info("PRICE: " + eElement.getElementsByTagName("PRICE").item(0).getTextContent());
					LOG.info("YEAR: " + eElement.getElementsByTagName("YEAR").item(0).getTextContent());
				}
			}

		} catch (ParserConfigurationException e) {
			LOG.severe(e.getMessage());
		} catch (SAXException e) {
			LOG.severe(e.getMessage());
		} catch (IOException e) {
			LOG.severe(e.getMessage());
		}
	}

}
