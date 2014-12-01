package com.swcguild.webappsitelab.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author apprentice
 */
@WebServlet(urlPatterns = {"/UnitConverterServlet"})
public class UnitConverterServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        double miles = 0;
        double kilometers = 0;
        double number = 0;
        boolean startWithMiles = true;

        String startingUnits = request.getParameter("startingUnits");

        try {
            number = Double.parseDouble(request.getParameter("number"));  //whatever you call it in your html, call it in your variable so you remember
        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "please enter a valid number");
            RequestDispatcher rd = request.getRequestDispatcher("indexUC.jsp");
            rd.forward(request, response);
        }

        if (startingUnits.equalsIgnoreCase("miles")) {
            startWithMiles = true;
            miles = number;

            kilometers = miles * 1.60934;
//            request.setAttribute("startWithMiles", startWithMiles);
//            request.setAttribute("miles", miles);
//            request.setAttribute("kilometers", kilometers);

        } else if (startingUnits.equalsIgnoreCase("kilometers")) {
            startWithMiles = false;
            kilometers = number;

            miles = kilometers / 1.60934;
//            request.setAttribute("startWithMiles", startWithMiles);
//            request.setAttribute("miles", miles);
//            request.setAttribute("kilometers", kilometers);

        }

        
        request.setAttribute("startWithMiles", startWithMiles);
        request.setAttribute("miles", miles);
        request.setAttribute("kilometers", kilometers);

        RequestDispatcher rd = request.getRequestDispatcher("responseUC.jsp");
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
