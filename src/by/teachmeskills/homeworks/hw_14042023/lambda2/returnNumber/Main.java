package by.teachmeskills.homeworks.hw_14042023.lambda2.returnNumber;

import java.util.Scanner;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число: ");
        Function<Integer, String> inputNumber = num -> {
            if (num > 0) {
                return "Положительное число";
            } else if (num < 0) {
                return "Отрицательное число";
            } else {
                return "Ноль";
            }
        };
        System.out.println(inputNumber.apply(scanner.nextInt()));
    }
}