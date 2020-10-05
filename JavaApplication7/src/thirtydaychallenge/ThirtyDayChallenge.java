/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thirtydaychallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author rajeshkumar.yadav
 */
class Node extends TreeNode {

    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int _val) {
        val = _val;
    }

    public TreeNode(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

class FirstUnique {

    DoublyLinkList queue;
    HashMap<Integer, DoublyLinkListNode> hm;

    public FirstUnique(int[] nums) {
        queue = new DoublyLinkList();
        hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            add(value);
        }
    }

    public int showFirstUnique() {
        if (queue.size == 0) {
            return -1;
        }
        int val = queue.head.val;
        return val;
    }

    public void add(int value) {

        if (hm.get(value) == null) {
            DoublyLinkListNode node = new DoublyLinkListNode(value);
            queue.insert(node, queue.size);
            hm.put(value, node);
        } else {
            queue.remove(hm.get(value));
        }
    }
}

public class ThirtyDayChallenge {

    public static void main(String[] args) {

        String[] arr = {"314", "49", "9001","15926535897", "14", "9323", "4", "973", "8462643383279"};
        //String str = "3141592653589793238462643383279";
        String str = "159265358979001";
        ThirtyDayChallenge td = new ThirtyDayChallenge();
        System.out.println(td.minNoOfSpaces(str, arr));
        
        
        /*["FirstUnique","showFirstUnique","add","showFirstUnique","add","showFirstUnique","add","showFirstUnique"]
[[[2,3,5]],[],[5],[],[2],[],[3],[]]*/
//        int[] arr = {2, 3, 5};
//        FirstUnique fu = new FirstUnique(arr);
//        System.out.println(" " + fu.showFirstUnique());
//        fu.add(5);
//        System.out.println(" " + fu.showFirstUnique());
//        fu.add(2);
//        System.out.println(" " + fu.showFirstUnique());
//        fu.add(3);
//        System.out.println(" " + fu.showFirstUnique());

//        ThirtyDayChallenge tdc = new ThirtyDayChallenge();
//        String str = "yisxjwry";
//        int[][] arr = {{1, 8}, {1, 4}, {1, 3}, {1, 6}, {0, 6}, {1, 4}, {0, 2}, {0, 1}};
//        String ans = tdc.stringShift(str, arr);
//        System.out.println(ans);
//        int a = -1;
//        int b = -2;
//        System.out.println(a + "" + b);
        /*
        "yisxjwry"
{[1,8},[1,4],[1,3],[1,6],[0,6],[1,4],[0,2],[0,1]]
         */
//        MinStack m = new MinStack();
//        
//        m.push(524);
//        m.push(-1024);
//        m.push(-1024);
//        m.push(524);
//        
//        m.pop();
//        m.getMin();
//        m.pop();
//        m.getMin();
//        m.pop();
        //System.out.println("m.pop" + m.pop());
    }
   
    
    
    public boolean isSymmetricUtil(TreeNode left, TreeNode right){
        
        if(left == null && right == null)
            return true;
        
        if(left == null && right != null)
            return false;
        if(left != null && right == null)
            return false;
        
        if(left.val == right.val)
            return isSymmetricUtil(left.left, right.right) && isSymmetricUtil(left.right, right.left);
        return false;
            
        
    }
    
    public boolean isSymmetric(TreeNode root) {
        
        if(root == null)
            return true;
        
        return isSymmetricUtil(root.left, root.right);
    }
    
    public int minNoOfSpacesUtil(String str, HashSet<String> hs){
        
        if(str.isEmpty())
            return 0;
        if(hs.contains(str))
            return 0;
        int min = Integer.MAX_VALUE;
        for(int i=1; i<str.length(); i++){
            if(hs.contains(str.substring(0, i))){
                int val = minNoOfSpacesUtil(str.substring(i), hs);
                if(val != Integer.MAX_VALUE && val + 1 < min )
                    min = val  + 1;
            }
        }
        return min;
    }
    
