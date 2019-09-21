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
        a[0] = Math.min(a[0], b[0]);
        a[1] = Math.max(a[1], b[1]);
        return a;
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {

        Stack<int[]> st = new Stack<>();

        if (intervals.length > 0) {
            st.push(intervals[0]);
        }
        int flag = 0;
        int i = 1;
        for (; i < intervals.length ; i++) {
            int[] a = st.peek();
            if(newInterval == a)
                newInterval = intervals[i];
            if (canMerge(a, newInterval)) {
                st.pop();
                newInterval = getMergedValue(a, newInterval);
                while(!st.isEmpty() && canMerge(st.peek(), newInterval))
                {
                    a = st.pop();
                    newInterval = getMergedValue(a, newInterval);
                }
                st.push(newInterval);
                //newInterval = null;
            } else {
                st.push(intervals[i]);
            }
        }

//        if (st.isEmpty()) {
//            st.push(newInterval);
//            for (; i < intervals.length; i++) {
//                int[] a = st.peek();
//
//                if (canMerge(a, intervals[i])) {
//                    st.pop();
//                    a = getMergedValue(a, intervals[i]);
//                    st.push(a);
//                } else {
//                    st.push(intervals[i]);
//                }
//            }
//        }
        int[][] r = new int[st.size()][2];
        int len = st.size() - 1;
        for ( i = len; i >= 0; i--) {
            r[i] = st.pop();
        }
        return r;
    }
    public static void main(String[] args) {
        InsertIntervals iobj = new InsertIntervals();
        int[][] a = new int[5][2];
         
    }

}
