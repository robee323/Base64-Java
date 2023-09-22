package pl.polsl.lotawiec.robert.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet used for forwarding user to the main page.
 * 
 * @author Robert Lotawiec
 * @version 1.3
 * 
 */
public class HomeServlet extends HttpServlet {
    
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
        doRequest(request, response);
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
        doRequest(request, response);
    }
    
    
    /**
     * Forwards user to the main page.
     *
     * @param request user request
     * @param response server response
     * @throws IOException if a servlet-specific error occurs
     * @throws ServletException if an I/O error occurs
     * 
     */
    private void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/").forward(request, response);
    }
}
