/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipdesign;

/**
 *
 * @author rajeshkumar.yadav
 */
public class LocationOnBoard {
    
    private int xaxis;
    private int yaxis;
    private ShootStatus shootstatus;
    private Ship ship;

    public LocationOnBoard(int xaxis, int yaxis) {
        this.xaxis = xaxis;
        this.yaxis = yaxis;
        this.shootstatus = ShootStatus.NOtShooted;
        ship = null;
    }

    public int getXaxis() {
        return xaxis;
    }

    public void setXaxis(int xaxis) {
        this.xaxis = xaxis;
    }

    public int getYaxis() {
        return yaxis;
    }

    public void setYaxis(int yaxis) {
        this.yaxis = yaxis;
    }

    public ShootStatus getShootstatus() {
        return shootstatus;
    }

    public void setShootstatus(ShootStatus shootstatus) {
        this.shootstatus = shootstatus;
        
        if(shootstatus == ShootStatus.Shooted && this.ship != null){
            int no = this.ship.getUnshootedLocation();
            no--;
            this.ship.setUnshootedLocation(no);
            if(no == 0)
                this.ship.setShipstatus(ShipStatus.Sunk);
        }
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }
    
    
}
