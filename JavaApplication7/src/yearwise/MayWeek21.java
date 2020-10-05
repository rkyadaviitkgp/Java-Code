/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yearwise;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author rajeshkumar.yadav
 */





class Shuffle {

    int[] arr;
    int[] arrReset;
    Random random;

    public Shuffle(int[] nums) {
        this.arr = nums;
        arrReset = new int[nums.length];
        for (int i = 0; i < arrReset.length; i++) {
            arrReset[i] = arr[i];
        }
        random = new Random();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {

        return arrReset;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {

        for (int i = 0; i < arr.length; i++) {
            int ind = random.nextInt(arr.length - i);
            int val = arr[ind];
            arr[ind] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = val;
        }
        return arr;
    }
}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


class Data {
    
    int val;
    Stack<Long> instant;
    int count ;
    
    public Data(int val){
        this.val = val;
        instant = new Stack();
        instant.push(System.nanoTime());
        count = 0;
    }
    
}
class FreqStack {

    HashMap<Integer, Data> hm;
    PriorityQueue<Data> pq;
    public FreqStack() {
        hm = new HashMap<>();
        pq = new PriorityQueue<>((o1, o2) -> {
            if(hm.get(o2.val).count > hm.get(o1.val).count)
                return 1;
            if(hm.get(o2.val).count < hm.get(o1.val).count)
                return -1;
            if(hm.get(o2.val).instant.peek() - hm.get(o1.val).instant.peek() > 0)
                return 1;
            if(hm.get(o2.val).instant.peek() - hm.get(o1.val).instant.peek() < 0)
                return -1;
            return 0;
            
        });
    }
    
    public void push(int x) {
        Data val = hm.getOrDefault(x, new Data(x));
        val.count++;
        val.instant.push(System.nanoTime());
        hm.put(x, val);
        if(pq.contains(val))
            pq.remove(val);
        pq.add(val);
        //System.out.println("push : "  + val.val );
    }
    
    public int pop() {
        Data val = pq.poll();
        val.count--;
        val.instant.pop();
        if(val.count > 0){
            //hm.put(val, c);
            pq.add(val);
        }
        //System.out.println("pop : "  + val.val );
        return val.val;
    }
}

public class MayWeek21 {

    public static void main(String[] args) {
//        int arr[][] = {
//            {1, 4, 7, 11, 15},
//            {2, 5, 8, 12, 19},
//            {3, 6, 9, 16, 22},
//            {10, 13, 14, 17, 24},
//            {18, 21, 23, 26, 30}
//        };
       // int[][] arr = {{1, 2}, {3, 2}, {3, 4}, {5, 4}, {5, 1}};

        MayWeek21 week21 = new MayWeek21();
//        
//        FreqStack fs = new FreqStack();
//        fs.push(5);
//        fs.push(7);
//        fs.push(5);
//        fs.push(7);
//        fs.push(4);
//        fs.push(5);
//        fs.pop();
//        fs.pop();
//        fs.pop();
//        fs.pop();
//apo agm afk aei adc alb ahn aja
        System.out.println("hi " +  " " + week21.hasAllCodes("00110",2));
    }
    
    public String add(String str){
        
        int len = str.length()-1;
        char carry = '1';
        StringBuffer strbf = new StringBuffer(str);
        strbf.reverse();
        StringBuffer sb = new StringBuffer();
        int i;
        for(i=0; i<strbf.length(); i++){
           
            if(strbf.charAt(i) == '1' && carry == '1'){
                sb.append('0');
            }else{
                sb.append(carry);
                sb.append(strbf.substring(i+1, strbf.length()));
                break;
            }
        }
        if(i>=strbf.length())
            sb.append(carry);
            
       
        return sb.reverse().toString();
    }
    
    public boolean hasAllCodes(String s, int k) {
        
        int count = 0;
        String code = "";
        int c = 1;
        while(k > 0){
            k--;
            c = c * 2;
            code = code + "0";
        }
        System.out.println(c);
        while(count < c){
            System.out.println(code);
            if(s.indexOf(code) == -1)
                return false;
            count++;
            code =  add(code);
        }
        return true;
    }
    
    public boolean canBeEqual(int[] target, int[] arr) {
        HashMap<Integer, Boolean> hm = new HashMap<>();
        for(int i=0; i<target.length; i++){
            hm.put(target[i], true);
        }
        for(int i=0; i<arr.length; i++){
            if(!hm.containsKey(arr[i]))
                return false;
        }
        return true;
    }
    
    public String reorganizeStringUtil(String s, int k) {

        HashMap<Character, Integer> hm = new HashMap<>();
        for (char c : s.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
            
            if (hm.get(c) > (s.length() + 1)/k ) {
                return "";
            }
            //System.out.println(hm.get(c) + " " + ((s.length())/k + 1) + " " + s.length());
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((o1, o2) -> hm.get(o2) - hm.get(o1));
        for (char c : hm.keySet()) {
            pq.add(c);
        }
        StringBuffer sb = new StringBuffer();
        while (!pq.isEmpty()) {
            char[] arr = new char[k];
            int count = 0;
            while (!pq.isEmpty() && count < k) {
                arr[count] = pq.poll();
                hm.put(arr[count], hm.get(arr[count]) - 1);
                sb.append(arr[count]);
                count++;
            }
            for(int i=0; i<count; i++){
                if(hm.get(arr[i]) > 0)
                    pq.add(arr[i]);
            }
        }
        return sb.toString();

    }
    
    public String reorganizeString(String S) {
        String s = reorganizeStringUtil(S, 3);
        return s;
    }
    
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        
        long curLocation = startFuel;
        int count = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o2[1] - o1[1]);
        int index = 0;
        while(curLocation < target){
            
            while(index < stations.length && stations[index][0] <= curLocation){
                pq.add(stations[index]);
                index++;
            }
            if(pq.isEmpty()){
                return -1;
            }
            int[] temp = pq.poll();
            curLocation = curLocation + temp[1];
            count++;
        }
        return count;
//        HashMap<Integer, HashMap<Long, Integer>> arr = new HashMap<>();
//        return minRefuelStopsUtil(target, startFuel, 0, stations, arr);
        
    }
    
    public int minRefuelStopsUtil(int target, long curLocation, int index, int[][] stations, 
        HashMap<Integer, HashMap<Long, Integer>> arr) {
  
        int res;
        if(curLocation >= target)
            return 0;
        if(index >= stations.length )
            return -1;
//        if(arr[curLocation][index] != 0)
//            return arr[curLocation][index];
        if(arr.containsKey(index)){
            if(arr.get(index).containsKey(curLocation))
                return arr.get(index).get(curLocation);
        }
        if(curLocation < stations[index][0])
            return -1;
        int a = minRefuelStopsUtil(target, curLocation + stations[index][1], index+1, stations, arr);
        int b = minRefuelStopsUtil(target, curLocation , index+1, stations, arr);
        if(a == -1 && b == -1)
            res =  a;
        else if(a == -1)
            res =  b;
        else if(b == -1)
            res =  a + 1;
        else 
            res =  Math.min(a+1, b);
        if(arr.containsKey(index)){
            arr.get(index).put(curLocation, res);
        }else{
            HashMap<Long, Integer> hm = new HashMap<>();
            hm.put(curLocation, res);
            arr.put(index, hm);
        }
        //arr[curLocation][index] = res;
        return res;
    }
    
    public void countCharacterOccurance(String str, int arr[]){
        for(char c : str.toCharArray()){
            arr[c - 'a']++;
        }
    }
    
    public List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<>();
        if(A.length == 0)
            return result;
        int[] ans = new int[26];
        
        countCharacterOccurance(A[0], ans);
        for(int i=1; i<A.length; i++){
            int[] temp = new int[26];
            countCharacterOccurance(A[i], temp);
            for(int k=0; k<26; k++)
                ans[k] = Math.min(ans[k], temp[k]);
        }
        for(char c = 'a'; c<='z'; c++)
            if(ans[c - 'a'] > 0)
                result.add(c + "");
        return result;
    }
    
