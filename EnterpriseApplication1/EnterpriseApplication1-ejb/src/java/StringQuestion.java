
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
public class StringQuestion {

    public String getString(int count, char c) {

        String str = "";
        for (int i = 0; i < count; i++) {
            str = str + c;
        }
        return str;

    }

    public String createJustifiedString(String[] list, int start, int end, int equal, int extra, char c) {

        String ans = "";

        for (int i = start; i < end - 1; i++) {
            
            ans = ans + list[i];
            if (extra > 0) {
                extra--;
                ans = ans + getString(equal + 1, c);
            } else {
                ans = ans + getString(equal, c);
            }
        }

        ans = ans + list[end - 1];
        return ans;

    }

    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> fullJustifed = new ArrayList<>();
        int start = 0;
        int end = 0;
        List<String> tmp = new ArrayList<String>();
        int len = words[0].length();
        tmp.add(words[0]);

        for (int i = 1; i < words.length; i++) {

            if (len + 1 + words[i].length() <= maxWidth) {

                tmp.add(words[i]);
                len = len + 1 + words[i].length();

            } else {

                int remainingLen = maxWidth - len;
                end = i;
                int equalDivision = 1;
                int extraPadding = 0;
                String s = "";

                if (tmp.size() > 1) {
                    equalDivision = remainingLen / (tmp.size() - 1) + 1;
                    extraPadding = remainingLen % (tmp.size() - 1);
                    s = createJustifiedString(words,start, end, equalDivision, extraPadding, ' ');
                } else {
                    s = tmp.get(0) + getString(maxWidth - tmp.get(0).length(), ' ');
                }
                
                start = i;
                fullJustifed.add(s);
                len = words[i].length();
                tmp.clear();
                tmp.add(words[i]);
            }

        }

        String s = createJustifiedString(words, start, words.length,  1, 0, ' ');
        s = s + getString(maxWidth - len, ' ');
        fullJustifed.add(s);

        return fullJustifed;
    }
    
    public int countSegments(String s) {
        StringTokenizer st = new StringTokenizer(s);
        return st.countTokens();
    }
    
