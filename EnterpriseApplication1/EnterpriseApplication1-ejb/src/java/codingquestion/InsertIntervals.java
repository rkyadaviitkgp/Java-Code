/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codingquestion;

import java.util.Stack;

/**
 *
 * @author rajeshkumar.yadav
 */
public class InsertIntervals {

    public boolean canMerge(int[] a, int[] b) {

        if (a[1] >= b[0]) {
            return true;
        }
        return false;
    }

    public int[] getMergedValue(int[] a, int[] b) {
        int[] a1 = new int[2];
        a1[0] = Math.min(a[0], b[0]);
        a1[1] = Math.max(a[1], b[1]);
        return a1;
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        int[][] arr = new int[0][0];
        Stack<Integer> st =  new Stack<Integer>();
        for(int i=0; i<intervals.length; i++){
            if(newInterval != null && canMerge(newInterval, intervals[i])){
                
                int[] mergedVal = new int[2];
                mergedVal = getMergedValue(intervals[i], mergedVal);
                
            }
        }
        
        return new int[1][1];

    }
    public static void main(String[] args) {
        InsertIntervals iobj = new InsertIntervals();
        int[][] a = new int[5][2];
         
    }

}
