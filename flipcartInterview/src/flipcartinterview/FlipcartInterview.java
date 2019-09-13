/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flipcartinterview;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rajeshkumar.yadav
 */
class SmartHomeDevice{
    
    String name;
    int timestamp;
    int category; /* we could have created child classes for diffrent category , for interest of time using category */
    int state; /*0 off 1 on*/
    int brightness;
    int speed;

    public SmartHomeDevice(String name, int category, int time) {
        this.name = name;
        this.category = category;
        timestamp = time;
    }

    public String getName() {
        return name;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public int getTimestamp() {
        return timestamp;
    }
    
    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
}

class InterfaceDevice{
    
    String name;
    String command;
    List<SmartHomeDevice> Registereddevice;

    public InterfaceDevice(String name, String command) {
        this.name = name;
        this.command = command;
        Registereddevice = new ArrayList<>();
    }

    public void setRegistereddevice(SmartHomeDevice device) {
        this.Registereddevice.add(device);
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

    public List<SmartHomeDevice> getRegistereddevice() {
        return Registereddevice;
    }
    
}

public class FlipcartInterview {

    /**
     * @param args the command line arguments
     */
    
    List<InterfaceDevice> interfaceDevice;
    public static int timeStampCount = 0;

    public FlipcartInterview() {
        interfaceDevice = new ArrayList<>();
    }
    
    private boolean isInterfaceRegistered(String name)
    {
        for(InterfaceDevice id : interfaceDevice)
        {
            if(id.getName().equals(name))
            {
                return true;
            }
    
        }
        System.out.println("Interface is not registered");
        return false;
    }
    
    public boolean addInterfaceDevice(String name, String command)
    {
        for(InterfaceDevice id : interfaceDevice)
        {
            if(id.getName().equals(name))
            {
                System.out.println("Device already registered ");
                return false;
            }
            if(id.getCommand().equals(command))
            {
                System.out.println("Please select a different command ");
                return false;
            }
        }
        InterfaceDevice ifd = new InterfaceDevice(name, command);
        interfaceDevice.add(ifd);
        return true;
    }
    
    private boolean isDeviceRegistered(String devicename, String interfaceName)
    {
        InterfaceDevice ifd = null;
        for(InterfaceDevice id : interfaceDevice)
        {
            if(id.getName().equals(interfaceName))
            {
                ifd = id;
                break;
            }
    
        }
        for(SmartHomeDevice smd : ifd.getRegistereddevice())
        {
            if(smd.getName().equalsIgnoreCase(devicename))
            {
                //System.out.println("Device is already registered");
                return true;
            }
        }
        return false;
    }
    
    private InterfaceDevice getInterfaceDevice(String interfaceName)
    {
        for(InterfaceDevice id : interfaceDevice)
        {
            if(id.getName().equals(interfaceName))
            {
                return id;
            }
    
        }
        return null;
    }
    
    public boolean addSmartHomeDevice(int categoty, String deviceNamename, String interfaceName)
    {
        if(!isInterfaceRegistered(interfaceName))
        {
            return false;
        }
        
        if(!isDeviceRegistered(deviceNamename, interfaceName))
        {
            SmartHomeDevice smd = new SmartHomeDevice(deviceNamename, categoty, timeStampCount++);
            InterfaceDevice ifd = getInterfaceDevice(interfaceName);
            ifd.getRegistereddevice().add(smd);
            return true;
        }
        
        //System.out.println("Device is already registreed ");
        return false;
        
    }
    
    private boolean isInterfaceCommandAvailable(String name)
    {
        for(InterfaceDevice id : interfaceDevice)
        {
            if(id.getCommand().equals(name))
            {
                return true;
            }
    
        }
        System.out.println("Interface command is not available");
        return false;
    }
    
    private InterfaceDevice interfaceObject(String name)
    {
        for(InterfaceDevice id : interfaceDevice)
        {
            if(id.getCommand().equals(name))
            {
                return id;
            }
    
        }
        System.out.println("Interface command is not available");
        return null;
    }
    
    private SmartHomeDevice getHomeDeviceObject(InterfaceDevice ifd, String deviceName)
    {
        for(SmartHomeDevice hmd : ifd.getRegistereddevice())
        {
            if(hmd.getName().equalsIgnoreCase(deviceName))
                return hmd;
        }
        return null;
    }
    
