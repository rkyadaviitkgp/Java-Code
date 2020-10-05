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
        
        String fromDestination = request.getParameter("from_destination");
        String toDestination = request.getParameter("to_destination");
        Integer price = Integer.parseInt(request.getParameter("price"));
        Integer year = Integer.parseInt(request.getParameter("year"));
        Integer month = Integer.parseInt(request.getParameter("month"));
        Integer day = Integer.parseInt(request.getParameter("day"));
        Integer hour = Integer.parseInt(request.getParameter("hour"));
        Integer minute = Integer.parseInt(request.getParameter("minute"));
        String planeMake = request.getParameter("airplane_make");
        String modelName = request.getParameter("airplane_model");
        Integer seating = Integer.parseInt(request.getParameter("airplane_seating"));
        
        Flight f = new Flight();
        f.setDestination(Airport.valueOf(toDestination));
        f.setSource(Airport.valueOf(fromDestination));
        f.setPrice(price);
        
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, day);
        c.set(Calendar.HOUR, hour);
        c.set(Calendar.MINUTE, minute);
        Date d = c.getTime();
        f.setTime(d);
        
        Aeroplane a = new Aeroplane();
        a.setPlaneMake(planeMake);
        a.setModelName(modelName);
        a.setSeatingCapacity(seating);
        f.setAeroplaneDetails(a);
        fs.addFlight( f, a);
        response.sendRedirect("Flights");
        
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
