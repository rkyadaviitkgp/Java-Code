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
public class VendingMachineFactory {
    
    public static VendingMachine createVencdingMachine()
    {
        return new VendingMachineImpl();
    }
    
}
