/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HomeAutomation;

import flipcartinterview.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author rajeshkumar.yadav
 */
public class InterfaceForDevice {
    
    String name;
    String command;
    String mode;
    
    Map<String, SmartHomeInterface> smd;

    public InterfaceForDevice(String name, String command) {
        this.name = name;
        this.command = command;
        this.mode = "Sleep";
        smd = new HashMap<String, SmartHomeInterface>();
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
    
    public boolean isDevicePresent(String name)
    {
        if(smd.get(name) != null)
            return true;
        return false;
    }
    
    
    
    public boolean addSmartHomeDevice(SmartHomeInterface deviceName){
        
        if(isDevicePresent(deviceName.getName()))
        {
            System.out.println("this smart home device is already registered with this interface");
            return false;
        }
        smd.put(deviceName.getName(), deviceName);
        return true;
        
    }
    
    public boolean processCommand(UserCommand ucmd)
    {
        if(!isDevicePresent(ucmd.getDeviceName()))
        {
            System.out.println("this device is not registred with this interface");
            return false;
        }
        
        SmartHomeInterface smdvar = smd.get(ucmd.getDeviceName());
        
        if(ucmd.getCommand().equalsIgnoreCase("ONOFF"))
        {
            if(ucmd.getVal() == 1)
            smdvar.turnOnOff(true);
            else
            smdvar.turnOnOff(false);
        }
        if(ucmd.getCommand().equalsIgnoreCase("SETSPEED"))
        {
            smdvar.setSpeed(ucmd.getVal());
        }
        if(ucmd.getCommand().equalsIgnoreCase("SETBRIGHTNESS"))
        {

            smdvar.setBrightness(ucmd.getVal());
        }
        return true;
    }
    
    public void printConnectedDevice()
    {
        System.out.println("Connected Home device for the intercae " + getName() + " are : ");
        int count = 0;
        System.out.println("#" +"               " + "Category" + "              " + "Name" + "              " + "State");
        for(Map.Entry  entryElement: smd.entrySet())
        {
            SmartHomeInterface entryval = (SmartHomeInterface) entryElement.getValue();
            System.out.println(++count + "              " + entryval.getClass() + "             " + entryval.getName() + "              " + entryval.isOnoff());
        }
    }
    
}
