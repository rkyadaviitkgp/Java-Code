/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package narshimhakarumanchi;
import java.util.ArrayList;
import java.util.Arrays;
import  java.util.Stack;

/**
 *
 * @author rajeshkumar.yadav
 */

/* check given expression has balanced parenthesis */

class BalancedParenthesis{
    
    String expression;
    
    public BalancedParenthesis(String exp){
        this.expression = exp;
    }
    
    public boolean isBalanced(){
        
       Stack<Character> st = new Stack<>();
       
        for(int i=0; i<expression.length(); i++){
            
            if(isOpeningParenthesis(expression.charAt(i))){
                
                st.push(expression.charAt(i));
                
            }else if(isClosingParenthesis(expression.charAt(i))){
                
                if(st.isEmpty())
                    return false;
                if(!hasCorrespondingOpeningPrenthesis(st.pop(), expression.charAt(i)))
                    return false;
                
            }
            
        }
        
        if(!st.isEmpty()) 
            return false;
        
        return true;
    }
    
    private boolean hasCorrespondingOpeningPrenthesis(char op, char cl){
        
        if(op == '(' && cl == ')')
            return true;
        if(op == '{' && cl == '}')
            return true;
        if(op == '[' && cl == ']')
            return true;
        
        return false;
    }
    
    private  boolean isClosingParenthesis(Character c){
      
       char[] arr = { ')' , '}' , ']'};
       for(int i = 0 ; i<arr.length; i++){
           if(arr[i] == c)
               return true;
       }
       return false;
       
    }
    
    private  boolean isOpeningParenthesis(Character c){
      
       char[] arr = {'(' , '{' , '[' };
       for(int i = 0 ; i<arr.length; i++){
           if(arr[i] == c)
               return true;
       }
       return false;
       
    }
    
}


class ReverseStack{
    
    Stack<Integer> st;
    
    public ReverseStack(Stack<Integer> st){
        
        this.st = new Stack<>();
        this.st = (Stack<Integer>) st.clone();
        
    }
   
    
     public void printStack(Stack<Integer> st){
        
        if(st.isEmpty())
        {
            System.out.println("");
            return;
        }
        int v = st.pop();
        printStack(st);
        System.out.println(v);
        st.push(v);
        
    }
    
    public void printStack(){
        
        if(st.isEmpty())
        {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("Contenet of the stack is");
        while(!st.isEmpty())
        {
            System.out.println(st.pop());
        }
        System.out.println("");
        
    }
    
    public void printStackUtil(Stack<Integer> st){
        
        if(st.isEmpty())
        {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("Contenet of the stack is");
        System.out.println(st);
        System.out.println("");
        
    }
    
    public void moveStack(Stack<Integer> st1, Stack<Integer> st2)
    {
        while(!st1.isEmpty())
        {
            st2.push(st1.pop());
        }
    }
    
    public void revrseStack(){
        
        Stack<Integer> temp = new Stack<>();
        int size = this.st.size();
        for(int i=0; i<size; i++)
        {
            moveStack( this.st, temp);
            int val = temp.pop();
            //System.out.println(val);
            moveStack(temp, this.st);
            this.st.push(val);
        }
        printStack();
    }
    
    public void insertAtBottom(Stack<Integer> st, int val){
        if(st.isEmpty())
        {
            st.push(val);
            return;
        }
        int v = st.pop();
        insertAtBottom(st, val);
        st.push(v);
    }
    
    public void reverseRecursively(Stack<Integer> st){
        
        if(st.isEmpty())
            return;
        int val = st.pop();
        reverseRecursively(st);
        insertAtBottom(st, val);
        
        
    }
    
}


class QueueUsingStack{
    
    Stack<Integer> st;
    ReverseStack rv;
    
    public  QueueUsingStack(){
        st = new Stack<Integer>();
        rv = new ReverseStack(st);
    }
    
    public boolean enque(int val){
        //this.st.push(val);
       rv.insertAtBottom(this.st, val);
        return true;
    }
    
    public int dequeue(){
        if(st.isEmpty())
            return -1;
        return st.pop();
    }
    
    
}

public class StackUtil {
    
    public static void main(String[] args) {
        
        Stack<Integer> st = new Stack<Integer>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.push(6);
        
       

        QueueUsingStack qs = new QueueUsingStack();
        qs.enque(1);
        qs.enque(2);
        qs.enque(3);
        qs.enque(4);
        System.out.println(" val " + qs.dequeue());
        System.out.println(" val " + qs.dequeue());
        System.out.println(" val " + qs.dequeue());
        System.out.println(" val " + qs.dequeue());
        
    }
    
    
    
}
