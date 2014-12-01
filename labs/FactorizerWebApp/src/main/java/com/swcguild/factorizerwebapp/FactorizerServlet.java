package com.swcguild.factorizerwebapp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name = "FactorizerServlet", urlPatterns = {"/FactorizerServlet"})
public class FactorizerServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Integer numberToFactor = 0;
        
        
        boolean perfectNum;
        boolean primeNum;
        

        try {

            numberToFactor = Integer.parseInt(request.getParameter("numberToFactor"));
        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "please enter an integer");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }

        List<Integer> intList = new ArrayList<Integer>();
        int iTotal = 0;
        int factorCount = 0;

        //Scanner sc=new Scanner(System.in);
        // System.out.println("What number would you like to factor");
        // System.out.println("The factors of " + numberToFactor + " are: ");
        for (int i = 1; i < numberToFactor; i++) {

            if (numberToFactor % i == 0) {

                //System.out.println(i);
                intList.add(i);
                

                iTotal += i;
                factorCount += 1;

            }

        }

        //test for perfect number
        if (iTotal == numberToFactor) {

            //System.out.println(numberToFactor + " is a perfect number");
            perfectNum=true;
        } else {

           // System.out.println(numberToFactor + " is not a perfect number");
            perfectNum=false;
        }

        //Test is number is prime
        if (factorCount == 1) {

           // System.out.println(numberToFactor + " is a prime number");
            primeNum=true;

        } else {

            //System.out.println(numberToFactor + " is not a prime number");
            primeNum=false;
        }

        
        request.setAttribute("perfectNum", perfectNum);
        request.setAttribute("primeNum", primeNum);
        
        request.setAttribute("intList", intList);
        request.setAttribute("numberToFactor", numberToFactor);
       
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
