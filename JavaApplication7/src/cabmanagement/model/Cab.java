/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabmanagement.model;

/**
 *
 * @author rajeshkumar.yadav
 */
public class Cab extends CabManagementEntity{
    
    String noPlate;
    CabType type;
    CabStatus status;
    String currCityID;

    public String getNoPlate() {
        return noPlate;
    }

    public void setNoPlate(String noPlate) {
        this.noPlate = noPlate;
    }

    public CabType getType() {
        return type;
    }

    public void setType(CabType type) {
        this.type = type;
    }

    public CabStatus getStatus() {
        return status;
    }

    public void setStatus(CabStatus status) {
        this.status = status;
    }

    public String getCurrCityID() {
        return currCityID;
    }

    public void setCurrCityID(String currCityID) {
        this.currCityID = currCityID;
    }
    
}
