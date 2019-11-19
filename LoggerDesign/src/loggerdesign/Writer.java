/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loggerdesign;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author rajeshkumar.yadav
 */
public class Writer extends Thread{

    String fileName;
    public static Writer wr = null;

    synchronized public static Writer getWriterInstance(String filename) throws IOException{
        System.out.println("loggerdesign.Writer.getWriterInstance()");
        return wr;
    }
    
    public void run(){
        
    }

    synchronized public void writeMessage(Message m) throws IOException {
            System.out.println("loggerdesign.Writer.writeMessage()");
    }
    synchronized public void closeFileStream() throws IOException{
        
    }
     public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
}
