
package pl.polsl.lotawiec.robert.model;

/**
 * Exception thrown when character does not appear in ASCII table
 * @author Robert Lotawiec
 * @version 1.1
 */

public class IllegalCharacterException extends Exception {
    /** Variable that have position where error has occured */
    private Integer position;
    
    /** Constructor of object with error message and position where error has occured
    *
    * @param message info about error
    * @param position info about position
    */
    public IllegalCharacterException(String message, Integer position) {
        super(message);
        this.position = position;
    }
    
    /** Constructor of object with error message
    *
    * @param message info about error
    */
    public IllegalCharacterException(String message) {
        super(message);
        this.position = null;
    }
    
    /** Getter of position where error has occured
    * @return position of error 
    */
    public Integer getPosition()
    {
        return position;
    }
    
}
