package pl.polsl.lotawiec.robert.model.db;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Logs Entity
 * @author Robert Lotawiec
 * version 1.4
 */
@Entity
@Table(name="history")
public class Log implements Serializable {
    
    
    /**
     * Log id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    /**
     * Preformed operation type
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "operation_type", nullable = false)
    private Operation operationType;
    
    /**
     * Operation execution time
     */
    @Column(name = "execution_time", nullable = false)
            private Timestamp executionTime;
    
    /**
     * Entity empty constructor
     */
    public Log() {}
    
    /**
     * Gets log identifier.
     * @return identifier of the log
     */
    public Long getId() {
        return id;
    }
    
    /**
     * Sets log identifier.
     * @param id identifier of the log
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * Gets log operation type.
     * @return operation type of the log
     */
    public Operation getOperationType() {
        return operationType;
    }
    
    /**
     * Sets log operation types.
     * @param operationType operation types of the log
     */
    public void setOperationType(Operation operationType) {
        this.operationType = operationType;
    }
    
    /**
     * Gets execution time identifier.
     * @return execution time of the log
     */
    public Timestamp getExecutionTime() {
        return executionTime;
    }
    
    /**
     * Sets log execution time.
     * @param executionTime execution time of the log
     */
    public void setExecutionTime(Timestamp executionTime) {
        this.executionTime = executionTime;
    }
}
