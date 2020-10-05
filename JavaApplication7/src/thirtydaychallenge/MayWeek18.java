/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thirtydaychallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;


/**
 *
 * @author rajeshkumar.yadav
 */
public class MayWeek18 {

    public static void main(String[] args) {
        String in = "(a(b(c)d)";
        int[] arr = {8, 2, 4, 7};
        int limit = 4;
        MayWeek18 may = new MayWeek18();
        //int ans = may.longestSubarray(arr, limit);
        System.out.println(" " + may.decodeAtIndex("leet2code3", 10));
        /* "leet2code3"
10*/

//        int[] arr1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
//        for (int i = 0; i < arr1.length; i++) {
//            if (arr1[i] == 2) {
//                System.out.println(" i = " + i);
//                break;
//            }
//        }
        //System.out.println(" " + may.isTreeEqual(null, null));
        //may.minRemoveToMakeValid(in);
    }
    
    public String decodeAtIndexUtil(String S, long K) {
    
        long  size = 0;
        int index = 0;
        
        if(K < S.length() && (S.charAt((int)K) < '0' || S.charAt((int)K) > '9'))
            return S.charAt((int)K) + "";
        
        while(index < S.length()){
            if(S.charAt(index) < '0' || S.charAt(index) > '9')
               {
                size++;
                if(size == K)
                    return S.charAt(index) + "";
                index++;
            }
            else{
                int start = index;
                while(start < S.length() && S.charAt(start) >= '0' && S.charAt(start) <= '9')
                    start++;
                size = Integer.parseInt(S.substring(index, start)) * size;
                index = start;
            }
            if(size > K)
                return decodeAtIndexUtil(S, K - size%K);
        }
        
       return "";
    }
    
    
    public String decodeAtIndex(String S, long K) {
    
        return decodeAtIndexUtil(S, K-1);
        
       
    }
    
    public String convertToTitle(int n) {
        if(n == 0)
            return "";
        if(n<=26)
        {
            return Character.toString((char)(n+64));
        }
        int rem = n%26;
        n = n/26;
        String ans =  convertToTitle(n);
        if(rem != 0)
            ans =  ans + Character.toString((char)(rem+64));
        return ans;
    }

    public boolean canIntervalMerged(int[] interval1, int[] interval2) {

        if (interval1[0] >= interval2[0] && interval1[0] <= interval2[1]) {
            return true;
        }
        if (interval2[0] >= interval1[0] && interval2[0] <= interval1[1]) {
            return true;
        }
        return false;

    }

    public int[] mergeInterval(int[] interval1, int[] interval2) {

        int[] newint = new int[2];
        newint[0] = Math.min(interval1[0], interval2[0]);
        newint[1] = Math.max(interval1[1], interval2[1]);
        return newint;

    }

    public Stack<int[]> mergeUtil(Stack<int[]> st, int[] interval) {

        Stack<int[]> tmpst = new Stack();

        while (interval != null) {
            if (!st.isEmpty() && canIntervalMerged(st.peek(), interval)) {
                interval = mergeInterval(st.pop(), interval);
            } else if (!st.isEmpty() && st.peek()[0] > interval[0]) {
                tmpst.push(st.pop());
            } else {
                st.push(interval);
                if (!tmpst.isEmpty()) {
                    interval = tmpst.pop();
                } else {
                    interval = null;
                }
            }
        }
        return st;

    }

    public int[][] insert(int[][] intervals, int[] newInterval) {

        Stack<int[]> st = new Stack<>();
        for (int i = 0; i < intervals.length; i++) {
            st.push(intervals[i]);
        }

        st = mergeUtil(st, newInterval);
        int[][] ans = new int[st.size()][2];

        for (int i = st.size() - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }
        return ans;
    }

    public int binarySearchInRotatedArray(int arr[], int start, int end) {

        if ((start + 1 == end) || (start == end)) {
            return start;
        }

        int mid = start + (end - start) / 2;

        if (arr[0] <= arr[mid]) {
            return binarySearchInRotatedArray(arr, mid + 1, end);
        } else {
            return binarySearchInRotatedArray(arr, start, mid);
        }

    }

