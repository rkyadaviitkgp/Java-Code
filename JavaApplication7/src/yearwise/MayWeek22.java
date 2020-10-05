/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yearwise;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author rajeshkumar.yadav
 */

class WeightPick {
    
    int arr[];
    Random random ;

    public WeightPick(int[] w) {
        random = new Random();
        if(w.length == 0)
            return;
        arr = new int[w.length];
        arr[0] = w[0];
        for(int i=1; i<w.length; i++){
            arr[i] = arr[i-1] + w[i];
        }
    }
    
    private int binarySearch(int start, int end, int val){
        
        if(start > end)
            return 0;
        int mid = start + (end-start)/2;
        if(arr[mid] == val)
            return mid;
        if(mid+1 <= end && arr[mid] <  val && arr[mid+1] > val)
            return mid + 1;
        if(mid - 1 >= start && arr[mid] > val && arr[mid-1] < val)
            return mid;
        if(arr[mid] > val)
            return binarySearch(start, mid-1, val);
        return binarySearch(mid+1, end, val);
        
    }
    
    public int pickIndex() {
        int val = random.nextInt(arr[arr.length] + 1);
        return binarySearch(0, arr.length-1, val);
    }
}

public class MayWeek22 {

    public static void main(String[] args) {

        MayWeek22 may22 = new MayWeek22();
        int[] nums = {3, 2, 1, 6, 0, 5,7,8};
        System.out.println(may22.shuffle(nums,nums.length));
        for(int i=0; i<nums.length; i++)
            System.out.println(nums[i] + " ");

    }
    
