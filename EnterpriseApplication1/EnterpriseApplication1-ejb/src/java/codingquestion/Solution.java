/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codingquestion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class TrieNode {
    
    private TrieNode[] arr;
    private boolean isEnd;
    private final int R = 26;
    
    public TrieNode() {
        arr = new TrieNode[R];
        isEnd = false;
    }
 
    public boolean isCharPresent(char ch)
    {
        return arr[ch-'a'] != null;
    }
    
    public TrieNode getChar(char ch)
    {
        return arr[ch-'a'];
    }
    
    public void setChar(char c, TrieNode node)
    {
        arr[c-'a'] = node;
    }

    public boolean isIsEnd() {
        return isEnd;
    }

    public void setIsEnd(boolean isEnd) {
        this.isEnd = isEnd;
    }

}


class Trie {

      TrieNode rootNode;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        rootNode = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {

        TrieNode temp = rootNode;
        for (int i = 0; i < word.length(); i++) {
            if (temp.getChar(word.charAt(i)) == null) {
                temp.setChar(word.charAt(i), new TrieNode());
            }
            temp = temp.getChar(word.charAt(i)); 
        }
        temp.setIsEnd(true);

    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        
        TrieNode temp = searchPrefix(word);
        return temp != null && temp.isIsEnd();
    }

    /**
     * Returns if there is any word in the trie that starts with the given
     * prefix.
     */
    
    public TrieNode searchPrefix(String prefix) {
        
        TrieNode temp = rootNode;
        for (int i = 0; i < prefix.length(); i++) {
            if (temp.getChar(prefix.charAt(i)) == null) {
                return null;
            } else {
                temp = temp.getChar(prefix.charAt(i));
            }

        }
        return temp;

    }
    
    public boolean startsWith(String prefix) {
        
        return searchPrefix(prefix) != null;
       
    }
    
   public String getMinPrefix(String str)
    {
       TrieNode temp = rootNode;
        for (int i = 0; i < str.length(); i++) {
            if (temp.getChar(str.charAt(i)) == null) {
                return str;
            } else {
                temp = temp.getChar(str.charAt(i));
                if(temp.isIsEnd())
                    return str.substring(0, i+1);
            }

        }
        return str;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

class Solution {
    
    
    public List<List<String>> MergeAccounts(List<List<String>> accounts){
        List<List<String>> l = null;
        return l;
    }
    
     public boolean canMerge(int[] a, int[] b){
         
         if(a[1] >= b[0])
            return true;
         return false;
     }
     
     public int[] getMergedValue(int[] a, int [] b)
     {
         a[0] = Math.min(a[0], b[0]);
         a[1] = Math.max(a[1], b[1]);
         return a;
     }
     
     public int[][] merge(int[][] intervals) {
        
        Stack<int[]> st = new Stack<>();
        for(int i=0; i<intervals.length; i++) /* sort bbased omn first no */
        {
            int minind = i;
            for(int j=i+1; j<intervals.length; j++)
            {
                if(intervals[j][0] < intervals[minind][0])
                {
                    minind = j;
                }
            }
            if(minind != i)
            {
                int a, b;
                a = intervals[i][0];
                b = intervals[i][1];
                intervals[i][0] = intervals[minind][0];
                intervals[i][1] = intervals[minind][1];
                intervals[minind][0] = a;
                intervals[minind][1] = b;
            }
            //System.out.println(intervals[i][0] +" " + intervals[i][1]);
        }
        
        int j = 0;
        st.push(intervals[0]);
        for(int i=1; i<intervals.length; i++)
        {
            int[] a = st.peek();
            if(canMerge(a, intervals[i]))
            {
                st.pop();
                a = getMergedValue(a, intervals[i]);
                st.push(a);
            }else{
                st.push(intervals[i]);
            }
        }
        
        int[][] r = new int[st.size()][2];
        int len = st.size() - 1;
        for(int i=len; i>=0; i--)
        {
            r[i] = st.pop();
        }
        return  r;
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();
        s.licenseKeyFormatting("abC--d-ef",2);
    }
    
    public String getUpperCase(char c)
    {
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int p;
        if(c >= 'A' && c<='Z')
            p = c - 'A';
        else if(c >= 'a' && c<='z')
         p = c - 'a';
        else
            return Character.toString(c);
        return s.substring(p, p+1);
    }
    
    public boolean isAlphanumeric(char c)
    {
        if(c >= 'A' && c <= 'Z')
            return true;
        if(c >= 'a' && c <= 'z')
            return true;
        if(c >= '0' && c <= '9')
            return true;
        return false;
    }
    
   
    public String licenseKeyFormatting(String S, int k) {
        
       
        StringBuilder newstr = new StringBuilder();
        int count = 0;
        for(int i=S.length()-1; i>=0; i--)
        {
            if(S.charAt(i) != '-')
            {
                if(count == k)
                {
                    count = 0;
                    newstr.append('-');
                }
                count++;
                newstr.append(Character.toUpperCase(S.charAt(i)));
            }
        }
        
        return newstr.reverse().toString();
    
    }
    
    public String replaceWords(List<String> dict, String sentence) {
        
        
        Trie t = new Trie();
        String result = "";
        for(int i=0; i<dict.size(); i++)
        {
            t.insert(dict.get(i));
        }
        
        String[] sentenceArray = sentence.split(" ");
        for(int i=0; i<sentenceArray.length; i++)
        {
            String res = t.getMinPrefix(sentenceArray[i]);
            if(result.isEmpty())
            {
                result = res;
            }else{
                result = result + " " + res;
            }
        }
        return result;
    }
    
}
/**
 *
 * @author rajeshkumar.yadav
 */
//public class Solution {
//    
//}
