/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.service;

import com.airlines.models.Flight;
import com.airlines.models.Pilot;
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
public class PilotService {

    @PersistenceContext(unitName = "airline")
    EntityManager em;
    
    public PilotService(){
        
    }
    
    public void addPilot(Pilot p){
        em.persist(p);
    }
    
    public void addPilotToFlight(String pilotId, String flightId){
        
        TypedQuery<Flight> fQuery = em.createNamedQuery("Flight.findById", Flight.class);
        fQuery.setParameter("id", Integer.parseInt(flightId));
        Flight f = fQuery.getSingleResult();
        
        TypedQuery<Pilot> pQuery = em.createNamedQuery("Pilot.findById", Pilot.class);
        pQuery.setParameter("id", Integer.parseInt(pilotId));
        Pilot p = pQuery.getSingleResult();
                
    }
}
