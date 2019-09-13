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
public class Board {
    
    int arr[];
    int size;

    public Board(int size) {
        this.size = size;
        arr = new int[size+1];
        for(int i=0; i<=size; i++)
            arr[i] = 0;
    }
    
    public void addSnake(int headpos, int tailpos)
    {
        if(headpos <= tailpos || !isValidPos(headpos) || !isValidPos(tailpos))
        {
            System.out.println("snake is not a valid smnake ");
            return;
        }
        
        int snakeLength =  tailpos - headpos;
        
        arr[headpos] = snakeLength;
        
    }
    
    public boolean isValidPos(int pos)
    {
        if(pos < 0 || pos > size)
            return false;
        return true;
    }
    
    public int getNextPos(int pos)
    {
        if(arr[pos] != 0)
        {
            pos = pos + arr[pos];
        }
        return pos;
    }
    public boolean isWinner(int pos)
    {
        if(!isValidPos(pos))
            return false;
        if(pos == size)
            return true;
        return false;
    }
    public void addLadder(int startPos, int endPos)
    {
        
        if(startPos > endPos || !isValidPos(startPos) || !isValidPos(endPos))
        {
            System.out.println(" invalid ladder");
            return;
        }
        
        int ladderLength = endPos - startPos ;
        arr[startPos] = ladderLength;
    }
    
    public boolean isSnakePresent(int pos)
    {
        if(arr[pos] < 0)
            return true;
        return false;
    }
    
    public boolean isLadderPresent(int pos)
    {
        if(arr[pos] > 0)
            return true;
        return false;
    }
    
}
