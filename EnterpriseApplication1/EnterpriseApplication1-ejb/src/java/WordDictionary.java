
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rajeshkumar.yadav
 */
class WordDictionary {

    /** Initialize your data structure here. */
    Map<Integer, List<String>> dictionaryMap;
    public WordDictionary() {
        
        dictionaryMap = new HashMap<>();
        
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        
        int len = word.length();
        List<String> l = dictionaryMap.get(len);
        
        if(l ==  null)
        {
            l = new ArrayList<String>();
            dictionaryMap.put(len, l);
        }
        l.add(word);
    }
    
    private boolean compareString(String str1, String str2){
        for(int i=0; i<str1.length(); i++)
        {
            if(str1.charAt(i) == '.')
                continue;
            else if(str1.charAt(i) != str2.charAt(i))
                return false;
                
        }
        return true;
    }
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        int len = word.length();
        List<String> l = dictionaryMap.get(len);
        
        if(l ==  null)
        {
            return false;
        }
        
        for(String str : l)
        {
            if(compareString(word, str))
                return true;
        }
        return false;
        
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
