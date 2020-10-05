/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dynamicprogramming;

/**
 *
 * @author rajeshkumar.yadav
 */

public class MaxProductSubSequence {
    
    public int maxProductSubSequenceUtil(int arr[], int product, int k,  int ind){
        
        if(ind >= arr.length)
            return product;
        return Integer.max(maxProductSubSequenceUtil(arr, product*arr[ind], k-1, ind+1), maxProductSubSequenceUtil(arr, product, k, ind+1));
        
    }
    
    public int maxProductSubSequence(int arr[], int k){
        
        int dynarr[][] = new int[k+1][arr.length+1];
        for(int i=0; i<=k; i++)
            dynarr[i][0] = 0;
        for(int i=0; i<=arr.length; i++)
            dynarr[0][i] = 0;
        
        dynarr[1][1] = arr[0];
        for(int i=2; i<=arr.length; i++)
            dynarr[1][i] = Integer.max(dynarr[1][i-1], arr[i-1]);
        for(int i=2; i<=k; i++)
            dynarr[i][1] = arr[0];
        for(int i = 2; i<=k; i++){
            
            for(int j=2; j<=arr.length; j++)
            {
                dynarr[i][j] = Integer.max(dynarr[i-1][j-1] * arr[j-1], dynarr[i][j-1]);
            }
            
        }
        
        return dynarr[k][arr.length];
        
        //return maxProductSubSequenceUtil(arr, 1, k, 0);
    }
    
    public static void main(String[] args) {
        //1, 2, -1, -3, -6, 4
        int arr[] = {-6, -3, -1, 1, 2, 4};
        MaxProductSubSequence mp = new MaxProductSubSequence();
        System.out.println("dynamicprogramming.MaxProductSubSequence.main()   " + mp.maxProductSubSequence(arr, 4));
    }
    
}
