/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.trabpoo.servlets;

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
 * @author chris
 */
@WebServlet("/juros-compostos.jsp")
public class JurosCompostos extends HttpServlet {

    private Double values[];

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
        response.setContentType("text/html;charset=UTF-8");

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
        RequestDispatcher view = request.getRequestDispatcher("/juros-compostos.jsp");
        processRequest(request, response);
        view.forward(request, response);
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
        RequestDispatcher view = request.getRequestDispatcher("/juros-compostos.jsp");
        Double amount = request.getParameter("amount") != null && Double.parseDouble(request.getParameter("amount")) > 0 ? Double.parseDouble(request.getParameter("amount")) : -1;
        Double interest = request.getParameter("interest") != null && Double.parseDouble(request.getParameter("interest")) > 0 ? Double.parseDouble(request.getParameter("interest")) : -1;
        Integer time = request.getParameter("time") != null && Integer.parseInt(request.getParameter("time")) > 0 ? Integer.parseInt(request.getParameter("time")) : -1;
        if (!(amount > 0 && interest > 0 && time > 0)) {
            response.setStatus(400);
        }
        Double actualAmount[] = new Double[time];
        for (int i = 0; i < time; i++) {
            if (i == 0) {
                actualAmount[i] = amount;
                continue;
            }
            actualAmount[i] = actualAmount[i - 1] + actualAmount[i - 1] * (interest / 100);
        }
//        request.setAttribute("values", values);
        this.values = actualAmount;
        view.forward(request, response);
    }

    public Double[] getValues() {
        if (this.values != null) {
            return this.values;
        }
        return new Double[0];
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
