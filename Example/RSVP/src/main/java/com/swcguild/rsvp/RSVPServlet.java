
package com.swcguild.rsvp;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



//we can change this annotation at any time to change URL pattern

@WebServlet(name = "RSVPServlet", urlPatterns = {"/RSVPServlet"})
public class RSVPServlet extends HttpServlet {
//http servlet class does a bunch of stuff for us
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String answer=request.getParameter("answer");  //we named it "answer" in the html form (in index.jsp)
        String message="";
        int numAttending=0;
        
        try{
        numAttending=Integer.parseInt(request.getParameter("numAttending"));  //whatever you call it in your html, call it in your variable so you remember
        }catch (NumberFormatException e) {
        request.setAttribute("errorMessage", "please enter an integer");
        RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
        }
        
        if (answer.equalsIgnoreCase("no")){
        message="Sorry you can't make it";
        }
        else {
        message="Can't wait to see you!  I'll reserve " + numAttending + " seats for you";
        }    
// we did the processing here, now send this back to view component using next 3 lines
        //forwards added information
        //acting like controller, telling jsp to display the view
        request.setAttribute("message", message);
        RequestDispatcher rd=request.getRequestDispatcher("response.jsp");
        rd.forward(request, response);
                    
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
        processRequest(request, response);   //commenting this out makes it so nothing happens when you click submit
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
