package by.teachmeskills.homeworks.hw_03032023.bank;

public class Main {
    public static void main(String[] args) {
        Validator validator = new Validator();
        System.out.println("Card 1\n");
        validator.validateCard(1231231231231231l, "VISA", true, "123", "12/24");
        System.out.println("----------------------------------\nCard 2\n ");
        validator.validateCard(111l, "MasterCard", false, "d5d5d", "12/21");
    }
}