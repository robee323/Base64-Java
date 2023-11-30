package pl.polsl.lotawiec.robert.model.db.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import pl.polsl.lotawiec.robert.model.db.Log;

/**
 * Logs Data Access Object.
 *
 * @author Robert Lotawiec
 * @version 1.4
 */
public class DaoLog {
    
    /**
     * Entity manager used to preform transactions with database.
     */
    private EntityManager em;
    
    /**
     * Empty constructor
     * creates data access object and new entity manager
     */
    public DaoLog() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pl.polsl.base64_JPA_standalone_jar_1.0-SNAPSHOTPU");
        em = emf.createEntityManager();
    }
    
    /**
     * Constructor with entity manager parameter
     * creates data access object with given entity manager
     * @param em entity manager
     */
    public DaoLog(EntityManager em) {
        this.em = em;
    }
     
    /**
     * Saves object into database
     * @param object object that have to be saved
     */
    public void saveLog(Object object){
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
     * Updated given log object
     *
     * @param object Modified object
     */
    public void updateLog(Object object) {
        em.getTransaction().begin();
        em.merge(object);
        em.getTransaction().commit();
    }
    
    /**
     * Finds given log by id
     *
     * @param logId log identifier
     * @return searched object
     */
    public Log findLogById(Integer logId) {
        Log log = em.find(Log.class, logId);
        if (log == null) {
            throw new EntityNotFoundException("Can't find log for ID " + logId);
        }
        return log;
    }
    
    /**
     * Return list of all operations.
     * @return list of all operations
     */
    public List<Log> getOperations() {
        CriteriaQuery<Log> cq = em.getCriteriaBuilder().createQuery(Log.class);
        return em.createQuery(cq.select(cq.from(Log.class))).getResultList();
    }
    
}
