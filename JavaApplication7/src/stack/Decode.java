/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

import java.util.Stack;

/**
 *
 * @author rajeshkumar.yadav
 */
public class Decode {

    public String decodeAtIndex(String S, long K) {

        long ind = 0;
        for (int i = 0; i < S.length(); i++) {

            if (!Character.isDigit(S.charAt(i))) {
                ind++;
            } else {
                int st = i;
                while (i < S.length() && Character.isDigit(S.charAt(i))) {
                    i++;
                }
                String st1 = S.substring(st, i);
                i--;

                long newind = ind * Integer.parseInt(st1);
                //System.out.println("newind and i is and k is " + newind + " " + i + " " + K);
                if (newind < K) {
                    ind = newind;

                } else if (K == newind) {
                    while (i >= 0 && Character.isDigit(S.charAt(i))) {
                        i--;
                    }
                    return S.charAt(i) + "";

                } else {
                    return decodeAtIndex(S, ind - newind % K);
                }
                //System.out.println("ind and i is and k is " + ind + " " + i + " " + K);
            }

            if (ind == K) {
                return S.charAt(i) + "";
            }
        }
        return decodeAtIndex(S, K - ind);
    }

    public String removeKdigits(String num, int k) {

        Stack<Integer> st = new Stack<Integer>();
        st.push(Character.digit(num.charAt(0), 10));
        int ind = 1;

        while (ind < num.length()) {
            int d = Character.digit(num.charAt(ind), 10);
            ind++;

            while (k > 0 && !st.isEmpty() && st.peek() > d) {
                k--;
                st.pop();
            }
            st.push(d);
        }
        while(k>0 && !st.isEmpty()){
            k--;
            st.pop();
        }
        StringBuilder sb;
        sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return removeLeadingZero(sb.reverse().toString()) ;
    }
    
    public boolean find132pattern(int[] nums) {
        
        Stack<Integer> st = new Stack<Integer>();
        st.push(nums[0]);
        for(int i=1; i<nums.length; i++){
            
            if(!st.isEmpty() && st.peek() <= nums[i]){
                st.push(nums[i]);
            }else{
                while(!st.isEmpty() && st.peek() > nums[i])
                {
                    st.pop();
                }
                if(!st.isEmpty())
                    return true;
            }
            
        }
        
        return false;
        
    }
    
    public static String removeLeadingZero(String str){
        int i = 0;
        while(i < str.length() && str.charAt(i) == '0')
        {
            i++;
        }
        String s =  str.substring(i, str.length());
        if(s.isEmpty())
            return "0";
        else
            return s;
    }

    public static void main(String[] args) {
        Decode d = new Decode();
        String str = "ajx37nyx97niysdrzice4petvcvmcgqn282zicpbx6okybw93vhk782unctdbgmcjmbqn25rorktmu5ig2qn2y4xagtru2nehmsp";
        int num = 976159153;

        /*
        "leet2code3"
        10
        "1432219"
3
        "vzpp636m8y"
        2920
         */
        //System.out.println("stack.Decode.main()" + d.decodeAtIndex(str, num)); 
        System.out.println("stack.Decode.main()" + d.removeKdigits("1432219", 5));
    }

}
