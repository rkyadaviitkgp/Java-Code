/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yearwise;

import com.sun.beans.editors.IntegerEditor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import javax.swing.tree.TreeNode;

class MyStack{
    
    public void pushAtBottom(Stack<Integer> st, int val){
        if(st.isEmpty()){
            st.push(val);
            return;
        }
        int v = st.pop();
        pushAtBottom(st, val);
        st.push(v);
    }
    
    public void reverseStack(Stack<Integer> st){
        if(st.isEmpty())
            return;
        int val = st.pop();
        reverseStack(st);
        pushAtBottom(st, val);
    }
    
    public void printArray(int[] arr){
        System.out.println("Content of array");
        for(int i : arr)
            System.out.print(i + " ");
        System.out.println();
    } 
    
    public void findSpan(int[] arr){
        
        Stack<Integer> st = new Stack<Integer>();
        int[] span = new int[arr.length];
        int length = arr.length;
        st.push(0);
        span[0] = 1;
        for(int i = 1; i<length; i++){
            
            while(!st.isEmpty() && arr[st.peek()] < arr[i])
                st.pop();
            if(st.isEmpty())
                span[i] = i + 1;
            else
                span[i] = i - st.peek();
            st.push(i);
        }
        printArray(span);
    }
    
    public void findMaxRectangle(int[] arr){
        
        Stack<Integer> st = new Stack<Integer>();
        int[] span = new int[arr.length];
        int length = arr.length;
        st.push(0);
        int max = arr[0];
        span[0] = 1;
        for(int i = 1; i<length; i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i])
                st.pop();
            if(st.isEmpty())
               span[i] = (i + 1) ;
            else
               span[i] =  (i - st.peek() ) ;
            st.push(i);
        }
        int size = st.size();
        while(!st.isEmpty()){
            span[st.peek()] = span[st.peek()] + arr.length - 1 - st.peek();
            st.pop();
        }
        printArray(span);
    }
}

class Solution {

    public NestedInteger deserialize(String s) {

        Stack<Object> stack = new Stack<>();
        String str = "";
        for (char c : s.toCharArray()) {
            if (c == '[') {
                stack.push((Object) "[");
            } else if (c == ']') {
                NestedInteger netedInteger = new NestedInteger();
                while (!stack.isEmpty()) {
                    Object ni = stack.pop();
                    if (!ni.toString().equals("[")) {
                        if (ni instanceof NestedInteger) {
                            netedInteger.add((NestedInteger) ni);
                        } else {
                            netedInteger.setInteger(Integer.parseInt((String) ni));
                        }
                    } else {
                        stack.push(netedInteger);
                        break;
                    }
                }
            } else if (c == ',') {
                stack.push((Object) str);
                str = "";
            } else {
                str = str + c;
            }
            System.out.println(stack);
        }
        if (!str.isEmpty()) {
            return new NestedInteger(Integer.parseInt(str));
        }
        return (NestedInteger) stack.pop();
    }
}

/**
 *
 * @author rajeshkumar.yadav
 */
public class MayWeek20 {

    public static void main(String[] args) {
        MayWeek20 sol = new MayWeek20();
        int[][] arr = {{0, 1}, {0, 2}, {1, 2}};
        int[] arr1 = {3,-2};
        int[] arr2 = {2, -6, 7};
//        MyStack ms = new MyStack();
//        ms.findMaxRectangle(arr1);
        sol.maxDotProduct(arr1, arr2);
        //System.out.println(sol.countSubstrings("aabaa"));
        //System.out.println(sol.isLongPressedName("leelee", "lleeelee"));
        //sol.puzzle();
    }
    
//    class Pair{
//        int x;
//        int y;
//        public Pair(int x, int y){
//            this.x = x;
//            this.y = y;
//        }
//    }
    
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    
   public int maxDotProductUtil(int[] nums1, int[] nums2, int index1, int index2, int val) {
        
        int v = Math.min(nums1.length, nums2.length);
        int a,b,c;      
        if(index1 >= v || index2 >= v)
        {
            return val;
        }
        a = maxDotProductUtil(nums1, nums2, index1+1, index2+1, val  +  nums1[index1] * nums2[index2]);
        b = maxDotProductUtil(nums1, nums2, index1+1, index2, val);
        c = maxDotProductUtil(nums1, nums2, index1, index2+1, val);
        if(a > b)
        {
            if(a > c)
                return a;
            return c;
        }else{
            if(b > c)
                return b;
            return c;
        }
    }
    
