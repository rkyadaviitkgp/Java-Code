/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liftmanagement.controller;

import liftmanagement.entity.Lift;
import liftmanagement.entity.LiftDirection;
import liftmanagement.entity.Request;

/**
 *
 * @author rajeshkumar.yadav
 */
public class DirectionManager {
    
    LiftDirection direction;

    public DirectionManager(LiftDirection direction) {
        this.direction = direction;
    }

    public LiftDirection getDirection() {
        return direction;
    }

    public void setDirection(LiftDirection direction) {
        this.direction = direction;
    }
    
    public void setDirectionForFirstRequest(Lift l, Request r){
         if(r.getSourceFloor() > l.getCurrentFloor())
                this.setDirection(LiftDirection.UP);
            else if(r.getSourceFloor() < l.getCurrentFloor())
                this.setDirection(LiftDirection.DOWN);
            else if(r.getSourceFloor() < l.getCurrentFloor())
                this.setDirection(LiftDirection.UP);
            else if(r.getSourceFloor() < l.getCurrentFloor())
                this.setDirection(LiftDirection.DOWN);
    }
    
    public void setDirection(Lift lift){
        if(this.getDirection() == LiftDirection.UP){
            for(Request r: lift.getRequest())
            {
                if(r.getDestinationFloor() > lift.getCurrentFloor())
                    return;
            }
            this.setDirection(LiftDirection.DOWN);
        }else if(this.getDirection() == LiftDirection.DOWN){
            for(Request r: lift.getRequest())
            {
                if(r.getDestinationFloor() < lift.getCurrentFloor())
                    return;
            }
            this.setDirection(LiftDirection.UP);
        }
    }
    
}
