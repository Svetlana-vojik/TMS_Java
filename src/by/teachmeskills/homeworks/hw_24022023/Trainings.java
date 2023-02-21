package by.teachmeskills.homeworks.hw_24022023;

public class Trainings {
    public static void main(String[] args) {
        int initialDistance = 10;
        int weekDistance = initialDistance;

        System.out.println("Пробег за 1: " + initialDistance);
        for (int i = 2; i <= 7; i++) {
            initialDistance += initialDistance / 10;
            weekDistance += initialDistance;
            System.out.println("Пробег за " + i + ": " + initialDistance);
        }
    }
}