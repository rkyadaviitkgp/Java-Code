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
    
    String Id;
    String cabId;
    String bookingId;
    TripStatus status;
    Date startTime;
    Date endTime;

    public Trip(String Id, String cabId, String bookingId, TripStatus status, Date startTime, Date endTime) {
        this.Id = Id;
        this.cabId = cabId;
        this.bookingId = bookingId;
        this.status = status;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

}
