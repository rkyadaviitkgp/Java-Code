/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codingquestion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author rajeshkumar.yadav
 */
public class SeptemberCircuitColourBoxes {

    public int getFactorial(int m)
    {
        if(m == 0 || m == 1)
            return 1;
        int fac = 1;
        for(int i=2; i<=m; i++)
            fac = fac * i;
        return fac;
    }
    
    public static long onlineTaxi(long distance, long oc, long of, long od)
    {
        if(distance < of)
            return oc;
        return oc + (distance - of) * od ;
    }
    
    public static long classicTaxi(long distance, long cs, long cb, long cm, long cd){
        
        return  cb + ( distance / cs ) * cm + cd * distance;
    }
    
    public static void goingToOffice(BufferedReader br) throws IOException
    {
        String input = br.readLine(); 
        StringTokenizer st = new StringTokenizer(input);
        long d, oc, of, od, cs, cb, cm, cd;
        d = Integer.parseInt(st.nextToken());
        input = br.readLine();
        st = new StringTokenizer(input);
        oc = Long.parseLong(st.nextToken());
        of = Long.parseLong(st.nextToken());
        od = Long.parseLong(st.nextToken());
        
        input = br.readLine();
        st = new StringTokenizer(input);
        cs = Long.parseLong(st.nextToken());
        cb = Long.parseLong(st.nextToken());
        cm = Long.parseLong(st.nextToken());
        cd = Long.parseLong(st.nextToken());
        
        long cost1 =  onlineTaxi(d, oc, of, od);
        long cost2 = classicTaxi(d, cs, cb, cm, cd);
        
        if(cost1 > cost2)
        {
            System.out.println("Classic Taxi");
        }else{
            System.out.println("Online Taxi");
        }
        
    }
    
    public static void main(String args[]) throws Exception {
       
        int mod = 1000000007;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        goingToOffice(br);
//        String input = br.readLine();                // Reading input from STDIN
//        StringTokenizer st = new StringTokenizer(input," ");
//        int n, m;
//        n = Integer.parseInt(st.nextToken());
//        m = Integer.parseInt(st.nextToken());
//        //System.out.println("n m" + n + " " + m);
//        int res  = 1; 
//        int m1 = m;
//        for(int i=1; i<=n; i++)
//        {
//            res = (res * m1)%mod;
//            m1--;
//            if(m1 == 0)
//                m1 = m;
//            //System.out.println("res " + res);
//        }
//        System.out.println(res);
    }

}
