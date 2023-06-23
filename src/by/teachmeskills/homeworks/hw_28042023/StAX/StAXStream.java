package by.teachmeskills.homeworks.hw_28042023.StAX;

import by.teachmeskills.homeworks.hw_28042023.SAX.Doctor;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class StAXStream {
    public static void main(String[] args) {

        String fileName = "C:\\Users\\svetlana.ezheleva\\Desktop\\Java\\HW\\Java HWs\\src\\by\\teachmeskills\\homeworks\\hw_28042023\\hospitalemploees.xml";
        List<Doctor> doctors = parseXMLfile(fileName);
        for (Doctor doctor : doctors) {
            System.out.println(
                    doctor.toString());
        }
    }

    private static List<Doctor> parseXMLfile(String fileName) {
        List<Doctor> doctors = new ArrayList<>();
        Doctor doctor = null;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(fileName));
            while (reader.hasNext()) {
                XMLEvent xmlEvent = reader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    if (startElement.getName().getLocalPart().equals("doctor")) {
                        doctor = new Doctor();
                    } else if (startElement.getName().getLocalPart().equals("name")) {
                        xmlEvent = reader.nextEvent();
                        doctor.setName(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("position")) {
                        xmlEvent = reader.nextEvent();
                        doctor.setPosition(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("department")) {
                        xmlEvent = reader.nextEvent();
                        doctor.setDepartment(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("workExperience")) {
                        xmlEvent = reader.nextEvent();
                        doctor.setWorkExperience(xmlEvent.asCharacters().getData());
                    }
                }
                if (xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("doctor")) {
                        doctors.add(doctor);
                    }
                }
            }
        } catch (XMLStreamException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return doctors;
    }
}