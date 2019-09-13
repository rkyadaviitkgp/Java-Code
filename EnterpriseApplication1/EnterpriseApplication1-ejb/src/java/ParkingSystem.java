
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rajeshkumar.yadav
 */

enum VehicleType{
    CAR, BIKE, TRUCK
}

enum ParkingSpotType{
    LARGE, MOTORBIKE, MEDIUM
}

enum ParkingTicketStatus{
    ACTIVE, PAID, LOST
}

class Address{
    String landmark;
    String post;
    String State;
    String pin;
}

class Person{
    String name;
    String id;
}

class Vehicle{
    
    String vehicleNumber;
    VehicleType type;
    ParkingSpot pspot;

}

class ParkingSpot{

    String number;
    boolean free;
    ParkingSpotType type;
    Vehicle parkedVehicle;

}

class ParkingFloor{
    
    String name;
    List<ParkingSpot> twoWheelerSpot;
    List<ParkingSpot> fourwheelr;
    

}

public class ParkingSystem {
    
    public static void main(String args[])
    {
        System.out.println(" You have just run HelloWorld !"); 
        System.out.println(" This is by help of Autocompletion !");
    }
    
}

