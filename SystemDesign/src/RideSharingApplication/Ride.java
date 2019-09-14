/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RideSharingApplication;

/**
 *
 * @author rajeshkumar.yadav
 */
public class Ride {
    
    StopName source;
    StopName destination;
    int seat;
    Driver offeredby;
    Passenger allotedTo;

    public Ride(StopName source, StopName destination, int seat) {
        this.source = source;
        this.destination = destination;
        this.seat = seat;
    }

    public void setPassenger(Passenger p)
    {
        this.allotedTo = p;
    }
    
    public Passenger getPassenger()
    {
        return this.allotedTo;
    }
    
    public StopName getSource() {
        return source;
    }

    public void setSource(StopName source) {
        this.source = source;
    }

    public StopName getDestination() {
        return destination;
    }

    public void setDestination(StopName destination) {
        this.destination = destination;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public Driver getOfferedby() {
        return offeredby;
    }

    public void setOfferedby(Driver offeredby) {
        this.offeredby = offeredby;
    }

    public Passenger getAllotedTo() {
        return allotedTo;
    }

    public void setAllotedTo(Passenger allotedTo) {
        this.allotedTo = allotedTo;
    }
    
    
    
    
}
