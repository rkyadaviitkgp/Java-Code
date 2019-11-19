/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airlines.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author rajeshkumar.yadav
 */
@NamedQuery(name ="Pilot.findById", query = "SELECT P FROM Pilot P WHERE P.id = :id")
@Entity
public class Pilot implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String firstName;
    private String lastName;
    private Integer pilotLisence;
    
    @Enumerated(EnumType.STRING) 
    private PilotRank pilotRank;
    
    @ManyToOne 
    @JoinColumn(name = "flight_fk")
    private Flight flightForPilot;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getPilotLisence() {
        return pilotLisence;
    }

    public void setPilotLisence(Integer pilotLisence) {
        this.pilotLisence = pilotLisence;
    }

    public PilotRank getPilotRank() {
        return pilotRank;
    }

    public void setPilotRank(PilotRank pilotRank) {
        this.pilotRank = pilotRank;
    }

    public Flight getFlightForPilot() {
        return flightForPilot;
    }

    public void setFlightForPilot(Flight flightForPilot) {
        this.flightForPilot = flightForPilot;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pilot)) {
            return false;
        }
        Pilot other = (Pilot) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pilot{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", pilotLisence=" + pilotLisence + ", pilotRank=" + pilotRank + ", flightForPilot=" + flightForPilot + '}';
    }

    
    
}
