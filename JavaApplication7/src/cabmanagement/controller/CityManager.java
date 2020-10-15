/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabmanagement.controller;

import cabmanagement.model.Cab;
import cabmanagement.model.City;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

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
    public boolean addNewCity(){
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
    
}
