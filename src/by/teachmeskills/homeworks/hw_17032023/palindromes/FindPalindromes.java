package by.teachmeskills.homeworks.hw_17032023.palindromes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FindPalindromes {
    public static final String FILE_PATH = "src\\by\\teachmeskills\\homeworks\\hw_17032023\\files\\";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH + "palindromes.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH + "findpalindromes.txt"))) {
            String line = reader.readLine();
            while (line != null) {
                StringBuilder builder1 = new StringBuilder(line);
                StringBuilder builder2 = new StringBuilder(builder1);
                builder1.reverse();
                if (builder1.toString().equals(builder2.toString()))
                    writer.write(line + '\n');
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}