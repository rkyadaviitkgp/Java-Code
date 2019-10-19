/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipdesign;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rajeshkumar.yadav
 */
public class User {
    
    private String name;
    private Board shipBoard;
    private Board missileBoard;
    private List<Ship> ship;
    private GameHandler gamehandler;

    public User(String name) {
        this.name = name;
        this.shipBoard = new Board();
        this.missileBoard = new Board();
        ship = new ArrayList<>();
    }
    
    public void PlaceShipOnBoard(ArrayList<ArrayList<Integer>> boatXLocation, ArrayList<ArrayList<Integer>> boatYLocation){
        
        
        if(checkValididtyOfInput(boatXLocation.get(0), boatYLocation.get(0)))
        {
            PlaceShip(0, 5, boatXLocation.get(0), boatYLocation.get(0));
        }
        
        if(checkValididtyOfInput(boatXLocation.get(1), boatYLocation.get(1)))
        {
            PlaceShip(0, 4, boatXLocation.get(1), boatYLocation.get(1));
        }
        
        if(checkValididtyOfInput(boatXLocation.get(2), boatYLocation.get(2)))
        {
            PlaceShip(0, 3, boatXLocation.get(2), boatYLocation.get(2));
        }
        
        if(checkValididtyOfInput(boatXLocation.get(3), boatYLocation.get(3)))
        {
            PlaceShip(0, 3, boatXLocation.get(3), boatYLocation.get(3));
        }
        
        if(checkValididtyOfInput(boatXLocation.get(4), boatYLocation.get(4)))
        {
            PlaceShip(0, 2, boatXLocation.get(4), boatYLocation.get(4));
        }
        
    }
    
    private void PlaceShip(int id, int len, ArrayList<Integer> xlist, ArrayList<Integer> ylist){
        
        List<LocationOnBoard> loc = new ArrayList<>();
        for(int i=0;i<xlist.size(); i++){
            int x = xlist.get(i);
            int y = ylist.get(i);   
            LocationOnBoard l = shipBoard.getBoardLoaction(x, y);
            loc.add(l);
        }
        
        Ship s = new Ship(id, len, loc);
        ship.add(s);
        
    }
    
    private boolean checkValididtyOfInput(ArrayList<Integer> x, ArrayList<Integer> y){
        if(x.size() != y.size()){
            System.err.println("Invalid input");
            return false;
        }
//        for(int i=0;i<x.size(); i++){
//            int x1 = x.get(i);
//            int y1 = y.get(i);
//            if(x1<0 || x1>9 || y1<0 || y1>9)
//            {
//                System.err.println("Invalid input");
//                return false;
//            }
//        }
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Board getShipBoard() {
        return shipBoard;
    }

    public void setShipBoard(Board shipBoard) {
        this.shipBoard = shipBoard;
    }

    public Board getMissileBoard() {
        return missileBoard;
    }

    public void setMissileBoard(Board missileBoard) {
        this.missileBoard = missileBoard;
    }

    public List<Ship> getShip() {
        return ship;
    }

    public void setShip(List<Ship> ship) {
        this.ship = ship;
    }

    public GameHandler getGamehandler() {
        return gamehandler;
    }

    public void setGamehandler(GameHandler gamehandler) {
        this.gamehandler = gamehandler;
    }
    
    
    
    
}
