/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rajeshkumar.yadav
 */
public class Solution1 {
    
    
    
    public int findUnsortedSubarray(int[] nums) {
        
        int stratInd = 0;
        int endInd = nums.length;
        
        return 0;
    }
    
    public int orangesRotting(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        int count  = 0;
        for(int i=0; i<n; i++)
        {
            for(int j=m; j<m; j++)
            {
                if(grid[i][j] >= 2)
                {
                    if(i-1>=0)
                    {
                        if(grid[i-1][j] > 1)
                        {
                            if(grid[i][j] + 1 < grid[i-1][j])
                            {
                                grid[i-1][j] = grid[i][j] + 1;
                            }
                        }
                    }
                    if(j-1>=0)
                    {
                        if(grid[i][j-1] > 1)
                        {
                            if(grid[i][j] + 1 < grid[i][j-1])
                            {
                                grid[i][j-1] = grid[i][j] + 1;
                            }
                        }
                    }
                    if(i+1<n)
                    {
                        if(grid[i+1][j] > 1)
                        {
                            if(grid[i][j] + 1 < grid[i+1][j])
                            {
                                grid[i+1][j] = grid[i][j] + 1;
                            }
                        }
                    }
                    if(j+1<n)
                    {
                        if(grid[i][j+1] > 1)
                        {
                            if(grid[i][j] + 1 < grid[i][j+1])
                            {
                                grid[i][j+1] = grid[i][j] + 1;
                            }
                        }
                    }
                }
            }
        }
        
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
            {
                if(grid[i][j] == 0)
                {
                    return -1;
                }
                if(count < grid[i][j])
                    count = grid[i][j];
            }
        
        return count - 1;
        
    }
    
    public int lengthOfLISUtil(int no, int index, int arr[], int count){
        
        if(index >= arr.length)
            return count;
        
        if(arr[index] > no)
            return Math.max(lengthOfLISUtil(arr[index], index+1, arr, count+1), lengthOfLISUtil(no, index+1, arr, count));
        else
            return lengthOfLISUtil(no, index+1, arr, count);
        
    }
    
    public int lengthOfLIS(int[] nums) {
        
        int ans = 0;
        for(int i=0; i<nums.length; i++){
            int no = lengthOfLISUtil(nums[i], i+1, nums, 1);
            if(no > ans)
                ans = no;
        }
        
        return ans;
        
    }
    
    
    public static void main(String args[]){
        
    }

    
}
