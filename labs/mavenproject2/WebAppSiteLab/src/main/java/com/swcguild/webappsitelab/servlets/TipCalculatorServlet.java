
package com.swcguild.webappsitelab.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "TipCalculatorServlet", urlPatterns = {"/TipCalculatorServlet"})
public class TipCalculatorServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        double cost=0;
    
        try{
        cost=Double.parseDouble(request.getParameter("cost"));
        }catch(NumberFormatException e) {
            request.setAttribute("errorMessage", "please enter an integer");
            RequestDispatcher rd = request.getRequestDispatcher("indexTC.jsp");
            rd.forward(request, response);
        }
       
        double tipPercentage=Double.parseDouble(request.getParameter("tipPercentage"));
        double tipRatio=tipPercentage/100;
        double tip=tipRatio*cost;
        double totalCost=(tipRatio*cost +cost);
        
        request.setAttribute("cost", cost);
        request.setAttribute("tipPercentage", tipPercentage);
        request.setAttribute("tip", tip); 
        request.setAttribute("totalCost", totalCost);
        
        RequestDispatcher rd=request.getRequestDispatcher("responseTC.jsp");
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
