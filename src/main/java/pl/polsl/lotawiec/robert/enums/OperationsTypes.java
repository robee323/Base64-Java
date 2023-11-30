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
    ENCRYPTION("Text encryption", 1),
    
    /**
     * Text decryption
     */
    DECRYPTION("Text decryption", 2);
    
    /**
     * Text description of given operation
     */
    private String operationDescription;
    
    
    /**
     * Numeric index of given operation
     */
    private int operationIndex;
    
    /**
     * Constructor for enumerated type
     * @param operationDescription Text description of given operation
     * @param operationIndex Index of given operation
     */
    private OperationsTypes(String operationDescription, int operationIndex) {
        this.operationDescription = operationDescription;
        this.operationIndex = operationIndex;
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
    
    /**
     * Getter for index of operation
     * @return Index of given operation
     */
    public int getOperationIndex() {
        return operationIndex;
    }
    
    
    /**
     * Setter for index of operation
     * @param operationIndex Index of given operation
     */
    public void setOperationIndex(int operationIndex) {
        this.operationIndex = operationIndex;
    }
    
}