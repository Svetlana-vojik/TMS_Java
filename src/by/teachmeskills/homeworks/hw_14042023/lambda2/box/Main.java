package by.teachmeskills.homeworks.hw_14042023.lambda2.box;

import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Consumer<HeavyBox> box1 = b -> System.out.println("Отгрузили ящик с весом " + b);
        Consumer<HeavyBox> box2 = b -> System.out.println("Отправляем ящик с весом " + b);
        box1.andThen(box2).accept(new HeavyBox(15));
    }
}