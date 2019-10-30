/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RideSharingApplication;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rajeshkumar.yadav
 */
public class RideSharingApplicationDemo {

    ScheduleRide scheduleRideObject;
    List<Driver> driverList;
    List<Passenger> RegisteredUserList;

    public RideSharingApplicationDemo(ScheduleRide scheduleRideObject) {
        this.scheduleRideObject = scheduleRideObject;
        this.driverList = new ArrayList<>();
        this.RegisteredUserList = new ArrayList<>();
    }

    public void registerPassenger(Passenger r) {
        r.setApp(scheduleRideObject);
        RegisteredUserList.add(r);
    }

    public void registerDriver(Driver d) {
        d.setScheduler(scheduleRideObject);
        driverList.add(d);
    }

    public static void main(String[] args) {

        ScheduleRide r = ScheduleRide.getScheduleRideObject();
        RideSharingApplicationDemo demoObj = new RideSharingApplicationDemo(r);
        
        Driver d1 = new Driver(1, "Suresh", 30, Sex.male);
        Driver d2 = new Driver(2, "Mukesh", 50, Sex.female);
        Driver d3 = new Driver(3, "Mahesh", 33, Sex.male);
        
        demoObj.registerDriver(d3);
        demoObj.registerDriver(d2);
        demoObj.registerDriver(d1);
        
        Passenger p1 = new Passenger("Rajesh", 30, 1, Sex.male);
        Passenger p2 = new Passenger("Akash", 33, 2, Sex.male);
        Passenger p3 = new Passenger("Abhinav", 40, 3, Sex.male);
        
        demoObj.registerPassenger(p3);
        demoObj.registerPassenger(p2);
        demoObj.registerPassenger(p1);
        
        d1.offerRide(StopName.kondapur, StopName.madhapur, 3);
        d1.offerRide(StopName.banjaraHills, StopName.madhapur, 5);
        d1.offerRide(StopName.botanicalGarden, StopName.madhapur, 3);
        d2.offerRide(StopName.cyberabad, StopName.madhapur, 6);
        d2.offerRide(StopName.inorbitmall, StopName.madhapur, 4);
        d3.offerRide(StopName.kondapur, StopName.madhapur, 4);
        
        //demoObj.scheduleRideObject.printListOfAvailableRide();
        
        p1.reuestRide(StopName.kondapur, StopName.madhapur, 4);
        p2.reuestRide(StopName.kondapur, StopName.madhapur, 3);
        
    }

}