    public int[][] reconstructQueue(int[][] people) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
        if(a[0] == b[0])
            return a[1] - b[1];
        return a[0] - b[0];
        });
        
        int[][] res = new int[people.length][2];
        for(int i=0; i<people.length; i++)
            Arrays.fill(res[i], -1);
        
        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            int count = temp[1];
            for(int i=0; i<people.length; i++){
                if(count == 0){
                    res[i] = temp;
                    break;
                }
                if(res[i][1] == -1){
                    count--;
                }
            }
        }
        return res;
    }
    
    
    public void shuffle(int[] nums, int start, int end) {
        
        int size = end - start + 1;
        if(size <= 2)
            return ;
        int beginInd = start + size/4;
        int endInd = start + size/2;
        int i = 0;
        while(beginInd + i < endInd){
            int a = nums[beginInd + i];
            nums[beginInd + i] = nums[endInd + i];
            nums[endInd + i] = a;
            i++;
        }
        
        shuffle(nums, start, endInd - 1);
        shuffle(nums, endInd, end);
        
    }
    
    public int[] shuffle(int[] nums, int n) {
        shuffle(nums, 0, nums.length-1);
        return nums;
    }
    
    public int[] getStrongest(int[] arr, int k) {
     
        int size = arr.length;
        Arrays.sort(arr);
        int median = arr[size/2];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
            if(Math.abs(a-median) == Math.abs(b - median))
            {
                return b - a;
            }
            return Math.abs(b - median) - Math.abs(a-median);
        });
        for(int i=0; i<arr.length; i++)
            pq.add(arr[i]);
        int res[] = new int[k];
        int i = 0;
        while(!pq.isEmpty()){
            res[i++] = pq.poll();
            if(i == k)
                break;
        }
        return res;
        
    }
    
    public int cost(int arr[][], int index, int countA, int countB, int cost){
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((b,a) -> ((Math.abs(a[0] - a[1])) - (Math.abs(b[0] - b[1]))));
        for(int i=0; i<arr.length; i++)
            pq.add(arr[i]);
        while(!pq.isEmpty()){
            int item[] = pq.poll();
            int min = 0;
            if(item[0] < item[1]){
                if(countA < arr.length/2){
                    countA++;
                    cost = cost + item[0];
                }else{
                    countB++;
                    cost = cost + item[1];
                }
            }else{
                if(countB < arr.length/2){
                    countB++;
                    cost = cost + item[1];
                }else{
                    countA++;
                    cost = cost + item[0];
                }
            }
        }
        return cost;
    }
    
    public int twoCitySchedCost(int[][] costs) {
        
        return cost(costs, 0, 0, 0, 0);
        
    }

    public boolean hasAllCodes(String s, int k) {

        if (s.length() < k) {
            return false;
        }
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < s.length() - k; i++) {
            set.add(s.substring(i, i + k));
        }
        return set.size() == 1 << k;

    }

    public TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {

        if (start > end) {
            return null;
        }

        int max = start;
        for (int i = start; i <= end; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        TreeNode root = new TreeNode(nums[max]);
        root.left = constructMaximumBinaryTree(nums, start, max - 1);
        root.right = constructMaximumBinaryTree(nums, max + 1, end);
        return root;

    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    public int dfs(int[][] matrix, int row, int col, int[][] arr, int[][] visit) {

        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length) {
            return 0;
        }

        if (visit[row][col] == 1) {
            return 0;
        }

        if (arr[row][col] != -1) {
            return arr[row][col];
        }

        visit[row][col] = 1;

        int a = 0, b = 0, c = 0, d = 0;
        if (row + 1 < matrix.length && matrix[row][col] < matrix[row + 1][col]) {
            a = 1 + dfs(matrix, row + 1, col, arr, visit);
        }
        if (row - 1 >= 0 && matrix[row][col] < matrix[row - 1][col]) {
            b = 1 + dfs(matrix, row - 1, col, arr, visit);
        }
        if (col + 1 < matrix[0].length && matrix[row][col] < matrix[row][col + 1]) {
            c = 1 + dfs(matrix, row, col + 1, arr, visit);
        }
        if (col - 1 >= 0 && matrix[row][col] < matrix[row][col - 1]) {
            d = 1 + dfs(matrix, row, col - 1, arr, visit);
        }

        visit[row][col] = 0;
        arr[row][col] = 1 + Math.max(a, Math.max(b, Math.max(c, d)));
        return arr[row][col];
    }

    public int longestIncreasingPath(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;
        int arr[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(arr[i], -1);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int[][] visit = new int[row][col];
                dfs(matrix, i, j, arr, visit);
            }
        }
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (max < arr[i][j]) {
                    max = arr[i][j];
                }
            }
        }
        return max;
    }
    
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        
        int res = 0;
        int gasSum = 0;
        int costSum = 0;
        for(int i=0; i<gas.length; i++){
            
            gasSum += gas[i];
            costSum += cost[i];
            if(costSum > gasSum)
                res = i+1;
            
        }
        if(costSum > gasSum)
            return -1;
        return res;
    }

    public int minDistance(String word1, String word2, int ind1, int ind2) {

        if (ind1 >= word1.length() && ind2 >= word2.length()) {
            return 0;
        }
        if (ind2 >= word2.length()) {
            return 1 + minDistance(word1, word2, ind1 + 1, ind2);
        }
        if (word1.charAt(ind1) == word2.charAt(ind2)) {
            return minDistance(word1, word2, ind1 + 1, ind2 + 1);
        }
        int a = 1 + minDistance(word1, word2, ind1, ind2 + 1); // insert case
        int b = 1 + minDistance(word1, word2, ind1 + 1, ind2); //delete case
        int c = 1 + minDistance(word1, word2, ind1 + 1, ind2 + 1);
        return Math.min(a, Math.min(b, c));
    }

    public int minDistance(String word1, String word2) {
        return minDistance(word1, word2, 0, 0);
    }

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {

        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int horizontalMax = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length - 1]);
        for (int i = 1; i < horizontalCuts.length; i++) {
            horizontalMax = Math.max(horizontalMax, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        int verticalMax = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length - 1]);
        for (int i = 1; i < verticalCuts.length; i++) {
            verticalMax = Math.max(verticalMax, verticalCuts[i] - verticalCuts[i - 1]);
        }
        long ans = horizontalMax * verticalMax;
        ans = ans % 1000000007;
        return (int) ans;
    }

    public int maxProduct(int[] nums) {

        int arr[] = new int[4];

        if (nums[0] > nums[1]) {
            arr[0] = arr[3] = nums[0];
            arr[1] = arr[2] = nums[1];
        } else {
            arr[0] = arr[3] = nums[1];
            arr[1] = arr[2] = nums[0];
        }
        System.out.println(arr[0] + " " + arr[1] + " " + arr[2] + " " + arr[3]);
        for (int i = 0; i < nums.length; i++) {
            if (arr[0] < nums[i]) {
                arr[1] = arr[0];
                arr[0] = nums[i];
            } else if (arr[1] < nums[i]) {
                arr[1] = nums[i];
            }
            if (arr[2] > nums[i]) {
                arr[3] = arr[2];
                arr[2] = nums[i];
            } else if (arr[3] > nums[i]) {
                arr[3] = nums[i];
            }
        }
        System.out.println(arr[0] + " " + arr[1] + " " + arr[2] + " " + arr[3]);
        return Math.max((arr[0] - 1) * (arr[1] - 1), (arr[2] - 1) * (arr[3] - 1));

    }

}
