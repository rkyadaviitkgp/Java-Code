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
public class UserCommand {
    
    String interfaceName;
    String deviceName;
    String command;
    int val;

    public UserCommand(String interfaceName, String deviceName, String command, int val) {
        this.interfaceName = interfaceName;
        this.deviceName = deviceName;
        this.command = command;
        this.val = val;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
    
    
    
    
}
