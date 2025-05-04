/**
 * Custom exception class for JavaBank application
 * Extends the standard Exception class
 */
public class myException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor that accepts a message
     * @param message The error message to be displayed
     */
    public myException(String message) {
        // Pass the message to the superclass constructor
        super(message);
    }
}