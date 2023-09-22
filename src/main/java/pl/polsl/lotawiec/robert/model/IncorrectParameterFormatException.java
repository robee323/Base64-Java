
package pl.polsl.lotawiec.robert.model;

/**
 * Exception class for objects thrown when string variable is in incorrect format.
 * 
 * @author Robert Lotawiec
 * @version 1.3
 * 
 */
public class IncorrectParameterFormatException extends Exception {
    
    /**
     * Non-parameter constructor
     */
    public IncorrectParameterFormatException() {
    }

    /**
     * Exception class constructor
     *
     * @param message display message
     * 
     */
    public IncorrectParameterFormatException(String message) {
        super(message);
    }
}
