/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HomeAutomation;

/**
 *
 * @author rajeshkumar.yadav
 */
public class Fans implements SmartHomeInterface{
    
    boolean onoff;
    String name;
    int speed;

    public Fans(String name) {
        this.name = name;
        this.onoff = false;
        this.speed = 5;
    }

    public boolean isOnoff() {
        return onoff;
    }

    public void setOnoff(boolean onoff) {
        this.onoff = onoff;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    
    public void turnOnOff(boolean val){
        this.onoff = val;
    }
    public void setBrightness(int val){
         System.out.println(" Command is not valid for this device ");
    }
    public void setSpeed(int val){
        if(val >=1 && val <= 5)
        {
            this.speed = val;
        }else
        {
            System.out.println("Invalid value for speed");
        }
    }
    
    
}
