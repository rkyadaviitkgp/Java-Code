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
public class NotSufficientChangeException extends  RuntimeException{
    private String message;
    public NotSufficientChangeException(String message)
    {
        this.message = message;
    }
    public String getMessage()
    {
        return message;
    }
}
