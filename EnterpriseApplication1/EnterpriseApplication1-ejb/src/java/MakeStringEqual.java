/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rajeshkumar.yadav
 */
public class MakeStringEqual {
    
//    public int minimumSwap(String s1, String s2) {
//        
//        
//        
//    }
    public boolean checkCondition(int[] A, int[] B, int index){
        
        int len = A.length;
        
        if(index-1 >= 0){
            if(A[index-1] > A[index] || B[index-1] > B[index])
                return false;
        }
        
        if(index+1 < len){
            if(A[index] > A[index+1] || B[index] > B[index+1])
                return false;
        }
        
        return true;
    }
    
    public void swapValue(int[] A, int[] B, int index){
        int v = A[index];
        A[index] = B[index];
        B[index] = v;
    }
    
    public int minSwapUtil(int[] A, int[] B, int index){
        
        if(index == A.length)
            return 0;
        
        //without swap 
        int val1 = Integer.MAX_VALUE, val2 = Integer.MAX_VALUE;
        if(checkCondition(A, B, index) == true)
            val1 = minSwapUtil(A, B, index+1);
        
        //With Swap 
        swapValue(A, B, index);
        if(checkCondition(A, B, index) ==  true)
        {
            val2 = minSwapUtil(A, B, index+1);
            if(val2 < Integer.MAX_VALUE)
                val2 = val2 + 1;
        }
        
        return val1 > val2 ? val2:val1;
    }
    
    public int minSwap(int[] A, int[] B) {
        
        if(A.length == 0 || A.length == 1)
            return 0;
        int[] dynProg = new int[A.length];
        for(int i=0; i<A.length; i++)
        {
            dynProg[i] = Integer.MAX_VALUE;
        }
        
        int val = minSwapUtil(A,B,0);
        
        return val;
    }
    public int maximumSwap(int num) {
        
        StringBuilder s = new StringBuilder(Integer.toString(num));
        int flag = 0;
        for(int i=0; i<s.length();i++){
            int ind = i;
            for(int j=i+1; j<s.length(); j++)
            {
                if(s.charAt(j) >= s.charAt(ind) ){
                    ind = j;
                    //System.err.println("hi");
                }
            }
            if(s.charAt(ind) > s.charAt(i))
            {
                char c = s.charAt(i);
                //System.err.println(" "  + i + " " + ind);
                s.setCharAt(i, s.charAt(ind));
                s.setCharAt(ind, c);
                //System.err.println(" ans " + s);
                return Integer.parseInt(s.toString());
            }
        }
        
        return num;
       
    }
    public static void main(String args[]){
        MakeStringEqual ms = new MakeStringEqual();
        System.err.println(" r " + ms.maximumSwap(98368));
    }
}

