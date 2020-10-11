/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabmanagement.model;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 *
 * @author rajeshkumar.yadav
 */
public class CabsHistory {
    
    Hashtable<String, List<CabInfo>> cabsHistory;

    public CabsHistory() {
        cabsHistory = new Hashtable<>();
    }
    
    public List<CabInfo> getCabHistory(String id){
        if(cabsHistory.get(id) == null)
        {
            System.err.println("Id not found");
            return null;
        }
        return cabsHistory.get(id);
    }
    
    public void addHistory(String id, CabInfo cab){
        if(cabsHistory.get(id) != null)
        {
            cabsHistory.get(id).add(cab);
        }else{
            List<CabInfo> l = new ArrayList<>();
            l.add(cab);
            cabsHistory.put(id, l);
        }
    }
    
    
}
