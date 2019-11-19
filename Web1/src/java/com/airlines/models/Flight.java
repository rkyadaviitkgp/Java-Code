 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airlines.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author rajeshkumar.yadav
 */
@Entity
@NamedQuery(name ="Flight.findById", query = "SELECT f FROM Flight f WHERE f.id = :id")
public class Flight implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private int price;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    
    @Enumerated(EnumType.STRING)
    private Airport source;
    
    @Enumerated(EnumType.STRING)
    private  Airport destination;
    
    @OneToOne
    @JoinColumn(name ="aeroplane_fk")
    private Aeroplane aeroplaneDetails;
    
    @OneToMany(mappedBy = "flightForPilot")
    private List<Pilot> pilots;

    public List<Pilot> getPilots() {
        return pilots;
    }

    public void setPilots(List<Pilot> pilots) {
        this.pilots = pilots;
    }
    
    

    public Aeroplane getAeroplaneDetails() {
        return aeroplaneDetails;
    }

    public void setAeroplaneDetails(Aeroplane aeroplaneDetails) {
        this.aeroplaneDetails = aeroplaneDetails;
    }

    
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Airport getSource() {
        return source;
    }

    public void setSource(Airport source) {
        this.source = source;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Flight)) {
            return false;
        }
        Flight other = (Flight) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Flight{" + "id=" + id + ", price=" + price + ", time=" + time + ", source=" + source + ", destination=" + destination + ", aeroplaneDetails=" + aeroplaneDetails + ", pilots=" + pilots + '}';
    } 
    
    
}
