package exceptions;

public class NoEmployeeFoundException extends Exception {
    public NoEmployeeFoundException(String message) {
        super(message);
    }
}