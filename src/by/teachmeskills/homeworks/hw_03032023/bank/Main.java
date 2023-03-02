package by.teachmeskills.homeworks.hw_03032023.bank;

public class Main {
    public static void main(String[] args) {
        Validator validator = new Validator();

        System.out.println("Validate Card Number");
        validator.validateCardNumber(1111111111111111l);
        validator.validateCardNumber(111l);

        System.out.println("Validate Card Type");
        validator.validateCardType("VISA");
        validator.validateCardType("MasterCard");

        System.out.println("Validate Owner");
        validator.validateOwner(true);
        validator.validateOwner(false);

        System.out.println("Validate CVV");
        validator.validateCVV("1234");
        validator.validateCVV("f5f5");
        validator.validateCVV("123");

        System.out.println("Validate Expiry Date");
        validator.validateExpiryDate("12/21");
        validator.validateExpiryDate("11/24");
        validator.validateExpiryDate("01/22");


    }
}
