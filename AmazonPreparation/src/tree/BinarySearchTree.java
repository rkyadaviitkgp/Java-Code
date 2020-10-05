/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

import tree.BinaryTree;
import tree.BinaryTreeNode;

/**
 *
 * @author rajeshkumar.yadav
 */
public class BinarySearchTree extends BinaryTree{

    public BinarySearchTree(BinaryTreeNode root) {
        super(root);
    }
    
    public BinarySearchTree(int arr[], int start, int end) {
        super(arr, start, end);
    }
    
    public BinaryTreeNode isBST(BinaryTreeNode bt, int arr[], int lr){
        if(bt == null)
            return bt;
        if(arr[0] == 0)
            return bt;
        if(bt.getLeft() == null && bt.getRight() == null)
            return bt;
        BinaryTreeNode btnl =  isBST(bt.getLeft(), arr, 0);
        BinaryTreeNode btnr =  isBST(bt.getRight(), arr, 1);
        if(btnl != null && btnl.getVal() > bt.getVal()){
            arr[0] = 0;
            return bt;
        }
        if(btnr != null && btnr.getVal() < bt.getVal()){
            arr[0] = 0;
            return bt;
        }
        if(lr == 0){
            return btnr;
        }else{
            return btnl;
        }
    }
    
    public void getTwoRootNode(BinaryTree bt1, BinaryTree bt2, BinaryTreeNode[] arr){
        BinaryTreeNode root1 = bt1.getRoot();
        BinaryTreeNode root2 = bt2.getRoot();
        BinaryTreeNode prev = null;
        if(root1.getVal() > root2.getVal()){
            arr[0] = root2;
            while(root2 != null && root2.getVal() < root1.getVal()){
                prev = root2;
                root2 = root2.getRight();
            }
            arr[1] = root2;
            prev.setRight(null);
        }else{
            arr[1] = root2;
            while(root2 != null && root2.getVal() >= root1.getVal()){
                prev = root2;
                root2 = root2.getLeft();
            }
            arr[0] = root2;
            prev.setLeft(null);
        }
        
    }
    
    public BinaryTreeNode insertUtil(BinaryTreeNode root, BinaryTreeNode newNode){
        if(root == null)
            return newNode;
        if(root.getVal() > newNode.getVal()){
            root.left = insertUtil(root.left, newNode);
        }else{
            root.right = insertUtil(root.right, newNode);
        }
        return root;
    }
    
    public void insert(BinaryTree bt, BinaryTreeNode node1){
        BinaryTreeNode root = bt.getRoot();
        if(root == null){
            bt.setRoot(node1);
            return;
        }else if(node1 == null)
            return ;
        bt.root = insertUtil(root, node1);
    }
    
    public BinaryTree mergeTwoBinarySearchTree(BinaryTree bt1, BinaryTree bt2){
        
        //get two nodes from second tree 
        BinaryTreeNode[] arr = new BinaryTreeNode[2];
        arr[0] = arr[1] = null;
        getTwoRootNode(bt1, bt2, arr);
        //insert two root node in first tree 
        insert(bt1, arr[0]);
        insert(bt1, arr[1]);
        //return head of first tree 
        return bt1;
    }
    
}
