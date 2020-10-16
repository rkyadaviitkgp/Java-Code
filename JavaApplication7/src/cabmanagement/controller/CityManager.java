/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabmanagement.controller;

import cabmanagement.model.Cab;
import cabmanagement.model.City;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author rajeshkumar.yadav
 */
public class CityManager {
    
    List<City> cityList;
    Hashtable<String, List<Cab>> cabHashTable;

    public CityManager() {
        cityList = new LinkedList<>();
        cabHashTable = new Hashtable<>();
    }
    
    //add anew city
    public boolean addNewCity(City c){
        cityList.add(c);
       return true; 
    }
    
     //Remove a bcity
    public boolean removeCity(String cityId){
       return true; 
    }
    
    //add a cab in cab list
    public boolean addCab(String cityId, Cab c){
        return true;
    }
    
    //remove a cab in cab list
    public boolean removeCab(String cityId, Cab c){
        return true;
    }
    
    //get City by Id
    public City getCity(String id)
    {
        for(City c : cityList){
            if(c.getId().equals(id))
                return c;
        }
        return null;
    }
    
    // change a cab city
    public boolean changeCabCity(Cab cab){
        
        return true;
    }
    
}
