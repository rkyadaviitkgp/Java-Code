/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yearwise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;
import static yearwise.MyThread.len;

/**
 *
 * @author rajeshkumar.yadav
 */

public class JuneWeek23 {
    
    public static void main(String[] args) {
        int arr[] = {-8,3,-5,-4,5};
        UtilClass ob = new UtilClass();
        System.out.println(ob.scoreOfParentheses("((()()())(())())"));
//        MyRunnable mr1 = new MyRunnable(10);
//        MyRunnable mr2 = new MyRunnable(10);
//        Thread mt1 = new Thread(mr1);
//        Thread mt2 = new Thread(mr2);
//        mt1.start();
//        mt2.start();
//        
//        try{
//            mt1.join();
//            mt2.join();
//        }catch(InterruptedException ie){
//            System.out.println(ie.getMessage());
//        }
//        System.out.println("Last line");
//        Printer p = new Printer("one");
//        ThreadSynchronization ts1 = new ThreadSynchronization("str1", p);
//        ThreadSynchronization ts2 = new ThreadSynchronization("str2", p);
//        ThreadSynchronization ts3 = new ThreadSynchronization("str3", p);
//        
//        ts1.start();
//        ts2.start();
//        ts3.start();
//        
    }
}

class Printer {
    String str;
    public Printer(String str){
        this.str = str;
    }
     public void  printString(String str){
        System.out.print(" ( " + str);
        Thread t = Thread.currentThread();
        try{
            t.sleep(10);
        }catch(InterruptedException ie){
            System.out.println(ie.getMessage());
        }
        System.out.println(" ) ");
    }
}

class ThreadSynchronization extends Thread{
    String str;
    Printer ptr;
    public ThreadSynchronization(String s, Printer p){
        str = s;
        ptr = p;
    }
    
    public void run(){
        synchronized(ptr ){
            ptr.printString(str);
        }
        
    }
}

class MyRunnable implements Runnable{
    
    int sleepTime;
    
    public MyRunnable(int val){
        sleepTime = val;
    }
    
    public void run(){
        Thread t = Thread.currentThread();
        try{
            for(int i=0; i<len; i++){
            System.out.println( " Name =  " + t.getName() + "  Value of i = " + i);
            t.sleep(sleepTime);
        }
        }catch(InterruptedException ie){
            System.out.print(ie.getMessage());
        }
    }
}

class MyThread extends Thread{
    
    public static final int len = 5;  
    int sleepTime;
    public MyThread(String name, int sleepTime){
        super(name);
        this.sleepTime = sleepTime;
    }
    
    public void run(){
        
        Thread t = Thread.currentThread();
        try{
            for(int i=0; i<len; i++){
            System.out.println(t.getName() + " " + i);
            sleep(sleepTime);
        }
        }catch(InterruptedException ie){
            System.out.print(ie.getMessage());
        }
        
        
    }
    
}

class RandomizedCollection {

    /** Initialize your data structure here. */
    static final int collectionSize = 100000;
    int collection[];
    int size;
    Random random;
    HashMap<Integer, LinkedList<Integer>> indicesHashMap;
    
    public RandomizedCollection() {
        collection = new int[collectionSize];
        size = -1;
        indicesHashMap = new HashMap<>();
        random = new Random();
    }
    
    private void printCollection(String fun){
        System.out.println(fun);
        for (Map.Entry<Integer, LinkedList<Integer>> entry : indicesHashMap.entrySet()) {
            Integer key = entry.getKey();
            LinkedList<Integer> value = entry.getValue();
            System.out.println(key + " " + value.toString());
        }
        for(int i=0; i<=size; i++)
        {
            System.out.print(" " + collection[i]);
        }
        System.out.println(" ");
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean ans = true;
        collection[++size] = val;
        if(indicesHashMap.containsKey(val))
        {
            ans = false;
            indicesHashMap.get(val).push(size);
        }else{
            LinkedList<Integer> st = new LinkedList<>();
            st.push(size);
            indicesHashMap.put(val, st);
        }
        printCollection("insert");
        return ans;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        
        if(!indicesHashMap.containsKey(val))
            return false;
        LinkedList<Integer> st = indicesHashMap.get(val);
        int ind = st.pop();
        if(ind != size)
        {
            int lastVal = collection[size];
            LinkedList<Integer> l = indicesHashMap.get(lastVal);
            for(int i = 0; i<l.size(); i++)
            {
                if(l.get(i) == size)
                {
                    l.remove(i);
                }
            }
            indicesHashMap.get(lastVal).push(ind);
            collection[ind] = lastVal;
        }
        size--;
        if(st.isEmpty())
            indicesHashMap.remove(val);
        printCollection("Remove");
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        int ind = random.nextInt(size+1);
        return collection[ind];
    }
}



class BrowserHistory {

    String urlHistory[];
    int currentLocation;
    int size;
    public static final int length = 5000;

    public BrowserHistory(String homepage) {
        urlHistory = new String[length];
        currentLocation = 0;
        urlHistory[currentLocation] = homepage;
        size = currentLocation + 1;
    }

