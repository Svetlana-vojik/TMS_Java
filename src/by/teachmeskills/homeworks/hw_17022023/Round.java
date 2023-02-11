package by.teachmeskills.homeworks.hw_17022023;

import java.util.Scanner;

public class Round {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Введите длину прямоуголька");
        int  a = scan.nextInt();

        System.out.println("Введите ширину прямоуголька");
        int  b = scan.nextInt();

        System.out.println("Введите радиус");
        int  r = scan.nextInt();

        if (2 * r >= Math.sqrt(a * a + b * b)) {
            System.out.println("Можно");
        }
        else {
            System.out.println("Нельзя");

        }

    }
}
