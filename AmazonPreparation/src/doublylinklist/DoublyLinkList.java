/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublylinklist;

/**
 *
 * @author rajeshkumar.yadav
 */
public class DoublyLinkList {

    DoublyLinkListNode head;

    public DoublyLinkList(DoublyLinkListNode head) {
        this.head = head;
    }

    //craete a doubly link list
    public DoublyLinkList(int[] arr) {

        this.head = null;
        DoublyLinkListNode temp = null;

        for (int val : arr) {
            if (head == null) {
                head = temp = new DoublyLinkListNode(val);
            } else {
                DoublyLinkListNode newNode = new DoublyLinkListNode(val);
                temp.next = newNode;
                newNode.prev = temp;
                temp = newNode;
            }

        }

    }
    
    //reverse a doubly link list
    public void reverse(){
        
        DoublyLinkListNode  curNode = head;
        DoublyLinkListNode prevNode = null;
        
        while(curNode != null){
            
            DoublyLinkListNode nextNode = curNode.next;
            curNode.next = prevNode;
            curNode.prev = nextNode;
            prevNode = curNode;
            curNode = nextNode;
        }
        
        head = prevNode;
    }
    
    //print a doubly link list 
    public void print() {
        DoublyLinkListNode temp = head;
        System.out.print("Null <-");
        while (temp != null) {
            String printString = "<=>";
            if(temp.next == null)
                printString = "->";
            System.out.print(temp.val + printString);
            temp = temp.next;
        }
        System.out.println("Null");
    }

}
