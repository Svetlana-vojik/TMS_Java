package by.teachmeskills.homeworks.hw_03032023.calculator;

public class Calculator {
    private int a;
    private int b;
    private int c;
    private int sum;
    private int minus;
    private int multiply;

    public Calculator(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
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

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int sum() {
        return a + b + c;
    }

    public int minus() {
        return (a - b - c);
    }

    public int multiply() {
        return a * b * c;
    }
}
