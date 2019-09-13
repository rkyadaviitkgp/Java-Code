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
public enum Coin {
    
    PENY(1), NICKLE(5), DIME(10), QUARTER(25);
    
    private int denomination;
    
    private Coin (int denomination)
    {
        this.denomination = denomination;
    }

    public int getDenomination() {
        return denomination;
    }
    
    
    
}
