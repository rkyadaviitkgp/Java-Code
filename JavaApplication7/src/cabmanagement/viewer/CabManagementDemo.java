/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabmanagement.viewer;

import cabmanagement.controller.CabBookingController;
import cabmanagement.model.Booking;
import cabmanagement.model.Cab;
import cabmanagement.model.User;
import cabmanagement.utility.ReadInput;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 *
 * @author rajeshkumar.yadav
 */
public class CabManagementDemo {

    public static void main(String[] args) {

        System.out.println("Login As User  :  1  ");
        System.out.println("Login As Admin :  2  ");
        ReadInput inp = new ReadInput();
        int option = inp.readInteger();
        CabBookingController controller = new CabBookingController();

        //read input
        while (true) {
            switch (option) {
                case 1:
                    User u = null;
                    boolean repeat = true;
                    while (repeat) {
                        System.out.println("Enter your option 1: Register Yourself \n2: Login \n");
                        int userOption = inp.readInteger();
                        String displayName, userName, password, dob;
                        switch (userOption) {
                            case 1:
                                //register a user
                                displayName = inp.readString();
                                userName = inp.readString();
                                password = inp.readString();
                                dob = inp.readString();
                                Date d = new Date(dob);
                                u = new User(displayName, userName, password, d);
                                controller.getUserManager().registerUser(u);
                                break;
                            case 2:
                                //login a user
                                userName = inp.readString();
                                password = inp.readString();
                                u = controller.getUserManager().loginUser(userName, password);
                                repeat = (u == null);
                                break;
                            default:
                                //invalid selection
                                System.out.println("Invalid Selection. Try again");
                        }
                    }
                    System.out.println("You have Loggedin as " + u.getDisplayName());
                    
                    // 1. make booking
                    String startTime, endTime, startCity, endCity;
                    startTime = inp.readString();
                    endTime = inp.readString();
                    startCity = inp.readString();
                    endCity = inp.readString();
                    Booking b = new Booking(new Date(), new Date(startTime), new Date(endTime), startCity, endCity, u.getId(), "transactiondummy");
                    controller.getTripManager().getBookingList().add(b);
                    controller.getUserManager().addBooking(u.getId(), b);
                    
                    // 3. check your past bookings
                    List<Booking> l = controller.getUserManager().getUserBookingHashTable().get(u.getId());
                    System.out.println(l);
                    
                    // 4. check your upcoming trips 
                    //not supported for now
                    
                    break;

                case 2:
                    // onborad a cab
                    // onborad a city
                    // check how long a cab was idle
                    // schedule a cab for a booking
                    // change location or state of a cab
                    // get cab history of a cab
                    // find city where demand for cab is high and time when demand is high
                    // complete a trip
                 default:
                     System.err.println("Invalid selection ");
            }
        }

    }
}
