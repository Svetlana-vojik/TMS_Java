package by.teachmeskills.homeworks.hw_17022023;

import java.util.Scanner;
import java.util.Arrays;

public class DoubleArray {
    public static int[][] multiArray;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  // Вводим n c клавиатуры
        multiArray = new int[n][]; // Создаем двумерный массив с n строк.
        for (int i = 0; i < n; i++) {  // Создаем цикл для инициализации строк массива
            int a = scanner.nextInt(); // пока цикл не завершится вводим числа с клавиатуры
            multiArray[i] = new int[a]; // Каждое число == колличеству элементов в массиве

        }
        for (int i = 0; i < multiArray.length; i++) {  // Выводим массив на экран
            for (int j = 0; j < multiArray[i].length; j++) {
                if ((i % 2) == 0 || (j % 2) == 0) {
                    multiArray[i][j] = 0;

                } else {
                    multiArray[i][j] = 1;
                }
                System.out.print(multiArray[i][j]);
            }
            System.out.println();
        }

    }
}



