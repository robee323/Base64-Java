package pl.polsl.lotawiec.robert.servlets;
import java.math.BigInteger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import pl.polsl.lotawiec.robert.model.db.dao.DaoLog;
import pl.polsl.lotawiec.robert.model.db.dao.DaoOperation;

/**
 * Inits web application lifecycle data
 * 
 * @author Robert Lotawiec
 * @version 1.4
 */
@WebListener
public class SessionLifetime implements ServletContextListener {

    /**
     * Class empty constructor
     */
    public SessionLifetime(){
        super();
    }
    
     /**
     * Initializes lifetime context
     * @param servletContextEvent context event
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pl.polsl.base64_JPA_standalone_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        servletContextEvent.getServletContext().setAttribute("entityManager", em);
        servletContextEvent.getServletContext().setAttribute("logsDao", new DaoLog(em));
        servletContextEvent.getServletContext().setAttribute("operationDao", new DaoOperation(em));
          
        
    }

    /**
     * Called when context is destroyed.
     * @param servletContextEvent context event
     */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}
