package by.teachmeskills.homeworks.hw_31032023.collection;

import static by.teachmeskills.homeworks.hw_31032023.collection.DocValidator.createReport;
import static by.teachmeskills.homeworks.hw_31032023.collection.DocValidator.enterDocPath;
import static by.teachmeskills.homeworks.hw_31032023.collection.DocValidator.readDoc;
import static by.teachmeskills.homeworks.hw_31032023.collection.DocValidator.validateDoc;

public class Main {
    public static void main(String[] args) {
        enterDocPath();
        readDoc();
        validateDoc();
        createReport();
    }
}