    public void printBrowserHistory(String fun, String arg) {
        System.out.println(fun + " " + arg);
        System.out.println("curlocation " + currentLocation);
        System.out.println("size " + size);
        for (int i = 0; i < size; i++) {
            System.out.print(urlHistory[i] + " ");
        }
        System.out.println();
        System.out.println("----");
    }

    public void visit(String url) {
        urlHistory[++currentLocation] = url;
        size = currentLocation + 1;
        //printBrowserHistory("visit", url);
    }

    public String back(int steps) {
        if (currentLocation - steps < 0) {
            currentLocation = 0;
        } else {
            currentLocation = currentLocation - steps;
        }
        //size = currentLocation + 1;
        //printBrowserHistory("back", steps+"");
        return urlHistory[currentLocation];
    }

    public String forward(int steps) {
        if (currentLocation + steps >= size) {
            currentLocation = size - 1;
        } else {
            currentLocation = currentLocation + steps;
        }
        //size = currentLocation + 1;
        //printBrowserHistory("forward", steps+"");
        return urlHistory[currentLocation];
    }
}

class UtilClass {
    
    
    
    
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            int val = 1;
            if(hm.containsKey(arr[i])){
                val = val + hm.get(arr[i]);
            }
            hm.put(arr[i], val);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1,o2) -> hm.get(o1) - hm.get(o2));
        for(int i : hm.keySet()){
            pq.add(i);
        }
        while(k > 0){
            int val = 0;
            if(!pq.isEmpty()){
                val = pq.poll();
            }else{
                break;
            }
            if(k >= hm.get(val))
                k = k - hm.get(val);
            else
                k = 0;
        }
        return pq.size();
    }
    
    public List<Integer> largestDivisibleSubset(int[] nums) {
        
        Arrays.sort(nums);
        List<Integer> list; // = new ArrayList<Integer>();
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            int count = 0;
            for(int j = i-1; j>=0; j--){
                if(hm.containsKey(nums[j])){
                    list = hm.get(nums[j]);
                    if(nums[i]%list.get(list.size()-1) == 0)
                    {
                        list.add(nums[i]);
                        count++;
                    }
                }
            }
            if(count == 0){
                list = new ArrayList<>();
                list.add(nums[i]);
                hm.put(nums[i], list);
            }
        }
        int max = 0;
        int ind = 0;
        for(int i=0; i<nums.length; i++){
            if(hm.containsKey(nums[i]))
            {
                if(max == 0 || hm.get(nums[ind]).size() < hm.get(nums[i]).size())
                {
                    ind = i;
                    max =  hm.get(nums[i]).size();
                }
            }
        }
        if(hm.containsKey(nums[ind]))
            list = hm.get(nums[ind]);
        else
            list = null;
        return list;
    }
     
    public List<Integer> findDuplicates(int[] nums) {
        
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<nums.length; i++){
            int val = nums[i];
            if(val < 0)
                val  = val * -1;
            if(nums[val - 1] < 0){
                list.add(val);
            }else{
                nums[val - 1] = -nums[val  - 1];
            }
        }
        return list;
    }
    
    public int scoreOfParentheses(String s) {

        Stack<String> st = new Stack();
        for (int i = 0; i < s.length(); i++) {
            String newstr = s.substring(i, i + 1);
            System.out.println(newstr);
            if (newstr.equalsIgnoreCase("(")) {
                st.push(newstr);
            } else {
                int val = 0;
                if (st.peek().equalsIgnoreCase("(")) {
                    val = 1;
                    st.pop();
                    while (!st.isEmpty() && !st.peek().equalsIgnoreCase("(")) {
                        int num = Integer.parseInt(st.pop());
                        val = val + num;
                    }
                    st.push(val + "");
                } else {
                    val = 0;
                    while(!st.isEmpty() && !st.peek().equalsIgnoreCase("("))
                    {
                        val =  Integer.parseInt(st.pop()) + val;
                        
                    }
                    
                    st.pop();
                    val = val * 2;
                    st.push(val + "");
                }

            }
        }
        if(st.isEmpty())
            return 0;
        return Integer.parseInt(st.pop());
    }
    
    public int calPoints(String[] ops) {
        Stack<Integer> st = new Stack();
        int sum = 0;
        
        for(int i=0; i<ops.length; i++){
            if(ops[i].equalsIgnoreCase("c")){
                int val = st.pop();
                sum = sum - val;
            }else if(ops[i].equalsIgnoreCase("d")){
                int val = st.peek();
                val = val * 2;
                st.push(val);
                sum = sum + val;
            }else if(ops[i].equalsIgnoreCase("+")){
                int a = st.pop();
                int b = st.pop();
                st.push(b);
                st.push(a);
                st.push(a+b);
                sum = sum + a + b;
            }else{
                int  val = Integer.parseInt(ops[i]);
                st.push(val);
                sum = sum + val;
            }
        }
        return sum;
    }
    
    
    private int binarySearch1(int arr[], int start, int end, int val){
        
        if(start > end)
            return start;
        
        int mid = start + (end-start)/2;
        
        if(arr[mid] == val)
            return mid;
        
        if(mid+1 <= end && val > arr[mid] && val < arr[mid+1])
            return mid+1;
        if(mid-1 >= start && arr[mid] > val && arr[mid-1] < val)
            return mid;
        
        if(arr[mid] > val)
            return binarySearch1(arr, start, mid-1, val);
        return binarySearch1(arr, mid+1, end, val);
        
    }
    
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int excessGas = 0;
        int excessCost = 0;
        int start = 0;
        for(int i=0; i<gas.length; i++){
            if(excessGas == 0)
                start = i;
            excessGas = excessGas + gas[i] - cost[i];
            if(excessGas < 0)
            {
                excessCost = excessCost + excessGas;
                excessGas = 0;
            }
        }
        if(excessCost + excessGas >= 0)
            return start;
        return -1;
    }
    
    public int searchInsert(int[] nums, int target) {
        //return binarySearch(nums, 0, nums.length-1, target);
        return Arrays.binarySearch(nums, target);
    }
    
    public int maxSubarraySumCircular(int[] arr) {
        if(arr.length == 0)
            return Integer.MIN_VALUE;
        int max = arr[0];
        int sum = 0, i, start = 0;
        for(i=0; (i + 1) % arr.length != start; i++){
            if(sum == 0)
                start = i%arr.length;
            sum = sum + arr[(i)%arr.length];
            if(sum > max)
                max = sum;
            if(sum <= 0){
                sum = 0;
                start = (i) % arr.length;
                if( i > arr.length)
                    break;
            }
        }
        return max;
    }
    
    public boolean isSubsequence(String s, String t, int ind1, int ind2, int[][] dyn){
        
        if(ind1 >= s.length())
            return true;
        if(ind2 >= t.length())
            return false;
        if(dyn[ind1][ind2] != -1){
            return dyn[ind1][ind2] == 1;
        }
        boolean b = false;
        for(int i=ind2; i<t.length(); i++)
        {
            if(s.charAt(ind1) == t.charAt(i))
            b = isSubsequence(s,t,ind1+1, i+1, dyn);
            if(b == true)
                break;
        }
        if(b == true)
            dyn[ind1][ind2] = 1;
        else
             dyn[ind1][ind2] = 0;
        return b;
    }
    
    public boolean isSubsequence(String s, String t) {
        if(s.length() > t.length())
            return false;
        int[][] dyn = new int[s.length()][t.length()];
        for(int i=0; i<s.length(); i++)
            Arrays.fill(dyn, -1);
        return isSubsequence(s,t,0,0, dyn);
    }
    
    public boolean isPredecessor(String str1, String str2){
        
        if(str2.length() + 1 != str1.length())
            return false;
        int count = 0;
        int ind1 = 0;
        int ind2 = 0;
        while(ind1 < str1.length() && ind2 < str2.length()){
            if(str1.charAt(ind1) == str2.charAt(ind2)){
                ind1++;
                ind2++;
            }else{
                ind1++;
                count++;
                if(count>1)
                    return false;
            }
        }
        return true;
    }
    
    public int longestStrChain(String[] words) {
        
        int length = words.length;
        int len[] = new int[length];
        Arrays.sort(words, (a,b) -> a.length() - b.length());
        len[0] = 1;
        
        for(int i = 1; i<words.length; i++){
            int max = 1;
            for(int j = i-1; j>=0; j--){
                if(isPredecessor(words[i], words[j]))
                {
                    if(max < len[j] + 1)
                        max = len[j] + 1;
                }
            }
            len[i] = max;
            System.out.print(" " + len[i]);
        }
        return len[length-1];
    }
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] matrix = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i=0; i<row; i++)
            matrix[i][0] = 1;
        for(int i=0; i<col; i++)
            matrix[0][i] = 1;
        for(int i=1; i<row; i++)
            for(int j=1; j<col; j++){
                if(obstacleGrid[i][j] == 1)
                    continue;
                matrix[i][j] = obstacleGrid[i-1][j] == 1 ? 0 : matrix[i-1][j] + obstacleGrid[i][j-1] == 1 ? 0 : matrix[i][j-1];
            }
        return matrix[row][col];
    }

    public int changeUtil(int amount, int[] coins, int ans[], int index, int[] dyn) {

        if (amount < 0) {
            return 0;
        }
        
        if (amount == 0) {
            //ans[0]++;
            return 1;
        }
        
        if (dyn[amount] != -1) {
            return dyn[amount];
        }
        
        int res = 0;

        for (int i = index; i < coins.length; i++) {
            if(changeUtil(amount - coins[i], coins, ans, i, dyn) != 0)
                res = res + 1;
        }
        
        dyn[amount] = res;
        return res;
    }

    public int change(int amount, int[] coins) {

        Arrays.sort(coins);
        int[] ans = new int[1];
        int[] dyn = new int[amount + 1];
        Arrays.fill(dyn, -1);
        changeUtil(amount, coins, ans, 0, dyn);
        return dyn[amount];
    }

}
