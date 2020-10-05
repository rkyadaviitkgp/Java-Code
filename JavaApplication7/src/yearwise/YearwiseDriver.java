/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yearwise;

import sun.security.krb5.internal.rcache.AuthList;

/**
 *
 * @author rajeshkumar.yadav
 */
public class YearwiseDriver {
    
    public static void main(String[] args) {
        JuneWeek24 wk = new JuneWeek24();
        boolean b = wk.testRecursion(3,928376);
        System.out.println(" b " + b);
    }
    
}
