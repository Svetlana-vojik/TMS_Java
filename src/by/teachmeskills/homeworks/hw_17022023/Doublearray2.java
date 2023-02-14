package by.teachmeskills.homeworks.hw_17022023;

public class Doublearray2 {
    public static void main(String[] args) {
        int[][] num = new int[10][];


        for (int i = 0; i < num.length; i++) {
            num[i] = new int[(int) (Math.random() * 20)];
            for (int j = 0; j < num[i].length; j++) {
                num[i][j] = j + 1;
                System.out.print(num[i][j]);

            }
            System.out.println();
        }

    }
}
