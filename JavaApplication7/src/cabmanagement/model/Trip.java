/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabmanagement.model;

import java.util.Date;

/**
 *
 * @author rajeshkumar.yadav
 */
public class Trip {
    
    String tripId;
    String cabId;
    String bookingId;
    TripStatus status;

    public Trip(String Id, String cabId, String bookingId, TripStatus status) {
        this.tripId = Id;
        this.cabId = cabId;
        this.bookingId = bookingId;
        this.status = status;
    }

    public String getId() {
        return tripId;
    }

    public void setId(String Id) {
        this.tripId = Id;
    }

    public String getCabId() {
        return cabId;
    }

    public void setCabId(String cabId) {
        this.cabId = cabId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public TripStatus getStatus() {
        return status;
    }

    public void setStatus(TripStatus status) {
        this.status = status;
    }

}
