/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeandladdergame;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author rajeshkumar.yadav
 */
public class Game {
    
    Board board;
    Dice dice;
    List<Player> player;
    Player winnerPlayer;

    public Game(Board board, List<Player> user) {
        this.board = board;
        this.dice = new Dice();
        this.player = user;
        winnerPlayer = null;
    }
    
    public void startGame() throws InterruptedException
    {
        boolean winner = false;
        int noOfPlayer = player.size();
        int turn = 0;
        while(winner == false)
        {
            int diceVal = dice.rollDice();
            Player plr = player.get(turn);
            
            int nextpos = plr.getPosOnBoard() + diceVal;
            if(board.isValidPos(nextpos))
            {
                nextpos = board.getNextPos(nextpos);
                plr.setPosOnBoard(nextpos);
                winner = board.isWinner(plr.getPosOnBoard());
            }
            System.out.println("Player " + plr.getName() + " throws dice and dice output is " + diceVal + " player position is " + plr.getPosOnBoard());
            turn++;
            turn = (turn)%noOfPlayer;
            if(winner == true)
            {
                winnerPlayer = plr;
            }
            
        }
    }
    
    public Player getWinner()
    {
        return winnerPlayer;
    }
    
}
