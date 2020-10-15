/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabmanagement.controller;

import cabmanagement.model.Cab;
import cabmanagement.model.CabInfo;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author rajeshkumar.yadav
 */
public class CabManager {
    
    List<Cab> cabList;
    Hashtable<String, List<CabInfo>> cabInfoHashTable;

    public CabManager() {
        cabList = new LinkedList<>();
        cabInfoHashTable = new Hashtable<>();
    }
    
    //onborad a new cab
    public boolean registerCab(){
        return true;
    }
    
    //retire a existing cab 
    public boolean retireCab(String cabId){
        return false;
    }
    
    //add a new info
    public boolean addInfo(String cabId, CabInfo info){
        return true;
    }
    
}
