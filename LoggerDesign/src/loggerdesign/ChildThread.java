/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loggerdesign;

import java.io.IOException;
import java.util.logging.Level;

/**
 *
 * @author rajeshkumar.yadav
 */
public class ChildThread extends Thread 
{ public ChildThread(String name){
    super(name);
}
    @Override
    public void run()  
    { 
        Logger lg;
        try {
            lg = Logger.getLoggerInstance(LoggerType.FILELOGGER, "/Users/rajeshkumar.yadav/Desktop/1.txt");
            lg.logMessage(MessageType.INFO, "hi " + Thread.currentThread().getName() + " ");
            lg.logMessage(MessageType.INFO, "hellow " + Thread.currentThread().getName() + " ");
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(ChildThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    } 
} 