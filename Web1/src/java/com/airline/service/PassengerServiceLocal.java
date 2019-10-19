/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.service;

import com.airlines.models.Passenger;
import javax.ejb.Local;

/**
 *
 * @author rajeshkumar.yadav
 */
@Local
public interface PassengerServiceLocal {
    
    public void addPassenger(Passenger p);
    
}
