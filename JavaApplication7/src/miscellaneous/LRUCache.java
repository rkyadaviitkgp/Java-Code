/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miscellaneous;

import java.util.HashMap;

/**
 *
 * @author rajeshkumar.yadav
 */

class Node{
    
    int key;
    int val;
    Node prev;
    Node next;
    
    public Node(int key, int val){
        this.val = val;
        this.key = key;
        this.next = this.prev = null;
    }
    
}

class DoublyLinkeList{
    
    Node head;
    Node tail;
    
    public DoublyLinkeList(){
        head = tail = null;
    }
    
    public void AddAtTail(Node n){
        
        if(head == null)
        {
            head = tail = n;
            return ;
        }
        
        n.prev = tail;
        tail.next = n;
        tail = n;
        
    }
    
    public void removeNode(Node n){
        
        if(n == head){
            head = head.next;
            if(head != null)
                head.prev = null;
            n.next = null;
            return;
        }
        
        if(n == tail){
            tail = tail.prev;
            if(tail != null)
                tail.next = null;
            n.prev = null;
            return;
        }
        
        n.prev.next = n.next;
        n.next.prev = n.prev;
        n.next = n.prev = null;
        return;
        
    }
    
    
    
}
public class LRUCache {
    
    HashMap<Integer, Node> hm;
    DoublyLinkeList dl;
    int capacity;
    int currentSize ;
    
    
    public LRUCache(int capacity) {
        
        currentSize = 0;
        hm = new HashMap<>();
        dl = new DoublyLinkeList();
        this.capacity = capacity;
        
    }
    
    public int get(int key) {
        
        Node node = hm.get(key);
        
        if( node == null)
            return -1;
        
        dl.removeNode(node);
        dl.AddAtTail(node);
        
        return node.val;
    }
    
    private void putInCache(int key, int value){
            currentSize++;
            Node n = new Node(key, value);
            hm.put(key, n);
            dl.AddAtTail(n);
    }
    
    public String put(int key, int value) {
        
        Node n = hm.get(key);
        if(n != null)
        {
            n.val = value;
            get(key);
            return "NULL";
        }
        
        if(currentSize == capacity){
           currentSize--;
           hm.remove(dl.head.key);
           dl.removeNode(dl.head); // remove least recently used item 
        }
        
        putInCache(key, value);
        
        return "NULL";
    }
    
//    public static void main(String[] args) {
//        
//        LRUCache lru = new LRUCache(2);
//        
//        System.out.println("get 2 " + lru.get(2));
//        System.out.println("put 2, 6 "  );
//        lru.put(2, 6);
//        System.out.println("get 1 " + lru.get(1));  
//        System.out.println("put 1, 5 "  );
//        lru.put(1, 5);
//        System.out.println("put 1, 2 "  );
//        lru.put(1, 2);
//        System.out.println("get 1 " + lru.get(1)); 
//        System.out.println("get 2 " + lru.get(2)); 
//    }
    
}

/*

Your input
["LRUCache","get","put","get","put","put","get","get"]
[[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
Output
[null,-1,null,-1,null,null,2,-1]
Expected
[null,-1,null,-1,null,null,2,6]

*/