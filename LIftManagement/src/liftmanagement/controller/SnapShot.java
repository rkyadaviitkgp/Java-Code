/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liftmanagement.controller;
import static liftmanagement.controller.LiftManager.timeCont;
import liftmanagement.entity.Lift;

/**
 *
 * @author rajeshkumar.yadav
 */
public class SnapShot {
    
    boolean flag;
    String fileName;

    public SnapShot() {
        flag = true;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    
    
    
    public void printSnapShot(LiftManager liftManager){
        if (flag == true) {
            takeSnapShot(liftManager);
        } else {
            for (Lift l : liftManager.getLiftList()) {
                System.out.println("Lift " + l.getLiftId()  + " " + l.getUnitTime());
            }
            System.exit(0);
        }
    }
   
    public void takeSnapShot(LiftManager liftManager){
        System.out.println("Time " + timeCont);
        String str = "";
        for (Lift l : liftManager.getLiftList()) {
            str = str + "Lift " + l.getLiftId() + "-> " + l.getCurrentFloor() + " (" + l.getLiftState().getState() + "), ";
        }
        str = str.substring(0, str.length() - 2);
        System.out.println(str);
    }
    
}
