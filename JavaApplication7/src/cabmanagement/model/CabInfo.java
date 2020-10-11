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
    
    String id;
    CabStatus status;
    Date timeStamp;
    String currentCity;

    public CabInfo(String id, CabStatus status, Date timeStamp, String currentCity) {
        this.id = id;
        this.status = status;
        this.timeStamp = timeStamp;
        this.currentCity = currentCity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CabStatus getStatus() {
        return status;
    }

    public void setStatus(CabStatus status) {
        this.status = status;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }
    
    
    
    
}
