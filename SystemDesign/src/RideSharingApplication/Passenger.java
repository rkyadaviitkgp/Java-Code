/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RideSharingApplication;

/**
 *
 * @author rajeshkumar.yadav
 */
public class Passenger {
    
    String name;
    int age;
    int id;
    Sex sex;
    ScheduleRide app;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
    
    

    public boolean setApp(ScheduleRide sh){
        this.app = sh;
        return true;
    }
    
    public Passenger(String name, int age, int id, Sex sex) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public Sex getSex() {
        return sex;
    }
    
    public boolean reuestRide(StopName source, StopName destination, int seatRequired){
        if(app != null)
        {
            Ride r = app.fullfillRequest(source, destination, seatRequired, this);
            if(r != null)
            {
                System.out.println("RideSharingApplication.Passenger.reuestRide() ride offered : Driver Name " + r.getOfferedby().getName() + " " );
                return true;
            }else{
                System.out.println("RideSharingApplication.Passenger.reuestRide() ride not abvialble ");
                return false;
            }
        }
        System.out.println("RideSharingApplication.Passenger.reuestRide() : Not registered User ");
        return false;
    }
    
}
