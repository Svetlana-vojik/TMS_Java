package by.teachmeskills.homeworks.hw_10032023.enumeration;

import java.util.Scanner;

public class University {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите количество учащихся: ");
        int numberOfStudents = scan.nextInt();

        Season current = Season.SUMMER;

        switch (current) {
            case WINTER, SPRING, AUTUMN ->
                    System.out.println("Школа №888, учащихся " + numberOfStudents + ", сейчас мы учимся.");
            case SUMMER -> System.out.println("Школа №888, учащихся " + numberOfStudents + ", отдыхаем");
        }
    }

    public enum Season {
        WINTER("Зима"),
        SPRING("Весна"),
        AUTUMN("Осень"),
        SUMMER("Лето");
        private final String name;

        Season(String name) {

            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}