    public boolean binarySearch(int arr[], int start, int end, int target, int flag) {

        if (start > end) {
            return false;
        }

        int mid = start + (end - start) / 2;

        if (arr[mid] == target) {
            return true;
        }

        if (flag == 1) {
            if (arr[mid] < target) {
                return binarySearch(arr, mid + 1, end, target, flag);
            } else {
                return binarySearch(arr, start, mid - 1, target, flag);
            }
        } else {
            if (arr[mid] < target) {
                return binarySearch(arr, start, mid - 1, target, flag);
            } else {
                return binarySearch(arr, mid + 1, end, target, flag);
            }
        }

    }

    public boolean search(int[] nums, int target) {

        int mid = binarySearchInRotatedArray(nums, 0, nums.length - 1);
        return binarySearch(nums, mid, nums.length - 1, target, 1) || binarySearch(nums, 0, mid - 1, target, 0);

    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= k + i && j < nums.length; j++) {
                if (nums[j] - nums[i] <= t) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public int longestPalindromeSubseqUtil(StringBuilder sb, int pos, int size) {

        if (pos == sb.length()) {
            if (isPalindrome(sb.toString()) == true) {
                return sb.length();
            } else {
                return -1;
            }
        }

        StringBuilder s1 = new StringBuilder(sb.deleteCharAt(pos));
        return Math.max(longestPalindromeSubseqUtil(s1, pos + 1, size), longestPalindromeSubseqUtil(sb, pos + 1, size));

    }

    public int longestPalindromeSubseq(String s) {

        StringBuilder sb = new StringBuilder(s);
        int pos = 0;
        int size = s.length();
        return longestPalindromeSubseqUtil(sb, pos, size);
    }

    public int mySqrtUtil(int x, int start, int end) {

        long mid = start + (end - start) / 2;
        if (mid * mid > x) {
            return mySqrtUtil(x, start, (int) mid - 1);
        }
        if ((mid + 1) * (mid + 1) > x) {
            return (int) mid;
        }
        return mySqrtUtil(x, (int) mid + 1, end);

    }

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        return mySqrtUtil(x, 1, x / 2 + 1);
    }

    public int pathSumUtil(TreeNode root, int target, int sum) {

        if (root == null) {
            return 0;
        }
        int ans = 0;
        if (sum == target) {
            ans++;
        }
        return ans + pathSumUtil(root.left, target, sum + root.val) + pathSumUtil(root.right, target, sum + root.val);

    }

    public int pathSum(TreeNode root, int sum) {
        return pathSumUtil(root, sum, 0);
    }

    public void pathSumUtil(TreeNode root, int target, int sum, int[] arr, HashMap<Integer, Integer> hm) {

        if (root == null) {
            return;
        }
        sum = sum + root.val;
        if (hm.get(sum - target) != null) {
            arr[0] = arr[0] + hm.get(sum - target);
        }
        hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        pathSumUtil(root.left, target, sum, arr, hm);
        pathSumUtil(root.right, target, sum, arr, hm);
        if (hm.get(sum) == 1) {
            hm.remove(sum);
        } else {
            hm.put(sum, hm.get(sum) - 1);
        }
    }
//    public int pathSum(TreeNode root, int sum) {
//        int[] ans = new int[1];
//        HashMap<Integer, Integer> hs = new HashMap<>();
//        pathSumUtil(root, sum, 0, ans, hs);
//        return ans[0];
//    }

