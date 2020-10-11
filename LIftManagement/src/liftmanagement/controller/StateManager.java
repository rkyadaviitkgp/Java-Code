/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liftmanagement.controller;

import com.sun.org.apache.xml.internal.dtm.ref.DTMDefaultBase;
import liftmanagement.entity.Lift;
import liftmanagement.entity.LiftRequest;
import liftmanagement.entity.LiftState;

/**
 *
 * @author rajeshkumar.yadav
 */
public class StateManager {
    
    LiftState state;

    public LiftState getState() {
        return state;
    }

    public void setState(LiftState state) {
        this.state = state;
    }

    public StateManager(LiftState state) {
        this.state = state;
    }
    
    public boolean checkAndSetState(Lift lift){
        
        //if gate is open the just close it and come out 
        if(state == LiftState.OPEN)
        {
            state = LiftState.CLOSE;
            return true;
        }
        
        //current floor is soucre then open the gate
        for(LiftRequest r : lift.getRequest()){
            // open and close
            if(lift.getCurrentFloor() == r.getSourceFloor() && !r.isSourceFinieshed() && lift.getLastFloorServed() != lift.getCurrentFloor()){
                //open gate
                state = LiftState.OPEN;
                r.setSourceFinieshed(true);
                lift.setLastFloorServed(lift.getCurrentFloor());
                lift.getDirection().setDirection(lift);
                return true;
            }
            
        }
        
        //current floor is destination then open 
        for(LiftRequest r : lift.getRequest()){
            // open and close
            if(lift.getCurrentFloor() == r.getDestinationFloor() && r.isSourceFinieshed() && lift.getLastFloorServed() != lift.getCurrentFloor()){
                //remove this request from queue
                lift.getRequest().remove(r);
                state  = LiftState.OPEN;
                lift.setLastFloorServed(lift.getCurrentFloor());
                lift.getDirection().setDirection(lift);
                return true;
            }
            
        }
        return false;
    }
    
    
}
