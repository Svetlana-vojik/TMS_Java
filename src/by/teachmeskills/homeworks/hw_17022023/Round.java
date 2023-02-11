package by.teachmeskills.homeworks.hw_17022023;

import java.util.Scanner;

public class Round {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Введите длину прямоуголька");
        float  a = scan.nextFloat();

        System.out.println("Введите ширину прямоуголька");
        float  b = scan.nextFloat();

        System.out.println("Введите радиус");
        float r = scan.nextFloat();

        if ( 2 * r >= Math.sqrt(a * a + b * b)) {
            System.out.println("Можно");
        }
        else {
            System.out.println("Нельзя");

        }

    }
}
