/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabmanagement.viewer;

import cabmanagement.controller.CabBookingController;
import cabmanagement.model.Cab;
import cabmanagement.utility.ReadInput;

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
                    int repeat = 1;
                    while (repeat == 1) {
                        System.out.println("Enter your option 1: Register Yourself \n2: Login \n");
                        int userOption = inp.readInteger();
                        switch (userOption) {
                            case 1:
                                controller.getRegisteredUser().add(controller.getOnBoardUser().onBoard("inputtext.txt"));
                                break;
                            case 2:
                                


                        }
                    }

                    // 1. book a trip 
                    // 2. onboard a user
                    // 3. check your past bookings
                    // 4. check your upcoming trips 
                    break;

                case 2:
                    System.out.println("Enter your option 1: onborad a cab \n2: OnBorad a city \n");
                    int onBoradOption = inp.readInteger();
                    switch (onBoradOption) {
                        case 1:
                            controller.getOnBoardedCabs().add(controller.getOnBoardCab().onBoard("inputfile.text"));
                            break;
                        case 2:
                            controller.getOnBoardedCity().add(controller.getOnBoardCity().onBoard("inputfile.text"));
                            break;
                        default:
                            System.err.println("Invalid option ");
                    }
                    // 4. start a trip
                    break;
                 default:
                     System.err.println("Invalid selection ");
            }
        }

    }
}
