package by.teachmeskills.homeworks.hw_14042023.lambda2.emptyString;

import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Predicate<String> notEmptyString = str -> !str.isEmpty();
        Predicate<String> notNullString = str -> str.length() > 0;

        System.out.print("Введите строку ");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        System.out.println(notNullString.test(string));
        System.out.println(notEmptyString.test(string));
        System.out.println(notNullString.and(notEmptyString).test(string));
    }
}