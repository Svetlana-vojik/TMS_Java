package by.teachmeskills.homeworks.hw_17032023.censorship;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final String FILE_PATH ="src\\by\\teachmeskills\\homeworks\\hw_17032023\\files\\censor.txt";
    public static final String BLACK_WORDS ="src\\by\\teachmeskills\\homeworks\\hw_17032023\\files\\black_list.txt";
    public static void main(String[] args) {
        try {
            String[] text = new String(Files.readAllBytes(Paths.get(FILE_PATH))).split("\\.");
            List<String> blackWords = Files.readAllLines(Paths.get(BLACK_WORDS));
            List<String> wrongSentences = new ArrayList<>();
            for (String blackWord : blackWords) {
                for (String sentence : text) {
                    if (sentence.toLowerCase().contains(blackWord.toLowerCase()) &&
                            !wrongSentences.contains(sentence)) {
                        wrongSentences.add(sentence);
                    }
                }
            }
            if (wrongSentences.size() == 0) {
                System.out.println("Файл прошел проверку на цензуру");
            } else {
                System.out.println("Количество предложений не прошедших цензуру " + wrongSentences.size());
                System.out.println();
                for (String wrongSentence : wrongSentences) {
                    System.out.println("ПРЕДЛОЖЕНИЕ | " + wrongSentence.trim());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}