package by.teachmeskills.homeworks.hw_10032023.enumeration;

import java.util.Objects;
import java.util.Scanner;

public class University {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите количество учащихся: ");
        int numberOfStudents = scan.nextInt();
        scan.nextLine();
        System.out.println("Введите пору года: ");
        String currentSeason = scan.nextLine();

        if (Season.WINTER.getName().equals(currentSeason) || Season.AUTUMN.getName().equals(currentSeason) || Season.SPRING.getName().equals(currentSeason)) {
            System.out.println("Школа №888, учащихся " + numberOfStudents + ", сейчас мы учимся.");
        } else if (Season.SUMMER.getName().equals(currentSeason)) {
            System.out.println("Школа №888, учащихся " + numberOfStudents + ", отдыхаем");
        } else {
            System.out.println("Такой поры года не существует");
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