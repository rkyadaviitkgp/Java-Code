/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RideSharingApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author rajeshkumar.yadav
 */

public class ScheduleRide {
    
    Map<String, List<Ride>> availableOfferedRide;
    
    private static ScheduleRide scheduleRideObject = null;
    
    private ScheduleRide()
    {
        availableOfferedRide =  new HashMap<String, List<Ride>>();
    }
    
    public static ScheduleRide getScheduleRideObject()
    {
        if(scheduleRideObject == null)
        {
            scheduleRideObject = new ScheduleRide();
            return scheduleRideObject;
        }
        return  scheduleRideObject;
    }
            
    public boolean addRide(Ride r, Driver d){
        
        String keyOfRide = r.getSource().toString() + r.getDestination().toString();
        r.setOfferedby(d);
        List<Ride> l = availableOfferedRide.get(keyOfRide);
        if( l != null)
        {
            l.add(r);
            return true;
        }
        
        l = new ArrayList<Ride>();
        l.add(r);
        availableOfferedRide.put(keyOfRide, l);
        return true;
        
    }
    
    private String returnListAsString(List<Ride> list)
    {
        String s = "";
        for(Ride r : list)
        {
            String tmp = r.getSource().toString() + r.getDestination().toString() + r.getSeat() + r.getOfferedby().getName();
            s = s + " <--> " + tmp;
        }
        return s.substring(4);
    }
    
    public void printListOfAvailableRide(){
        for(Map.Entry entry : availableOfferedRide.entrySet())
        {
            System.out.println("Key : " + entry.getKey() + " List  : " +  returnListAsString((List<Ride>)entry.getValue()));
        }
    }
    
    private int getMostMatchingRide(int noOfSeat, List<Ride> list){
        
        int ind = -1;
        int wastage = 0;
        for(int i=0; i<list.size(); i++)
        {
            if(noOfSeat == list.get(i).getSeat())
            {
                return i;
            }
            else if(noOfSeat < list.get(i).getSeat())
            {
                if(ind == -1)
                {
                    ind = i;
                    wastage = list.get(i).getSeat() - noOfSeat;
                }else if(wastage > list.get(i).getSeat() - noOfSeat)
                {
                    ind = i;
                    wastage = list.get(i).getSeat() - noOfSeat;
                }
            }
        }
        return  ind;
        
    }
    
    public Ride fullfillRequest(StopName source, StopName destination, int noOfSeat, Passenger p){
        
        String keyOfRide = source.toString() + destination.toString();
        List<Ride> l = availableOfferedRide.get(keyOfRide);
        
        if(l != null)
        {
            int ind = getMostMatchingRide(noOfSeat, l);
            if(ind != -1)
            {
                Ride r = l.get(ind);
                r.setAllotedTo(p);
                l.remove(ind);
                return r;
            }
        }
            
        System.out.println(" Could not find driver ");
        return null;
    }
    
    
}
