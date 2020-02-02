
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rajeshkumar.yadav
 */

class TimeInMinute implements Comparable<TimeInMinute>{
    
    int time;
    int type; // is it startb time or end time
    
    public TimeInMinute(int time, int t){
        this.time = time;
        type = t;
    }
    
    
  @Override
  public int compareTo(TimeInMinute u) {
    return time-u.time;
  }
    
    
}

class TimeInfo{
    
    int startTime; // time in minutes
    int endTime;   
    
    public TimeInfo(String[] time){
        
        startTime = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
        endTime = Integer.parseInt(time[2]) * 60 + Integer.parseInt(time[3]);
        
    }
    
    
} 

class CabService{
    
    String city1;
    String city2;
    TimeInfo[] city1ToCity2;
    TimeInfo[] city2ToCity1;
    int delay;
    
    public CabService(String c1, String c2, int delay, String[] c1c2, String[] c2c1){
        
        this.city1 = c1;
        this.city2 = c2;
        this.delay = delay;
        
        city1ToCity2 = new TimeInfo[c1c2.length];
        
        for(int i = 0; i<c1c2.length; i++){
            String[] time = c1c2[0].split("\\s+");
            city1ToCity2[i] = new TimeInfo(time);
        }
        
        city2ToCity1 = new TimeInfo[c2c1.length];
        
        for(int i = 0; i<c2c1.length; i++){
            String[] time = c2c1[0].split("\\s+");
            city2ToCity1[i] = new TimeInfo(time);
        }
        
        //Collections.sort(list, c);
        
    }
    
    public int getCount(TimeInfo[] start1, TimeInfo[] end2){
        
       
        List<TimeInMinute> tm = new ArrayList<>();
        
        for(int i=0; i<start1.length;i++)
        {
            TimeInMinute t = new TimeInMinute(start1[i].startTime, 1);
            tm.add(t);
        }
        for(int i=0; i<end2.length;i++)
        {
            TimeInMinute t = new TimeInMinute(end2[i].endTime, 0);
            tm.add(t);
        } 
        
        Collections.sort(tm);
        int count = 0;
        int max = 0;
        for(int i=0; i<tm.size(); i++)
        {
            if(tm.get(i).type == 1)
                count++;
            else 
                count--;
            if(max < count)
                max = count;
        }
        return max;
        
    }
    
    public int getNumberOfdriver(){
        
       return getCount(city1ToCity2, city2ToCity1);
        
        
    }
    
    
}

public class InterviewQuestions {
    
    
    
}
