/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author rajeshkumar.yadav
 */

class StackIsempty extends Exception{
    String msg;
    public StackIsempty(String str){
        super(str);
    }
    
}

class StackFromQueue{
    
    Queue<Integer> q1;
    int count;

    public StackFromQueue() {
        count = 0;
        q1 = new LinkedList<>();
    }
    
    public void push(int val){
      
        q1.add(val);
        count++;
        for(int i=1; i<=count-1; i++){
            int v = q1.poll();
            q1.add(v);
        }
    }
    
    public int pop() throws StackIsempty {
        if(q1.peek() == null)
            throw new StackIsempty("empty");
        return q1.poll();   
    }
    
}
public class JavaApplication7 {

    /**
     * @param args the command line arguments
     */
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        StackFromQueue sfq = new StackFromQueue();
        sfq.push(1);
        sfq.push(2);
        sfq.push(3);
        sfq.push(4);
        sfq.push(5);
        try {
            System.out.println(sfq.pop());
        } catch (StackIsempty e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(sfq.pop());
        } catch (StackIsempty e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(sfq.pop());
        } catch (StackIsempty e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(sfq.pop());
        } catch (StackIsempty e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(sfq.pop());
        } catch (StackIsempty e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(sfq.pop());
        } catch (StackIsempty e) {
            System.out.println(e.getMessage());
        }
        
    }
    
}