//    public int compress(char[] chars) {
//        
//        
//        
//        for(int i=0; i<chars.length; i++){
//            
//        }
//        
//    }
    
    public void getWordsFromParagraph(String s, List<String> list){
        
        int start = 0;
        int end = 0;
        while(end < s.length()){
            
            while(end<s.length() && (s.charAt(end) >= 'a' && s.charAt(end) <= 'z'))
                end++;
            
            list.add(s.substring(start, end));
            
            while(end<s.length() && (s.charAt(end) < 'a' || s.charAt(end) > 'z') )
            end++;
            
            start = end;
            
        }
        
    }
    
    public String addStrings(String num1, String num2) {
        
        StringBuffer sb = new StringBuffer();
        int end1 = num1.length() - 1;
        int end2 = num2.length() - 1;
        int carry = 0;
        
        while(end1 >= 0 && end2 >= 0){
            int isum = Integer.parseInt(num1.substring(end1, end1+1)) + 
                    Integer.parseInt(num2.substring(end2, end2+1)) + carry;
            if(isum > 9){
                carry = isum / 10;
            }else{
                carry = 0;
            }
            sb.append(isum%10);
            end1--;
            end2--;
        }
        
        while(end1 >= 0 ){
            int isum = Integer.parseInt(num1.substring(end1, end1+1)) + carry;
            if(isum > 9){
                carry = isum / 10;
            }else{
                carry = 0;
            }
            sb.append(isum%10);
            end1--;
        }
        
        while(end2 >= 0){
            int isum = Integer.parseInt(num2.substring(end2, end2+1)) + carry;
            if(isum > 9){
                carry = isum / 10;
            }else{
                carry = 0;
            }
            sb.append(isum%10);
            end2--;
        }
        
        if(carry > 0)
            sb.append(carry);
        
        return sb.reverse().toString();
        
        
    }
    
    public boolean isLongPressedName(String name, String typed) {
    
        char[] nameArray = name.toCharArray();
        char[] typedArray = typed.toCharArray();
        int j = 0;
        for(int i=0; i<typedArray.length; i++){
            if(j<nameArray.length && nameArray[j] == typedArray[i]){
                j++;
            }
        }
        return (j == name.length());
    }
    
    public int repeatedStringMatch(String A, String B) {
        
        int count = 1;
        String ans = A;
        int minCount = (B.length())/A.length() + 1;
        
        while(count <= minCount && ans.indexOf(B) == -1){
            ans = ans + A;
            count++;
        }
        
        if(ans.indexOf(B) == -1)
            return -1;
        else
            return count;
    }
    
    public String mostCommonWord(String paragraph, String[] banned) {
        
        paragraph = paragraph.toLowerCase();
        HashMap<String, Boolean> hm = new HashMap<String, Boolean>();
        HashMap<String, Integer> paraHm = new HashMap<>();
        
        for(String s: banned){
            hm.put(s, Boolean.TRUE);
        }
        
        //StringTokenizer st = new StringTokenizer(paragraph);
        List<String> list = new ArrayList<String>();
        getWordsFromParagraph(paragraph, list);
        
       for(int i=0; i<list.size(); i++){
            
            String tok = list.get(i);
            if(tok.charAt(tok.length()-1)>'z' || tok.charAt(tok.length()-1)<'a')
            {
                tok = tok.substring(0,tok.length()-1);
            }
            if(paraHm.containsKey(tok)){
                int count = paraHm.get(tok) + 1;
                paraHm.replace(tok, count);
            }else{
                paraHm.put(tok, 1);
            }
            
        }
        int max = 0;
        String ans = "";
        for(String tok: paraHm.keySet()){
            if(!hm.containsKey(tok)){
                if(max < paraHm.get(tok)){
                    max = paraHm.get(tok);
                    ans = tok;
                }
            }
        }
        return ans;
    }
    
    public boolean isVowel(char c){
        
        if(c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
            return true;
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            return true;
        return false;
    }
    
    public String reverseVowels(String s) {
        
        char[] charArray = s.toCharArray();
        int start = 0;
        int end = s.length()-1;
        
        while(start < end){
            
            while(!isVowel(s.charAt(start))){
                start++;
            }
            
            while(!isVowel(s.charAt(end))){
                end--;
            }
            if(start < end){
                char c = s.charAt(start);
                charArray[start] = s.charAt(end);
                charArray[end] = c;
                start++;
                end--;
            }
        }
        return new String(charArray);
    }
    
    public boolean repeatedSubstringPattern(String s) {
        
        if(s.length()%2 == 1)
        {
            char firstChar = s.charAt(0);
            
            for(char c : s.toCharArray()){
                if(c != firstChar)
                    return false;
            }
            
            return true;
        }
        String str = s.substring(0,s.length()/2);
        str = str + str;
        return s.equals(str);
    }
    
    public int numDecodings(String s) {
        
        while(!s.isEmpty() && s.charAt(0) == '0'){
            s = s.substring(1);
        }
        if(s.length() == 0)
            return 0;
        
        int arr[] = new int[s.length()];
        arr[s.length()-1] = 1;
        
        for(int i=s.length()-2; i>=0; i--){
               
            for(int j=i; j<s.length(); j++){
                if(Integer.parseInt(s.substring(i, j+1)) <= 26){
                     arr[i] = arr[i] + 1 + (j+1 < s.length() ? arr[j+1] : 0);
                }else{
                    break;
                }
            }
            
        }
        
        return arr[0];
        
    }
    
    
    public boolean isValidHexdecimalNumber(String num){
        for(char c : num.toCharArray()){
            if( (c>='0' && c<='9') || c>='a' || c<='f')
                continue;
            else
                return false;
        }
        return true;
    }
    
    public boolean matchCharCountInString(String str, char inputChar, int count){
        int tempCount = 0;
        for(char c : str.toCharArray()){
            if(c == inputChar)
                tempCount++;
        }
        //System.out.println(tempCount);
        if(count == tempCount)
            return true;
        return false;
    }
    
    public String validIPAddress(String IP) {
        
        if(IP.contains(".")){
            
            StringTokenizer st = new StringTokenizer(IP, ".");
            
            if(!matchCharCountInString(IP, '.',3) || st.countTokens() < 4 )
                return "Neither";
            while(st.hasMoreTokens()){
                int val = 0;
                String nextTok = st.nextToken();
                if(nextTok.charAt(0) == '0'){
                    return "Neither";
                }
                try{
                    val = Integer.parseInt(nextTok);
                }catch(NumberFormatException nfe){
                    return "Neither";
                }
                //System.out.println(val);
                if(val < 0 || val >255)
                    return "Neither";
            }
            return "IPv4";
            
        }else if(IP.contains(":")){
             
            StringTokenizer st = new StringTokenizer(IP, ":");
             if(!matchCharCountInString(IP, ':', 7) || st.countTokens() < 8)
                return "Neither";
            while(st.hasMoreTokens()){
                
                if(!isValidHexdecimalNumber(st.nextToken()))
                    return "Neither";
            }
            return "IPv6";
        }
        return "Neither";
    }
    

}
