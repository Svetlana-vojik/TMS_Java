package by.teachmeskills.homeworks.hw_03032023.calculator;

public class Calculator {
    private int a;
    private int b;
    private int sum;
    private int minus;
    private int multiply;

    public Calculator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int sum() {
        return a + b;
    }

    public int minus() {
        return (a - b);
    }

    public int multiply() {
        return a * b;
    }
}