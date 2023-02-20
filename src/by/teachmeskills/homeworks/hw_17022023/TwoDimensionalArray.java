package by.teachmeskills.homeworks.hw_17022023;

import java.util.Arrays;
import java.util.Scanner;

public class TwoDimensionalArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter rows count:");
        int rows = scanner.nextInt();
        System.out.println("Please, enter columns count:");
        int columns = scanner.nextInt();
        int[][] twoDimArray = new int[rows][columns];

        for (int i = 0; i < twoDimArray.length; i++) {
            for (int j = 0; j < twoDimArray.length; j++)
                twoDimArray[i][j] = (int) (Math.random() * 20);
        }
        for (int i = 0; i < twoDimArray.length; i++) {
            for (int j = 0; j < twoDimArray[i].length; j++) {
                if (twoDimArray[i][j] % 2 == 0) {
                    System.out.print("0 ");
                } else {
                    System.out.print("1 ");
                }
            }
            System.out.println();
        }
    }
}