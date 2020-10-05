/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabmanagement.controller;

import cabmanagement.model.CabManagementEntity;
import cabmanagement.model.City;

/**
 *
 * @author rajeshkumar.yadav
 */
public class OnBoardCity implements OnBoard{

    @Override
    public CabManagementEntity onBoard() {
        //create a city 
        City c = new City();
        return c;
        //
    }
    
}
