package by.teachmeskills.homeworks.hw_24022023;

public class Trainings {
    public static void main(String[] args) {
        int way = 10;
        int way7 = way;

        System.out.println("Пробег за 1: " + way);
        for (int i = 2; i <= 7; i++) {
            way += way / 10;
            way7 += way;
            System.out.println("Пробег за " + i + ": " + way);
        }
    }
}