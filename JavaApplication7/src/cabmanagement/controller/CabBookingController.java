/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabmanagement.controller;

import cabmanagement.model.City;

/**
 *
 * @author rajeshkumar.yadav
 */

public class CabBookingController {
   
   CabManager cabManager;
   CityManager cityManager;
   UserManager userManager;
   TripManager tripManager;

    public CabBookingController() {
        cabManager  = new CabManager();
        cityManager = new CityManager();
        userManager = new UserManager();
        tripManager = new TripManager();
    }

    public CabManager getCabManager() {
        return cabManager;
    }

    public void setCabManager(CabManager cabManager) {
        this.cabManager = cabManager;
    }

    public CityManager getCityManager() {
        return cityManager;
    }

    public void setCityManager(CityManager cityManager) {
        this.cityManager = cityManager;
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    public TripManager getTripManager() {
        return tripManager;
    }

    public void setTripManager(TripManager tripManager) {
        this.tripManager = tripManager;
    }
    
    // get demanded city
    public City getDemandedCity(){
        String cityId = tripManager.getDemandedCity();
        return cityManager.getCity(cityId);
    }
   
}