    public int minNoOfSpaces(String str, String[] arr){
        
        HashSet<String> hs = new HashSet<>();
        for(int i=0; i<arr.length; i++){
            hs.add(arr[i]);
        }
        int val = minNoOfSpacesUtil(str, hs);
        return val == Integer.MAX_VALUE ? -1 : val;
    }
    
    
    public String commonPrefix(String str1, String str2){
        int len = Integer.min(str1.length(), str2.length());
        String str = "";
        for(int i=0; i<len; i++){
            if(str1.charAt(i) == str2.charAt(i)){
                str = str + str1.charAt(i);
            }else{
                return str;
            }
        }
        return str;
    }
    
    public String longestCommonPrefix(String[] strs) {
        String ans = strs[0];
        for(int i = 1; i<strs.length; i++){
            
            ans = commonPrefix(ans, strs[i]);
            if(ans.length() == 0)
                return ans;
        
        }
        return ans;
        
    }
    
    /*1534236469*/
    public int reverse(int x) {
        int sign = 1;
        if(x < 0)
            sign = -1;
        int arr[] = new int[12];
        int size = 0;
        while(x != 0){
            
            int digit = x%10;
            x = x / 10;
            arr[size++] = digit;
        }
        int val = 0;
        int decimal = 1;
        for(int i=size-1; i>=0; i--){
            val = val + arr[i] * decimal;
            decimal = decimal * 10;
        }
        return val;
    }
    
    public int firstUniqChar(String s) {
        int arr1[] = new int[26];
        
        
        for(int i=0; i<s.length(); i++)
            arr1[s.charAt(i) - 'a']++;
        for(int i=0; i<s.length(); i++)
        {
            if(arr1[s.charAt(i) - 'a' ] == 1)
                return i;
        }
        
        return -1;
    }
    public boolean isAnagram(String s, String t) {
        
        
        int arr1[] = new int[26];
        int arr2[] = new int[26];
        
        for(int i=0; i<s.length(); i++)
            arr1[s.charAt(i) - 'a']++;
        
        for(int i=0; i<t.length(); i++)
            arr2[s.charAt(i) - 'a']++;
        
        for(int i=0; i<26; i++)
            if(arr1[i] != arr2[i])
                return false;
        return true;
    }
    
