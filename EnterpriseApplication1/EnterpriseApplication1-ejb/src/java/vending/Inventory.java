/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vending;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author rajeshkumar.yadav
 */
public class Inventory<T> {
    
    private Map<T, Integer> inventory;// = new HashMap<T, Integer>(); 
    
    public Inventory(Inventory in)
    {
        Map<T, Integer> tempCashInventory = new HashMap<T, Integer>(in.getInventory());
        this.inventory = tempCashInventory;
    }
    public Inventory()
    {
        inventory = new HashMap<T, Integer>(); 
    }
    public int getQuantity(T item)
    {
        Integer count = inventory.get(item);
        if(count == null)
            return 0;
        else
            return count;
    }
    
    public void add(T Item)
    {
        int count  = getQuantity(Item);
        inventory.put(Item, count+1);
    }
    
    public void deduct(T item)
    {
        if(hasItem(item))
        {
            int count = getQuantity(item) -1 ;
            inventory.put(item, count);
        }
    }
    
    public boolean hasItem(T item)
    {
        if(getQuantity(item) > 0)
            return true;
        return false;
    }
    
    public void clear()
    {
        inventory.clear();
    }
    
    public void put(T item, int quantity)
    {
        inventory.put(item, quantity);
    }

    public Map<T, Integer> getInventory() {
        return inventory;
    }
    
    
    
}
