/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabmanagement.model;

import java.util.Date;
import java.util.Random;

/**
 *
 * @author rajeshkumar.yadav
 */
public class Booking {
    
    String bookingId;
    Date bookingdate;
    Date startTime;
    Date endTime;
    String startCityId;
    String endCityId;
    String userId;
    String transactionId;

    public Booking(Date bookingdate, Date startTime, Date endTime, String startCityId, String endCityId, String userId, String transactionId) {
        this.bookingId = "booking" + new Random().ints(1000);
        this.bookingdate = bookingdate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.startCityId = startCityId;
        this.endCityId = endCityId;
        this.userId = userId;
        this.transactionId = transactionId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Date getBookingdate() {
        return bookingdate;
    }

    public void setBookingdate(Date bookingdate) {
        this.bookingdate = bookingdate;
    }

    public String getStartCityId() {
        return startCityId;
    }

    public void setStartCityId(String startCityId) {
        this.startCityId = startCityId;
    }

    public String getEndCityId() {
        return endCityId;
    }

    public void setEndCityId(String endCityId) {
        this.endCityId = endCityId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Booking{" + "bookingId=" + bookingId + ", bookingdate=" + bookingdate + ", startTime=" + startTime + ", endTime=" + endTime + ", startCityId=" + startCityId + ", endCityId=" + endCityId + ", userId=" + userId + ", transactionId=" + transactionId + '}';
    }

}
