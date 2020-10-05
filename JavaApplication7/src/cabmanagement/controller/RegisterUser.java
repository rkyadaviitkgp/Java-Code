/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabmanagement.controller;

import cabmanagement.model.CabManagementEntity;
import cabmanagement.model.User;
import cabmanagement.model.User;

/**
 *
 * @author rajeshkumar.yadav
 */
public class RegisterUser implements OnBoard{

    @Override
    public CabManagementEntity onBoard() {
         //create user 
         User u = new User();
         return u;
    }
    
}
