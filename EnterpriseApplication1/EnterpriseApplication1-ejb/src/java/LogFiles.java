
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rajeshkumar.yadav
 */
public class LogFiles {
    
    private boolean isDigitLog(String logLine){
        StringTokenizer st = new StringTokenizer(logLine," ");
        st.nextToken();
        try {
            Integer.parseInt(st.nextToken());
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    private void swapLog(String[] logs, int i, int j){
        String temp = logs[j];
        logs[j] = logs[i];
        logs[i] = temp;
    } 
    
    public String[] reorderLogFiles(String[] logs) {
        
        int j = logs.length-1;
        int i = logs.length-1;
        while(i>=0){
            if(isDigitLog(logs[i])){
                swapLog(logs, i, j);
                j--;
            }
            i--;
        }
        Arrays.sort(logs,0, j+1, new Comparator<String>(){ 
  
            @Override
            public int compare(String s1, String s2) 
            { 
                int ind1 = s1.indexOf(' ');
                int ind2 = s2.indexOf(' ');
                String s1Identifier = s1.substring(0, ind1);
                String s1Terminal = s1.substring(ind1);
                String s2Identifier = s2.substring(0, ind2);
                String s2Terminal = s2.substring(ind2);
                if(s1Terminal.equalsIgnoreCase(s2Terminal))
                    return s1Identifier.compareToIgnoreCase(s2Identifier);
                else
                    return s1Terminal.compareToIgnoreCase(s2Terminal);
              
            } 
        }); 
        return logs;
    }

}
