/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thirtydaychallenge;

/**
 *
 * @author rajeshkumar.yadav
 */
public class DoublyLinkListNode {
    
    int val;
    DoublyLinkListNode next;
    DoublyLinkListNode prev;
    int flag;
    
    public DoublyLinkListNode(int value){
        this.val = value;
        this.next = this.prev = null;
        flag = 1;
    }
    
}
