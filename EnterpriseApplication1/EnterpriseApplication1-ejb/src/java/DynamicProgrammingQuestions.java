
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rajeshkumar.yadav
 */
public class DynamicProgrammingQuestions {

    public int longestCommonSubsequenceUtil(String text1, String text2, int ind1, int ind2, int[][] memo) {

        if (ind1 > text1.length() || ind2 > text2.length()) {
            return 0;
        }
        if (memo[ind1][ind2] != Integer.MIN_VALUE) {
            return memo[ind1][ind2];
        }
        int a = Integer.MIN_VALUE, b = Integer.MIN_VALUE, c = Integer.MIN_VALUE;
        if (text1.charAt(ind1) == text2.charAt(ind2)) {
            a = 1 + longestCommonSubsequenceUtil(text1, text2, ind1 + 1, ind2 + 1, memo);
        }
        b = longestCommonSubsequenceUtil(text1, text2, ind1 + 1, ind2 + 1, memo);
        c = longestCommonSubsequenceUtil(text1, text2, ind1 + 1, ind2 + 1, memo);
        a = Math.max(a, b);
        a = Math.max(a, c);
        memo[ind1][ind2] = a;
        return memo[ind1][ind2];

    }

    public int longestCommonSubsequence(String text1, String text2) {

        int[][] memo = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                memo[i][j] = Integer.MIN_VALUE;
            }
        }
        return longestCommonSubsequenceUtil(text1, text2, 0, 0, memo);
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] memo = new int[nums.length];
        memo[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            memo[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] <= nums[i]) {
                    memo[i] = nums[j] + 1;
                    if (max < memo[i]) {
                        max = memo[i];
                    }
                    break;
                }
            }
        }

        return memo[nums.length - 1];
    }

    public String getString(char c, int count) {

        char[] charArray = new char[count];
        for (int i = 0; i < count; i++) {
            charArray[i] = c;
        }
        String s = new String(charArray);
        return s;
    }

    public boolean checkRemaingPattern(String p, int ind) {
        for (int i = ind; i < p.length(); i++) {
            if (p.charAt(i) != '*' && (i + 1 == p.length() || p.charAt(i + 1) != '*')) {
                return false;
            }
        }
        return true;
    }

    public boolean isMatchUtil(String s, int ind1, String p, int ind2) {

        if (ind1 >= s.length()) {
            if (checkRemaingPattern(p, ind2) == true) {
                return true;
            } else {
                return false;
            }
        }
        if (ind2 >= p.length()) {
            return false;
        }

        if (ind2 + 1 < p.length() && p.charAt(ind2 + 1) == '*') {
            return isMatchUtil(s, ind1, p, ind2 + 1);
        }

        if (p.charAt(ind2) == '.' || p.charAt(ind2) == s.charAt(ind1)) {
            return isMatchUtil(s, ind1 + 1, p, ind2 + 1);
        } else if (p.charAt(ind2) == '*') {

            for (int i = 0; i <= s.length() - ind1; i++) {
                String p1 = getString(p.charAt(ind2 - 1), i) + p.substring(ind2 + 1);
                if (isMatch(s.substring(ind1), p1) == true) {
                    return true;
                }
            }
            return false;

        } else if (p.charAt(ind2) != s.charAt(ind1)) {
            return false;
        }
        //return false;

        return false;
    }

    public boolean isMatch(String s, String p) {
        return isMatchUtil(s, 0, p, 0);
        //return true;
    }

    /*
    Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like ? or *.
     */
    public boolean containsOnlyStar(String pattern, int patternInd) {

        for (int i = patternInd; i < pattern.length(); i++) {
            if (pattern.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }

    public boolean wildCardUtil(String input, int inputInd, String pattern, int patternInd, int[][] arr) {
        if (arr[inputInd][patternInd] == 0) {
            return false;
        } else if (arr[inputInd][patternInd] == 1) {
            return true;
        }
        if (inputInd >= input.length() && (patternInd >= pattern.length() || containsOnlyStar(pattern, patternInd) == true)) {
            arr[inputInd][patternInd] = 1;
            return true;
        }
        if (inputInd >= input.length()) {
            arr[inputInd][patternInd] = 0;
            return false;
        }
        if (patternInd >= pattern.length()) {
            arr[inputInd][patternInd] = 0;
            return false;
        }
        if (input.charAt(inputInd) == pattern.charAt(patternInd)) {
            boolean b = wildCardUtil(input, inputInd + 1, pattern, patternInd + 1, arr);
            if (b == true) {
                arr[inputInd][patternInd] = 1;
                return true;
            } else {
                arr[inputInd][patternInd] = 0;
                return false;
            }
        }
        if (pattern.charAt(patternInd) == '?') {
            boolean b = wildCardUtil(input, inputInd, pattern, patternInd + 1, arr);
            if (b == true) {
                arr[inputInd][patternInd] = 1;
                return true;
            } else {
                arr[inputInd][patternInd] = 0;
                return false;
            }
        }
        if (pattern.charAt(patternInd) == '*') {
            for (int i = 0; i <= input.length(); i++) {
//                String input1 = ( (i == input.length()) ? "" : input.substring(i));
//                String pattern1 = pattern.substring(patternInd);
//                if(wildCard(input1, pattern1) == true)
//                    return true;
                if (wildCardUtil(input, i + inputInd, pattern, patternInd + 1, arr) == true) {
                    arr[inputInd][patternInd] = 1;
                    return true;
                }
            }
            arr[inputInd][patternInd] = 0;
            return false;
        }
        arr[inputInd][patternInd] = 0;
        return false;
    }

    public boolean wildCard(String s, String p) {

        int[][] arr = new int[s.length() + 1][p.length() + 1];
        if (s.isEmpty() && containsOnlyStar(p, 0) == true) {
            return true;
        }
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= p.length(); j++) {
                arr[i][j] = -1;
            }
        }
        wildCardUtil(s, 0, p, 0, arr);
        if (arr[s.length()][p.length()] == 1) {
            return true;
        }
        return false;

    }

    public int coinChangeUtil(int[] coins, int amount, int[] arr) {

        if (arr[amount] != -1) {
            return arr[amount];
        }

        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return Integer.MAX_VALUE;
        }

        int max = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            int temp = Integer.MAX_VALUE;
            if (coins[i] <= amount) {
                int val = coinChangeUtil(coins, amount - coins[i], arr);
                if (val != Integer.MAX_VALUE) {
                    temp = 1 + val;
                }
            }
            if (temp < max) {
                max = temp;
            }
        }
        arr[amount] = max;
        return max;
    }

    public int coinChange(int[] coins, int amount) {

        int[] arr = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            arr[i] = -1;
        }
        int val = coinChangeUtil(coins, amount, arr);
        if (val == Integer.MAX_VALUE) {
            return -1;
        }
        return val;
    }

    public int countOfSubSetSum(int arr[], int sum, int index) {

//        if(dyn[sum][index+1] != -1)
//            return dyn[sum][index+1];
        if (sum == 0) {
            return 1;
        }

        if (index >= arr.length || sum < 0) {
            return 0;
        }

        return countOfSubSetSum(arr, sum - arr[index], index + 1) + countOfSubSetSum(arr, sum, index + 1);

    }

    public int getVal(int[][] dyn, int index, int sum) {
        if (sum < 0) {
            return 0;
        }
        if (index < 0) {
            return 0;
        }
        //if(index >= )
        int max = 0;
        if (sum == 0) {
            max = 1;
        }
        return Math.max(max, dyn[sum][index]);
    }

    public int countOfSubSetSumDyn(int[] arr, int sum, int[][] dyn) {

        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= arr.length; j++) {

                dyn[i][j] = getVal(dyn, j - 1, i - arr[j - 1]) + getVal(dyn, j - 1, i);
                //System.out.print(dyn[i][j] + " ");
            }
            //System.out.println("");
        }
        return dyn[sum][arr.length];
    }

