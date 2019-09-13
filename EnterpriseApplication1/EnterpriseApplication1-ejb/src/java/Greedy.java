/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rajeshkumar.yadav
 */
import java.util.*;
import java.lang.*;
import  java.io.*;

public class Greedy {
    
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputN = br.readLine();                // Reading input from STDIN
        int n  = Integer.parseInt(inputN);
        String nos = br.readLine();
        StringTokenizer st = new StringTokenizer(nos, " ");
        int[] arr = new int[st.countTokens()];
        int index = 0;
        while(st.hasMoreElements())
        {
            arr[index++] = Integer.parseInt(st.nextToken());
        }
    }
    
}
