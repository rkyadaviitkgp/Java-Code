/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrieDesign;

/**
 *
 * @author rajeshkumar.yadav
 */
public class TrieNode {
    
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
