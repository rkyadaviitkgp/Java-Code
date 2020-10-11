/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liftmanagement;
import liftmanagement.controller.InputManager;
import liftmanagement.controller.LiftManager;
import liftmanagement.entity.Request;

/**
 *
 * @author rajeshkumar.yadav
 */
public class LiftManagementDemo {

    /**
     * @param args the command line arguments
     */
    static int noOfFloor = 10;
    static int noOfLift = 2;
    public static final int timeToSleep = 100;
    
    public static void main(String[] args) throws InterruptedException {
        
        //{timeOfInput, sourceFloor, DestinationFloor}
        int initialRequest[][] = {{0, 0,7}, {0, 3, 0}, {2, 4, 6}};
        InputManager input = new InputManager(initialRequest);
        LiftManager lm = new LiftManager(noOfLift, noOfFloor, input);
        while(true)
        {
            lm.progress();
            Thread.sleep(timeToSleep);
        }
    }
    
}

/*

T=0
LIFT 1 -- > 0 (OPEN), LIFT 2 ---> 0 (CLOSE)
T=1
LIFT 1 -- > 0 (CLOSE), LIFT 2 ---> 1 (CLOSE)
T=2
4 6
LIFT 1 -- > 1(CLOSE), LIFT 2 ---> 2 (CLOSE)
T=3
LIFT 1 -- > 2 (CLOSE), LIFT 2 ---> 3 (OPEN)
T=4
LIFT 1 -- > 3(CLOSE) , LIFT 2 ---> 3 (CLOSE)
T=5
LIFT 1 -- > 4(OPEN), LIFT 2 ---> 2(CLOSE)
T=6
LIFT 1 -- > 4(CLOSE), LIFT 2 ---> 1(CLOSE)
T=7
LIFT 1 -- >5(CLOSE), LIFT 2 ---> 0(OPEN)
T=8
LIFT 1 -- >6(OPEN), LIFT 2 ---> 0(CLOSE)
T=9
LIFT 1 OPENS
LIFT 1 -- >6 (CLOSE), LIFT 2 ---> 0(CLOSE)
T=10
LIFT 1 -- >7(OPEN), LIFT 2 ---> 0(CLOSE)
T=11
LIFT 1 OPENS
LIFT 1 -- >7(CLOSE), LIFT 2 ---> 0(CLOSE)
LIFT 1: 11 SECONDS
LIFT 2: 8 SECONDS

*/