    public int maxDotProduct(int[] nums1, int[] nums2) {
        
        return maxDotProductUtil(nums1, nums2, 0, 0, 0);
        
    }
    
    public int pseudoPalindromicPathsUtil(TreeNode root, int arr[], int count){
        
        if(root == null){
            if(count <= 1)
                return 1;
            return 0;
        }
        
        if(arr[root.val]%2 == 0){
            count++;
        }else{
            count--;
        }
        arr[root.val]++;
        
        int a = pseudoPalindromicPathsUtil(root.left, arr, count);
        int b = pseudoPalindromicPathsUtil(root.right, arr, count);
        
        if(arr[root.val]%2 == 0){
            count++;
        }else{
            count--;
        }
        arr[root.val]--;
        
        return (a + b)/2;
        
    }
    
    public int pseudoPalindromicPaths (TreeNode root) {
        
        if(root == null)
            return 0;
        
        int arr[] = new int[10];
        int count = 0;
        return pseudoPalindromicPathsUtil(root, arr, 0);
        
    }
    
    public int maxVowels(String s, int k) {
        
        int count = 0;
        int max = 0;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u'){
                count++;
            }
            if(i>=k)
            {
                if(s.charAt(i-k) == 'a' || s.charAt(i-k) == 'e' || s.charAt(i-k) == 'i' || s.charAt(i-k) == 'o' || s.charAt(i-k) == 'u'){
                count--;
            }
            }
            if(max < count)
                max = count;
        }
        return Math.max(count, max);
    }
    
    public int isPrefixOfWord(String sentence, String searchWord) {
        
        StringTokenizer st = new StringTokenizer(sentence, " ");
        int index = 0;
        while(st.hasMoreTokens()){
            String tok = st.nextToken();
            if(tok.startsWith(searchWord))
                return index;
            index++;
        }
        return -1;
    }
    
    public void incrementCount(HashMap<Integer, Integer> hm, int count, int val, int startIndex){
  
            hm.put(startIndex + count , val);
       
    }
    
    public int longestConsecutive(int[] nums) {
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        int max = 0;
        for(int i = 0 ; i<nums.length; i++){
            if(hm.containsKey(nums[i]))
                continue;
            int val = 0;
            if(hm.containsKey(nums[i] - 1) && hm.containsKey(nums[i] + 1)){
                val = 1 + hm.get(nums[i] - 1) + hm.get(nums[i] +1);
                incrementCount(hm, -hm.get(nums[i] - 1), 1 + hm.get(nums[i] - 1) + hm.get(nums[i] +1), nums[i]);
                incrementCount(hm, hm.get(nums[i] + 1), 1 + hm.get(nums[i] - 1) + hm.get(nums[i] +1), nums[i]);
            }else if(hm.containsKey(nums[i] - 1) ){
                incrementCount(hm, -hm.get(nums[i] - 1), 1 + hm.get(nums[i] - 1), nums[i]);
                hm.put(nums[i], 1 + hm.get(nums[i] - 1));
                val = 1 + hm.get(nums[i] - 1);
            }else if(hm.containsKey(nums[i] + 1)){
                incrementCount(hm, hm.get(nums[i] + 1), 1 + hm.get(nums[i] + 1), nums[i]);
                hm.put(nums[i], 1 + hm.get(nums[i] + 1));
                val = 1 + hm.get(nums[i] + 1);
            }else{
                hm.put(nums[i], 1);
                val = 1;
            }
            if(max < val)
                max = val;
        }
        return max;
    }
    
    public int leastInterval(char[] tasks, int n) {
        
        int len = 26;
        if(n == 0)
            return tasks.length;
        int[] arr = new int[len];
        for(char c : tasks){
            arr[c-'A']++;
        }
        
        Queue<Integer> q = new PriorityQueue<>((i1,i2) -> arr[i2] - arr[i1]);
        
        for(int i=0; i<len; i++)
            if(arr[i] > 0)
                q.add(i);
        
        int ans = 0;
       
        
        while(!q.isEmpty()){
            List<Integer> taskSequence = new ArrayList<>();
            
            while(!q.isEmpty() && taskSequence.size() <= n +  1){
                taskSequence.add(q.poll());
                arr[taskSequence.get(taskSequence.size()-1)]--;
            }
            ans = ans + n+1;
            for(int i : taskSequence){
                if(arr[i] > 0)
                    q.add(i);
            }
        }
        return ans;
     
    }
    
    public int[] mergeTwoInterval(int arr1[], int arr2[]){
        int res[] = new int[2];
        if(arr1[0] > arr2[1] || arr2[0] > arr1[1])
            return res;
        res[0] = Math.max(arr1[0], arr2[0]);
        res[1] = Math.min(arr1[1], arr2[1]);
        return res;
    }
    
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        Stack<int[]> st1 = new Stack<>();
        Stack<int[]> st2 = new Stack<>();
        for(int i = A.length - 1; i>=0; i--)
            st1.push(A[i]);
        for(int i = A.length - 1; i>=0; i--)
            st1.push(B[i]);
        List<List<Integer>> list = new ArrayList<>();
        while(!st1.isEmpty() && !st2.isEmpty()){
            int[] arr = mergeTwoInterval(st1.peek(), st2.peek());
            if(arr[0] != 0 || arr[1] != 0){
                List<Integer> l1 = new ArrayList<>();
                l1.add(arr[0]);
                l1.add(arr[1]);
                list.add(l1);
                st1.pop();
                st2.pop();
            }else if(st1.peek()[1] < st2.peek()[0]){
                st1.pop();
            }else{
                st2.pop();
            }
        }
        int[][] ans = new int[list.size()][2];
        for(int i=0; i<list.size(); i++){
            ans[i][0] = list.get(i).get(0);
            ans[i][1] = list.get(i).get(1);
        }
        return ans;
    }
    
    public String frequencySort(String s) {
        int arr[] = new int[256];
        for(char c : s.toCharArray()){
            arr[c]++;
        }
         return Arrays.stream(s.split("")).sorted(
        ((o1, o2) -> {
                    Integer i1 = arr[o1.charAt(0)];
                    Integer i2 = arr[o2.charAt(0)];
                    return Integer.compare(i1, i2);
                })
        ).collect(Collectors.joining());
    }
    
    public boolean isPalindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
    
    public int countSubstrings(String s) {
        
        int len = s.length();
        int num = len;
        for(int i=0; i<len; i++){
            int j = i+1;
            while(j < len){
                if(isPalindrome(s, i, j)){
                    num = num + 1;
                    System.out.println(i + " " + j + " " + num);
                    
                }
                j++;
            }
        }
        return num;
    }
    
    public int[] dailyTemperatures(int[] T) {
        
        int arr[]  = new int[T.length];
        arr[T.length-1] = 0;
        for(int i = T.length-2; i>=0; i--){
            int ind = i+1;
          
            while(T[i] > T[ind]){
                if(arr[ind] == 0)
                    break;
                ind = ind + arr[ind];
            }
            
            if(T[i] > T[ind])
               arr[i] = ind - i;
            else
                arr[i] = 0;
            
        }
        return arr;
    }
    
    public int[] countBits(int num) {
        
        int arr[] = new int[num+1];
        arr[0] = 0;
        int pow = 1;
        int index = 1;
        
        while(index <= num){
            
            arr[index] = arr[index - pow] + 1;
            if(pow == index)
                pow = 2 * pow;
            index++;
        }
        return arr;
    }

    public int findUnsortedSubarray(int[] nums) {

//        Queue<Integer> maxQueue = new PriorityQueue<>((o1,o2) -> o2-o1);
//        Queue<Integer> minQueue = new PriorityQueue<>();
//        for(int num : nums){
//            maxQueue.add(num);
//            minQueue.add(num);
//        }
//        while(!maxQueue.isEmpty())
//            System.out.println(maxQueue.poll());
//        while(!minQueue.isEmpty())
//            System.out.println(minQueue.poll());
        int beg = -1, end = -2, min = nums[nums.length - 1], max = nums[0];

        for (int i = 1; i < nums.length; i++) {

            if (nums[nums.length - i - 1] > min) {
                beg = nums.length - i - 1;
            }
            if (nums[i] < max) {
                end = i;
            }

            min = Math.min(min, nums[nums.length - i - 1]);
            max = Math.max(max, nums[i]);

        }
        return end - beg + 1;
// int n = A.length, beg = -1, end = -2, min = A[n-1], max = A[0];
//    for (int i=1;i<n;i++) {
//      max = Math.max(max, A[i]);
//      min = Math.min(min, A[n-1-i]);
//      if (A[i] < max) end = i;
//      if (A[n-1-i] > min) beg = n-1-i; 
//    }
//    return end - beg + 1;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> list = new ArrayList<Integer>();
        for (int num : nums) {
            if (num < 0) {
                num = num * -1;
            }
            if (nums[num] > 0) {
                nums[num] = -nums[num];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                list.add(i + 1);
            }
        }
        return list;
    }

    public int reverseBits(int n) {

        int twoPower = 1;
        int sum = 0;
        while (n != 0) {
            int bit = n & 1;
            if (bit == 0) {
                sum = sum + twoPower;
            }
            twoPower = twoPower * 2;
        }
        return sum;

    }

    public boolean canFinish(List<List<Integer>> list, int[] courseStatus, int index) {

        if (courseStatus[index] == 1) {
            return true;
        }

        if (list.get(index).isEmpty()) {
            courseStatus[index] = 1;
            return true;
        }

        if (courseStatus[index] == 2) {
            return false;
        }
        courseStatus[index] = 2;
        List<Integer> courses = list.get(index);
        for (int course : courses) {
            if (courseStatus[course] != 1) {
                if (!canFinish(list, courseStatus, course)) {
                    return false;
                }
            }
        }
        courseStatus[index] = 1;
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            list.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int[] courseStatus = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (courseStatus[i] == 0 && canFinish(list, courseStatus, i) == false) {
                return false;
            }
        }
        return true;
    }

