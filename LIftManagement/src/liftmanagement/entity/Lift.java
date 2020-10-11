/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liftmanagement.entity;
import java.util.LinkedList;
import java.util.List;
import liftmanagement.controller.DirectionManager;
import liftmanagement.controller.StateManager;

/**
 *
 * @author rajeshkumar.yadav
 */
public class Lift {
    
    int liftId;
    int currentFloor;
    int lastFloorServed ;
    int unitTime;
    
    StateManager liftState;
    DirectionManager direction;
    List<LiftRequest> request;
    

    public Lift(int liftId, LiftState liftState, int currentFloor, LiftDirection direction) {
        this.liftId = liftId;
        this.liftState = new StateManager(liftState);
        this.currentFloor = currentFloor;
        this.direction = new DirectionManager(direction);
        this.request = new LinkedList<>();
        this.lastFloorServed = -1;
    }
    
    public void getRequest(Request r){
        if(request.size() == 0){
            direction.setDirectionForFirstRequest(this, r);
        }
        LiftRequest lr = new LiftRequest(r.sourceFloor, r.destinationFloor, unitTime);
        request.add(lr);
    }
    
    public void moveUp(){
        currentFloor++;
    }
    
    public void moveDown(){
        currentFloor--;
    }
    
    public boolean move(){
        
        //check if current floor has soucre or destination 
        if(request.size() == 0)
        {
            //last close will not be counted in timeUnit
            liftState.setState(LiftState.CLOSE);
            return false;
        }
        
        unitTime++;
        
        //if gate was opened or closed the downt move in this second
        if(liftState.checkAndSetState(this))
            return true;
        
        if(direction.getDirection() == LiftDirection.UP)
            moveUp();
        else
            moveDown();
        
        return true;
 
    }

    public List<LiftRequest> getRequest() {
        return request;
    }

    public void setRequest(List<LiftRequest> request) {
        this.request = request;
    }

    public int getLiftId() {
        return liftId;
    }

    public void setLiftId(int liftId) {
        this.liftId = liftId;
    }

    public StateManager getLiftState() {
        return liftState;
    }

    public void setLiftState(StateManager liftState) {
        this.liftState = liftState;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getUnitTime() {
        return unitTime;
    }

    public void setUnitTime(int unitTime) {
        this.unitTime = unitTime;
    }

    public DirectionManager getDirection() {
        return direction;
    }

    public void setDirection(DirectionManager direction) {
        this.direction = direction;
    }

    public int getLastFloorServed() {
        return lastFloorServed;
    }

    public void setLastFloorServed(int lastFloorServed) {
        this.lastFloorServed = lastFloorServed;
    }

}
