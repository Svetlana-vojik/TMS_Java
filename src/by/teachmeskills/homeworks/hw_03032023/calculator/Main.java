package by.teachmeskills.homeworks.hw_03032023.calculator;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(2,10,8);
        System.out.println("Сумма равна: " + calculator.sum());
        System.out.println("Разница равна: " + calculator.minus());
        System.out.println("Произведение равно: " + calculator.multiply());
    }
}
