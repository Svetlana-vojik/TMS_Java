package by.teachmeskills.homeworks.hw_10032023.shop;

public class EmptyProductListException extends Exception {
    public EmptyProductListException() {
    }

    public EmptyProductListException(String message) {
        super(message);
    }
}