/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liftmanagement.controller;

import java.util.LinkedList;
import java.util.List;
import liftmanagement.ReadInput;
import liftmanagement.entity.Lift;
import liftmanagement.entity.LiftDirection;
import liftmanagement.entity.LiftState;
import liftmanagement.entity.Request;

/**
 *
 * @author rajeshkumar.yadav
 */
public class LiftManager {

    boolean flag = true;
    int noOfFloor;
    static int timeCont = 0;
    
    //list of all lift 
    List<Lift> liftList;
    //reuest to be served
    List<Request> unAssignedRequest;
    //request Scheduler
    Scheduler scheduler;
    //snapShot
    SnapShot snapShot;
    //input class 
    ReadInput reader;
    //inputManager
    InputManager input;

    //initialize system
    public LiftManager(int noOfLift, int noOfFloor, InputManager inp) {
        this.noOfFloor = noOfFloor;
        liftList = new LinkedList<>();
        unAssignedRequest = new LinkedList<>();
        for (int i = 0; i < noOfLift; i++) {
            Lift l = new Lift(i + 1, LiftState.CLOSE, 0, LiftDirection.UP);
            liftList.add(l);
        }
        scheduler = new RoundRobinScheduler();
        reader = new ReadInput();
        snapShot = new SnapShot();
        input = inp;
    }

    //take request from user
    public void takeNewRequest() {
        int source, destination;
        System.out.println("Enter Soucrce Destination eg: 3 4");
        reader.readStringArray();
        source = Integer.parseInt(reader.getNextString());
        destination = Integer.parseInt(reader.getNextString());
        Request r = new Request(source, destination, timeCont);
        // schedule request
        scheduleRequest(r);
    }
    
    //add request to reuest list
    public void addRequst(Request r){
        unAssignedRequest.add(r);
    }

    //assign request to lift
    public void scheduleRequest(Request r) {
        scheduler.scheduleRequest(r, liftList);
    }

    //stae progress 
    public void progress() {
        
        snapShot.printSnapShot(this);
        
        //check if there is any input at this time
        if(input.getHashTable().containsKey(timeCont))
        {
            for(Request r : input.getHashTable().get(timeCont))
            {
                scheduleRequest(r);
            }
        }

        flag = false;
        for (Lift l : liftList) {
            flag =  l.move() || flag;
        }
        snapShot.setFlag(flag);
        
        timeCont++;
    }

    public List<Lift> getLiftList() {
        return liftList;
    }

    public void setLiftList(List<Lift> liftList) {
        this.liftList = liftList;
    }
    
    

}
