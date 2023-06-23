package by.teachmeskills.homeworks.hw_28042023.DOM;

import by.teachmeskills.homeworks.hw_28042023.SAX.Doctor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DOM {
    private static final String XML_FILE_PATH = "C:\\Users\\svetlana.ezheleva\\Desktop\\Java\\HW\\Java HWs\\src\\by\\teachmeskills\\homeworks\\hw_28042023\\hospitalemploees.xml";

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(XML_FILE_PATH));

        NodeList doctorElement = document.getDocumentElement().getElementsByTagName("doctor");

        ArrayList<Doctor> doctors = new ArrayList<>();
        for (int i = 0; i < doctorElement.getLength(); i++) {
            doctors.add(getDoctor(doctorElement.item(i)));
        }
        for (Doctor doctor : doctors) {
            System.out.println(doctor.toString());
        }
    }

    private static Doctor getDoctor(Node node) {
        Doctor doctor = new Doctor();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            doctor.setName(getTagValue("name", element));
            doctor.setPosition(getTagValue("position", element));
            doctor.setDepartment(getTagValue("department", element));
            doctor.setWorkExperience(getTagValue("workExperience", element));
        }
        return doctor;
    }

    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }
}