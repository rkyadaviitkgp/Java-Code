/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeandladdergame;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rajeshkumar.yadav
 */
public class SnakeAndLadderGame {

    
    public static void main(String[] args) throws InterruptedException {
        
        Board b = new Board(100);
        List<Player> plr = new ArrayList<Player>();
                
        b.addSnake(62, 5);
        b.addSnake(33, 6);
        b.addSnake(49, 9);
        b.addSnake(88, 16);
        b.addSnake(41, 20);
        b.addSnake(56, 53);
        b.addSnake(98, 64);
        b.addSnake(93, 73);
        b.addSnake(95, 75);
        
        b.addLadder(2, 37);
        b.addLadder(27, 46);
        b.addLadder(10, 32);
        b.addLadder(51, 68);
        b.addLadder(61, 79);
        b.addLadder(65, 84);
        b.addLadder(71, 91);
        b.addLadder(81, 100);
        
        Player p1 = new Player("Gourav");
        Player p2 = new Player("Sagar");
        Player p3 = new Player("Rajesh");
        Player p4 = new Player("Sourav");
        
        plr.add(p1);
        plr.add(p2);
        plr.add(p3);
        plr.add(p4);
        
        Game g =  new Game(b, plr);
        g.startGame();
        
        System.out.println("Winner is " + g.getWinner().getName());
        
        
        
    }
    
}