/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabmanagement.model;
/**
 *
 * @author rajeshkumar.yadav
 */
public class Cab extends CabManagementEntity{
    
    String noPlate;
    CabType type;

    public Cab(String noPlate, CabType type) {
        this.noPlate = noPlate;
        this.type = type;
    }

    public String getNoPlate() {
        return noPlate;
    }

    public void setNoPlate(String noPlate) {
        this.noPlate = noPlate;
    }

    public CabType getType() {
        return type;
    }

    public void setType(CabType type) {
        this.type = type;
    }
    
}
