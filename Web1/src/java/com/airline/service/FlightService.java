/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.service;

import com.airlines.models.Aeroplane;
import com.airlines.models.Flight;
import com.airlines.models.Passenger;
import com.airlines.models.Pilot;
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
    
    public void addPilotToFlight(String pilotId, String flightId){
        
        TypedQuery<Flight> fquery = em.createNamedQuery("Flight.findById", Flight.class);
        fquery.setParameter("id", Integer.parseInt(flightId));
        Flight f = fquery.getSingleResult();
        
        TypedQuery<Pilot> pquery = em.createNamedQuery("Pilot.findById", Pilot.class);
        pquery.setParameter("id", Integer.parseInt(pilotId));
        Pilot p = pquery.getSingleResult();
        
        List<Pilot> plist = f.getPilots();
        plist.add(p); 
        f.setPilots(plist);
        p.setFlightForPilot(f);
        
    }
    
    public List<Flight> getFlight(){
        
        TypedQuery<Flight> fquery = em.createQuery("SELECT f from Flight f", Flight.class);
        List<Flight> results = fquery.getResultList();
        return results;  
    }
    
}
