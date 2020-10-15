/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabmanagement.utility;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 *
 * @author rajeshkumar.yadav
 */
public class ReadInput {
    
    BufferedReader br;
    StringTokenizer st;
    public ReadInput(){
        br = new BufferedReader(new InputStreamReader(System.in));
    }
    
    public int readInteger() {
        String val = readString();
        return Integer.parseInt(val);
    }
    
    public char readChar() {
        String val = readString();
        if(val.length() > 0)
        return val.charAt(0);
        else
            return '0';
    }
    
    public long readLong() {
        String val = readString();
        return Long.getLong(val);
    }
    
    public String readString(){
        String val = "";
        try {
            val = br.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return val;
    }
    
    public void readIntegerArray(int[] arr){
        String val = readString();
        StringTokenizer st = new StringTokenizer(val, " ");
        int  i = 0;
        while(st.hasMoreElements()){
            arr[i++] =  Integer.parseInt(st.nextToken());
        }   
    }
    
    public void readStringArray(){
        String val = readString();
        st = new StringTokenizer(val, " ");
    }
    
    public boolean hasMoreString(){
        return st.hasMoreElements();
    }
    
    public String getNextString(){
        return st.nextToken();
    }
}
