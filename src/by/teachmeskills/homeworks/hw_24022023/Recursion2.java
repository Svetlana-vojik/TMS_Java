package by.teachmeskills.homeworks.hw_24022023;

public class Recursion2 {
    public static void main(String[] args) {
        System.out.println(recursion(41, 50));
        System.out.println(recursion(-10, -5));
    }

    public static String recursion(int a, int b) {
        if (a > b) {
            if (a == b) {
                return Integer.toString(a);
            }
            return a + " " + recursion(a - 1, b);
        } else {
            if (a == b) {
                return Integer.toString(a);
            }
            return a + " " + recursion(a + 1, b);
        }
    }
}