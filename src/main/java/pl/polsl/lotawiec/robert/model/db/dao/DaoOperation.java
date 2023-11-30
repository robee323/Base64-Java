package pl.polsl.lotawiec.robert.model.db.dao;

import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import pl.polsl.lotawiec.robert.enums.OperationsTypes;
import pl.polsl.lotawiec.robert.model.db.Operation;

/**
 * Operations Data Access Object.
 *
 * @author Robert Lotawiec
 * @version 1.4
 */
public class DaoOperation {
    
    /**
     * Entity manager used to preform transactions with database.
     */
    private EntityManager em;
    
    /**
     * Empty constructor
     * creates data access object and new entity manager
     */
    public DaoOperation() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pl.polsl.base64_JPA_standalone_jar_1.0-SNAPSHOTPU");
        em = emf.createEntityManager();
        initValues();
    }
    
    /**
     * Constructor with entity manager parameter
     * creates data access object with given entity manager
     * @param em entity manager
     */
    public DaoOperation(EntityManager em) {
        this.em = em;
        initValues();
    }
    
    /**
     * Initializes the default operations types in the database
     */
    public void initValues(){
        List<OperationsTypes> operation_types = Arrays.asList(
                OperationsTypes.ENCRYPTION,
                OperationsTypes.DECRYPTION);
        
        operation_types.stream().forEach(t ->{
            System.out.println("pl.polsl.lotawiec.robert.model.db.dao.DaoOperation.initValues(): Cheking: "+ t.name());
            if (getOperations().stream().filter(o -> t.name().equals(o.getOperationName())).findFirst().isEmpty()){
                System.out.println("Adding " + t.name()+ " to DB");
                Operation operation = new Operation();
                operation.setOperationName(t.name());
                operation.setOperationDescription(t.getOperationDescription());
                operation.setId((long) t.getOperationIndex());
                saveOperation(operation);
            }
        });
    }
    
    /**
     * Saves object into database
     * @param object object that have to be saved
     */
    public void saveOperation(Object object){
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }
    
    /**
     * Updated given operations object
     *
     * @param object modified object
     */
    public void updateOperation(Object object) {
        em.getTransaction().begin();
        em.merge(object);
        em.getTransaction().commit();
    }
    
    /**
     * Finds given operation by id
     *
     * @param logId operation identifier
     * @return searched object
     */
    public Operation findOperationById(Long logId) {
        Operation operaiton = em.find(Operation.class, logId);
        if (operaiton == null) {
            throw new EntityNotFoundException("Can't find operation for ID " + logId);
        }
        return operaiton;
    }
    
    /**
     * Return list of all logs.
     * @return list of all logs
     */
    public List<Operation> getOperations() {
        CriteriaQuery<Operation> cq = em.getCriteriaBuilder().createQuery(Operation.class);
        return em.createQuery(cq.select(cq.from(Operation.class))).getResultList();
    }
}