//    public static void main(String args[]){
//        
//        long start = System.currentTimeMillis();
//        DynamicProgrammingQuestions dp = new DynamicProgrammingQuestions();
//        int[] arr = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
//        int sum = 9;
////        int arr[] = {1,1,7,1, 5};
////        int sum = 9;
//        int[][] dyn = new int[sum+1][arr.length+1];
//        for(int i=0; i<=sum; i++)
//            dyn[i][0] = 0;
//        for(int j = 0; j<=arr.length; j++)
//                dyn[0][j] = 0;
//        //int ans = dp.countOfSubSetSum(arr, sum, 0);
//        dp.countOfSubSetSumDyn(arr, sum, dyn);
//        long end = System.currentTimeMillis();
//        System.out.println(dyn[sum][arr.length] + "  -- " + (end-start));
//        
//    }
//    
    public int findTargetSumWaysUtil(int[] nums, int sum, int index) {

        if (index == nums.length && sum == 0) {
            return 1;
        }
        if (index > nums.length) {
            return 0;
        }
        return findTargetSumWaysUtil(nums, sum - nums[index], index + 1) + findTargetSumWaysUtil(nums, sum + nums[index], index + 1);

    }

    public int findTargetSumWays(int[] nums, int S) {

        return findTargetSumWaysUtil(nums, S, 0);

    }

    public int maxSumDivThree(int[] nums, int sum, int index, int[] memo) {

        if (index >= nums.length) {
            if (sum % 3 == 0) {
                return sum;
            }
            return -1;
        }

        if (memo[index] != Integer.MIN_VALUE) {
            return memo[index];
        }

        int res1 = maxSumDivThree(nums, sum + nums[index], index + 1, memo);
        int res2 = maxSumDivThree(nums, sum, index + 1, memo);
        memo[index] = Math.max(res1, res2);
        return memo[index];
    }

    public int maxSumDivThree(int[] nums) {

        final int sumDivisbleBy = 3;
        int arr[] = new int[sumDivisbleBy];
        int currentVal[] = new int[sumDivisbleBy];
        Arrays.fill(arr, 0);

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] % 3 == 1) {
                currentVal[1] = Math.max(arr[1], arr[0] + nums[i]);
                currentVal[0] = Math.max(arr[2] + nums[i], arr[0]);

            } else if (nums[i] % 3 == 2) {

                currentVal[2] = Math.max(arr[2], arr[0] + nums[i]);
                currentVal[0] = Math.max(arr[1] + nums[i], arr[0]);

            } else {

                currentVal[1] = Math.max(arr[1] + nums[i], arr[1]);
                currentVal[0] = Math.max(arr[0] + nums[i], arr[0]);
                currentVal[2] = Math.max(arr[2] + nums[i], arr[2]);

            }

            for (int j = 0; j < sumDivisbleBy; j++) {
                arr[j] = currentVal[j];
            }
        }

        return arr[0];
    }

    public static int coinChangeProblem(int amount, int coins[], int index, int[][] memo) {

        if (amount < 0) {
            return 0;
        }

        if (memo[index][amount] != -1) {
            return memo[index][amount];
        }

        if (amount == 0) {
            return 1;
        }

        int a = 0;
        for (int i = index; i < coins.length; i++) {
            a = a + coinChangeProblem(amount - coins[i], coins, i, memo);
        }

        memo[index][amount] = a;
        return memo[index][amount];

    }

    public static void longestPalindromicSubString() {

    }

    public int numDecodings(String s) {

        if (s.isEmpty() || s == null) {
            return 0;
        }

        int[] arr = new int[s.length()];

        int digit1 = Integer.parseInt(s.charAt(0) + "");

        if (digit1 >= 1) {
            arr[0] = 1;
        } else {
            return 0;
        }

        int digit2 = 0;

        for (int i = 1; i < s.length(); i++) {

            digit2 = Integer.parseInt(s.charAt(i) + "");

            if (digit2 >= 1) {
                arr[i] = arr[i - 1];
            } else if (digit2 == 0) {
                if (digit1 * 10 <= 26 && digit1 * 10 >= 1) {
                    arr[i] = ((i - 2 >= 0) ? arr[i - 2] : 1);
                }
                digit1 = digit2;
                continue;
            }

            if (digit1 * 10 + digit2 != digit2 && digit1 * 10 + digit2 <= 26) {
                arr[i] = arr[i] + ((i - 2 >= 0) ? arr[i - 2] : 1);
            }
            digit1 = digit2;
        }

        return arr[s.length() - 1];

    }
    
    public boolean checkSubArraySum(int nums[], int ind, int sum, int len, int k, int [] arr){
        
        if(ind >= nums.length)
            return false;
        
        if(arr[ind] != 0)
            return ((arr[ind] == 1) ? true: false);
        
        sum = sum + nums[ind];
        len++;
        
         if(len >= 2 && ( (k!= 0 && sum % k == 0) || k == sum))
             return true;
         
         boolean var1 =  checkSubArraySum(nums, ind+1, sum, len, k, arr); 
         boolean var2  = checkSubArraySum(nums, ind+1, nums[ind], 1, k, arr);
         
         
         
         if(var2 == true)
             arr[ind] = 1;
         else
             arr[ind] = -1;
         
         return var2 || var1;
    }
    
    public boolean checkSubarraySum(int[] nums, int k) {
        
        int[] arr = new int[nums.length];
        return checkSubArraySum(nums, 0, 0, 0, k, arr);
        
    }

    public static void main(String[] args) throws IOException {
        int t;
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        t = Integer.parseInt(s);
        while (t > 0) {
            t--;
//            s = br.readLine();
//            n = Integer.parseInt(s);
//            s = br.readLine();
//            StringTokenizer st = new StringTokenizer(s);
//            s = br.readLine();
//            int amount = Integer.parseInt(s);
//            int[] arr = new int[n];
//            int i = 0;
//            while(st.hasMoreTokens()){
//                arr[i++] = Integer.parseInt(st.nextToken());
//            }
            //arr[n] = 0;
            //int[][] memo = new int[n+1][amount+1];
            n = 4;
            int amount = 10;
            int[][] memo = new int[n + 1][amount + 1];
            for (int i = 0; i < n; i++) {
                Arrays.fill(memo[i], -1);
            }
            //coinChangeProblem(amount, arr, 0, memo);
            int[] arr1 = {2, 5, 3, 6};
            int a = coinChangeProblem(amount, arr1, 0, memo);
            System.out.println(a);
            //System.out.println(arr[n]);
        }
    }
    
    

}