//    public boolean searchMatrix(int[][] matrix, int target) {
//        
//        
//        
//    }
//    
    public void swap(int arr[], int i, int j) {
        if (i < 0 || i >= arr.length || j < 0 || j >= arr.length) {
            return;
        }
        int a = arr[i];
        arr[i] = arr[j];
        arr[j] = a;
    }

    public void sortColors(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            while (i < nums.length && nums[i] == 0 || nums[i] == 1) {
                i++;
            }
            while (j >= 0 && nums[j] == 2) {
                j--;
            }
            swap(nums, i, j);
        }
        i = 0;
        while (i < j) {
            while (i < nums.length && nums[i] == 0) {
                i++;
            }
            while (j >= 0 && nums[j] == 1) {
                j--;
            }
            swap(nums, i, j);
        }
    }

    public boolean knapSack(int[] nums, int target, int index) {

        if (target == 0) {
            return true;
        }
        if (index >= nums.length) {
            return false;
        }
        return knapSack(nums, target - nums[index], index + 1) || knapSack(nums, target, index + 1);

    }

    public boolean knapSack(int[] nums, int target, int[][] dyn) {

        for (int i = 1; i <= target; i++) {
            for (int j = 1; j <= nums.length; j++) {
                if (i >= nums[j - 1]) {
                    dyn[i][j] = Integer.max(dyn[i][j - 1], dyn[i - nums[j - 1]][j]);
                } else {
                    dyn[i][j] = dyn[i][j - 1];
                }
            }
        }
        return dyn[target][nums.length] == 1 ? true : false;
    }

    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int i : nums) {
            sum = sum + i;
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum = sum / 2;
        int[][] dyn = new int[sum + 1][nums.length + 1];
        for (int i = 1; i <= sum; i++) {
            dyn[i][0] = 0;
        }
        for (int i = 0; i <= nums.length; i++) {
            dyn[0][i] = 1;
        }

        return knapSack(nums, sum, dyn);

    }

    public boolean recursiveCall(String str, int index, HashSet<String> hs) {

        if (str.length() == index) {
            return true;
        }
        for (int i = index; i < str.length(); i++) {
            String s = str.substring(index, i + 1);
            if (hs.contains(s)) {
                if (recursiveCall(str, i + 1, hs)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {

        HashSet<String> hs = new HashSet<String>();
        for (String str : wordDict) {
            hs.add(str);
        }
        return recursiveCall(s, 0, hs);
    }

    public boolean recursive(char[][] arr, int x, int y, String str, int index) {

        if (index == str.length()) {
            return true;
        }

        if (x < 0 || x >= arr.length || y < 0 || y >= arr[0].length) {
            return false;
        }

        if (arr[x][y] != str.charAt(index)) {
            //arr[x][y] = '1';
            return false;
        }
        arr[x][y] = '1';
        boolean b = recursive(arr, x + 1, y, str, index + 1) || recursive(arr, x - 1, y, str, index + 1) || recursive(arr, y - 1, y, str, index + 1) || recursive(arr, y + 1, y, str, index + 1);
        arr[x][y] = str.charAt(index);
        return b;
    }

    public boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if (recursive(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    class Pair{
        
        int x,y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            //return "(" + x + "," + y + ") ";
            return x*4+y+1 + "";
        }
        
        
    }

    public void recursive(int[][] arr, int x, int y, int count, Stack<Pair> st) {

        if (x == 0 && y == 3 && arr[x][y] == 0 && count == 15) {
            st.push(new Pair(x, y));
            System.out.println(st);
            st.pop();
            return;
        }

        if (x < 0 || x >= arr.length || y < 0 || y >= arr[0].length) {
            return;
        }

        if (arr[x][y] >= 1 && !(x == 3 && y == 0)) { /* already visisted and not cell 13 then return */
            return;
        }

        if(arr[x][y] == 0){ /* only increament if its not visisted */
            count++;
        }
        
        arr[x][y]++;
        st.push(new Pair(x,y));
           
        recursive(arr, x + 1, y, count, st);
        recursive(arr, x - 1, y, count, st);
        recursive(arr, x, y + 1, count, st);
        recursive(arr, x, y - 1, count, st);
  
        arr[x][y]--;
        st.pop();
        
    }

    public void puzzle() {
        
        int len = 4;
        Stack<Pair> st = new Stack();
        int arr[][] = new int[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(arr[i], 0);
        }
        recursive(arr, 3, 0, 0, st);
    }

    public String licenseKeyFormatting(String s, int k) {

        int i = s.length() - 1;
        String str = "";
        String resuString = "";
        while (i >= 0) {
            char c = s.charAt(i);
            if (c != '-') {
                if (Character.isDigit(c)) {
                    str = c + str;
                } else {
                    str = Character.toUpperCase(c) + str;
                }
            }
            if (str.length() == k) {
                if (resuString.isEmpty()) {
                    resuString = str;
                } else {
                    resuString = str + "-" + resuString;
                }
                str = "";
            }
            i--;
        }
        return resuString;
    }

    public boolean checkInclusion(String s1, String s2) {

        char[] s1Array = s1.toCharArray();
        Arrays.sort(s1Array);
        s1 = new String(s1Array);
        for (int i = s1.length(); i < s2.length(); i++) {
            char[] s2Array = s2.substring(i - s1.length(), i).toCharArray();
            Arrays.sort(s2Array);
            String sub = new String(s2Array);
            if (s1.equalsIgnoreCase(sub)) {
                return true;
            }
        }

        return false;
    }

    public int bitwiseComplement(int N) {

        int num = 1;
        int ans = 0;
        do {
            int bit = N & 1;
            if (bit == 0) {
                ans = ans + num;
            }
            num = num * 2;
            N = N >> 1;
        } while (N != 0);
        return ans;
    }

    public int heightChecker(int[] heights) {
        int[] newHeight = new int[heights.length];
        System.arraycopy(heights, 0, newHeight, 0, heights.length);
        Arrays.sort(newHeight);
        int i = 0;
        int count = 0;
        while (i < heights.length) {
            if (heights[i] != newHeight[i]) {
                count++;
            }
            i++;
        }
        return count;
    }

    public boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int j = 0;
        while (i < name.length() && j < typed.length()) {
            if (name.charAt(i) != typed.charAt(j)) {
                return false;
            }
            int count1 = 0;
            int count2 = 0;
            if (i + 1 < name.length() && name.charAt(i) == name.charAt(i + 1)) {
                while (i + 1 < name.length() && name.charAt(i) == name.charAt(i + 1)) {
                    count1++;
                    i++;
                }
            } else {
                i++;
            }

            if (j + 1 < typed.length() && typed.charAt(j) == typed.charAt(j + 1)) {
                while (j + 1 < typed.length() && typed.charAt(j) == typed.charAt(j + 1)) {
                    count2++;
                    j++;
                }
            } else {
                j++;
            }

            if (count1 > count2) {
                return false;
            }
        }
        if (i == name.length() && j == typed.length()) {
            return true;
        }
        return false;
    }
}

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
class NestedInteger {
    // Constructor initializes an empty nested list.

    public NestedInteger() {

    }

    //Constructor initializes a single integer.
    public NestedInteger(int value) {

    }

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger() {
        return true;
    }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() {
        return 1;
    }

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value) {

    }

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni) {

    }

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList() {
        List<NestedInteger> list = new ArrayList<>();
        return list;
    }
}