    public int[][] kClosest(int[][] points, int K) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[0]*o2[1] - o1[0]*o1[1]);
        
        for(int i=0; i<points.length; i++){
            pq.add(points[i]);
            if(pq.size() > K)
                pq.poll();
        }
        int arr[][] = new int[K][2];
        for(int i=0; i<K; i++)
            arr[i] = pq.poll();
        return arr;
    }
    
     public boolean dfs(char[][] board, int row, int col, int index, String str, int arr[][]){
        
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length)
            return false;
        if(arr[row][col] == 1)
            return false;
        
        if(index >= str.length())
            return true;
        
        if(board[row][col] != str.charAt(index))
            return false;
        arr[row][col] = 1;
        
        return dfs(board, row+1, col, index+1, str, arr) ||  dfs(board, row-1, col, index+1, str, arr) || dfs(board, row, col+1, index+1, str, arr) ||  dfs(board, row, col-1, index+1, str, arr);  

    }
     
    
    public List<String> findWords(char[][] board, String[] words) {
        
        HashMap<Character, List<String>> hm = new HashMap<>();
        for(int i=0; i<words.length; i++){
            hm.getOrDefault(words[i].charAt(0), new ArrayList<String>()).add(words[i]);
        }
        List<String> ans = new ArrayList<>();
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(hm.containsKey(board[i][j])){
                    List<String> l = hm.get(board[i][j]);
                    System.out.println(l);
                    for(int k=0; k<l.size(); k++){
                        int arr[][]  = new int[board.length][board[0].length];
                        if(dfs(board, i, j, 0, l.get(k), arr)){
                            ans.add(l.get(k));
                            l.remove(k);
                        }
                    }
                }
            }
        }
        return ans;
    }
    
     public List<String> wordBreak(List<String> list, String str, int startIndex, List<String> wordDict, HashMap<Integer, List<String>> hm) {
        List<String> retList = new ArrayList<>();
        if(hm.get(startIndex) != null)
            return hm.get(startIndex);
        if(startIndex >= str.length())
            return retList;
        for(int i=startIndex+1; i<=str.length(); i++){
            String subStr = str.substring(startIndex, i);
            String f = "";
            if(wordDict.contains(subStr)){
                if(i == str.length())
                {
                    retList.add(subStr);
                    hm.put(startIndex, retList);
                    return retList;
                }
                List<String> rettemp = wordBreak(list, str, i, wordDict, hm);
                for(int indk = 0; indk < rettemp.size(); indk++){
                                f = subStr + " " + rettemp.get(indk);
                                retList.add(f);
                }
            }
        }
        hm.put(startIndex, retList);
        return retList;
    }
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> l = new ArrayList<>();
        HashMap<Integer, List<String>> hm = new HashMap<>();
        for(int i=0; i<s.length(); i++)
            hm.put(i, null);
        wordBreak(l, s, 0, wordDict, hm);
        return hm.get(0);
    }

    public List<Integer> spiralOrder(int[][] matrix) {

        
        List<Integer> spiralTraversal = new ArrayList<>();
        if (matrix.length == 0) {
            return spiralTraversal;
        }
        int startRow = 0;
        int endRow = matrix.length - 1;
        int startCol = 0;
        int endCol = matrix[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {

            for (int i = startCol; i <= endCol; i++) {
                spiralTraversal.add(matrix[startRow][i]);
            }
            startRow++;

            for (int i = startRow; i <= endRow; i++) {
                spiralTraversal.add(matrix[i][endCol]);
            }
            endCol--;
            
            if(endRow >= startRow)
            for (int i = endCol; i >= startCol; i--) {
                spiralTraversal.add(matrix[endRow][i]);
            }
            endRow--;
            
            if(startCol <= endCol)
            for (int i = endRow; i >= startRow; i--) {
                spiralTraversal.add(matrix[i][startCol]);
            }
            startCol++;
            
        }
        return spiralTraversal;
    }

    public double myPowUtil(double x, int n) {

        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        double a = myPowUtil(x, n / 2);
        if (n % 2 != 0) {
            return a * a * x;
        }
        return a * a;

    }

    public double myPow(double x, int n) {

        Double val = myPowUtil(x, n);
        if (n >= 0) {
            return val;
        }
        return 1 / val;

    }

    public int maxProfit(int[] prices) {

        int len = prices.length;
        int[] profit = new int[len];
        profit[len - 1] = 0;
        for (int i = len - 2; i >= 0; i--) {

            int max = profit[i + 1];
            for (int j = i + 1; j < len; j++) {
                if (prices[j] >= prices[i]) {
                    int curProfit = prices[j] - prices[i] + (j + 2 < len ? profit[j + 2] : 0);
                    if (max < curProfit) {
                        max = curProfit;
                    }
                }
            }
            profit[i] = max;
        }
        return profit[0];
    }

    public boolean possibleBipartition(int N, int[][] dislikes) {

        if (dislikes.length == 0) {
            return true;
        }
        Set<Integer> setA = new HashSet<Integer>();
        Set<Integer> setB = new HashSet<Integer>();

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < dislikes.length; i++) {
            q.add(dislikes[i]);
        }
        int[] arr = q.poll();
        setA.add(arr[0]);
        setB.add(arr[1]);
        while (!q.isEmpty()) {
            int n = q.size();
            int i = 0;
            int count = 0;
            while (i < n) {
                arr = q.poll();
                if ((setA.contains(arr[0]) && setA.contains(arr[1])) || (setB.contains(arr[1]) && setB.contains(arr[0]))) {
                    return false;
                }
                if (setA.contains(arr[0]) || setB.contains(arr[1])) {
                    setA.add(arr[0]);
                    setB.add(arr[1]);
                    count++;
                } else if (setB.contains(arr[0]) || setA.contains(arr[1])) {
                    setA.add(arr[1]);
                    setB.add(arr[0]);
                    count++;
                } else {
                    q.add(arr);
                }
                i++;
            }
            if (count == 0 && !q.isEmpty()) {
                setA.clear();
                setB.clear();
                arr = q.poll();
                setA.add(arr[0]);
                setB.add(arr[1]);
            }
        }
        return true;

    }
