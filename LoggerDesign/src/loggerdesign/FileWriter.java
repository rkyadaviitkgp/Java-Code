/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loggerdesign;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rajeshkumar.yadav
 */
public class FileWriter extends Writer {

    String fileName;
    BufferedWriter br;
    int bufferSize;
    BlockingQueue<Message> queue;
    private static FileWriter writerObject = null;

    private FileWriter(String fileName, BlockingQueue<Message> queue, int bufferSize) throws IOException {
        super();
        this.fileName = fileName;
        this.queue = queue;
        this.bufferSize = bufferSize;
    }

    synchronized public static Writer getWriterInstance(String filename, BlockingQueue<Message> queue, int bufferSize) throws IOException {

        if (writerObject == null) {
            writerObject = new FileWriter(filename, queue, bufferSize);
        }
        return writerObject;
    }

    public void run() {
        try {
            System.out.println("loggerdesign.FileWriter.run()" + Thread.currentThread().getName());
            //while (true) {
                List<Message> list = new ArrayList<Message>();
                queue.drainTo(list);
                //Message message = queue.take();
                if(list.size() > 0)
                writeMessage(list);
                //Check whether end of file has been reached
                
           //}

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(FileWriter.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    synchronized public void writeMessage(List<Message> list) throws IOException {
        System.out.println("loggerdesign.FileWriter.writeMessage()" + Thread.currentThread().getName());
        br = new BufferedWriter(new java.io.FileWriter(fileName, true));
        for(int i=0; i<list.size(); i++){
            br.write(list.get(i).toString());
            br.newLine();
        }
        br.close();
        //Thread.currentThread().st
    }
    
    synchronized public void closeFileStream() throws IOException {
        br.close();
    }
    
}
