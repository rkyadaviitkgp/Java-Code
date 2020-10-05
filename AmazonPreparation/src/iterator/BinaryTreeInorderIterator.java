/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iterator;

import java.util.Stack;
import listener.BinaryTreeListener;
import listener.Listener;
import tree.BinaryTree;
import tree.BinaryTreeNode;

/**
 *
 * @author rajeshkumar.yadav
 */
public class BinaryTreeInorderIterator implements Iterator{
    
    Tracker tc;
    Boolean option;
    Stack<BinaryTreeNode> st;
    Listener listener;

    public BinaryTreeInorderIterator() {
        
    }
    
    public BinaryTreeInorderIterator(BinaryTree bt, Boolean option) {
        st = new Stack<>();
        this.option = option;
        if(option == true){
            tc = new Tracker();
            listener = new BinaryTreeListener();
        }
        BinaryTreeNode root = bt.getRoot();
        while(root != null){
            st.push(root);
            root = root.getLeft();
        }
    }

    @Override
    public boolean hasNext() {
        return !st.isEmpty();
    }

    @Override
    public  BinaryTreeNode next() {
        if(option == true && tc.arr[0] == true){
            System.out.println("err");
            return (BinaryTreeNode) null;
        }
        BinaryTreeNode bt = st.pop();
        BinaryTreeNode rt = bt.getRight();
        while(rt != null){
            st.push(rt);
            rt = rt.getLeft();
        }
        return (BinaryTreeNode)bt;
    }
    
}
