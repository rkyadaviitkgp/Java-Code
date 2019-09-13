/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeandladdergame;

import java.util.Random;

/**
 *
 * @author rajeshkumar.yadav
 */
public class Dice {
    
    public int rollDice()
    {
        Random rand = new Random(); 
        int val =  rand.nextInt(7); 
        if(val == 0)
            return val + 1;
        else return val;
    }
    
}
