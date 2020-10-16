/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabmanagement.model;

import java.util.List;

/**
 *
 * @author rajeshkumar.yadav
 */
public class City {
    
    String Name;
    String id;
    String state;

    public City(String Name, String id, String state) {
        this.Name = Name;
        this.id = id;
        this.state = state;
    }

    @Override
    public String toString() {
        return "City{" + "Name=" + Name + ", id=" + id + ", state=" + state + '}';
    }
    
    

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
