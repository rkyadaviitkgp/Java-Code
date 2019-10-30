
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rajeshkumar.yadav
 */
/**
 * Definition for a binary tree node.
 * public class Forest {
     int val;
     Forest left;
     Forest right;
     Forest(int x) { val = x; }
 }
 */
class BSTIterator {

    Stack<Forest> st;
    public BSTIterator(Forest root) {
        st =  new Stack<Forest>();
        while(root != null)
        {
            st.push(root);
            root= root.left;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        
        Forest temp =  st.pop();
        int val = temp.val;
        if(temp.right!=null)
        {
            temp = temp.right;
            while(temp!=null)
            {
                st.push(temp);
                temp = temp.left;
            }
        }
        return val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(st.empty())
            return false;
        return true;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */