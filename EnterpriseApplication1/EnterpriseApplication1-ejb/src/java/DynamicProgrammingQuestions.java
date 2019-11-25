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
    
    public int longestCommonSubsequenceUtil(String text1, String text2, int ind1, int ind2, int[][] memo){
        
        if(ind1 > text1.length()  || ind2 > text2.length())
            return 0;
        if(memo[ind1][ind2] != Integer.MIN_VALUE)
            return memo[ind1][ind2];
        int a = Integer.MIN_VALUE , b = Integer.MIN_VALUE, c = Integer.MIN_VALUE;
        if(text1.charAt(ind1) == text2.charAt(ind2))
            a = 1 + longestCommonSubsequenceUtil(text1, text2, ind1+1, ind2+1, memo);
        b = longestCommonSubsequenceUtil(text1, text2, ind1+1, ind2+1, memo);
        c = longestCommonSubsequenceUtil(text1, text2, ind1+1, ind2+1, memo);
        a = Math.max(a, b);
        a = Math.max(a, c);
        memo[ind1][ind2] = a;
        return memo[ind1][ind2];
        
    }
    
     public int longestCommonSubsequence(String text1, String text2) {
        
        int[][] memo = new int[text1.length()][text2.length()];
        for(int i=0; i<text1.length(); i++)
        {
            for(int j=0; j<text2.length(); j++){
                memo[i][j] = Integer.MIN_VALUE;
            }
        }
        return longestCommonSubsequenceUtil(text1, text2, 0, 0, memo);
    }
     
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0)
            return  0;
        int[] memo = new int[nums.length];
        memo[0] = 1;
        int max = 1;
        for(int i=1; i<nums.length; i++){
            memo[i] = 1;
            for(int j=i-1; j>=0; j--){
                if(nums[j] <= nums[i]){
                    memo[i] = nums[j] + 1;
                    if(max < memo[i])
                        max = memo[i];
                    break;
                }
            }
        }
        
        return memo[nums.length-1];
    }
    
    public String getString(char c , int count){
        
        char[] charArray = new char[count];
        for(int i=0; i<count; i++){
            charArray[i] = c;
        }
        String s = new String(charArray);
        return s;
    }
    
    public boolean checkRemaingPattern(String p, int ind){
        for(int i=ind; i<p.length(); i++){
            if(p.charAt(i) != '*' && (i+1 == p.length() || p.charAt(i+1) != '*'))
                return false;
        }
        return true;
    }
    
    public boolean isMatchUtil(String s, int ind1, String p, int ind2){
        
        if(ind1 >= s.length())
        {
            if(checkRemaingPattern(p, ind2) == true)
                return true;
            else
                return false;
        }
        if(ind2 >= p.length())
            return false;
        
        if(ind2+1 < p.length() && p.charAt(ind2+1) == '*')
            return isMatchUtil(s, ind1, p, ind2+1);
        
        if(p.charAt(ind2) == '.' || p.charAt(ind2) == s.charAt(ind1))
            return isMatchUtil(s, ind1+1, p, ind2+1);
        else if(p.charAt(ind2) == '*'){
            
            for(int i=0; i<=s.length()-ind1; i++){
                String p1 = getString(p.charAt(ind2-1), i) + p.substring(ind2 + 1);
                if(isMatch(s.substring(ind1), p1) == true)
                    return true;
            }
            return false;
            
        }else if(p.charAt(ind2) != s.charAt(ind1)){
            return false;
        }
        //return false;
        
        return false;
    }
    
    public boolean isMatch(String s, String p) {
        return isMatchUtil(s,0,p,0);
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
    
    
    public boolean wildCardUtil(String input , int inputInd, String pattern, int patternInd){
        
        if(inputInd >= input.length() && patternInd>= pattern.length())
            return true;
        if(inputInd >= input.length())
            return false;
        if(patternInd>= pattern.length())
            return false;
        if(input.charAt(inputInd) == pattern.charAt(patternInd))
            return wildCardUtil(input, inputInd + 1, pattern, patternInd+1);
        if(pattern.charAt(patternInd) == '?')
            return wildCardUtil(input, inputInd, pattern, patternInd+1);
        if(pattern.charAt(patternInd) == '*')
        {
            for(int i=0; i<=input.length(); i++){
                String input1 = ( (i == input.length()) ? "" : input.substring(i));
                String pattern1 = pattern.substring(patternInd);
                if(wildCard(input1, pattern1) == true)
                    return true;
            }
            return false;
        }
        return false;
    }
    
    public boolean wildCard(String s, String p) {
        
        
        return true;
        
    }
    
}
