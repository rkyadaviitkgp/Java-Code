/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liftmanagement.controller;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import liftmanagement.entity.Request;

/**
 *
 * @author rajeshkumar.yadav
 */
public class InputManager {
    
    int arr[][];
    Hashtable<Integer, List<Request>> hashTable;

    public InputManager(int[][] arr) {
        this.arr = arr;
        hashTable = new Hashtable<>();
        for(int i=0; i<arr.length; i++)
        {
            List<Request> reqList = hashTable.getOrDefault(arr[i][0], new LinkedList<>());
            Request r = new Request(arr[i][1], arr[i][2], arr[i][0]);
            reqList.add(r);
            hashTable.put(arr[i][0], reqList);
        }
    }

    public Hashtable<Integer, List<Request>> getHashTable() {
        return hashTable;
    }

    public void setHashTable(Hashtable<Integer, List<Request>> hashTable) {
        this.hashTable = hashTable;
    }
    
}
