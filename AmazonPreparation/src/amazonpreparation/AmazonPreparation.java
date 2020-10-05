/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amazonpreparation;

import tree.BinarySearchTree;
import doublylinklist.DoublyLinkList;
import iterator.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import stackproblems.StackProblems;
import tree.BinaryTree;
import tree.BinaryTreeNode;

/**
 *
 * @author rajeshkumar.yadav
 */
public class AmazonPreparation {

    /**
     * @param args the command line arguments
     */
    
    public void testDoublyLinkList(){
        int[] arr = {1,2,3,4,5};
        DoublyLinkList dll = new DoublyLinkList(arr);
        dll.print();
        dll.reverse();
        dll.print();
    }
    
    public void testBinaryTree(){
        int[] arr = {1,2};
        BinaryTree bt = new BinaryTree(arr, 0, 1);
//        bt.inOrderTraversal(bt.getRoot());
//        System.out.println("amazonpreparation.AmazonPreparation.testBinaryTree()");
//        bt.postOrderTraversal(bt.getRoot());
//        System.out.println("amazonpreparation.AmazonPreparation.testBinaryTree()");
//        bt.preOrderTraversal(bt.getRoot());
        BinaryTreeNode[] btArr = new BinaryTreeNode[2];
        bt.convertToDoublyLinkList(bt.getRoot(), btArr);
        bt.printDoublyLinkList(btArr[1]);
    }
    
    public void testPostFixConversion(){
        String expression = "a+b*c+d";
        StackProblems sp = new StackProblems();
        System.out.println(sp.getPostFixExpression(expression));
    }
    
    public void testRevreseStack(){
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.push(6);
        System.out.println(st.toString());
        StackProblems sp = new StackProblems();
        sp.recursiveReverseStack(st);
        System.out.println(st.toString());
    }
    
    public void testSortStack(){
        Stack<Integer> st = new Stack<>();
        st.push(4);
        st.push(2);
        st.push(1);
        st.push(3);
        st.push(6);
        st.push(5);
        System.out.println(st.toString());
        StackProblems sp = new StackProblems();
        sp.recursiveSortStack(st);
        System.out.println(st.toString());
    }
    
    public void testSpanOfStock(){
        int[] arr= {100, 80, 60, 70, 60, 75, 85};
        int res[];
        StackProblems sp = new StackProblems();
        res = sp.spanOfStock(arr);
        for(int a : res)
        System.out.print(a + " ");
        System.out.println("");
    }
    
    //test binary tree from inorder and preorder
    public void testBinaryTreeInOrderPreOrder(){
        int inOrder[] = {1,2,3,4,5,6,7,8,9};
        int preOrder[] = {4,2,1,3,8,6,5,7,9};
        int lastIndex = 8;
        BinaryTree bt = new BinaryTree(preOrder, 0, lastIndex, inOrder, 0, lastIndex);
        bt.inOrderTraversal(bt.getRoot());
        System.out.println();
        bt.preOrderTraversal(bt.getRoot());
    }
    
    //test binary tree from inorder and preorder
    public void testBinaryTreeInorderSuccessor(){
        int inOrder[] = {1,2,3,4,5,6,7,8,9};
        int preOrder[] = {4,2,1,3,8,6,5,7,9};
        int lastIndex = 8;
        BinaryTree bt = new BinaryTree(preOrder, 0, lastIndex, inOrder, 0, lastIndex);
        //bt.inOrderTraversal(bt.getRoot());
        System.out.println();
        Iterator<BinaryTreeNode> it = bt.getIterator("inorder", true);
        while(it.hasNext()){
            System.out.print(" " + ((BinaryTreeNode)it.next()).getVal() + " ");
        }
    }
    
    //test if BST
    public void testBinaryTreeISBST(){
        int inOrder[] = {1,2,3,5,6,7,8,9,10};
        int lastIndex = 8;
        BinarySearchTree bst = new BinarySearchTree(inOrder, 0, lastIndex);
        System.out.println();
        int[] arr = new int[1];
        arr[0] = 1;
        bst.isBST(bst.getRoot(), arr, 0);
        if(arr[0] == 1)
            System.out.println("BST");
        else
            System.out.println("NOT BST");
    }
    
     //merge two binary search tree 
    public void testMregeTree(){
        int[] arr1 = {1,2,13,24};
        BinarySearchTree bst1 = new BinarySearchTree(arr1, 0, 3);
        int[] arr2 = {2,8,9,14};
        BinarySearchTree bst2 = new BinarySearchTree(arr2, 0, 3);
        // bst1.inOrderTraversal(bst1.getRoot());
        // bst2.inOrderTraversal(bst2.getRoot());
        
        bst1 = (BinarySearchTree) bst1.mergeTwoBinarySearchTree(bst1, bst2);
        
        bst1.inOrderTraversal(bst1.getRoot());
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        AmazonPreparation ap = new AmazonPreparation();
        //ap.testDoublyLinkList();
        //ap.testBinaryTree();
        //ap.testPostFixConversion();
        //ap.testRevreseStack();
        //ap.testSortStack();
        //ap.testSpanOfStock();
        //ap.testBinaryTreeInOrderPreOrder();
        //ap.testBinaryTreeInorderSuccessor();
        //ap.testBinaryTreeISBST();
        ap.testMregeTree();
    }
    
}
