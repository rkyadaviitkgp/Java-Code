/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabmanagement.model;

import cabmanagement.utility.UniqueIdGenerator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author rajeshkumar.yadav
 */
public class Cab {
    
    String id;
    String noPlate;
    CabType type;

    public Cab(String noPlate, CabType type) {
        id = "cab" + UniqueIdGenerator.generateUniqueId();
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
