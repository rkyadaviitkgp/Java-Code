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
public class Booking {
    
    String id;
    Date journeyDate;
    Date bookingdate;
    String startCityId;
    String endCityId;
    String userId;

    public Booking(Date journeyDate, Date bookingdate, String startCityId, String endCityId, String userId) {
        this.journeyDate = journeyDate;
        this.bookingdate = bookingdate;
        this.startCityId = startCityId;
        this.endCityId = endCityId;
        this.userId = userId;
    }

    public Date getJourneyDate() {
        return journeyDate;
    }

    public void setJourneyDate(Date journeyDate) {
        this.journeyDate = journeyDate;
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
}
