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
public class Trie {

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

}
