/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vending;

/**
 *
 * @author rajeshkumar.yadav
 */
public enum Item {
    
    COKE("Coke", 35), PEPSI("Pepsi", 20), SODA("Soda", 30);
    private String name;
    private int price;
    
    private Item(String name, int price)
    {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
    
}
