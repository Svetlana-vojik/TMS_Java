import exceptions.NoEmployeeFoundException;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class JaxbWorker {
    private static final String XML_FILE_PATH = "C:\\Users\\svetlana.ezheleva\\Desktop\\Java\\HW\\Java HWs\\jaxb\\hospitalemploees.xml";
    private static final List<Doctor> doctors = new ArrayList<>();

    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader(XML_FILE_PATH));
        String body = br.lines().collect(Collectors.joining());
        StringReader reader = new StringReader(body);
        JAXBContext context = JAXBContext.newInstance(Hospital.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Hospital hospital = (Hospital) unmarshaller.unmarshal(reader);

        hospital.getDoctorList().forEach(s -> {
            doctors.add(new Doctor(s.getName(), s.getPosition(), s.getDepartment(), s.getWorkExperience()));
        });
        doctors.forEach(s ->
                System.out.printf("Doctor name: %s; Position: %s; Department %s; WorkExperience: %s\n",
                        s.getName(), s.getPosition(), s.getDepartment(), s.getWorkExperience()));

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter the doctor name: ");
        try {
            checkDoctor(scanner.nextLine());
        } catch (NoEmployeeFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void checkDoctor(String string) throws NoEmployeeFoundException {
        Doctor doctor = JaxbWorker.doctors.stream().filter(s -> s.getName().equals(string)).findAny().orElseThrow(() -> new NoEmployeeFoundException("No such employee found!"));
        System.out.println(doctor.toString());
    }
}