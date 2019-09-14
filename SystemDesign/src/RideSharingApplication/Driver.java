/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RideSharingApplication;

import java.util.List;

/**
 *
 * @author rajeshkumar.yadav
 */

public class Driver {
    
    int id;
    String name;
    int age;
    Sex sex;
    ScheduleRide scheduler;
    List<Ride> offered;
    List<Ride> completed;

    public Driver(int id, String name, int age, Sex sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.scheduler = null;
    }
    
//    public boolean registerToRideSharingApp(ScheduleRide sh){
//        this.scheduler = sh;
//        return true;
//    }
    
    public void setScheduler(ScheduleRide s)
    {
        scheduler = s;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
    
    public void offerRide(StopName source, StopName destination, int noOfSeat){
        
        Ride r = new Ride(source, destination, noOfSeat);
        if(scheduler != null)
        {
            scheduler.addRide(r, this);
        }
        
    }
    
    
    
}
