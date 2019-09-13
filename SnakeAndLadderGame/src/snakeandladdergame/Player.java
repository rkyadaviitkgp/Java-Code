/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeandladdergame;

/**
 *
 * @author rajeshkumar.yadav
 */
public class Player {
    
    String name;
    int posOnBoard;

    public Player(String name) {
        this.name = name;
        this.posOnBoard = 0;
    }

    public void setNextPos(int val)
    {
        
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosOnBoard() {
        return posOnBoard;
    }

    public void setPosOnBoard(int posOnBoard) {
        this.posOnBoard = posOnBoard;
    }
    
}
