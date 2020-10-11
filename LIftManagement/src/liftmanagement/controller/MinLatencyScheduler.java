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
public class MinLatencyScheduler implements Scheduler{

    @Override
    public void scheduleRequest(Request r, List<Lift> liftList) {
        // get count of time to serve this request by all available lift and choose the least one 
    }
    
}
