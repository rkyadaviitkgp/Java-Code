/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liftmanagement.entity;

import java.util.List;

/**
 *
 * @author rajeshkumar.yadav
 */
public class Lift {
    
    String liftId;
    LiftState liftState;
    int currentFloor;
    LiftDirection direction;
    List<Request> request;
    
    
}
