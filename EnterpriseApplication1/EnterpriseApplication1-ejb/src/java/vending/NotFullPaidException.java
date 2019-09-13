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
public class NotFullPaidException extends RuntimeException{
    
    private String message;
    private long remaining;
    
    public NotFullPaidException(String message, long remaining)
    {
        this.message = message;
        this.remaining = remaining;
    }

    public long getRemaining() {
        return remaining;
    }
    
    public String getMessage()
    {
        return message + remaining;
    }
    
    
    
}
