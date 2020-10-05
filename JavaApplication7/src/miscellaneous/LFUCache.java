/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miscellaneous;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 *
 * @author rajeshkumar.yadav
 */
class LFUNode implements Comparable<LFUNode>{
    
    int key;
    int value;
    int usedCount;
    Timestamp ts;
    
    public LFUNode(int key, int value){
        this.key = key;
        this.value = value;
        usedCount = 1;
        ts = new Timestamp(System.currentTimeMillis());
    }
    
    public int compareTo(LFUNode lfunode) {
        if(this.usedCount > lfunode.usedCount)
            return 1;
        else if(this.usedCount == lfunode.usedCount)
        {
            if(this.ts.getTime() > lfunode.ts.getTime())
                return 1;
            else
                return -1;
        }
        return -1;
    }

}

public class LFUCache {
    
    HashMap<Integer, LFUNode> hm;
    PriorityQueue<LFUNode> LFUQueue;
    int capacity;
    int size;
    
    public LFUCache(int capacity){
        
        this.capacity = capacity;
        this.size = capacity;
        hm = new HashMap<>();
        LFUQueue = new PriorityQueue<>();
        
    }
    
    public int get(int key){
        
        LFUNode node = hm.get(key);
        if(node == null || size == 0)
        {
            return -1;
        }
        
         node.usedCount++;
         node.ts = new Timestamp(System.currentTimeMillis());
         LFUQueue.remove(node);
         LFUQueue.add(node);
        
        
        return node.value;
    }
    
    public void put(int key, int value){
        
        if(size == 0)
            return;
        LFUNode node = hm.get(key);
        if(node != null)
        {
            node.value = value;
            node.usedCount++;
            node.ts = new Timestamp(System.currentTimeMillis());
            LFUQueue.remove(node);
            LFUQueue.add(node);
            return;
        }
        
        if(this.capacity == 0){
            this.capacity++;
            node = LFUQueue.remove();
            hm.remove(node.key);
        }
        this.capacity--;
        LFUNode newNode = new LFUNode(key, value);
        hm.put(key, newNode);
        LFUQueue.add(newNode);
        
    }
    
}
