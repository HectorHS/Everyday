package com.hhs.everyday;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hecto on 10/06/2017.
 */
public class XMLParser {
    InputSource inputFile;

    public XMLParser(InputSource inputFile) {
        this.inputFile = inputFile;
    }

    public List<TrackerItem> readXml() {
        List<TrackerItem> allTrackers = new ArrayList<TrackerItem>();
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;

        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            XPath xPath = XPathFactory.newInstance().newXPath();

            String expression = "/trackers/tracker";
            NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node nNode = nodeList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    String trackerLabel = eElement.getElementsByTagName("label").item(0).getTextContent();
                    TrackerType trackerType = convertToTrackerType(eElement.getElementsByTagName("type").item(0).getTextContent());

                    allTrackers.add(new TrackerItem(trackerLabel, trackerType));
                }
            }
// TODO handle exceptions properly
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        return allTrackers;
    }

    private TrackerType convertToTrackerType(String input) {
        if (input.equals("text")) {
            return TrackerType.text;
        } else if (input.equals("number")) {
            return TrackerType.number;
        } else if (input.equals("counter")) {
            return TrackerType.counter;
        } else if (input.equals("spectrum")) {
            return TrackerType.spectrum;
        } else if (input.equals("checkbox")) {
            return TrackerType.checkbox;
        }
// TODO not happy with this implementation, there must be a better way
        return null;
    }
}