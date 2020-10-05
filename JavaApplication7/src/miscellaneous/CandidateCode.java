/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miscellaneous;

/**
 *
 * @author rajeshkumar.yadav
 */
import java.io.*;
import java.util.*;
public class CandidateCode {
    public static void main(String args[] ) throws Exception {

    	int n;
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        n = Integer.parseInt(input);
        input = br.readLine();
        long arr[] = new long[n];
        StringTokenizer st = new StringTokenizer(input, " ");
        int i = 0;
        while(st.hasMoreTokens())
        {
            arr[i] = Long.parseLong(st.nextToken());
            i++;
        }
        input = br.readLine();
        st = new StringTokenizer(input, " ");
        long res = Long.MAX_VALUE;
        
        for(i=0; i<n; i++)
        {
            long val = Long.parseLong(st.nextToken());
            if(val/arr[i] < res)
            {
                res = val/arr[i];
            }
        }
        System.out.print(res);

   }
}
