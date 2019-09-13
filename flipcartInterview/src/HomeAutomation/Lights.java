/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HomeAutomation;

import flipcartinterview.*;

/**
 *
 * @author rajeshkumar.yadav
 */
public class Lights implements SmartHomeInterface{
    
    boolean onoff;
    String name;
    int brightness;

    public Lights(String name) {
        this.name = name;
        brightness = 5;
        this.onoff = false;
    }

    public boolean isOnoff() {
        return onoff;
    }

    public int getBrightness() {
        return brightness;
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
    
    public void turnOnOff(boolean val){
        this.onoff = val;
    }
    
    public void setBrightness(int val){
        if(val >= 1 || val <= 10)
        {
            brightness = val;
        }else
        {
            System.out.println(" Invalid brightness value ");
        }
    }
    
    public void setSpeed(int val){
        System.out.println(" Command is not valid for this device ");
    }
    
}
