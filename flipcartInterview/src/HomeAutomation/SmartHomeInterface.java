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
public interface SmartHomeInterface {
    
    public String getName();
    public boolean isOnoff();
    public void turnOnOff(boolean val);
    public void setBrightness(int val);
    public void setSpeed(int val);
          
}
