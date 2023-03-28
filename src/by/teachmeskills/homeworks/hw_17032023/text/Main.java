package by.teachmeskills.homeworks.hw_17032023.text;

import java.io.*;

public class Main {
    public static final String directory = "src\\by\\teachmeskills\\homeworks\\hw_17032023\\files\\";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(directory + "text1.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter(directory + "text1out.txt"));
             BufferedReader reader1 = new BufferedReader(new FileReader(directory + "sentences.txt"));
             BufferedWriter writer1 = new BufferedWriter(new FileWriter(directory + "sentences.txt"))) {
            String list;
            while ((list = reader.readLine()) != null) {
                String[] array = list.split("\\.");
                for (String s : array) {
                    writer1.write(s + "\n");
                    writer1.flush();
                }
            }
            String str;
            while ((str =reader1.readLine())!= null) {
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