   public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;
        while(i < j){
            while(i<s.length() && (s.charAt(i) < 'a' || s.charAt(i) > 'z'))
                i++;
            while(j>=0 && (s.charAt(j) < 'a' || s.charAt(j) > 'z'))
                j--;
            if(s.charAt(i) != s.charAt(j))
                return false;
            else{
                i++;
                j--;
            }
        }
        return true;
    }
    
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] arr = new int[2];
        for(int i=0; i<nums.length; i++){
            int val = target - nums[i];
            if(hm.get(val) != null){
                arr[0] = hm.get(val);
                arr[1] = i;
                return arr;
            }else{
                hm.put(nums[i], i);
            }
        }
        return arr;
    }
    
    public void reverse(int [] arr, int start, int end){
        while(start < end)
        {
            arr[start] =  arr[start] + arr[end];
            arr[end] = arr[start] - arr[end];
            arr[start] = arr[start] - arr[end];
            start++;
            end++;
        }
    }

    public void rotate(int[] nums, int k) {
        if(nums.length == 0)
            return;
        
        int start = nums.length - 2 * k < 0 ? 0 : nums.length - 2 * k; 
        int end = nums.length - 1;
        
        while(end > 0){
            reverse(nums, start, end);
            end = end - k;
            start =  start - k < 0 ? 0 : start - k;
        }
        
    }
     
    public int[] plusOne(int[] digits) {
        //List<Integer> list = new ArrayList<Integer>();
        int carry = 1;
        for(int i = digits.length - 1 ; i>=0 && carry > 0; i--){
            digits[i] = digits[i] + carry;
            carry = digits[i]/10;
            digits[i] = digits[i]%10;
        }
        if(carry == 0){
            return digits;
        }else{
            int[] arr = new int[digits.length+1];
            arr[0] = carry;
            for(int i=0; i<digits.length; i++){
                arr[i+1] = digits[i];
            }
            return arr;
        }
    }
    public int longestCommonSubsequence(String text1, String text2) {
        
        int arr[][] = new int[text1.length()+1][text2.length()+1];
        
        for(int i=0; i<=text1.length();i++)
            arr[i][0] = 0;
        for(int i=0; i<=text2.length();i++)
            arr[0][i] = 0;
        
        for(int i=1; i<=text1.length(); i++){
            for(int j=1; j<=text2.length(); j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    arr[i][j] = 1 + arr[i-1][j-1];
                }else{
                    arr[i][j] = Integer.max(arr[i-1][j], arr[i][j-1]);
                }
            }
        }
        return arr[text1.length()][text2.length()];
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> hm.get(n1) - hm.get(n2));
        for (int key : hm.keySet()) {
            heap.add(key);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        List<Integer> ans = new ArrayList<Integer>();
        while (!heap.isEmpty()) {
            ans.add(heap.poll());
        }
        return ans;
    }

    public String convertToTitle(int n) {
        if (n == 0) {
            return "";
        }
        if (n <= 26) {
            String ans = 'A' + n + "";
            return ans;
        }
        int rem = n % 26;
        n = n / 26;
        String ans = convertToTitle(n);
        if (rem != 0) {
            ans = 'A' + rem + ans;
        }
        return ans;

    }

    public int power(int a, int b) {

        if (b == 0) {
            return 1;
        }
        if (b == 1) {
            return a;
        }
        if (b % 2 == 0) {
            return power(a * a, b / 2);
        } else {
            return a * power(a * a, b / 2);
        }

    }

    public int titleToNumber(String s) {

        int ans = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            ans = ans + power(26, s.length() - 1 - i) * (s.charAt(i) - 'A');
        }
        return ans;
    }

    public int coinChangeUtil(int[] coins, int amount) {

        if (amount < 0) {
            return Integer.MAX_VALUE;
        }
        if (amount == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int val = coinChangeUtil(coins, amount - coin);
            if (val != Integer.MAX_VALUE && val + 1 < min) {
                min = val + 1;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;

    }

    public int uniquePaths(int m, int n) {

        int arr[][] = new int[m][n];

        for (int i = 0; i < m; i++) {
            arr[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            arr[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = arr[i][j - 1] + arr[i - 1][j];
            }
        }
        return arr[m - 1][n - 1];

    }

    public int binarySearch(int arr[], int start, int end, int val) {

        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;
        if (arr[mid] == val) {
            return mid;
        } else if (arr[mid] > val) {
            return binarySearch(arr, start, mid - 1, val);
        } else {
            return binarySearch(arr, mid + 1, end, val);
        }

    }

    public int[] searchRange(int[] nums, int target) {

        int arr[] = new int[2];

        int mid = binarySearch(nums, 0, nums.length - 1, target);
        if (mid == -1) {
            arr[0] = arr[1] = -1;
            return arr;
        } else {
            int cur = mid;
            while (cur != -1) {
                arr[0] = cur;
                cur = binarySearch(nums, 0, cur - 1, target);
            }
            cur = mid;
            while (cur != -1) {
                arr[1] = cur;
                cur = binarySearch(nums, cur + 1, nums.length - 1, target);
            }
        }
        return arr;
    }

    public int findKthLargest(int[] nums, int k) {

        Queue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (heap.size() < k) {
                heap.add(nums[i]);
            } else {
                if (heap.peek() < nums[i]) {
                    heap.poll();
                    heap.add(nums[i]);
                }
            }
        }
        System.out.println(heap.toArray());
        return heap.peek();
    }

    public void kthSmallestUtil(TreeNode root, int k, int arr[]) {
        if (root == null) {
            return;
        }
        kthSmallestUtil(root.left, k, arr);
        k--;
        if (k == 0 && arr[0] == Integer.MIN_VALUE) {
            arr[0] = root.val;
        }
        kthSmallestUtil(root.right, k, arr);

    }

    public int kthSmallest(TreeNode root, int k) {
        int[] arr = new int[1];
        kthSmallestUtil(root, k, arr);
        return arr[0];
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lengthA = 0;
        int lengthB = 0;
        ListNode cur1 = headA;
        ListNode cur2 = headB;

        while (cur1 != null) {
            lengthA++;
            cur1 = cur1.next;
        }

        while (cur2 != null) {
            lengthB++;
            cur2 = cur2.next;
        }
        cur1 = headA;
        cur2 = headB;
        if (lengthA > lengthB) {
            int count = lengthA - lengthB;
            while (count > 0) {
                count--;
                cur1 = cur1.next;
            }
        } else {
            int count = lengthB - lengthA;
            while (count > 0) {
                count--;
                cur2 = cur2.next;
            }
        }
        while (cur1 != null && cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        return cur1;

    }

//    public Node connect(Node root) {
//
//        List<List<Node>> ans = new ArrayList<List<Node>>();
//        if (root == null) {
//            return root;
//        }
//
//        Queue<Node> tree = new LinkedList<Node>();
//        tree.add(root);
//        int count;
//        while (!tree.isEmpty()) {
//            List<Node> level = new ArrayList<>();
//            count = tree.size();
//            while (count != 0) {
//                count--;
//                Node presentNode = tree.poll();
//                level.add(presentNode);
//                if (presentNode.left != null) {
//                    tree.add(presentNode.left);
//                }
//                if (presentNode.right != null) {
//                    tree.add(presentNode.right);
//                }
//            }
//            ans.add(level);
//        }
//
//        for (List<Node> list : ans) {
//
//            Node prev = list.get(0);
//            for (int i = 1; i < list.size(); i++) {
//                prev.next = list.get(i);
//                prev = list.get(i);
//            }
//        }
//        return root;
//    }

    public List<List<Integer>> zigzagLevelOrderUtil(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> tree = new LinkedList<TreeNode>();
        tree.add(root);
        int count;
        while (!tree.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            count = tree.size();
            while (count != 0) {
                count--;
                TreeNode presentNode = tree.poll();
                level.add(presentNode.val);
                if (presentNode.left != null) {
                    tree.add(presentNode.left);
                }
                if (presentNode.right != null) {
                    tree.add(presentNode.right);
                }
            }
            ans.add(level);
        }

        return ans;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans;
        ans = zigzagLevelOrderUtil(root);
        int count = 0;
        for (List<Integer> list : ans) {
            if (count % 2 == 1) {
                Collections.reverse(list);
            }
            count++;
        }

        return ans;
    }

    public void inorderTraversalUtil(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorderTraversalUtil(root.left, list);
        list.add(root.val);
        inorderTraversalUtil(root.right, list);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        inorderTraversalUtil(root, list);
        return list;
    }

    public boolean canJump(int[] nums) {

        if (nums.length == 0) {
            return false;
        }
        boolean[] reach = new boolean[nums.length];
        if (nums[nums.length - 1] > 0) {
            reach[nums.length - 1] = true;
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] + i >= nums.length) {
                reach[i] = true;
            } else {
                for (int j = i + 1; j <= i + nums[i]; j++) {
                    if (reach[j] == true) {
                        reach[i] = true;
                        break;
                    }
                }
            }
        }
        return reach[0];
    }

    public ListNode oddEvenList(ListNode head) {

        if (head == null) {
            return head;
        }
        ListNode cur1, head1, cur2, head2, prev;
        cur1 = head1 = prev = head;
        cur2 = head2 = head.next;

        while (cur1 != null && cur2 != null) {
            prev = cur1;
            if (cur1.next != null) {
                cur1.next = cur1.next.next;
                cur1 = cur1.next;
            }
            if (cur2.next != null) {
                cur2.next = cur2.next.next;
                cur2 = cur2.next;
            }
        }
        prev.next = head2;
        return head1;

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carray = 0;
        ListNode head = null;
        ListNode cur = null;
        while (l1 != null || l2 != null || carray != 0) {
            int v1 = 0, v2 = 0;
            if (l1 != null) {
                v1 = l1.val;
            }
            if (l2 != null) {
                v2 = l2.val;
            }

            int sum = carray + v1 + v2;
            carray = sum / 10;
            sum = sum % 10;

            if (head == null) {
                head = cur = new ListNode(sum);
            } else {
                cur.next = new ListNode(sum);
                cur = cur.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return head;
    }

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            int req = -nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                if (nums[start] + nums[end] == req) {
                    List<Integer> l1 = new ArrayList<>();
                    l1.add(nums[i]);
                    l1.add(nums[start]);
                    l1.add(nums[end]);
                    ans.add(l1);
                    while (start + 1 < nums.length && nums[start] == nums[start + 1]) {
                        start++;
                    }
                    while (end - 1 >= 0 && nums[end] == nums[end - 1]) {
                        end--;
                    }

                } else if (nums[start] + nums[end] > req) {
                    end--;
                } else {
                    start++;
                }
            }
        }

        return ans;
    }

    public boolean increasingTriplet(int[] nums) {

        if (nums.length <= 2) {
            return false;
        }
        int[] incsubSeq = new int[nums.length];
        incsubSeq[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    if (max < incsubSeq[j] + 1) {
                        max = incsubSeq[j] + 1;
                    }
                }
            }
            incsubSeq[i] = max;
            if (max >= 3) {
                return true;
            }
        }
        return false;
    }

    public void setZero(int[][] matrix, int id, int rowcolflag) {
        if (rowcolflag == 1) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[id][i] = 0;
            }
        } else {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][id] = 0;
            }
        }
    }

    public void setZeroes(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;
        int[] arrayRow = new int[row * col];
        int[] arraycol = new int[row * col];
        int ind = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    arrayRow[ind] = i;
                    arraycol[ind] = j;
                    ind++;
                }
            }
        }

        for (int i = 0; i < ind; i++) {
            setZero(matrix, arrayRow[i], 1);
            setZero(matrix, arraycol[i], 0);
        }

    }

    public int lengthOfLongestSubstringUtil(String s, int start, HashMap<Character, Integer> hm) {

        for (int i = start; i < s.length(); i++) {
            if (hm.get(s.charAt(i)) != null) {
                return i;
            } else {
                hm.put(s.charAt(i), i);
            }
        }
        return s.length();

    }

    public boolean checkPalindrome(String s, int start, int end) {

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public String longestPalindromeUtil(String s, int start, int end, String[][] hm) {

        if (start > end) {
            return "";
        }

        if (start == end) {
            return s.charAt(start) + "";
        }

        if (!hm[start][end].isEmpty()) {
            return hm[start][end];
        }

        String ans = "";

        if (checkPalindrome(s, start, end)) {
            ans = s.substring(start, end + 1);
            hm[start][end] = ans;
            return ans;
        }

        String a = longestPalindromeUtil(s, start, end - 1, hm);
        String b = longestPalindromeUtil(s, start + 1, end, hm);

        if (a.length() > b.length()) {

            ans = a;
        } else {
            ans = b;
        }

        hm[start][end] = ans;
        return ans;

    }

    public String longestPalindrome(String s) {
        String[][] hm = new String[s.length()][s.length()];
        return longestPalindromeUtil(s, 0, s.length() - 1, hm);
    }

    public int lengthOfLongestSubstring(String s) {

        int ans = 0;

//        while (end < s.length()) {
//            HashMap<Character, Integer> hm = new HashMap<>();
//            end = lengthOfLongestSubstringUtil(s, start, hm);
//            if (ans < end - start) {
//                ans = end - start;
//            }
//            if(end != s.length()){
//                start = hm.get(s.charAt(end));
//            }else{
//                start = end;
//            }
//            
//        }
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0, j = 0; j < s.length(); j++) {

            if (hm.get(s.charAt(j)) != null) {
                i = Integer.max(hm.get(s.charAt(j)) + 1, i);
            }
            ans = Integer.max(ans, j - i + 1);
            hm.put(s.charAt(j), j);

        }

        return ans;
    }

    public int maxProfit(int[] prices) {

        int profit = 0;
        if (prices.length == 0) {
            return profit;
        }
        int buy = prices[0];
        int temp = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                profit = profit + prices[i - 1] - buy;
                buy = prices[i];
            }
        }
        if (prices[prices.length - 1] > buy) {
            profit = profit + prices[prices.length - 1] - buy;
        }
        return profit;
    }

    /**
     * // This is the BinaryMatrix's API interface. // You should not implement
     * it, or speculate about its implementation
     */
    interface BinaryMatrix {

        public int get(int x, int y);

        public List<Integer> dimensions();
    };

    public int checkOne(BinaryMatrix binaryMatrix, int x, int y, int row) {
        for (int i = x; i < row; i++) {
            if (binaryMatrix.get(i, y) == 1) {
                return i;
            }
        }
        return -1;
    }

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {

        List<Integer> l1 = binaryMatrix.dimensions();
        int row = l1.get(0);
        int column = l1.get(1);
        int start = 0;
        int end = column - 1;
        int res = -1;
        int begin = 0;

        while (start < end) {

            int mid = start + (end - start / 2);
            res = checkOne(binaryMatrix, begin, mid, row);
            if (res == -1) {
                start = mid + 1;
            } else {
                begin = res;
                end = mid;
            }

        }
        return res;

    }

    public TreeNode isValidBSTUtil(TreeNode root, int lr, boolean[] arr) {

        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        if (arr[0] == false) {
            return root;
        }

        TreeNode lmax = isValidBSTUtil(root.left, 0, arr);
        TreeNode rmin = isValidBSTUtil(root.right, 1, arr);

        if (!(lmax == null || lmax.val < root.val) && (rmin == null || rmin.val > root.val)) {
            arr[0] = false;
            return root;
        }
        if (lr == 0) {
            return rmin;
        } else {
            return lmax;
        }

    }

    public boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }
        boolean[] arr = new boolean[1];
        arr[0] = true;

        TreeNode lmax = isValidBSTUtil(root.left, 0, arr);
        TreeNode rmin = isValidBSTUtil(root.right, 1, arr);

        return ((lmax == null || lmax.val < root.val) && (rmin == null || rmin.val > root.val) && arr[0]);

    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Integer.max(maxDepth(root.left), maxDepth(root.right));
    }

    public int climbStairsUtil(int[] arr, int n) {

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            arr[1] = 1;
            return 1;
        }
        if (n == 2) {
            arr[2] = 2;
            return 2;
        }
        if (arr[n] != Integer.MIN_VALUE) {
            return arr[n];
        }
        int val1 = climbStairsUtil(arr, n - 1);
        int val2 = climbStairsUtil(arr, n - 2);
        arr[n] = val1 + val2;
        return arr[n];

    }

    public int climbStairs(int n) {
        int[] arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = Integer.MIN_VALUE;
        }
        return climbStairsUtil(arr, n);
    }

    public int maxSubArray(int[] nums) {

        int maxsum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (maxsum + nums[i] > nums[i]) {
                maxsum = maxsum + nums[i];
            } else {
                maxsum = nums[i];
            }
        }
        return maxsum;
    }

    public TreeNode bstFromPreorderUtil(int[] arr, int start, int end) {

        if (start > end) {
            return null;
        }

        TreeNode root = new TreeNode(arr[start]);
        int i;
        for (i = start + 1; i <= end; i++) {
            if (arr[i] > arr[start]) {
                break;
            }
        }
        root.left = bstFromPreorderUtil(arr, start + 1, i - 1);
        root.right = bstFromPreorderUtil(arr, i, end);
        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorderUtil(preorder, 0, preorder.length - 1);
    }

    public boolean isHappyUtil(Integer no, HashMap<Integer, Boolean> hm) {

        if (hm.get(no) != null) {
            return false;
        }
        hm.put(no, Boolean.TRUE);
        int sumno = 0;
        while (no > 0) {
            int digit = no % 10;
            no = no / 10;
            sumno = sumno + digit * digit;
        }
        if (sumno == 1) {
            return true;
        }
        return isHappyUtil(sumno, hm);

    }

    public boolean isHappy(int n) {
        HashMap<Integer, Boolean> hm = new HashMap<>();
        return isHappyUtil(n, hm);

    }

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> list = new ArrayList<>();
        HashMap<String, ArrayList<String>> hp = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] array = strs[i].toCharArray();
            Arrays.sort(array);
            String sortedStr = String.valueOf(array);
            if (hp.get(sortedStr) == null) {
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(strs[i]);
                hp.put(sortedStr, arrayList);
            } else {
                hp.get(sortedStr).add(strs[i]);
            }
        }

        for (ArrayList<String> arrayList : hp.values()) {
            list.add(arrayList);
        }

        return list;
    }

    void bfsTraversal(int[][] grid, int[][] dfsArray, int i, int j) {

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        if (j + 1 < grid[0].length && dfsArray[i][j] + grid[i][j + 1] < dfsArray[i][j + 1]) {
            dfsArray[i][j + 1] = dfsArray[i][j] + grid[i][j + 1];
            bfsTraversal(grid, dfsArray, i, j + 1);
        }
        if (i + 1 < grid.length && dfsArray[i][j] + grid[i + 1][j] < dfsArray[i + 1][j]) {
            dfsArray[i + 1][j] = dfsArray[i][j] + grid[i + 1][j];
            bfsTraversal(grid, dfsArray, i + 1, j);
        }

    }

    public int minPathSum(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
        int[][] bfsArray = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                bfsArray[i][j] = Integer.MAX_VALUE;
            }
        }
        bfsArray[0][0] = grid[0][0];
        bfsTraversal(grid, bfsArray, 0, 0);
        return bfsArray[row - 1][col - 1];
    }

    public void dfsTraversal(char[][] grid, int i, int j) {

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            dfsTraversal(grid, i + 1, j);
            dfsTraversal(grid, i - 1, j);
            dfsTraversal(grid, i, j + 1);
            dfsTraversal(grid, i, j - 1);
        }

    }

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    dfsTraversal(grid, i, j);
                }
            }
        }
        return count;
        /* no of islands */
    }

    public String shiftUtil(String s, int shift) {
        shift = shift % s.length();
        if (shift < 0) {
            shift = shift * -1;
        } else {
            shift = s.length() - shift;
        }

        String sub1 = s.substring(0, shift);
        String str2 = s.substring(shift, s.length());
        return str2 + sub1;

//        else{ /* we need to do right shift */
//            String sub1 = s.substring(0, s.length() - shift);
//            String str2 = s.substring(s.length() - shift, s.length());
//            return str2+sub1;
//        }
    }

    public String stringShift(String s, int[][] shift) {

        int right = 0;
        for (int i = 0; i < shift.length; i++) {
            if (shift[i][0] == 0) {
                right = right - shift[i][1];
            }
            if (shift[i][0] == 1) {
                right = right + shift[i][1];
            }
        }
        return shiftUtil(s, right);
    }

    public boolean checkValidString(String str, int index, int count) {

        if (str.length() == index) {
            return count == 0;
        }

        if (count < 0) {
            return false;
        }

        if (str.charAt(index) == '(') {
            return checkValidString(str, index + 1, count + 1);
        }

        if (str.charAt(index) == ')') {
            return checkValidString(str, index + 1, count - 1);
        }

        if (str.charAt(index) == '*') {
            return checkValidString(str, index + 1, count) || checkValidString(str, index + 1, count + 1) || checkValidString(str, index + 1, count - 1);
        }

        return false;

    }

    public boolean checkValidString(String s) {

        return checkValidString(s, 0, 0);

    }

    //
    public int[] productExceptSelf(int[] nums) {

        int product = 1;
        int len = nums.length;

        int[] res = new int[nums.length];
        int[] mul = new int[nums.length];
        int[] mulr = new int[nums.length];

        mul[0] = nums[0];
        mulr[nums.length - 1] = nums[nums.length - 1];

        for (int i = 1; i < nums.length; i++) {
            mul[i] = mul[i - 1] * nums[i];
            mulr[len - 1 - i] = mulr[len - i] * nums[len - 1 - i];
        }

        for (int i = 0; i < nums.length; i++) {
            product = 1;
            if (i - 1 >= 0) {
                product = mul[i - 1];
            }
            if (i + 1 <= len - 1) {
                product = product * mulr[i + 1];
            }

            res[i] = product;
        }

        return res;
    }

    //day 13
    public int findMaxLength(int[] nums) {

        HashMap<Integer, Integer> hm = new HashMap<>();
        int res = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {
                count--;
            } else {
                count++;
            }

            if (count == 0) {
                if (res < i + 1) {
                    res = i + 1;
                }
            } else {
                if (hm.get(count) != null) {
                    if (i - hm.get(count) > res) {
                        res = i - hm.get(count);
                    }

                } else {
                    hm.put(count, i);
                }
            }

        }

        return res;

    }

    //day 12
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < stones.length; i++) {
            pq.add(stones[i]);
        }

        int x = 0, y = 0;

        while (!pq.isEmpty()) {
            x = pq.poll();
            if (pq.isEmpty()) {
                break;
            } else {
                y = pq.poll();
            }

            if (x == y) {
                x = y = 0;
            } else {
                x = x - y;
            }

            pq.add(x);

        }

        return x;

    }

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //day 11 
    public int diameterOfBinaryTree(TreeNode t, int[] ans) {

        if (t == null) {
            return 0;
        }

        int left = diameterOfBinaryTree(t.left, ans);
        int right = diameterOfBinaryTree(t.right, ans);

        if (ans[0] < left + right + 1) {
            ans[0] = left + right + 1;
        }

        if (left < right) {
            return left + 1;
        }
        return right + 1;

    }

    public int diameterOfBinaryTree(TreeNode root) {

        int[] arr = new int[0];
        arr[0] = 0;

        diameterOfBinaryTree(root, arr);

        return arr[0];

    }

    public ListNode middleNode(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode mid = head;
        int count = 1;
        ListNode tail = head.next;

        while (tail != null) {

            mid = mid.next;
            count++;
            tail = tail.next;
            if (tail != null) {
                tail = tail.next;
            }

        }

        if (count % 2 == 0) {
            return head.next;
        }
        return head;

    }

    public String getString(String S) {

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '#') {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else {
                st.push(S.charAt(i));
            }
        }

        String str = "";
        while (!st.isEmpty()) {
            str = str + st.pop();
        }
        return str;
    }

    public boolean backspaceCompare(String S, String T) {

        String str1 = getString(S);
        String str2 = getString(T);

        if (str1.equals(str2)) {
            return true;
        }
        return false;
    }

    public void moveZeroes(int[] nums) {

        int startIndex = 0;
        int endIndex = 0;

        while (endIndex < nums.length) {

            while (endIndex < nums.length && nums[endIndex] == 0) {
                endIndex++;
            }
            if (endIndex == nums.length) {
                break;
            } else {

                nums[startIndex] = nums[endIndex];
                nums[endIndex] = 0;
                startIndex++;
                endIndex++;
            }

        }

    }

    public int countElements(int[] arr) {

        int res = 0;
        Arrays.sort(arr);
        int count = 1;
        for (int i = 0; i < arr.length - 1; i++) {

            if (arr[i] == arr[i + 1]) {
                count++;
            } else {

                if (arr[i] == arr[i + 1]) {
                    res = res + count;
                }
                count = 1;
            }
        }
        return res;
    }

}

class MinStack {

    /**
     * initialize your data structure here.
     */
    Stack<Integer> st;
    Stack<Integer> minst;

    public MinStack() {

        st = new Stack<Integer>();
        minst = new Stack<Integer>();

    }

    public void push(int x) {
        st.push(x);
        if (minst.isEmpty() || minst.peek() >= x) {
            minst.push(x);
        }
    }

    public void pop() {

        if (st.isEmpty()) {
            return;
        }
        if (st.peek().intValue() == minst.peek().intValue()) {
            minst.pop();
        }
        st.pop();

    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return minst.peek();
    }

}

class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