    public boolean isTreeEqual(TreeNode root1, TreeNode root2, HashMap<TreeNode, TreeNode> hm) {

        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null && root2 != null) {
            return false;
        }
        if (root2 == null && root1 != null) {
            return false;
        }
        if (hm.get(root1) == root2 || hm.get(root2) == root1) {
            return true;
        }
        if (root1.val == root2.val) {
            boolean b = isTreeEqual(root1.left, root2.left, hm) && isTreeEqual(root1.right, root2.right, hm);
            if (b == true) {
                hm.put(root1, root2);
            }
            return b;
        } else {
            return true;
        }
    }

    public String findDuplicateSubtreesUtil(TreeNode root, HashMap<String, Integer> hm, List<TreeNode> list) {

        if (root == null) {
            return "#";
        }
        String tree = root.val + "," + findDuplicateSubtreesUtil(root.left, hm, list) + "," + findDuplicateSubtreesUtil(root.right, hm, list);
        if (hm.getOrDefault(tree, 0) == 1) {
            list.add(root);
        }
        hm.put(tree, hm.getOrDefault(tree, 0) + 1);
        return tree;

    }

    public void tree2strUtil(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val + "");
        if (root.left == null && root.right == null) {
            return;
        }
        String left = "";
        String right = "";
        sb.append('(');
        tree2str(root.left);
        sb.append(')');
        if (root.right != null) {
            sb.append('(');
            tree2str(root.right);
            sb.append(')');
        }

    }

    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        tree2strUtil(root, sb);
        return sb.toString();
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        List<TreeNode> ans = new ArrayList<TreeNode>();
        HashMap<String, Integer> hm = new HashMap<>();
        findDuplicateSubtreesUtil(root, hm, ans);
        return ans;
    }

    public int longestSubarray(int[] nums, int limit) {

        int start = 0;
        int end = 0;
        int len = 1;
        PriorityQueue<ArrayPair> maxq = new PriorityQueue<>((o1, o2) -> o2.a - o1.a);
        PriorityQueue<ArrayPair> minq = new PriorityQueue<>((o1, o2) -> o1.a - o2.a);

        while (end < nums.length) {

            maxq.add(new ArrayPair(nums[end], end));
            minq.add(new ArrayPair(nums[end], end));

            while (!maxq.isEmpty() && !minq.isEmpty() && maxq.peek().a - minq.peek().a > limit) {

                if (maxq.peek().a == nums[end]) {
                    start = minq.peek().b + 1;
                    while (!minq.isEmpty() && minq.peek().b < start) {
                        minq.poll();
                    }
                } else {
                    start = maxq.peek().b + 1;
                    while (!maxq.isEmpty() && maxq.peek().b < start) {
                        maxq.poll();
                    }
                }

            }

            len = Math.max(len, end - start + 1);
            end++;
        }
        return len;

    }

    class ArrayPair {

        int a;
        int b;

        public ArrayPair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        int start = 0;
        int end = 0;
        PriorityQueue<ArrayPair> pq = new PriorityQueue<>((o1, o2) -> o2.a - o1.a);
        while (end < nums.length && end < k) {
            pq.add(new ArrayPair(nums[end], end));
            end++;
        }
        int[] arr = new int[nums.length - k + 1 >= 1 ? nums.length - k + 1 : 1];
        int index = 0;
        arr[index++] = pq.peek().a;
        while (end < nums.length) {
            start++;
            pq.add(new ArrayPair(nums[end], end));
            while (pq.peek().b < start) {
                pq.poll();
            }
            arr[index++] = pq.peek().a;
            end++;
        }
        return arr;
    }

    public boolean kLengthApart(int[] nums, int k) {
        int temp = k;
        int i = 0;
        while (i < nums.length && nums[i] != 1) {
            i++;
        }
        i++;
        for (; i < nums.length; i++) {
            if (nums[i] == 0) {
                temp--;
            } else {
                if (temp > 0) {
                    return false;
                }
                temp = k;
            }
        }

        return true;
    }

    public String destCity(List<List<String>> paths) {
        HashSet<String> hs = new HashSet<>();
        for (List<String> list : paths) {
            hs.add(list.get(0));
        }
        for (List<String> list : paths) {
            if (!hs.contains(list.get(1))) {
                return list.get(1);
            }
        }
        return "";
    }

    public int numComponents(ListNode head, int[] G) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < G.length; i++) {
            hs.add(G[i]);
        }
        int count = 0;
        while (head != null) {
            if (hs.contains(head.val)) {
                count++;
                while (head != null && hs.contains(head.val)) {
                    head = head.next;
                }
            } else {
                head = head.next;
            }

        }
        return count;
    }

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        int arrsum = 0;
        for (int i = 0; i < nums.length; i++) {
            arrsum = arrsum + nums[i];
        }
        return sum - arrsum;
    }

    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
            } else {
                if (st.isEmpty()) {
                    return false;
                }
                char popedChar = st.pop();
                if (c == ')' && popedChar != '(') {
                    return false;
                }
                if (c == '}' && popedChar != '{') {
                    return false;
                }
                if (c == ']' && popedChar != '[') {
                    return false;
                }

            }
        }
        return st.isEmpty();
    }

    public int getIntegerValue(List<Integer> list) {
        int decimal = 1;
        int no = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            no = no + list.get(i) * decimal;
            decimal = decimal * 10;
        }
        return no;
    }

    public void pathSumUtil(TreeNode root, int[] sum, List<Integer> curList) {
        if (root == null) {
            return;
        }
        curList.add(root.val);

        if (root.left == null && root.right == null) {
            int res = getIntegerValue(curList);
            sum[0] = sum[0] + res;
        }
        pathSumUtil(root.left, sum, curList);
        pathSumUtil(root.right, sum, curList);
        curList.remove(curList.size() - 1);
    }

    public int sumNumbers(TreeNode root) {
        int arr[] = new int[1];
        List<Integer> list = new ArrayList<>();
        pathSumUtil(root, arr, list);
        return arr[0];
    }

    public void pathSumUtil(TreeNode root, int sum, List<List<Integer>> list, List<Integer> curList) {
        if (root == null) {
            return;
        }
        curList.add(root.val);
        sum = sum - root.val;
        if (sum == 0 && root.left == null && root.right == null) {
            List<Integer> clist = new ArrayList<>(curList);
            list.add(clist);
        }
        pathSumUtil(root.left, sum, list, curList);
        pathSumUtil(root.right, sum, list, curList);
        curList.remove(curList.size() - 1);
    }

