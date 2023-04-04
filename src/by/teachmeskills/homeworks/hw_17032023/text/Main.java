package by.teachmeskills.homeworks.hw_17032023.text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static final String FILE_PATH = "src\\by\\teachmeskills\\homeworks\\hw_17032023\\files\\";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH + "text1.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH + "text1out.txt"));
             BufferedReader reader1 = new BufferedReader(new FileReader(FILE_PATH + "sentences.txt"));
             BufferedWriter writer1 = new BufferedWriter(new FileWriter(FILE_PATH + "sentences.txt"))) {
            String list;
            while ((list = reader.readLine()) != null) {
                String[] array = list.split("\\.");
                for (String s : array) {
                    writer1.write(s + "\n");
                    writer1.flush();
                }
            }
            String str;
            while ((str = reader1.readLine()) != null) {
                if ((TextFormatter.checkPalindromes(str) || TextFormatter.returnWordNumber(str) >= 3 && TextFormatter.returnWordNumber(str) <= 5)) {
                    writer.write(str + "\n");
                    writer.flush();
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}