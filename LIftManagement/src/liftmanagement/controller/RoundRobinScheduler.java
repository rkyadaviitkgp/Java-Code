/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liftmanagement.controller;

import java.util.List;
import liftmanagement.entity.Lift;
import liftmanagement.entity.Request;

/**
 *
 * @author rajeshkumar.yadav
 */
public class RoundRobinScheduler implements Scheduler{

    @Override
    public void scheduleRequest(Request r, List<Lift> liftList) {
        //get lift with least load and assign this request
        Lift minLoadLift = liftList.get(0);
        for (Lift l : liftList) {
            if (minLoadLift.getRequest().size() > l.getRequest().size()) {
                minLoadLift = l;
            }
        }
        minLoadLift.getRequest(r);
    }
    
}
