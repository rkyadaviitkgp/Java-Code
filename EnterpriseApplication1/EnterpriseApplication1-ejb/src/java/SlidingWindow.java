
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import javax.naming.ldap.StartTlsRequest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rajeshkumar.yadav
 */
public class SlidingWindow {
    
    private Queue<Integer> queue;
    List<Integer> dequeue;
    int size ;
     /** Initialize your data structure here. Set the size of the deque to be k. */
    public SlidingWindow(int k) {
        dequeue = new ArrayList<>();
        this.size = k;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        
        if(dequeue.size() == size)
            return false;
        dequeue.add(0, value);
        return true;
        
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        
        int sz = dequeue.size();
        
        if(sz == size)
            return false;
        
        dequeue.add(value);
        return true;
        
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        
        if(dequeue.size() == 0)
            return false;
        dequeue.remove(0);
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(dequeue.size() == 0)
            return false;
        dequeue.remove(dequeue.size()-1);
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if(!isEmpty())
            return dequeue.get(0);
        return -1;
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if(!isEmpty())
        return dequeue.get(dequeue.size()-1);
        return -1;
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        if(dequeue.size() == 0)
            return true;
        return false;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        if(dequeue.size() == size)
            return true;
        return false;
    }
    
    public SlidingWindow() {
        queue = new LinkedList<>();
    }
    
    public int ping(int t) {
        
        while(!queue.isEmpty() && queue.peek() < t - 3000){
            queue.poll();
        }
        queue.add(t);
        return queue.size();
        
    }
    
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        
//        int ans = 0;
//        int count = 0;
//        int max = 0;
//        int lastindex = 0;
        
//        for(int i=0; i<customers.length; i++){
//            
//            if(grumpy[i] == 1){
//                
//                if(count == X){
//                   
//                    while(lastindex < customers.length && grumpy[lastindex] != 1){
//                        ans =  ans - customers[lastindex];
//                        lastindex++;
//                    }
//                    ans =  ans - customers[lastindex];
//                    lastindex++;
//                    count--;
//                    
//                }   
//                count++;
//            }
//            ans = ans + customers[i];
//            if(max < ans)
//                max = ans;
//        }
//        
//        
//        return max;
        
        
        int ct=0, res=0, sum=0;
        for(int i=0;i<grumpy.length;i++) {
            if(grumpy[i]==0) res+=customers[i];
            else sum+=customers[i];
            if(i>=X&&grumpy[i-X]==1) sum-=customers[i-X];
            ct=Math.max(ct, sum);
        }
        return ct+res;
    }

    public int equalSubstring(String s, String t, int maxCost) {

        int ans = 0;
        int start = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {

            ans = ans + Math.abs(s.charAt(i) - t.charAt(i));
            if (ans > maxCost) {

                ans = ans - Math.abs(s.charAt(start) - t.charAt(start));
                start++;
            } else {
                max = Math.max(max, i - start + 1);
            }
        }
        return max;
    }
    
    public int getMinIndex(int arr[], int start, int end, int sum, int K){
        
//        if(sum < K)
//            return Integer.MAX_VALUE;
        
        if(start > end)
            return Integer.MAX_VALUE;
        
        if(start == end && sum >= K)
            return 1;
        
        int a = getMinIndex(arr, start+1, end, sum - arr[start], K);
        int b = getMinIndex(arr, start, end - 1, sum - arr[end], K);
        int c = Integer.MAX_VALUE;
        if(sum >= K)
            c = end - start + 1;
        return Math.min(c, Math.min(a, b));
            
    }
    
    public int shortestSubarray(int[] A, int K) {
        
        if(A.length == 0)
            return -1;
        int sum = 0;
        for(int i=0; i<A.length; i++)
        {
            if(A[i] >= K)
                return 1;
            sum = sum + A[i];
        }
        
        int minSubArray = Integer.MAX_VALUE;
        minSubArray = getMinIndex(A, 0, A.length-1, sum, K);
//        int start = 0;
//        //int end = 0;
//       
//        
//        
//        for(int i=0; i<A.length; i++){
//            
//            sum = sum + A[i];
//            
//            if(sum >= K){
//                
//                int temp = getMinIndex(A, start, i, sum, K);
//                if(temp < minSubArray)
//                    minSubArray = temp;
//                sum = sum - A[start];
//                start++;
//            }
//            
//            
//        }
        
        if(minSubArray == Integer.MAX_VALUE)
            return -1;
        
        return minSubArray;
        
    }

    public static void main(String[] args) {
        SlidingWindow sw = new SlidingWindow();
        int[] arr1 = {1,0,1,2,1,1,7,5};
        int[] arr2 = {0,1,0,1,0,1,0,1};
        
        System.out.println(sw.maxSatisfied(arr1, arr2, 3));
        /*
        
        [1,0,1,2,1,1,7,5]
[0,1,0,1,0,1,0,1]
3
        */
        
    }

}
