/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabmanagement.controller;

import cabmanagement.model.CabManagementEntity;
import cabmanagement.model.User;
import cabmanagement.model.User;
import cabmanagement.utility.ReadInput;
import java.util.Date;

/**
 *
 * @author rajeshkumar.yadav
 */
public class RegisterUser implements OnBoard {
    
    static int count = 0;

    @Override
    public CabManagementEntity onBoard(String configurationFileName) {
        //create user 
        String displayName = "", userName = "", password = "", dob = "";
        ReadInput inp = new ReadInput();
        System.out.println("Enter your DisplayName Username Password and dateofbirth(dd/mm/yyyy)");
        inp.readStringArray();
        if (inp.hasMoreString()) {
            displayName = inp.getNextString();
        }
        if (inp.hasMoreString()) {
            userName = inp.getNextString();
        }
        if (inp.hasMoreString()) {
            password = inp.getNextString();
        }
        if (inp.hasMoreString()) {
            dob = inp.getNextString();
        }
        String uid = "User " + count++;
        User u = new User(uid, displayName, userName, password, new Date(dob));
        inp  = null;
        return u;
    }

}
