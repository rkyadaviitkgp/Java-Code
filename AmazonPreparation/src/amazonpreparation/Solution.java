/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amazonpreparation;

// you can also use imports, for example:

import java.util.ArrayList;
import java.util.List;

// import java.util.*;

public class Solution {
    
    //list is conating 0 and 1
    //output : print the sorted list
    //output1 : 
    public void sortList(List<Integer> list){
        //insertion sort nlog(n) where n is length of list
        // count no of zero and put that many zero
        // keep two index and keepon advancing 1st index and reducing last idex unless 1stindex <lastindex 
        if(list.size() == 0)
            return;
        int startIndex = 0;
        int endIndex = list.size()-1;
        
        while(startIndex < endIndex){
            
            while(startIndex < list.size() && list.get(startIndex) == 0){
                startIndex++;
            }
            
            while(endIndex >= 0 && list.get(endIndex) == 1){
                endIndex--;
            }
            
            if(startIndex < endIndex){
                list.add(startIndex, 0);
                list.add(endIndex, 1);
                startIndex++;
                endIndex--;
            }
            
        }
    }
    
    
    public void printBalancedParanthesisUtil(char list[], int open, int close, int index, int n){
        
        //base condition
        if( index == 2*n )
        {
            for(int i=0; i<2*n; i++)
            {
                System.out.print(list[i] + " ");
            }
            System.out.println();
            return;
        }
        
        if(open == close || (open > close && open < n)){
            list[index] = '(';
            printBalancedParanthesisUtil(list, open+1, close, index+1, n);
        }
        
        if(open == n || open > close){
              list[index] = ')';
            printBalancedParanthesisUtil(list, open, close+1, index+1, n);
        }
        
        
    } 
    
    public void printBalancedParanthesis(int n){
        
        int openCount = n;
        int closeCount = n;
        char list[] = new char[2*n];
        printBalancedParanthesisUtil(list, 0, 0, 0, n);
        
    }

    public static void main(String [] args) {
        // you can write to stdout for debugging purposes, e.g.
       //System.out.println("This is a debug message");
       //array is given and its 0 and 1
       Solution sol = new Solution();
       sol.printBalancedParanthesis(3);
    }
}
