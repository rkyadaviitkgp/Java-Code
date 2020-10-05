/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author rajeshkumar.yadav
 */
public class DynamicProgrammingQuestion {
    
    //get sum of the array
public int getSum(int[] arr){
    int sum = 0;
    for(int i=0; i<arr.length; i++){
        sum =  sum + arr[i];
    }
    return sum;
}

//binary search
public int binarySearch(int arr[], int start, int end, int val){
    if(start > end)
        return -1;
    int mid = start + (end-start)/2;
    if(arr[mid] == val)
        return mid;
    if(arr[mid] > val)
        return binarySearch(arr, start, mid-1, val);
    return binarySearch(arr, mid+1, end, val);
}

// get pair of item 
public List<Integer> getPair(int[] arr1, int[] arr2){
    
    int sum1 = getSum(arr1);
    int sum2 = getSum(arr2);
    int[] searchingArray;
    int[] searchingForArrray;
    int d = 0;
    if(sum1 > sum2){
        searchingArray = arr1;
        searchingForArrray = arr2;
        d = sum1 - sum2;
    }else{
        searchingArray = arr2;
        searchingForArrray = arr1;
        d = sum2 - sum1;
    }
    Arrays.sort(searchingArray);
    List<Integer> ans;
    ans = new ArrayList<>();
    for(int i=0; i<searchingForArrray.length; i++)
    {
        int ind = binarySearch(searchingArray, 0, searchingArray.length-1, searchingForArrray[i] + d) ;
        if(ind != -1)
        {
            ans.add(ind);
            ans.add(i);
            return ans;
        }
    }
    return ans;
}
    
    public int editUtil(String str1, int ind1, String str2, int ind2){
        
        //case when we need to add new remaining character 
        if(str1.length() <= ind1)
            return str2.length() - ind2;
        
        //case when we need to delete remaining new character
        if(str2.length() <= ind2)
            return str1.length() - ind1;
        if(str1.charAt(ind1) == str2.charAt(ind2))
            return editUtil(str1, ind1+1, str2, ind2+1);
        //delete case , replace case, insert case
        return Integer.min(editUtil(str1, ind1 + 1, str2, ind2) + 1, Integer.min(editUtil(str1, ind1+1, str2, ind2+1)+1, editUtil(str1, ind1, str2, ind2+1)+1));
        
    }
    
    public int editDistance(String str1, String str2){
        return editUtil(str1, 0, str2, 0);
    }
    
    public void printArray(int[] arr){
        for(int i=0; i<arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public int coinChnageProblem(int arr[], int index, int money){
        
        if(money == 0)
            return 1;
        
        if(money < 0 || arr.length <= index)
            return 0;
        int sum = 0;
        for(int i=index; i<arr.length; i++)
            sum = sum + coinChnageProblem(arr, i, money-arr[i]);
        //sum = sum + coinChnageProblem(arr, index+1, money);
        return sum;
    }
    
    public void coinChnage(){
        
        ReadInput rd = new ReadInput();  
        int money   = rd.readInteger();
        int len     = rd.readInteger();
        int[] arr   = new int[len];
        rd.readIntegerArray(arr);
        int ans = 0;
        if(money != 0)
            ans = coinChnageProblem(arr, 0, money);
        System.out.println(ans);

    }
    
    //same item can not be selected many times
    public int knapSackWithoutRepetation(int weight[], int val[], int n, int capacity){
        int[][] profit = new int[capacity+1][n+1];
        
        for(int i=0; i<=n; i++)
            profit[0][i] = 0;
        for(int i=0; i<=capacity; i++)
            profit[i][0] = 0;
        
        for(int i = 1; i<=capacity; i++){
            for(int j=1; j<=n; j++){
                if(i >= weight[j-1])
                {
                    profit[i][j] = Math.max(profit[i][j-1], val[j-1] + profit[i-weight[j-1]][j-1]);
                }else{
                    profit[i][j] = profit[i][j-1];
                }
            }
        }
        return profit[capacity][n];
    }
    
    //same item can be selected many times
    public int knapSack(int weight[], int val[], int n, int capacity){
        int[] profit = new int[capacity+1];
        profit[0] = 0;
        for(int i = 1; i<=capacity; i++){
            int temp = 0;
            for(int j=0; j<n; j++)
            {
                if(weight[j] <= i){
                    if(temp < val[j] + profit[i-weight[j]])
                        temp = val[j] + profit[i-weight[j]];
                }
            }
            profit[i] = temp;
        }
        return profit[capacity];
    }
    
    public void KnpaSack(){
        
        ReadInput rd = new ReadInput();
        int t = rd.readInteger();
        System.out.println(t);
        while(t-- > 0){
            int n = rd.readInteger();
            int w = rd.readInteger();
            System.out.println(n);
            System.out.println(w);
            int[] weight = new int[w];
            int[] val = new int[w];
            rd.readIntegerArray(val);
            rd.readIntegerArray(weight);
            System.out.println(knapSackWithoutRepetation(weight, val, n, w));
        }
        
    }
    
    public static void main(String[] args) {
        DynamicProgrammingQuestion dpq = new DynamicProgrammingQuestion();
        String str1 = "geekpq";
        String str2 = "geeskk";
        //dpq.KnpaSack();
       // dpq.coinChnage();
        int arr[] = {1,2,3,4};
        int arr2[] = {0,3,5,0};
        List<Integer> l = dpq.getPair(arr, arr2);
        System.out.println(l.toString());
        

    }
    
    
}
