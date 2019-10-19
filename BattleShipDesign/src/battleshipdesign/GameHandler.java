/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipdesign;

import java.util.ArrayList;

/**
 *
 * @author rajeshkumar.yadav
 */
public class GameHandler {
    
    User u1;
    User u2;

    public GameHandler(String u1Name, String u2Name, ArrayList<ArrayList<Integer>> u1Xaxis, ArrayList<ArrayList<Integer>>u1Yaxis, ArrayList<ArrayList<Integer>> u2Xaxis, ArrayList<ArrayList<Integer>>u2Yaxis) {
        
        u1 = new User(u1Name);
        u2 = new User(u2Name);
        u1.PlaceShipOnBoard(u1Xaxis, u1Yaxis);
        u2.PlaceShipOnBoard(u2Xaxis, u2Yaxis);
        
    }

    public User getU1() {
        return u1;
    }

    public void setU1(User u1) {
        this.u1 = u1;
    }

    public User getU2() {
        return u2;
    }

    public void setU2(User u2) {
        this.u2 = u2;
    }
    
    
   
    public boolean shootTarget(int turn, int xpos, int ypos){
        User u;
        if(turn == 1){
            u = u2;
        }else{
            u = u1;
        }
        u.getShipBoard().getBoardLoaction(xpos, ypos).setShootstatus(ShootStatus.Shooted);
        if(u.getShipBoard().getBoardLoaction(xpos, ypos).getShip() != null)
            return true;
        return false;
    }
    
    public boolean DoesUserWon(int turn){
        User u;
        if(turn == 1){
            u = u2;
        }else{
            u = u1;
        }
        
        for(int i=0; i<u.getShip().size(); i++)
        {
            if(u.getShip().get(i).getShipstatus() != ShipStatus.Sunk)
                return false;
        }
        return true;
    }
    
    
}
