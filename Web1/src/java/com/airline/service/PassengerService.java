/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.service;

import com.airlines.models.Passenger;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author rajeshkumar.yadav
 */
@Stateless
@LocalBean
public class PassengerService  {
    
    @PersistenceContext(unitName ="airline")
    private EntityManager em;

    public PassengerService() {
        //this.<error> = "airline";
    }
    
    public void addPassenger(Passenger p){
        
        em.persist(p); 
        
    }
    
    public List<Passenger> getPassenger(){
        
        TypedQuery<Passenger> fquery = em.createNamedQuery("Passenger.getPassenger", Passenger.class);
        //fquery.setParameter("id", Integer.parseInt(flightId));
        List<Passenger> plist = fquery.getResultList();
        return plist;
        
    }
    
}
