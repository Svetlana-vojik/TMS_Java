package by.teachmeskills.homeworks.hw_24022023;

public class Amoeba {
    public static void main(String[] args) {
        int a = 1;
        int time = 24;

        while (time >= 3) {
            for (int i = 0; i < time; i++) {
                a *= 2;
                time -= 3;
                System.out.println(a);
            }
        }
    }
}