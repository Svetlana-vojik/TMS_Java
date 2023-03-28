package by.teachmeskills.homeworks.hw_17032023.palindromes;

import java.io.*;

public class FindPalindromes {
    public static final String directory = "src\\by\\teachmeskills\\homeworks\\hw_17032023\\files\\";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(directory + "palindromes.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter(directory + "findpalindromes.txt"))) {
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