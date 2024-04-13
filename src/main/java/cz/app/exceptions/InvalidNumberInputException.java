package cz.app.exceptions;

public class InvalidNumberInputException extends NumberFormatException {
    public InvalidNumberInputException(String message) {
        super(message);
    }
}
