/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liftmanagement.entity;
/**
 *
 * @author rajeshkumar.yadav
 */
public class LiftRequest extends Request{
    
    boolean sourceFinieshed;
    boolean destinationFinieshed;
    
    public LiftRequest(int sourceFloor, int destinationFloor, int time) {
        super(sourceFloor, destinationFloor, time);
        this.sourceFinieshed = this.destinationFinieshed = false;
    }
   
    public boolean isSourceFinieshed() {
        return sourceFinieshed;
    }

    public void setSourceFinieshed(boolean sourceFinieshed) {
        this.sourceFinieshed = sourceFinieshed;
    }

    public boolean isDestinationFinieshed() {
        return destinationFinieshed;
    }

    public void setDestinationFinieshed(boolean destinationFinieshed) {
        this.destinationFinieshed = destinationFinieshed;
    }

}
