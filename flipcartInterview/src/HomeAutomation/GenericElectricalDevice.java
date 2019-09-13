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
public class GenericElectricalDevice implements SmartHomeInterface{
    
    boolean onoff;
    String name;

    public GenericElectricalDevice(String name) {
        this.name = name;
        this.onoff = false;
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
    
    public void turnOnOff(boolean b)
    {
        this.onoff = b;
    }
    
    public void setBrightness(int val){
         System.out.println(" Command is not valid for this device ");
    }
    
    public void setSpeed(int val){
         System.out.println(" Command is not valid for this device ");
    }
  
}
