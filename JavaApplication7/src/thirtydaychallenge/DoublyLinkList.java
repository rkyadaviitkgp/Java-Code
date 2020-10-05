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
public class DoublyLinkList {
    
    DoublyLinkListNode head;
    DoublyLinkListNode tail;
    int size;
    
    public DoublyLinkList(){
        this.head = this.tail = null;
        size = 0;
    }
    
    public DoublyLinkListNode removeHead(){
        DoublyLinkListNode cur = head;
        if(size == 1){
            head = tail = null;
        }else{
            head = head.next;
            head.prev = null;
            cur.next = cur.prev = null;
        }
        cur.flag = 0;
        size--;
        return cur;
    }
    
    public DoublyLinkListNode removeTail(){
        DoublyLinkListNode cur = tail;
        tail = tail.prev;
        tail.next = null;
        cur.next = cur.prev = null;
        cur.flag = 0;
        size--;
        return cur;
    }
    
    public void remove(DoublyLinkListNode node){
        
        if(size == 0)
            return;
        
        if(node.flag == 0 )
            return;
        
        if(head == node){
            removeHead();
            return;
        }
        
        if(tail == node){
            removeTail();
            return;
        }
        
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = node.prev = null;
        node.flag = 0;
        size--;
        return;
        
    }
    
    public void insertAtHead(DoublyLinkListNode node){
        
        if(size == 0){
                head = node;
                tail = head;
            }else{
                node.next = head;
                head.prev = node;
                head = node;
            }
        size++;
    }
    
    public void insertAtTail(DoublyLinkListNode node){
        
        tail.next = node;
        node.prev = tail;
        tail = node;
        size++;
            
    }
    
    public void insert(DoublyLinkListNode node, int ind){
        
        if(ind > size){
            return;
        }
        
        /* insert at head */
        if(ind == 0){
            insertAtHead(node);
            return;
        }
        
        if(ind == size){
           insertAtTail(node);
           return;
        }
        
        int indval = 0;
        DoublyLinkListNode curnode = head;
        while(indval != ind){
            indval++;
            curnode = curnode.next;
        }
        
        curnode.prev.next = node;
        node.prev = curnode.prev;
        node.next = curnode;
        curnode.prev = node;
        size++;
        return;
        
    }
    
}
