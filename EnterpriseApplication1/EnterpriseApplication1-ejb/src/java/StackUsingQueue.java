
import java.util.LinkedList;
import java.util.Queue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rajeshkumar.yadav
 */
class StackUsingQueue {

    /** Initialize your data structure here. */
    Queue<Integer> q1 ;
    Queue<Integer> q2 ;
    public StackUsingQueue() {
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        if(q1.isEmpty()){
            q2.add(x);
        }else{
            q1.add(x);
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        
        if(q1.isEmpty()){
            while(q2.size() > 1){
                int x = q2.poll();
                q1.add(x);
            }
            return q2.poll();
        }else{
            while(q1.size() > 1){
                int x = q1.poll();
                q2.add(x);
            }
            return q1.poll();
        }
    }
    
    /** Get the top element. */
    public int top() {
        int x = pop();
        push(x);
        return x;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(q1.isEmpty() && q2.isEmpty())
            return true;
        return false;
    }
}
