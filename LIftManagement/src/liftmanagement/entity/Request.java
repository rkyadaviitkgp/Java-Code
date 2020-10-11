/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liftmanagement.entity;

/**
 *
 * @author rajeshkumar.yadav
 */
public class Request {
    int sourceFloor;
    int destinationFloor;
    int liftId;
    int time;

    public Request(int sourceFloor, int destinationFloor,  int time) {
        this.sourceFloor = sourceFloor;
        this.destinationFloor = destinationFloor;
        this.time = time;
    }

    public int getSourceFloor() {
        return sourceFloor;
    }

    public void setSourceFloor(int sourceFloor) {
        this.sourceFloor = sourceFloor;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }

    public void setDestinationFloor(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }

    public int getLiftId() {
        return liftId;
    }

    public void setLiftId(int liftId) {
        this.liftId = liftId;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

}
