/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabmanagement.controller;

import cabmanagement.model.Booking;
import cabmanagement.model.User;
import java.time.format.FormatStyle;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author rajeshkumar.yadav
 */
public class UserManager {
    List<User> registeredUser;
    Hashtable<String, List<Booking>> userBookingHashTable;

    public UserManager() {
        registeredUser = new LinkedList<>();
        userBookingHashTable = new Hashtable<>();
    }

    public List<User> getRegisteredUser() {
        return registeredUser;
    }

    public Hashtable<String, List<Booking>> getUserBookingHashTable() {
        return userBookingHashTable;
    }
    
    //add booking for a user
    public boolean addBooking(String userId, Booking b){
        List<Booking> list = userBookingHashTable.get(userId);
        if(list == null)
        {
            list = new LinkedList<>();
            userBookingHashTable.put(userId, list);
        }
        list.add(b);
        return true;
    }
    
    // register/add a user
    public boolean registerUser(User u)
    {
        registeredUser.add(u);
        return true;
    }
    
    // check Login credential
    public User loginUser(String userName, String password)
    {
        return getUserByUserNameAndPassword(userName, password);
    }
    
    //get User by userName and password
    public User getUserByUserNameAndPassword(String userName, String password){
        for(User u: registeredUser)
        if(u.getUserName().equals(userName) && u.getPassword().equals(password))
            return u;
        return null;
    }
    
    //check login credentials
    private boolean checkCredentials(String userName, String password){
        for(User u: registeredUser)
        if(u.getUserName().equals(userName) && u.getPassword().equals(password))
            return true;
        return false;
    }
    
    // get user
    public User getUserById(String userId)
    {
        for(User u: registeredUser)
            if(u.getId().equals(userId))
                return u;
        return null;
    }
    
}
