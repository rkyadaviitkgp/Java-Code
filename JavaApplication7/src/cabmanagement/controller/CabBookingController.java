/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabmanagement.controller;

import cabmanagement.model.City;
import cabmanagement.model.User;
import cabmanagement.model.Cab;
import cabmanagement.model.CabManagementEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rajeshkumar.yadav
 */

public class CabBookingController {
    
    List<CabManagementEntity> onBoardedCabs;
    List<CabManagementEntity> onBoardedCity;
    List<CabManagementEntity> registeredUser;
    OnBoard onBoardUser;
    OnBoard onBoardCity;
    OnBoard onBoardCab;
    
    public CabBookingController(){
        onBoardedCabs       = new ArrayList<>();
        onBoardedCity       = new ArrayList<>();
        registeredUser      = new ArrayList<>();
        onBoardUser         = new RegisterUser();
        onBoardCity         = new OnBoardCity();
        onBoardCab          = new OnBoardCab();
    }

    public List<CabManagementEntity> getOnBoardedCabs() {
        return onBoardedCabs;
    }

    public void setOnBoardedCabs(List<CabManagementEntity> onBoardedCabs) {
        this.onBoardedCabs = onBoardedCabs;
    }

    public List<CabManagementEntity> getOnBoardedCity() {
        return onBoardedCity;
    }

    public void setOnBoardedCity(List<CabManagementEntity> onBoardedCity) {
        this.onBoardedCity = onBoardedCity;
    }

    public List<CabManagementEntity> getRegisteredUser() {
        return registeredUser;
    }

    public void setRegisteredUser(List<CabManagementEntity> registeredUser) {
        this.registeredUser = registeredUser;
    }

    public OnBoard getOnBoardUser() {
        return onBoardUser;
    }

    public void setOnBoardUser(OnBoard onBoardUser) {
        this.onBoardUser = onBoardUser;
    }

    public OnBoard getOnBoardCity() {
        return onBoardCity;
    }

    public void setOnBoardCity(OnBoard onBoardCity) {
        this.onBoardCity = onBoardCity;
    }

    public OnBoard getOnBoardCab() {
        return onBoardCab;
    }

    public void setOnBoardCab(OnBoard onBoardCab) {
        this.onBoardCab = onBoardCab;
    }
    
    
   
}
