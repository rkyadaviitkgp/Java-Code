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
public class CabInfo {
    
    String cabId;
    CabStatus cabStatus;
    Date time;
    Trip trip;
    String currentCity;

    public CabInfo(CabStatus cabStatus, Date time, Trip trip, String currentCity) {
        this.cabStatus = cabStatus;
        this.time = time;
        this.trip = trip;
        this.currentCity = currentCity;
    }

    @Override
    public String toString() {
        return "CabInfo{" + "cabId=" + cabId + ", cabStatus=" + cabStatus + ", time=" + time + ", trip=" + trip + ", currentCity=" + currentCity + '}';
    }
    
    

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }
    
    public String getCabId() {
        return cabId;
    }

    public void setCabId(String cabId) {
        this.cabId = cabId;
    }

    public CabStatus getCabStatus() {
        return cabStatus;
    }

    public void setCabStatus(CabStatus cabStatus) {
        this.cabStatus = cabStatus;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }
    
}
