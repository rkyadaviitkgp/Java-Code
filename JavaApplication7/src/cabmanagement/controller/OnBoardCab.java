/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabmanagement.controller;

import cabmanagement.model.CabManagementEntity;
import cabmanagement.model.Cab;

/**
 *
 * @author rajeshkumar.yadav
 */
public class OnBoardCab implements OnBoard{

    @Override
    public CabManagementEntity onBoard(String configurationFileName) {
        //craete a cab
        //read cab details
        //Cab c = new Cab();
        return new CabManagementEntity();
    }
    
}