//    public List<List<Integer>> pathSum(TreeNode root, int sum) {
//        
//        List<List<Integer>> list = new ArrayList<>();
//        List<Integer> curList =  new ArrayList<>();
//        pathSumUtil(root, sum, list, curList);
//        return list;
//    }
    public boolean hasPathSumUtil(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        sum = sum - root.val;
        if (root.left == null && root.right == null && sum == 0) {
            return true;
        }
        boolean b1 = hasPathSumUtil(root.left, sum);
        if (b1 == false) {
            b1 = hasPathSumUtil(root.right, sum);
        }
        return b1;
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return hasPathSumUtil(root, sum);
    }

    public void deepestLeavesSumUtil(TreeNode root, int height, int arr[]) {

        if (root == null) {
            return;
        }

        if (height > arr[0]) {
            arr[0] = height;
            arr[1] = root.val;
        } else if (height == arr[0]) {
            arr[1] = arr[1] + root.val;
        }

        deepestLeavesSumUtil(root.left, height + 1, arr);
        deepestLeavesSumUtil(root.right, height + 1, arr);

    }

    public int deepestLeavesSum(TreeNode root) {
        int[] arr = new int[2];
        arr[0] = 0;
        arr[1] = 0;
        deepestLeavesSumUtil(root, 1, arr);
        return arr[1];
    }

    public String minRemoveToMakeValid(String s) {

        int[] st = new int[s.length()];
        int stindex = -1;
        char[] carr = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            if (carr[i] == '(') {
                st[++stindex] = i;
            } else if (carr[i] == ')') {
                if (stindex == -1) {
                    st[++stindex] = i;
                } else if (carr[st[stindex]] == '(') {
                    stindex--;
                } else {
                    st[++stindex] = i;
                }
            }
        }
        StringBuilder sb = new StringBuilder("");
        for (int i = s.length() - 1; i >= 0; i--) {
            if (stindex > -1 && st[stindex] == i) {
                stindex--;
                continue;
            }
            sb.append(carr[i]);
        }
        return sb.reverse().toString();

    }

    public void getPath(TreeNode root, TreeNode p, Stack<TreeNode> st) {

        if (root == null) {
            return;
        }
        if (p == root) {
            st.push(p);
            return;
        }
        st.push(root);
        getPath(root.left, p, st);
        getPath(root.right, p, st);
        st.pop();

    }

    public void printStack(Stack<TreeNode> st) {

        Stack<TreeNode> temp = (Stack<TreeNode>) st.clone();
        while (!temp.isEmpty()) {
            System.out.print(temp.pop().val);
        }

    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] ranarr = new int[26];
        int[] magarr = new int[26];
        for (char c : ransomNote.toCharArray()) {
            ranarr[c - 'a']++;
        }
        for (char c : magazine.toCharArray()) {
            magarr[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (ranarr[i] != 0 && ranarr[i] > magarr[i]) {
                return false;
            }
        }
        return true;
    }

    public int numJewelsInStones(String J, String S) {
        HashSet<Character> hs = new HashSet<>();
        for (char c : J.toCharArray()) {
            hs.add(c);
        }
        int count = 0;
        for (char c : S.toCharArray()) {
            if (hs.contains(c)) {
                count++;
            }
        }
        return count;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        getPath(root, p, st1);
        getPath(root, q, st2);
        // printStack(st1);
        // printStack(st2);
        while (st1.size() > st2.size()) {
            st1.pop();
        }
        while (st1.size() < st2.size()) {
            st2.pop();
        }
        while (st1.peek().val != st2.peek().val) {
            st1.pop();
            st2.pop();
        }
        return st1.peek();

    }

    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
    boolean isBadVersion(int version) {
        return true;
    }

    public int firstBadVersionUtil(int start, int end) {
        if (start == end) {
            return start;
        }
        if (start + 1 == end) {
            if (isBadVersion(start)) {
                return start;
            }
            return end;
        }
        int mid = start + (end - start) / 2;
        if (isBadVersion(mid)) {
            return firstBadVersionUtil(start, mid);
        }
        return firstBadVersionUtil(mid + 1, end);
    }

    public int firstBadVersion(int n) {
        return firstBadVersionUtil(1, n);
    }

    public int maxPathSumUtil(TreeNode root, int[] val) {
        if (root == null) {
            return 0;
        }
        int value = root.val;
        int leftpart = maxPathSumUtil(root.left, val);
        int rightPart = maxPathSumUtil(root.right, val);
        if (value + leftpart + rightPart > val[0]) {
            val[0] = value + leftpart + rightPart;
        }
        if (leftpart + value > rightPart + value) {
            return leftpart + value;
        }
        return rightPart + value;

    }

    public int maxPathSum(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int[] res = new int[1];
        maxPathSumUtil(root, res);
        return res[0];
    }

    public int rob(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int[] dynArr = new int[nums.length];
        dynArr[0] = nums[0];
        dynArr[1] = Integer.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dynArr[i] = Integer.max(nums[i] + dynArr[i - 2], dynArr[i - 1]);
        }
        return dynArr[nums.length - 1];
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int size = m + n;
        int i = m - 1;
        int j = n - 1;
        int k = 0;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                //nums1[size-k-1] = nums1[i];
                nums1[i + j + 1] = nums1[i];
                i--;
            } else {
                //nums1[size-k-1] = nums2[j];
                nums1[i + j + 1] = nums2[j];
                j--;
            }
            k++;
        }
        while (i >= 0) {
            //nums1[size-k-1] = nums1[i];
            nums1[i] = nums1[i];
            k++;
            i--;
        }
        while (j >= 0) {
            //nums1[size-k-1] = nums2[j];
            nums1[j] = nums2[j];
            k++;
            j--;
        }

    }

    public ListNode getMiddleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur1 = head;
        ListNode cur2 = head.next;
        while (cur2 != null && cur2.next != null) {
            cur1 = cur1.next;
            cur2 = cur2.next.next;
        }
        return cur1;
    }

    public boolean checkPalindrome(ListNode list1, ListNode list2) {

        while (list1 != null && list2 != null) {
            if (list1.val != list2.val) {
                return false;
            }
            list1 = list1.next;
            list2 = list2.next;
        }

        if (list1 != null && list1.next.next != null) {
            return false;
        }

        return true;

    }

    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }
        ListNode middleNode = getMiddleNode(head);
        ListNode part2 = reverseList(middleNode.next);
        middleNode.next = null;
        boolean res = checkPalindrome(head, part2);
        part2 = reverseList(part2);
        middleNode.next = part2;
        return res;
    }

    public TreeNode sortedArrayToBSTUtil(int[] arr, int start, int end) {

        if (start > end) {
            return null;
        }

        if (start == end) {
            TreeNode node = new TreeNode(arr[start]);
            return node;
        }

        int mid = start + (end - start) / 2;
        TreeNode n = new TreeNode(arr[mid]);

        n.left = sortedArrayToBSTUtil(arr, start, mid - 1);
        n.right = sortedArrayToBSTUtil(arr, mid + 1, end);
        return n;

    }

    public TreeNode sortedArrayToBST(int[] nums) {

        TreeNode root = sortedArrayToBSTUtil(nums, 0, nums.length - 1);
        return root;

    }

    public void deleteNode(ListNode node) {
        ListNode nodenext = node.next;
        if (nodenext != null) {
            node.val = nodenext.val;
            node.next = nodenext.next;
            nodenext.next = null;
        }
    }

    public ListNode reverseListRecursiveutil(ListNode prevNode, ListNode curNode) {

        ListNode nextNode = curNode.next;
        curNode.next = prevNode;
        ListNode root = curNode;
        if (nextNode != null) {
            root = reverseListRecursiveutil(curNode, nextNode);
        }
        return root;

    }

    public ListNode reverseListRecursive(ListNode head) {

        if (head == null) {
            return head;
        }

        return reverseListRecursiveutil(null, head);

    }

    public ListNode reverseList(ListNode head) {

        if (head == null) {
            return head;
        }
        ListNode prevNode = null;
        ListNode nextNode;
        while (head != null) {
            nextNode = head.next;
            head.next = prevNode;
            prevNode = head;
            head = nextNode;
        }
        return prevNode;

    }

    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }
        ListNode cur1 = head;
        ListNode cur2 = head.next;
        while (cur2 != null && cur2.next != null && cur1 != cur2) {
            cur2 = cur2.next.next;
            cur1 = cur1.next;
        }
        if (cur1 == cur2) {
            return true;
        }
        return false;

    }

}

