/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HomeAutomation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author rajeshkumar.yadav
 */
public class HomeAutomationDemo {
    
    Map<String, InterfaceForDevice> interfaceMap;

    public HomeAutomationDemo() {
        interfaceMap = new HashMap<String, InterfaceForDevice>();
    }
    
    public boolean isInterfacePresent(String ifd)
    {
        if(interfaceMap.get(ifd) != null)
        {
            //System.out.println("Interface is laredy added to home automation ");
            return true;
        }
        return false;
    }
    
    public boolean addInterfaceDevice(String name, String commnad)
    {
        InterfaceForDevice ifd = new InterfaceForDevice(name, commnad);
        if(!isInterfacePresent(ifd.getName()))
        {
            interfaceMap.put(ifd.getName(), ifd);
            return true;
        }
        return false;
    }
    
    public boolean addSmartHomeDevice(String deviceName, String category, String interfaceName){
        
        if(!isInterfacePresent(interfaceName))
        {
            System.out.println("Interface is not present ");
            return false;
        }
        SmartHomeInterface newdevice = null;
        if(category.equalsIgnoreCase("Generic"))
        {
            newdevice = new GenericElectricalDevice(deviceName);
            
        }else if(category.equalsIgnoreCase("Fan"))
        {
            newdevice = new Fans(deviceName);
        }else if(category.equalsIgnoreCase("Light"))
        {
            newdevice= new Lights(deviceName);
        }else{
            System.out.println("Invalid category");
            return false;
        }
        return interfaceMap.get(interfaceName).addSmartHomeDevice(newdevice);
    }
    
    public InterfaceForDevice getInterfaceFromCommand(String command){
        
        for(Map.Entry entryval : interfaceMap.entrySet())
        {
            InterfaceForDevice ifd = (InterfaceForDevice) entryval.getValue();
            if(ifd.getCommand().equalsIgnoreCase(command))
                return ifd;
        }
        return null;
    }
    
    public boolean giveCommand(String interfaceCommand, String deviceName, String deviceCommand, int val)
    {
        InterfaceForDevice ifd = getInterfaceFromCommand(interfaceCommand);
        if(ifd == null)
        {
            System.out.println("Invalid interface command ");
            return false;
        }
        
        UserCommand ucmd = new UserCommand(ifd.getName(), deviceName, deviceCommand, val);
        
        return ifd.processCommand(ucmd);
        
    }
    
    public void printConnectedDevice(String interfaceName)
    {
        if(!isInterfacePresent(interfaceName))
        {
            System.out.println("Interface is not present ");
            return ;
        }
        
        InterfaceForDevice ifd = interfaceMap.get(interfaceName);
        
        ifd.printConnectedDevice();
    }
    
    public static void main(String[] args) throws IOException {
        
        HomeAutomationDemo had = new HomeAutomationDemo();
        
        
        had.addInterfaceDevice("Google Home","OK,Google");
        had.addInterfaceDevice("Alexa","Alexa");
        

        had.addSmartHomeDevice("Drawing Room Light", "light", "Alexa");
        had.addSmartHomeDevice("Living Room Fan", "Fan", "Google Home");
        had.addSmartHomeDevice("Smart Charger", "generic", "Alexa");
        
        
        had.giveCommand("Alexa", "Drawing Room Light", "onoff", 1);
        had.giveCommand("OK,Google", "Living Room Fan", "onoff", 1);
        had.giveCommand("OK,Google", "Living Room Fan", "setspeed", 5);
        had.giveCommand("OK,Google", "Living Room Fan", "setspeed", 7);
        had.giveCommand("Alexa", "Drawing Room Light", "setbrightness", 7);
        
        had.printConnectedDevice("Alexa");


//Living Room Fan speed to 7 (outside the predefined range of 1 - 5)
//10. give_command(“Alexa”, set Drawing Room Light Brightness to 8”) -> OK, Drawing Room
//Light Brightness set to 8
//11. give_command(“Alexa”,”Smart Charger”,”ON”) -> OK, Smart Charger turned on
//12. give_command(“Alexa”,”Smart Charger”,”OFF”) -> OK, Smart Charger turned off
//13. give_command(“OK Google”,”Living Room Fan”, “OFF”) -> OK, Living Room Fan turned
//off
//14. give_command(“OK Google”,”Living Room Fan”,”Speed”,”3”) -> Sorry, Living Room Fan
//is not turned on
//15. print_connected_device(“Google Home”)
//        
//        
        
        
        /*boolean option = true;
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        while(option)
        {
            System.out.println("Press 1 for adding a new interface device to home Automation : ");
            System.out.println("Press 2 for adding a new Home device to an interface device : ");
            System.out.println("Press 3 to put a command to a Home device : ");
            System.out.println("Press 4 for printing usage of interface device : ");
            String s = br.readLine();
            int sel = Integer.parseInt(s);
            if(sel == 1)
            {
                
            }else if(sel == 2)
            {
                
            }else if(sel == 3)
            {
                
            }else if(sel == 4)
            {
                
            }
        }*/
        
    }
    
    
}
