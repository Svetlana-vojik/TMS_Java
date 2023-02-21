package by.teachmeskills.homeworks.hw_24022023;

public class Amoeba {
    public static void main(String[] args) {
        int ameba = 1;

        for (int i = 3; i < 24; i += 3) {
            ameba *= 2;
            System.out.printf("Hours  %d, ameba counts  %d\n", i, ameba);
        }
    }
}