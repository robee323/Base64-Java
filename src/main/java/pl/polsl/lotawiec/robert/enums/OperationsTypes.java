package pl.polsl.lotawiec.robert.enums;

/**
 * Type that represents possible operations performed by the program
 * @author Robert Lotawiec
 * @version 1.2
 */
public enum OperationsTypes {
    
    /**
     * Text encryption
     */
    ENCRYPTION("Text encryption"),
    
    /**
     * Text decryption
     */
    DECRYPTION("Text decryption"),
    
    /**
     * Generating a pair of keys
     */
    NEW_KEYS("Generating a pair of keys");
    
    /**
     * Text description of given operation
     */
    private String operationDescription;
    
    /**
     * Constructor for enumerated type
     * @param operationDescription Text description of given operation
     */
    private OperationsTypes(String operationDescription){
        this.operationDescription = operationDescription;
    }
    
    /**
     * Getter for description of operation
     * @return Text description of given operation
     */
    public String getOperationDescription() {
        return operationDescription;
    }
    
    /**
     * Setter for description of operation
     * @param operationDescription Text description of given operation
     */
    public void setOperationDescription(String operationDescription) {
        this.operationDescription = operationDescription;
    }
}
