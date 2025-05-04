/**
 * Custom exception class for JavaBank application
 * Extends the standard Exception class
 */
public class MyException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor that accepts a message
     * @param message The error message to be displayed
     */
    public MyException(String message) {
        // Pass the message to the superclass constructor
        super(message);
    }
}