class Solution {

    public void setParent(int[] parent, int parentId, int childId) {
        if (parent[parentId] == parentId) {
            parent[childId] = parentId;
            return;
        }
        setParent(parent, parent[parentId], childId);
    }

    public int getParent(int[] parent, int id) {
        if (parent[id] == id) {
            return id;
        }
        return getParent(parent, parent[id]);
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        String nameArr[] = new String[accounts.size()];
        int parentArr[] = new int[accounts.size()];
        int index = 0;
        for (List<String> list : accounts) {
            nameArr[index] = list.get(0);
            parentArr[index] = index;
            index++;
        }

        index = 0;
        HashMap<String, Integer> hm = new HashMap<>();

        for (List<String> list : accounts) {
            int curParent = parentArr[index];

            for (int i = 1; i < list.size(); i++) {
                String mailAddress = list.get(i);
                if (hm.get(mailAddress) != null) {
                    int newParent = hm.get(mailAddress);
                    if (newParent < curParent) {
                        setParent(parentArr, newParent, curParent);
                        curParent = parentArr[newParent];
                    } else {
                        setParent(parentArr, curParent, newParent);
                    }
                } else {
                    hm.put(mailAddress, curParent);
                }
            }
        }

        HashMap<Integer, SortedSet<String>> hashMap = new HashMap<>();
        for (Entry<String, Integer> str : hm.entrySet()) {
            int parent = getParent(parentArr, str.getValue());
            if (hashMap.containsKey(parent)) {
                hashMap.get(parent).add(str.getKey());
            } else {

                SortedSet<String> sset = new TreeSet<>();
                sset.add(str.getKey());
                hashMap.put(str.getValue(), sset);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (Entry<Integer, SortedSet<String>> entry : hashMap.entrySet()) {
            int val = entry.getKey();
            List<String> list = new ArrayList<>(entry.getValue());
            list.add(0, nameArr[val]);
            result.add(list);
        }
        return result;
    }

    public boolean check321(List<Pair321> list, int ind, int[] nums) {

        for (int i = list.size() - 1; i >= 0; i--) {
            if (nums[list.get(i).min] < nums[ind] && nums[list.get(i).max] > nums[ind]) {
                return true;
            }
        }
        return false;
    }

    public boolean find132pattern(int[] nums) {
        List<Pair321> list = new ArrayList<>();
        Pair321 p = new Pair321(0, 0);
        list.add(p);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[list.get(list.size() - 1).min]) {
                p = new Pair321(i, i);
                list.add(p);
            } else {
                if (check321(list, i, nums) == true) {
                    return true;
                }
                list.get(list.size() - 1).setMax(i);
            }
        }
        return false;
    }
}

