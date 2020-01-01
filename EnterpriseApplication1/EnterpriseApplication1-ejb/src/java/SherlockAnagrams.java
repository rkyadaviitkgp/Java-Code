
import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rajeshkumar.yadav
 */


public class SherlockAnagrams {
    
    String input;
    
    public SherlockAnagrams(String in){
        input = in;
    }
    
    public void fillCharCount(String a, int[] arr){
        for(int i=0; i<a.length(); i++){
            arr[a.charAt(i) - 'a']++; // assuming input sting contains only lower case 
        }
    }
    
    public boolean checkCharCount(int [] arra, int[] arrb)
    {
        for(int i=0; i<26; i++)
        {
            if(arra[i] != arrb[i])
                return false;
        }
        return true;
    }
    
    public boolean isStringConatinsSameChar(String a, String b){
        
        int[] arra = new int[26];
        int[] arrb = new int[26];
        
        for(int i=0; i<26; i++)
        {
            arra[i] = arrb[i] = 0;
        }
        
        fillCharCount(a, arra);
        fillCharCount(b, arrb);
        boolean v = checkCharCount(arra, arrb);
        return v;
    }
    
    public List<Pair<String, String>> getSherlockAnagramsPairs(){
        
        List<Pair<String, String>> ans = new ArrayList<>();
        
        for(int i=0; i<input.length(); i++){
            int len = 1;
            while(i+len <= input.length()){
                
                for(int j=i+1; j+len<=input.length(); j++)
                {
                    String a = input.substring(i, i+len);
                    String b = input.substring(j, j+len);
                    //System.out.println(a+" "+b);
                    boolean r = isStringConatinsSameChar(a,b);
                    if(r)
                    {
                        Pair<String, String> p = new Pair(a, b);
                        ans.add(p);
                    }
                }
                len++;
            }
        }
        return ans;
    }
    
    public void printAns(List<Pair<String, String>> l){
        System.out.println("SherlockAnagrams.printAns() 1 ");
        for(int i=0; i<l.size(); i++)
        {
            System.out.println(l.get(i).getKey() + " " + l.get(i).getValue());
        }
        
    }
    
    public static void main(String args[]){
        
        SherlockAnagrams sn = new SherlockAnagrams("cdcd");
        List<Pair<String, String>> l = sn.getSherlockAnagramsPairs();
        sn.printAns(l);
    }
    
}
