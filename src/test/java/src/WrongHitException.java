package src;

public class WrongHitException extends Exception{
    public WrongHitException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
