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
class ThreadDemo extends Thread {
    public void run(){
        try
        { 
            // Displaying the thread that is running 
            String s = "Thread " + 
                  Thread.currentThread().getId() + 
                  " is running"; 
            Logger lg = Logger.getLoggerInstance(LoggerType.FILELOGGER, "/Users/rajeshkumar.yadav/Desktop/1.txt");
            lg.logMessage(MessageType.INFO, s);
            s = "Thread " + 
                  Thread.currentThread().getId() + 
                  " is exiting"; 
            lg.logMessage(MessageType.INFO, s);
  
        } 
        catch (Exception e) 
        { 
            // Throwing an exception 
            System.out.println ("Exception is caught"); 
        } 
    } 
    }
public class LoggerDesign {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        

        int n = 8; // Number of threads 
        Logger lg = Logger.getLoggerInstance(LoggerType.FILELOGGER, "/Users/rajeshkumar.yadav/Desktop/1.txt");
        lg.logMessage(MessageType.INFO, "hi");
        //lg.setLoggerLevel(MessageType.ERROR);
        lg.logMessage(MessageType.INFO, "Message 2");
        lg.logMessage(MessageType.INFO, "Message 3");
        lg.logMessage(MessageType.INFO, "Message 4");
//        try {
//            lg.wr.join();
//        } catch (InterruptedException ex) {
//            java.util.logging.Logger.getLogger(Logger.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
    }
    
}
