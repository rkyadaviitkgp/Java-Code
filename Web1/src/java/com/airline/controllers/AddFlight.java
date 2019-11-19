/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.controllers;

import com.airline.service.FlightService;
import com.airlines.models.Aeroplane;
import com.airlines.models.Airport;
import com.airlines.models.Flight;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rajeshkumar.yadav
 */
@WebServlet(name = "AddFlight", urlPatterns = {"/AddFlight"})
public class AddFlight extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @EJB
    FlightService fs;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddFlight</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddFlight at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
        Flight f = new Flight();
        f.setDestination(Airport.DELHI);
        f.setSource(Airport.PUNE);
        f.setPrice(1000);
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 2019);
        c.set(Calendar.MONTH, 2);
        c.set(Calendar.DAY_OF_MONTH, 2);
        c.set(Calendar.HOUR, 7);
        c.set(Calendar.MINUTE, 10);
        Date d = c.getTime();
        f.setTime(d);
        
        Aeroplane a = new Aeroplane();
        a.setPlaneMake("Indigo");
        a.setModelName("777");
        a.setSeatingCapacity(250);
        
        f.setAeroplaneDetails(a);
        
        System.out.println(f);
        System.out.println(a);
        PrintWriter out = response.getWriter();
        out.println(f);
        out.println(a);
        fs.addFlight( f, a);
        
        
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
