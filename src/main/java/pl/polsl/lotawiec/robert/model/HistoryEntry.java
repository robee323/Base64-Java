package pl.polsl.lotawiec.robert.model;

import java.util.Date;
import pl.polsl.lotawiec.robert.enums.OperationsTypes;

/**
 * A single entry in operations history table
 * 
 * @author Robert Lotawiec
 * @version 1.3
 */
public class HistoryEntry {
    
    /**
     * Type of preformed operation
     */
    private OperationsTypes operationType;
    
    /**
     * Result of preformed operation
     */
    private String opeartionResult; 
    
    /**
     * Time of preformed operation
     */
    private Date operationTime;
    
    /**
     *  Crates a new history entry object
     *  a row to the end of the preformed operations table
     *
     * @param operationType Type of preformed operation
     * @param opeartionResult Result of preformed operation
     */
    public HistoryEntry(OperationsTypes operationType, String opeartionResult){
        this.operationType = operationType;
        this.opeartionResult = opeartionResult;
        this.operationTime = new Date();
    }
    
    /**
     * Getter for operation type
     * @return type of preformed operation
     */
    public OperationsTypes getOperationType() {
        return operationType;
    }
    
    /**
     * Setter for operation type
     * @param operationType type of preformed operation
     */
    public void setOperationType(OperationsTypes operationType) {
        this.operationType = operationType;
    }
    
    /**
     * Getter for operation result
     * @return result of preformed operation
     */
    public String getOpeartionResult() {
        return opeartionResult;
    }
    
    /**
     * Setter for operation result
     * @param opeartionResult result of preformed operation
     */
    public void setOpeartionResult(String opeartionResult) {
        this.opeartionResult = opeartionResult;
    }
    
    /**
     * Getter for operation time
     * @return time of preformed operation
     */
    public Date getOperationTime() {
        return operationTime;
    }
    
    /**
     * Setter for operation time
     * @param operationTime time of preformed operation
     */
    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }
    
}
