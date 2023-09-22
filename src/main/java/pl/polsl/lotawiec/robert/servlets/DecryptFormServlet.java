package pl.polsl.lotawiec.robert.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import pl.polsl.lotawiec.robert.enums.OperationsTypes;
import pl.polsl.lotawiec.robert.model.Base64Model;
import pl.polsl.lotawiec.robert.model.HistoryEntry;
import pl.polsl.lotawiec.robert.model.IllegalCharacterException;

/**
 * Servlet used for decrypting the data
 *
 * @author Robert Lotawiec
 * @version 1.3
 * 
 */
public class DecryptFormServlet extends HttpServlet {
    
    
    /**
     * Model of application
     * provides methods used to encrypt and decrypt the data
     */
     private Base64Model base64Model = new Base64Model();
    /** A regex that the input string has to match to be encoded from ASCII to BASE64*/
    private static final String PATTERN_BASE64 = "^([A-Za-z0-9+_]{4})*([A-Za-z0-9+_]{3}=|[A-Za-z0-9+_]{2}==)?$";

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
            Logger.getLogger(DecryptFormServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(DecryptFormServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    /**
     * Handles the decrypt request
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
        
        OperationsTypes operation = OperationsTypes.DECRYPTION;
        PrintWriter out = response.getWriter();
        //if cookie getcookies is different than null
        if(request.getCookies()!=(null))
        {
        Cookie errorCookie = new Cookie("NumberOfErrors", "0");
        Cookie operationCookie = new Cookie(operation.name(), "0");
        for (Cookie c : request.getCookies()) {
            if ("NumberOfErrors".equals(c.getName())) {
                errorCookie = c;
            }
            if(operation.name().equals(c.getName())) {
                operationCookie = c;
            }
        }
        
        
        String decryptMessage = request.getParameter("decryptMessage");
        //add null
        if (decryptMessage.equals("") || decryptMessage.equals(null)) {
            errorCookie.setValue(String.valueOf(Integer.parseInt(errorCookie.getValue()) + 1));
            response.addCookie(errorCookie);
            
            response.sendError(response.SC_BAD_REQUEST, "Fill in the input field!");
            return;
        }
        String result = null;
        
        try 
        {
            base64Model.validateString(decryptMessage, PATTERN_BASE64);
        } catch (IllegalCharacterException ex) {
            errorCookie.setValue(String.valueOf(Integer.parseInt(errorCookie.getValue()) + 1));
            response.addCookie(errorCookie);
            
            response.sendError(response.SC_BAD_REQUEST, ex.getMessage()+"! Check the correctness of your input and try again");
            return;
        }
        result=base64Model.decode(decryptMessage);
        out.println("<p><span>Decrypted: </span>"+result+"</p>");
        operationCookie.setValue(String.valueOf(Integer.parseInt(operationCookie.getValue()) + 1));
        response.addCookie(operationCookie);
        
        HttpSession currSession = request.getSession();
        List<HistoryEntry> history = (List<HistoryEntry>) currSession.getAttribute("opeations-history");
        if (history == null) {
            history = new ArrayList<>();
        }
        history.add(new HistoryEntry(operation, result));
        currSession.setAttribute("opeations-history", history);
    }
    }
}
