/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vending;

//import com.sun.xml.fastinfoset.util.FixedEntryStringIntMap;

/**
 *
 * @author rajeshkumar.yadav
 */
public class Bucket<E1, E2> {
    
    private E1 first;
    private E2 second;
    
    public Bucket(E1 first, E2 second)
    {
        this.first = first;
        this.second =  second;
    }

    public E1 getFirst() {
        return first;
    }

    public E2 getSecond() {
        return second;
    }
    
}
