/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackproblems;

import java.util.Stack;

/**
 *
 * @author rajeshkumar.yadav
 */
public class StackProblems {

    // return postfix representation of given infix 
    public String getPostFixExpression(String expression) {

        StringBuilder sb = new StringBuilder();
        Stack<String> st = new Stack();

        //check if a valid infix exppreesion
        // convert to post fix expression
        for (char c : expression.toCharArray()) {
            if (Operators.isOparetor(c + "")) {
                if (st.isEmpty() || (st.peek().equals("(")) || (Operators.getOperatorPrecedence(st.peek()) < Operators.getOperatorPrecedence(c + ""))) {
                    st.push(c + "");
                } else {
                    while (!st.isEmpty() && !st.equals("(") && Operators.getOperatorPrecedence(st.peek()) >= Operators.getOperatorPrecedence(c + "")) {
                        sb.append(st.pop());
                    }
                    st.push(c + "");
                }
            } else if (c == '(') {
                st.push(c + "");
            } else if (c == ')') {
                while (!st.isEmpty() && !st.peek().equals("(")) {
                    sb.append(st.pop());
                }
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else {
                sb.append(c + "");
            }
        }

        //pop all oparator from stack and append it to sb
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        //return postfix expression
        return sb.toString();
    }

    //recursively reverse stack
    public void recursiveReverseStack(Stack<Integer> st) {
        if (!st.isEmpty()) {
            int topValue = st.pop();
            recursiveReverseStack(st);
            pushAtBottom(st, topValue);
        }
    }

    //push item bottom of stack
    public void pushAtBottom(Stack<Integer> st, int val) {
        if (st.isEmpty()) {
            st.push(val);
        } else {
            int topItem = st.pop();
            pushAtBottom(st, val);
            st.push(topItem);
        }
    }

    //recursively reverse stack
    public void recursiveSortStack(Stack<Integer> st) {
        if (!st.isEmpty()) {
            int topValue = st.pop();
            recursiveSortStack(st);
            pushAtSortedBottom(st, topValue);
        }
    }

    //push item bottom of stack
    public void pushAtSortedBottom(Stack<Integer> st, int val) {
        if (st.isEmpty() || st.peek() < val) {
            st.push(val);
        } else {
            int topItem = st.pop();
            pushAtSortedBottom(st, val);
            st.push(topItem);
        }
    }

    public int[] spanOfStock(int stockPrice[]) {
        int span[] = new int[stockPrice.length];
        if (stockPrice.length == 0) {
            return span;
        }
        span[0] = 1;
        for (int i = 1; i < stockPrice.length; i++) {
            int j = i-1;
            while( j >= 0 && stockPrice[j] <= stockPrice[i]){
                j = j - span[j];
            }
            if(j < 0)
                span[i] = i+1;
            else
                span[i] = i - j;
        }
        return span;
    }

}
