/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.service;

import com.airlines.models.Aeroplane;
import com.airlines.models.Flight;
import com.airlines.models.Passenger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rajeshkumar.yadav
 */
@Stateless
@LocalBean
public class FlightService {

    @PersistenceContext(unitName ="airline")
    private EntityManager em;

    public FlightService() {
        //this.<error> = "airline";
    }
    
    public void addFlight(Flight f, Aeroplane a){
        
        em.persist(f);
        em.persist(a);
        
    }
}
