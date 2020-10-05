/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicprogramming;
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
        int val = 0;
        try {
            val = br.read();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return (char) val;
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
}
