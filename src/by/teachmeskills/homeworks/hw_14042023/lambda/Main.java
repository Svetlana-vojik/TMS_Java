package by.teachmeskills.homeworks.hw_14042023.lambda;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Введите 1 или 2: ");
        Scanner scanner = new Scanner(System.in);

        MyInterface<String> myInterface1 = str -> new StringBuilder(str).reverse().toString();
        MyInterface<Integer> myInterface2 = s -> {
            int num = 1;
            for (int i = 2; i <= s; i++) {
                num *= i;
            }
            return num;
        };

        switch (scanner.nextInt()) {
            case 1 -> {
                System.out.println("Введите строку: ");
                scanner.nextLine();
                System.out.println(myInterface1.get(scanner.nextLine()));
            }
            case 2 -> {
                System.out.println("Введите число: ");
                System.out.println(myInterface2.get(scanner.nextInt()));
            }
            default -> System.out.println("Введено неверное число");
        }
    }
}