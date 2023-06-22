package by.teachmeskills.homeworks.hw_28042023.SAX;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Main {
    private static ArrayList<Doctor> doctors = new ArrayList<>();
    private static final String XML_FILE_PATH = "C:\\Users\\svetlana.ezheleva\\Desktop\\Java\\HW\\Java HWs\\src\\by\\teachmeskills\\homeworks\\hw_28042023\\hospitalemploees.xml";

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            XMLHandler handler = new XMLHandler();
            parser.parse(new File(XML_FILE_PATH), handler);
            doctors.forEach(e -> System.out.printf("Doctor name: %s, position: %s, department: %s, experience: %s\n",
                    e.getName(), e.getPosition(), e.getDepartment(), e.getWorkExperience()));
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static class XMLHandler extends DefaultHandler {
        private String name, position, department, workExperience, lastElementName;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            lastElementName = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if ((name != null && !name.isEmpty()) && (position != null && !position.isEmpty())
                    && (department != null && !department.isEmpty()) && (workExperience != null && !workExperience.isEmpty())) {

                doctors.add(new Doctor(name, position, department, workExperience));
                name = null;
                position = null;
                department = null;
                workExperience = null;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String information = new String(ch, start, length);
            information = information.replace("\n", "").trim();

            if (!information.isEmpty()) {
                if (lastElementName.equals("name"))
                    name = information;
                if (lastElementName.equals("position"))
                    position = information;
                if (lastElementName.equals("department"))
                    department = information;
                if (lastElementName.equals("workExperience"))
                    workExperience = information;
            }
        }
    }
}