class Pair321 {

    int min;
    int max;

    public Pair321(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }

}

// Definition for a Node.
class Node1 {

    int val;
    Node1 next;
    Node1 random;

    public Node1(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution1 {

    public Node1 copy(Node1 head) {
        Node1 root = head;
        Node1 cur = null;
        Node1 next = null;
        while (head != null) {
            cur = new Node1(head.val);
            next = head.next;
            head.next = cur;
            cur.next = next;
            head = next;
        }
        return root;
    }

    public Node1 copyRandomList(Node1 head) {

        if (head == null) {
            return head;
        }

        Node1 head2 = copy(head);
        Node1 cur = head2;
        while (head2 != null) {

            Node1 dup = head.next;
            dup.random = head2.random != null ? head2.random.next : null;
            head2 = dup.next;

        }

        Node1 head1 = head;
        head2 = head.next;
        Node1 res = head2;
        while (head1 != null) {

            head1.next = head2.next;
            if (head1.next != null) {
                head2.next = head1.next.next;
            }
            head1 = head1.next;
            head2 = head.next;

        }

        return res;
    }
}

class MyNode {

    int val;
    MyNode next;

    public MyNode(int val) {
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public MyNode getNext() {
        return next;
    }

    public void setNext(MyNode next) {
        this.next = next;
    }

}

class MyLinkedList {

    MyNode head;
    MyNode tail;
    int size;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        head = tail = null;
        size = 0;
    }

    public MyNode getNthNode(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        int count = 0;
        MyNode tmp = head;
        while (count != index) {
            tmp = tmp.next;
            count++;
        }
        return tmp;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is
     * invalid, return -1.
     */
    public int get(int index) {

        MyNode tmp = getNthNode(index);
        return tmp != null ? tmp.val : -1;

    }

    /**
     * Add a node of value val before the first element of the linked list.
     * After the insertion, the new node will be the first node of the linked
     * list.
     */
    public void addAtHead(int val) {

        size++;
        if (head == null) {
            head = new MyNode(val);
            tail = head;
        } else {
            MyNode tmp = new MyNode(val);
            tmp.next = head;
            head = tmp;
        }

    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {

        size++;
        if (tail == null) {
            tail = head = new MyNode(val);
        } else {
            MyNode tmp = new MyNode(val);
            tail.next = tmp;
            tail = tmp;
        }

    }

    /**
     * Add a node of value val before the index-th node in the linked list. If
     * index equals to the length of linked list, the node will be appended to
     * the end of linked list. If index is greater than the length, the node
     * will not be inserted.
     */
    public void addAtIndex(int index, int val) {

        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }
        size++;

        MyNode tmp = getNthNode(index - 1);
        if (tmp != null) {

            MyNode newnode = new MyNode(val);
            newnode.next = tmp.next;
            tmp.next = newnode;

        }

    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {

        if (index < 0 || index >= size) {
            return;
        }

        if (index == 0) {
            if (size == 1) {
                head = tail = null;
            } else {
                head = head.next;
            }
            size--;
            return;
        }

        if (index == size - 1) {
            if (size == 1) {
                head = tail = null;
            } else {
                MyNode tmp = getNthNode(index - 1);
                if (tmp != null) {
                    tail = tmp;
                    tail.next = null;
                }
            }
                size--;
                return;
            }

            MyNode tmp = getNthNode(index - 1);
            if (tmp != null) {
                tmp.next = tmp.next.next;
                size--;
            }

        }
    }
