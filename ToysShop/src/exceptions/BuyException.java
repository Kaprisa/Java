package exceptions;

public class BuyException extends Exception {
    public BuyException() {
         super("У вас недостаточно денег.");
    }

    public BuyException(String message) {
        super(message);
    }
}
