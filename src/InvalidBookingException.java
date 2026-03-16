/**
 * This custom exception represents invalid booking scenarios.
 */
public class InvalidBookingException extends Exception {
    /**
     * Creates an exception with a descriptive error message.
     * @param message error description
     */
    public InvalidBookingException(String message) {
        super(message);
    }
}