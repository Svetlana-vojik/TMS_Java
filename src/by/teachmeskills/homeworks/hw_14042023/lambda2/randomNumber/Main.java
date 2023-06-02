package by.teachmeskills.homeworks.hw_14042023.lambda2.randomNumber;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Supplier <Integer> random = () ->(int) (Math.random() * 50);
        System.out.println(random.get());
    }
}