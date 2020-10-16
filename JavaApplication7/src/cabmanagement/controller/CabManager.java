/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabmanagement.controller;

import cabmanagement.model.Cab;
import cabmanagement.model.CabInfo;
import cabmanagement.model.CabStatus;
import java.util.Date;
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
    
    //get cab history
    public List<CabInfo> getCabHistory(String cabId)
    {
        List<CabInfo> cInfoList = cabInfoHashTable.get(cabId);
        return cInfoList;
    }
    
    //onborad a new cab
    public boolean registerCab(Cab c){
        cabList.add(c);
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
    
    //get idle time of a cab 
    public long getIdleTime(String cabId){
        
        List<CabInfo> l = getCabHistory(cabId);
        CabInfo cinfo = l.get(l.size()-1);
        if(cinfo.getCabStatus() != CabStatus.IDLE){
            System.out.println("Cab Is " + cinfo.getCabStatus());
            return 0;
        }
        Date d = new Date();
        return  d.getTime() - cinfo.getTime().getTime();
        
    }
    
}
