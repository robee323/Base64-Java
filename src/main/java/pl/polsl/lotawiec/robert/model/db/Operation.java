package pl.polsl.lotawiec.robert.model.db;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Operations types Entity
 * @author Robert Lotawiec
 * version 1.4
 */
@Entity
@Table(name="operations_types")
public class Operation implements Serializable {
    
    /**
     * Operation id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; 
    
    /**
     * Operation name
     */
    @Column(name = "operation_name", nullable = false)
    private String operationName;
    
    /**
     * Operation description
     */
    @Column(name = "operation_description", nullable = false)
    private String operationDescription;
    
    /**
     * Entity empty constructor
     */
    public Operation() {}
    
    /**
     * Gets operation identifier.
     * @return identifier of the operation
     */
    public Long getId() {
        return id;
    }
    
    /**
     * Sets operation identifier.
     * @param id identifier of the operation
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * Gets name of the operation.
     * @return name of the operation.
     */
    public String getOperationName() {
        return operationName;
    }
    
    /**
     * Sets operation name.
     * @param operationName new name of the operation
     */
    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }
    
    /**
     * Gets description of the operation.
     * @return description of the operation.
     */
    public String getOperationDescription() {
        return operationDescription;
    }
    
    /**
     * Sets operation description.
     * @param operationDescription new name of the operation
     */
    public void setOperationDescription(String operationDescription) {
        this.operationDescription = operationDescription;
    }
    
}
