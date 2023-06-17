package tmspaymentsystem.exception;

public class NoBankAccountsFoundException extends Exception{
    public NoBankAccountsFoundException(String message){
        super(message);
    }
}