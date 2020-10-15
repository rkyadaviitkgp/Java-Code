/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabmanagement.controller;

import cabmanagement.model.Booking;
import cabmanagement.model.Trip;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author rajeshkumar.yadav
 */
public class TripManager {
    
    List<Booking> bookingList;
    List<Trip> tripList;

    public TripManager() {
        tripList = new LinkedList<>();
        bookingList = new LinkedList<>();
    }

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    public List<Trip> getTripList() {
        return tripList;
    }

    public void setTripList(List<Trip> tripList) {
        this.tripList = tripList;
    }
    
    
    
    
}
