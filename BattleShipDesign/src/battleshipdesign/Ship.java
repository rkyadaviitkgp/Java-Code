/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipdesign;

import java.util.List;

/**
 *
 * @author rajeshkumar.yadav
 */
public class Ship {
    
    private int id;
    private int length;
    private ShipStatus shipstatus;
    List<LocationOnBoard> postion;
    private int unshootedLocation;

    public Ship(int id, int length, List<LocationOnBoard> postion) {
        this.id = id;
        this.length = length;
        this.postion = postion;
        this.shipstatus = ShipStatus.Afloat;
        for(int i = 0; i<postion.size(); i++)
            postion.get(i).setShip(this);
        this.unshootedLocation = length;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public ShipStatus getShipstatus() {
        return shipstatus;
    }

    public void setShipstatus(ShipStatus shipstatus) {
        this.shipstatus = shipstatus;
    }

    public List<LocationOnBoard> getPostion() {
        return postion;
    }

    public void setPostion(List<LocationOnBoard> postion) {
        this.postion = postion;
    }

    public int getUnshootedLocation() {
        return unshootedLocation;
    }

    public void setUnshootedLocation(int unshootedLocation) {
        this.unshootedLocation = unshootedLocation;
    }
    
    
    
    
    
    
}