//    public int maxRobWithoutRoot(TreeNode root){
//        
//        if(root == null)
//            return 0;
//        
//        return  maxRobWithRoot(root.left) + maxRobWithRoot(root.right);
//        
//    }

    public int jump(int[] nums) {

        int[] jumpArr = new int[nums.length];
        jumpArr[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {

            int min = nums.length;
            for (int j = i + 1; j <= i + nums[i] && j < nums.length; j++) {
                if (min > jumpArr[j]) {
                    min = jumpArr[j];
                }
            }
            jumpArr[i] = 1 + min;
        }
        return jumpArr[0];
    }

    public int kthSmallest(int[][] matrix, int k) {

        int arr[] = new int[matrix[0].length];
        int n = matrix.length;
        int m = matrix[0].length;
        int i;
        int val = 0;
        while (k != 0) {
            k--;
            int min = 0;
            for (i = 0; i < n; i++) {
                if (arr[i] < m && matrix[i][arr[i]] < matrix[min][arr[min]]) {
                    min = i;
                }
            }
            val = matrix[i][arr[i]];
            arr[i]++;
        }
        return val;
    }

    public void dfs(char[][] board, int[][] arr, int row, int col) {

        if (row >= board.length || row < 0 || col < 0 || col >= board[0].length) {
            return;
        }
        if (arr[row][col] == 1 || board[row][col] == 'X') {
            return;
        }

        arr[row][col] = 1;
        dfs(board, arr, row + 1, col);
        dfs(board, arr, row - 1, col);
        dfs(board, arr, row, col + 1);
        dfs(board, arr, row, col - 1);
    }

    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        int n = board.length;
        int m = board[0].length;
        int[][] arr = new int[n][m];
        for (int i = 0; i < m; i++) {
            if (board[0][i] == 'O' && arr[0][i] == 0) {
                dfs(board, arr, 0, i);
            }
            if (board[n - 1][i] == 'O' && arr[n - 1][i] == 0) {
                dfs(board, arr, n - 1, i);
            }
        }
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O' && arr[i][0] == 0) {
                dfs(board, arr, i, 0);
            }
            if (board[i][m - 1] == 'O' && arr[i][m - 1] == 0) {
                dfs(board, arr, i, m - 1);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != 1) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public int maxUncrossedLinesUtil(int[] a, int[] b, int aind, int bind) {

        int i;
        for (i = bind; i >= 0; i--) {
            if (a[aind] == b[i]) {
                break;
            }
        }
        if (i >= 0) {
            return Math.max(1 + maxUncrossedLinesUtil(a, b, aind - 1, i - 1), maxUncrossedLinesUtil(a, b, aind - 1, bind));
        }
        return maxUncrossedLinesUtil(a, b, aind - 1, bind);
    }

    public int maxUncrossedLines(int[] A, int[] B) {
        int[][] arr = new int[A.length][B.length];
        //for(int i=0; i<arr.length; i++)
        Arrays.fill(A, -1);
        return maxUncrossedLinesUtil(A, B, A.length - 1, B.length - 1);
    }

    public int maxRobWithRoot(TreeNode root) {

        if (root == null) {
            return 0;
        }

        TreeNode l = root.left;
        TreeNode r = root.right;
        int a = root.val;
        if (l != null) {
            a = a + maxRobWithRoot(l.left) + maxRobWithRoot(l.right);
        }
        if (r != null) {
            a = a + maxRobWithRoot(r.left) + maxRobWithRoot(r.right);
        }
        return Math.max(a, maxRobWithRoot(l) + maxRobWithRoot(r));
        //return root.val + maxRobWithoutRoot(root.left) + maxRobWithoutRoot(root.right);

    }

    public int rob(TreeNode root) {
//        return Math.max(maxRobWithRoot(root), maxRobWithoutRoot(root));
        return maxRobWithRoot(root);
    }

    public void rotateByNightyDegree(int[][] matrix) {

        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;
        //int count = (matrix.length + 1) / 2;
        while (rowStart <= rowEnd) {
            for (int i = 0; i < colEnd - colStart; i++) {

                int a = matrix[rowStart + i][colEnd];
                matrix[rowStart + i][colEnd] = matrix[rowStart][colStart + i];
                int b = matrix[rowEnd][colEnd - i];
                matrix[rowEnd][colEnd - i] = a;
                a = matrix[rowEnd - i][colStart];
                matrix[rowEnd - i][colStart] = b;
                matrix[rowStart][colStart + i] = a;

            }
            //count--;
            colStart++;
            rowStart++;
            colEnd--;
            rowEnd--;
        }

    }

    public void rotateByAngle(int[][] matrix, int angle) {
        if (angle % 90 != 0) {
            System.out.println("Invalid Angle Input");
            return;
        }
        int count = angle / 90;
        count = count % 4;
        for (int i = 0; i < count; i++) { // each rotaion is of 90 
            rotateByNightyDegree(matrix);
        }
    }

    public void rotate(int[][] matrix) {
        rotateByAngle(matrix, 90);
    }

    public void combinationSumUtil(int[] candidates, int target, List<List<Integer>> ans, List<Integer> list, HashMap<String, Boolean> hm) {

        if (target == 0) {
            List<Integer> l = new ArrayList<>(list);
            l.sort((o1, o2) -> o1 - o2);
            if (!hm.containsKey(l.toString())) {
                hm.put(l.toString(), Boolean.TRUE);
                ans.add(l);
            }
            return;
        }

        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                list.add(candidates[i]);
                combinationSumUtil(candidates, target - candidates[i], ans, list, hm);
                list.remove(list.size() - 1);
            }
        }

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> list = new ArrayList<>();
        HashMap<String, Boolean> hm = new HashMap<>();
        combinationSumUtil(candidates, target, list, new ArrayList<>(), hm);
        return list;

    }

    public int maximalSquare(char[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;
        int maxSquare[][] = new int[n + 1][m + 1];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (matrix[i][j] == 1) {
                    if (matrix[i - 1][j - 1] == 1) {
                        maxSquare[i][j] = Math.min(Math.min(maxSquare[i - 1][j - 1], maxSquare[i][j - 1]), maxSquare[i - 1][j]) + 1;
                        if (maxSquare[i][j] > max) {
                            max = maxSquare[i][j];
                        }
                    }
                }
            }
        }
        return max;
    }

    public int columnBinarySearch(int[][] arr, int col, int start, int end, int val) {

        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (mid > start && arr[mid][col] > val && arr[mid - 1][col] <= val) {
            return mid - 1;
        }
        if (mid < end && arr[mid][col] <= val && arr[mid + 1][col] > val) {
            return mid;
        }

        if (arr[mid][col] == val) {
            return mid;
        }

        if (arr[mid][col] > val) {
            return columnBinarySearch(arr, col, start, mid - 1, val);
        }
        return columnBinarySearch(arr, col, mid + 1, end, val);

    }

    public int rowBinarySearch(int[][] arr, int row, int start, int end, int val) {

        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (arr[row][mid] == val) {
            return mid;
        }

        if (arr[row][mid] > val) {
            return rowBinarySearch(arr, row, start, mid - 1, val);
        }
        return rowBinarySearch(arr, row, mid + 1, end, val);

    }

    public boolean searchMatrix(int[][] matrix, int target) {

        int startRow = 0;
        int endRow = matrix.length - 1;
        int col = 0;
        while (col < matrix[0].length) {

            int ind = columnBinarySearch(matrix, col, startRow, endRow, target);
            if (ind != -1) {
                endRow = ind;
                int ans = rowBinarySearch(matrix, endRow, col, matrix[0].length - 1, target);
                if (ans != -1) {
                    return true;
                }
            }
            col++;
        }
        return false;
    }

}
