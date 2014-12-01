package com.swcguild.lucky7swebapp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
@WebServlet(name = "Lucky7sServlet", urlPatterns = {"/Lucky7sServlet"})
public class Lucky7sServlet extends HttpServlet {

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

//        Scanner userInput = new Scanner(System.in);

        List <String> messageList=new ArrayList<String>();
        Random rGen = new Random();

        int randomNum = rGen.nextInt(8) + 1;

        int rollOne = 0;
        int rollTwo = 0;
        int moneySum = 0;
        int rollCount = 0;
        int maxAmount = 0;
        int rollSum;
        int addCount = 0;
        String rollSumX;
        String moneySumX;
        String rollCountX;
        String addCountX;

// System.out.println("How much money do you have to bet?");
        //moneySum = Integer.parseInt(userInput.nextLine());
        try {
            moneySum = Integer.parseInt(request.getParameter("answer"));
        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "please enter an integer");
            
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");  //leaving it as index
            rd.forward(request, response);
        }

        maxAmount = moneySum;

        while (moneySum > 0) {

            rollOne = rGen.nextInt(6) + 1;
            rollTwo = rGen.nextInt(6) + 1;

            rollSum = rollOne + rollTwo;
            rollCount++;

            //  System.out.println("\n" + "You rolled " + rollSum);
           messageList.add("You rolled: " + rollSum);

          
            

            if (rollSum == 7) {

                moneySum += 4;
                maxAmount += 4;

                if (moneySum > maxAmount) {
                    maxAmount = moneySum;
                    addCount = rollCount;
                   
                }

            } else {
                moneySum -= 1;

            }

            //System.out.println("You have " + moneySum + " dollars remaining");
            messageList.add("You have: " + moneySum + " dollars remaining");
            
           

        }

        // System.out.print("\n" + "You rolled " + rollCount + " times...");
        request.setAttribute("rollCount", rollCount);
       

        //  System.out.println("You should have stopped at " + addCount + " when you had + " + maxAmount);
      
        request.setAttribute("addCount", addCount);

        request.setAttribute("maxAmount", maxAmount);
       
        request.setAttribute("messageList", messageList);
        
        RequestDispatcher rd = request.getRequestDispatcher("response.jsp");
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
