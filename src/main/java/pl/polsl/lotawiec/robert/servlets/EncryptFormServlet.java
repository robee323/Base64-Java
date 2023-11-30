package pl.polsl.lotawiec.robert.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import pl.polsl.lotawiec.robert.enums.OperationsTypes;
import pl.polsl.lotawiec.robert.model.Base64Model;
import pl.polsl.lotawiec.robert.model.HistoryEntry;
import pl.polsl.lotawiec.robert.model.IllegalCharacterException;
import pl.polsl.lotawiec.robert.model.db.Log;
import pl.polsl.lotawiec.robert.model.db.dao.DaoLog;
import pl.polsl.lotawiec.robert.model.db.dao.DaoOperation;

/**
 * Servlet used for encrypting the data
 *
 * @author Robert Lotawiec
 * @version 1.4
 * 
 */
public class EncryptFormServlet extends HttpServlet {
    
    
    /**
     * Model of application
     * provides methods used to encrypt and decrypt the data
     */
    private Base64Model base64Model = new Base64Model();
    /** A regex that the input string has to match to be dencoded from BASE64 to ASCII*/
    private static final String PATTERN_ASCII = "^([ A-Za-z0-9+_]{1,})+[ \\t\\n\\x0B\\f\\r]*";
    
    /**
     * History Data Access Object
     */
    private DaoLog logsDao;
    
    
    /**
     * Operation Data Access Object
     */
    private DaoOperation operationDao;
    
    /**
     * Finds instance of DAOs and RSA form servlet context
     */
    @Override
    public void init() {
        logsDao = (DaoLog) getServletContext().getAttribute("logsDao");
        operationDao = (DaoOperation) getServletContext().getAttribute("operationDao");
    }
    
    /**
     * Handles the GET request and sends response.
     *
     * @param request user request
     * @param response server response
     * @throws IOException if a servlet-specific error occurs
     * @throws ServletException if an I/O error occurs
     * 
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            doRequest(request, response);
        } catch (IllegalCharacterException ex) {
            Logger.getLogger(EncryptFormServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Handles the POST request and sends response.
     *
     * @param request user request
     * @param response server response
     * @throws IOException if a servlet-specific error occurs
     * @throws ServletException if an I/O error occurs
     * 
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            doRequest(request, response);
        } catch (IllegalCharacterException ex) {
            Logger.getLogger(EncryptFormServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    /**
     * Handles the encrypt request
     *
     * @param request user request
     * @param response server response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws IllegalCharacterException when string with invalid characters occurs
     * 
     */
    public void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IllegalCharacterException {
        
        request.setCharacterEncoding("UTF-8");
        response.setContentType("UTF-8");
        
        OperationsTypes operation = OperationsTypes.ENCRYPTION;
        
        PrintWriter out = response.getWriter();
        
        
        Cookie errorCookie = new Cookie("NumberOfErrors", "0");
        Cookie operationCookie = new Cookie(operation.name(), "0");
        if(request.getCookies()!=(null))
        {
        for (Cookie c : request.getCookies()) {
            if ("NumberOfErrors".equals(c.getName())) {
                errorCookie = c;
            }
            if(operation.name().equals(c.getName())) {
                operationCookie = c;
            }
        }
        }
        
        
        String encryptMessage = request.getParameter("encryptMessage");
        
        if (encryptMessage.equals("") || encryptMessage.equals(null)){ //encryptMessage.length() == 0 
            errorCookie.setValue(String.valueOf(Integer.parseInt(errorCookie.getValue()) + 1));
            response.addCookie(errorCookie);
            
            response.sendError(response.SC_BAD_REQUEST, "Fill in the input field!");
            
            return;
        }
        try 
        {
            base64Model.validateString(encryptMessage, PATTERN_ASCII);
        } 
        catch (IllegalCharacterException ex) 
        {
            errorCookie.setValue(String.valueOf(Integer.parseInt(errorCookie.getValue()) + 1));
            response.addCookie(errorCookie);
            
            response.sendError(response.SC_BAD_REQUEST, ex.getMessage()+"! Check the correctness of your input and try again");
            
            return;
        }
        String result = base64Model.encode(encryptMessage);
        out.println("<p><span>Encrypted: </span>"+result+"</p>");
        
        operationCookie.setValue(String.valueOf(Integer.parseInt(operationCookie.getValue()) + 1));
        response.addCookie(operationCookie);
        
        /*HttpSession currSession = request.getSession();
        List<HistoryEntry> history = (List<HistoryEntry>) currSession.getAttribute("opeations-history");
        if (history == null) {
            history = new ArrayList<>();
        }
        history.add(new HistoryEntry(operation, result));
        currSession.setAttribute("opeations-history", history);*/
        Log log = new Log();
        log.setOperationType(operationDao.findOperationById((long) operation.getOperationIndex()));
        log.setExecutionTime(new Timestamp(System.currentTimeMillis()));
        
        logsDao.saveLog(log);
    
    }
}
