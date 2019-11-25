/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package loggerdesign;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;

/**
 *
 * @author rajeshkumar.yadav
 */
public class Logger extends Thread{
    
    Writer wr;
    MessageType loggerLevel;
    LoggerType loggerType;
    int counter;
    int bufferSize;
    Message[] buffer;
    BlockingQueue<Message> queue;// = new ArrayBlockingQueue<String>(1024);
    public static Logger logger = null;
    
    private Logger(LoggerType type, String fileName) throws IOException{
        loggerType = type;
        counter = 0;
        bufferSize = 2;
        buffer = new Message[bufferSize];
        queue = new ArrayBlockingQueue<Message>(bufferSize);
        if(type == LoggerType.FILELOGGER)
            wr = FileWriter.getWriterInstance(fileName, queue, bufferSize);
        wr.start();
        loggerLevel = MessageType.INFO;
        //this.start();
    }
    
    synchronized public static Logger getLoggerInstance(LoggerType type, String FileName) throws IOException{
        if(logger == null){
            logger = new Logger(type, FileName);
        }
        return logger;
    }

    public MessageType getLoggerLevel() {
        return loggerLevel;
    }

    public void setLoggerLevel(MessageType loggerLevel) {
        this.loggerLevel = loggerLevel;
    }
    
    public void run(){
        
    }
    
    synchronized public void logMessage(MessageType logLevel, String message){
        System.out.println("loggerdesign.Logger.logMessage()" + Thread.currentThread().getName());
        if(loggerLevel != logLevel)
            return;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        //System.out.println(dtf.format(now));  
 
        Message m = new Message(message  + (dtf.format(now)) , logLevel);
        try{
            buffer[counter++] = m;
            
            if(counter == bufferSize){
            
            for(int i = 0; i<bufferSize; i++){
                queue.put(buffer[i]); 
            }
            wr.run();
            counter = 0;
            
            }
        }catch(InterruptedException ie){
            ie.getMessage();
        }
        

    }
    
    public void cloaseWriter() throws IOException{
        wr.closeFileStream();
    }

    public String getFileName() {
        return wr.getFileName();
    }

    public void setFileName(String fileName) {
        wr.setFileName(fileName);
    }
    
    
}
