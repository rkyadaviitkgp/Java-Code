/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liftmanagement;
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
        String val = "";
        try {
            val = br.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return 0;
        }
        return Integer.parseInt(val);
    }
    
    public char readChar() {
        String val = "0";
        try {
            val = br.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return (char) val.charAt(0);
    }
    
    public long readLong() {
        String val = "";
        try {
            val = br.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return Long.getLong(val);
    }
    
    public void readIntegerArray(int[] arr){
        String val = "";
        try {
            val = br.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        StringTokenizer st = new StringTokenizer(val, " ");
        int  i = 0;
        while(st.hasMoreElements()){
            arr[i++] =  Integer.parseInt(st.nextToken());
        }   
    }
    
    public void readStringArray(){
        String val = "";
        try {
            val = br.readLine();
            //System.out.println("Debug : " + val);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        st = new StringTokenizer(val, " ");
    }
    
    public boolean hasMoreString(){
        return st.hasMoreElements();
    }
    
    public String getNextString(){
        return st.nextToken();
    }
}
