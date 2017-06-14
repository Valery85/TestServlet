 //trasfer parameters from brawser to code

package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;


public class ServletParamWork extends HttpServlet {
    
 //field for test Session attribute
    public int count;
    
    //to get init params wich was assigned in web.xml
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config); //To change body of generated methods, choose Tools | Templates.
        Enumeration en = config.getInitParameterNames();
        while (en.hasMoreElements()) {
            String nextElement = en.nextElement().toString();
            System.out.println("Param name =" + nextElement);  
            System.out.println (" Param value = " + config.getInitParameter(nextElement));
                   
            
        }
        System.out.println(config.getInitParameter("initparam"));

    }
     
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
  //increment count every time when user come to page      
          count++;
          
  // write field count as attribute in Session
          request.getSession().setAttribute("count", count);
        
          try (PrintWriter out = response.getWriter()) {
 
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletParamWork</title>");            
            out.println("</head>");
            out.println("<body>");
            
  // get all used parameters names
       // output on console
       Enumeration e = request.getParameterNames();
       
       while (e.hasMoreElements()){
           System.out.println(e.nextElement());
       }
       // output on page
       Enumeration e2 = request.getParameterNames();
       while (e2.hasMoreElements()){
           String param = e2.nextElement().toString();
           out.println("<h1>  " + param + " = " + request.getParameter(param) + " </h1>" );
       }
       
       
  // use name parameter p1  
            out.println("<h1> Parameter1 = " + request.getParameter("p1")+ "</h1>");
  
// output the count (session attribute)
            out.println("<h1> count = " + count +  "</h1>");
         
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
