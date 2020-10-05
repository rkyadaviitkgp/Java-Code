/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

import iterator.BinaryTreeInorderIterator;
import iterator.Iterator;

/**
 *
 * @author rajeshkumar.yadav
 */
public class BinaryTree {

    BinaryTreeNode root;

    public BinaryTree(BinaryTreeNode root) {
        this.root = root;
    }

    public BinaryTreeNode getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }

    public BinaryTreeNode BinaryTreeUtil(int[] arr, int start, int end) {

        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        BinaryTreeNode newNode = new BinaryTreeNode(arr[mid]);
        newNode.left = BinaryTreeUtil(arr, start, mid - 1);
        newNode.right = BinaryTreeUtil(arr, mid + 1, end);
        return newNode;
    }

    public BinaryTree(int[] arr, int start, int end) {
        root = BinaryTreeUtil(arr, start, end);
    }

    public void inOrderTraversal(BinaryTreeNode bt) {

        if (bt == null) {
            return;
        }
        inOrderTraversal(bt.left);
        System.out.print(bt.val + " ");
        inOrderTraversal(bt.right);

    }

    public void preOrderTraversal(BinaryTreeNode bt) {

        if (bt == null) {
            return;
        }
        System.out.print(bt.val + " ");
        preOrderTraversal(bt.left);
        preOrderTraversal(bt.right);

    }

    public void postOrderTraversal(BinaryTreeNode bt) {

        if (bt == null) {
            return;
        }

        postOrderTraversal(bt.left);
        postOrderTraversal(bt.right);
        System.out.print(bt.val + " ");

    }

    //print doubly link list 
    public void printDoublyLinkList(BinaryTreeNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.right;
        }
    }

    //convert a binary tree into a doubly link list 
    public void convertToDoublyLinkList(BinaryTreeNode root, BinaryTreeNode[] arr) {

        if (root == null) {
            return;
        }
        convertToDoublyLinkList(root.left, arr);
        if (arr[0] == null) {
            arr[0] = arr[1] = root;
        } else {
            root.left = arr[0];
            arr[0].right = root;
            arr[0] = root;
        }
        convertToDoublyLinkList(root.right, arr);

    }

    //search an item in the array 
    public int searchUtil(int arr[], int start, int end, int val) {

        for (int i = start; i <= end; i++) {
            if (arr[i] == val) {
                return i;
            }
        }
        return -1;
    }

    //create binary tree 
    public BinaryTree(int preOrder[], int preStart, int preEnd, int inOrder[], int inStart, int inEnd) {
        BinaryTreeNode bt = createTreeUtil(preOrder, preStart, preEnd, inOrder, inStart, inEnd);
        this.root = bt;
    }

    //create tree form inorder and post order traversal
    public BinaryTreeNode createTreeUtil(int preOrder[], int preStart, int preEnd, int inOrder[], int inStart, int inEnd) {

        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        int index = searchUtil(inOrder, inStart, inEnd, preOrder[preStart]);

        BinaryTreeNode bt = new BinaryTreeNode(preOrder[preStart]);
        bt.left = createTreeUtil(preOrder, preStart + 1, preStart + index - inStart, inOrder, inStart, index - 1);
        bt.right = createTreeUtil(preOrder, preStart + index - inStart + 1, preEnd, inOrder, index + 1, inEnd);
        return bt;
    }

    public Iterator getIterator() {
        return new BinaryTreeInorderIterator(this, false);
    }

    public Iterator getIterator(String str, boolean option) {

        switch (str) {
            case "inorder":
                return new BinaryTreeInorderIterator(this, true);
            case "postorder":
                return new BinaryTreeInorderIterator(this, true);
        }
        //by default
        return new BinaryTreeInorderIterator(this, true);
    }

}