    public boolean giveCommand(String interfaceCommand, String deviceName, int state,  int util)
    {
        if(!isInterfaceCommandAvailable(interfaceCommand))
            return false;
        InterfaceDevice ifd = interfaceObject(interfaceCommand);
        if(isDeviceRegistered(deviceName, ifd.getName()))
        {
            SmartHomeDevice hmd = getHomeDeviceObject(ifd, deviceName);
            if(hmd.getCategory() == 1)
            {
                if(hmd.getState() == state)
                {
                    System.out.println("System is alredy " + state + " state ");
                    return false;
                }
                hmd.setState(state);
                hmd.setTimestamp(timeStampCount++);
                System.out.println(" general device Turned on ");
                return true;
            }else if(hmd.getCategory() == 2)
            {
              if(util > 10 || util < 0)
              {
                  System.out.println("Invalid range ");
                  return false;
              }
              
              if(hmd.getState() == 1)
              {
                    hmd.brightness  = util;
                    System.out.println("light brightness Successfully set ");
                    return true;
              }else if(state == 1)
              {
                hmd.setState(state);
                hmd.setTimestamp(timeStampCount++);
                System.out.println(" light Turned on ");
                return true;
              }
              
            }else if(hmd.getCategory() == 3)
            {
                 if(util > 5 || util < 0)
              {
                  System.out.println("Invalid range ");
                  return false;
              }
              
              if(hmd.getState() == 1)
              {
                    hmd.speed  = util;
                    System.out.println("fan speed set Successfully ");
                    return true;
              }else if(state == 1)
              {
                hmd.setState(state);
                hmd.setTimestamp(timeStampCount++);
                System.out.println(" fan Turned on ");
                return true;
              }
            }
        }
        
        
        return false;
    }
    
    public void printConnectedDevice(String DeviceName)
    {
        for(InterfaceDevice ifd : interfaceDevice)
        {
            if(ifd.getName().equalsIgnoreCase(DeviceName))
            {
                System.out.println("List of devices for : " + DeviceName);
                for(SmartHomeDevice hmd : ifd.getRegistereddevice())
                {
                    System.out.println("        " + hmd.getName());
                }
                return;
            }
        }
    }
    
    public void printConnectedDeviceUsage(String DeviceName)
    {
        for(InterfaceDevice ifd : interfaceDevice)
        {
            if(ifd.getName().equalsIgnoreCase(DeviceName))
            {
                System.out.println("Usage of devices for : " + DeviceName);
                for(SmartHomeDevice hmd : ifd.getRegistereddevice())
                {
                    System.out.println("        " + hmd.getName() + " " + (timeStampCount - hmd.getTimestamp()) );
                }
                return;
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        FlipcartInterview fi = new FlipcartInterview();
        
        fi.addInterfaceDevice("Google Home", "Ok Google");
        fi.addInterfaceDevice("Alexa", "Alexa");
        fi.addInterfaceDevice("Oracle", "Oracle");
        
        
      //  fi.addSmartHomeDevice(2, "DrawingRoomLigt", "Alexa");
        //fi.addSmartHomeDevice(3, "LivingRoomFan", "Google Home");
          fi.printConnectedDeviceUsage("Oracle");
          fi.addSmartHomeDevice(3, "LivingRoomFan", "Oracle");
          fi.giveCommand("Oracle", "LivingRoomFan", 1, 4);
          fi.printConnectedDeviceUsage("Oracle");
          fi.giveCommand("Oracle", "LivingRoomFan", 1, 3);
          fi.printConnectedDeviceUsage("Oracle");
          //fi.giveCommand("Oracle", "LivingRoomFan", 0, 3);
          fi.printConnectedDeviceUsage("Oracle");
//        
          fi.printConnectedDevice("Oracle");
//         
         
//      fi.addSmartHomeDevice(1, "SmartCharger", "Alexa");
//      fi.giveCommand("Alexa", "DrawingRoomLigt", 1, 8);
//      fi.giveCommand("Ok Google", "LivingRoomFan", 1, 4);
//      fi.printConnectedDevice("Google Home");
//      fi.printConnectedDeviceUsage("Alexa");
  
    }
    
}
