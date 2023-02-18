package by.teachmeskills.homeworks.hw_17022023;

import java.util.Scanner;

public class TwoDimensionalArray {
    public static int[][] multiArray;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        multiArray = new int[n][];
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            multiArray[i] = new int[a];

        }
        for (int i = 0; i < multiArray.length; i++) {
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



