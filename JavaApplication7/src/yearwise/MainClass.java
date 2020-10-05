/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yearwise;

import java.util.List;

/**
 *
 * @author rajeshkumar.yadav
 */
public class MainClass {
    
    public static void main(String[] args) {
        UtilClass utl = new UtilClass();
        int nums[] = {1,2,3};
        List<Integer> l = utl.largestDivisibleSubset(nums);
        System.out.println(l);
    }
    
}
