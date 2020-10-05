/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabmanagement.controller;

import cabmanagement.model.City;
import cabmanagement.model.User;
import cabmanagement.model.Cab;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rajeshkumar.yadav
 */

public class CabBookingController {
    
    List<Cab> cabList;
    List<City> cityList;
    List<User> userList;
    OnBoard onBoardUser;
    OnBoard onBoardCity;
    OnBoard onBoardCab;
    
    public void CabBookingController(){
        cabList     = new ArrayList<>();
        cityList    = new ArrayList<>();
        userList    = new ArrayList<>();
        onBoardUser = new RegisterUser();
        onBoardCity = new OnBoardCity();
        onBoardCab  = new OnBoardCab();
    }
   
}
