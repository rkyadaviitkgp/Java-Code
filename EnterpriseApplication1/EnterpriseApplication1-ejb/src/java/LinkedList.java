/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rajeshkumar.yadav
 */

class LinkNode{
    
    int val;
    LinkNode next;
    
    public LinkNode(int val){
        this.val = val;
        this.next = null;
    }
    
    
    
}
public class LinkedList {
    
    public LinkNode createList(int[] arr){
        if(arr.length == 0)
            return null;
        
            
        LinkNode head = new LinkNode(arr[0]);
        LinkNode temp = head;
        for(int i=1; i<arr.length; i++)
        {
            temp.next = new LinkNode(arr[i]);
            temp = temp.next;
        }
        return head;
    }
    
    public void printList(LinkNode head){
        
        while(head != null)
        {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.print(" NULL ");
        System.err.println("");
    }
    
    public LinkNode reverseRecursivelyUtil(LinkNode head, LinkNode[] newHead){
        
        if(head.next == null)
        {
            newHead[0] = head;
            return head;
        }
        LinkNode prev = reverseRecursivelyUtil(head.next, newHead);
        prev.next = head;
        head.next = null;
        return  head;
    }
    
    public LinkNode reverseRecursively(LinkNode head){
        LinkedList ll = new LinkedList();
        LinkNode[] newHead = new LinkNode[1];
        ll.reverseRecursivelyUtil(head, newHead);
        return newHead[0];
    }
    
    public static void main(String args[]){
        
        int arr[] = {1,2,3,4,5};
        LinkedList ll = new LinkedList();
        LinkNode list = ll.createList(arr);
        LinkNode rvl = ll.reverseRecursively(list);
        ll.printList(rvl);
        
        
    }
    
   
    
}
