package by.teachmeskills.homeworks.hw_31032023.collection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class DocValidator {
    private static final ArrayList<String> docPaths = new ArrayList<>();
    private static final HashSet<String> docNumber = new HashSet<>();
    private static final HashMap<String, String> docValidation = new HashMap<>();
    public static final String REPORT = "src\\by\\teachmeskills\\homeworks\\hw_31032023\\files\\report.txt";

    public static void enterDocPath() {
        try (Scanner scan = new Scanner(System.in);) {
            System.out.println("Введите путь/имя файла: ");
            String string;
            while (!Objects.equals(string = scan.next(), "0")) {
                docPaths.add(string);
            }
        }
    }

    public static void readDoc() {
        for (String string : docPaths) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(string))) {
                String s;
                while ((s = bufferedReader.readLine()) != null) {
                    docNumber.add(s);
                }
            } catch (IOException e) {
                System.out.print(e.getMessage());
            }
        }
    }

    public static void validateDoc() {
        for (String string : docNumber) {
            if ((string.startsWith("docnum") || string.startsWith("contract")) && string.chars().allMatch(Character::isLetterOrDigit) && string.length() == 15) {
                docValidation.put(string, "- valid");
            } else if (string.length() == 15) {
                if (!(string.startsWith("docnum") || string.startsWith("contract"))) {
                    docValidation.put(string, "- invalid, incorrect name of the document. The doc number have to be started with \"contract\" or \"docnum\".");
                }
                for (int i = 0; i < string.length(); ++i) {
                    char c = string.charAt(i);
                    if (!Character.isLetterOrDigit(c)) {
                        docValidation.put(string, " -invalid, incorrect name of the document, illegal character " + "\"" + c + "\".");
                    }
                }
            } else {
                for (int i = 0; i < string.length(); ++i) {
                    char c = string.charAt(i);
                    if (!Character.isLetterOrDigit(c)) {
                        docValidation.put(string, " - invalid, incorrect length and illegal character " + "\"" + c + "\".");
                        break;
                    } else {
                        docValidation.put(string, "- invalid, incorrect length");
                    }
                }
            }
        }
    }

    public static void createReport() {
        try (BufferedWriter bf = new BufferedWriter(new FileWriter(REPORT))) {
            for (Map.Entry<String, String> record : docValidation.entrySet()) {
                bf.write(record.getKey() + record.getValue() + '\n');
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}