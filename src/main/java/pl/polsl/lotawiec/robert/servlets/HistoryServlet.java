package pl.polsl.lotawiec.robert.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pl.polsl.lotawiec.robert.model.HistoryEntry;

/**
 * Servlet used getting history of operations.
 *
 * @author Robert Lotawiec
 * @version 1.3
 * 
 */
public class HistoryServlet extends HttpServlet {
    
    
    /**
     * Handles the GET request and sends response.
     *
     @param request user request
     @param response server response
     @throws IOException if a servlet-specific error occurs
     @throws ServletException if an I/O error occurs
     * 
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doRequest(request, response);
    }
    
    /**
     * Handles the POST request and sends response.
     *
     @param request user request
     @param response server response
     @throws IOException if a servlet-specific error occurs
     @throws ServletException if an I/O error occurs
     * 
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doRequest(request, response);
    }
    
    
    /**
     * Handles the history request
     *
     @param req user request
     @param resp server response
     @throws ServletException if a servlet-specific error occurs
     @throws IOException if an I/O error occurs
     * 
     */
    private void doRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        
        List<HistoryEntry> history = (List<HistoryEntry>) session.getAttribute("opeations-history");
        
        if (history == null)
            history = new ArrayList<>();
        
        out.print("<table><tr><th>Time</th><th>Operation</th><th>Result</th></tr>");
        
        history.forEach((HistoryEntry h) ->{
            out.print("<tr><td>"
                    +new SimpleDateFormat("HH:mm:ss.SSS").format(h.getOperationTime())+"</td><td>"
                    +h.getOperationType().getOperationDescription()+"</td><td>"
                    +h.getOpeartionResult()+"</td></tr>");
        });
        
        out.print("</table>");
    }
}
