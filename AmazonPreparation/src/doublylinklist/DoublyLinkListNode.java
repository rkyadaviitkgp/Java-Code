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
public class DoublyLinkListNode {
    int val;
    DoublyLinkListNode next;
    DoublyLinkListNode prev;

    public DoublyLinkListNode(int val) {
        this.val = val;
        this.next=this.prev=null;
    }
    
}
