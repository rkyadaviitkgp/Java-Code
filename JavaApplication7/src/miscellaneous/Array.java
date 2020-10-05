/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miscellaneous;

import java.util.Arrays;
import java.util.HashSet;

/**
 *
 * @author rajeshkumar.yadav
 */
public class Array {
    
    void removeDuplicate(int arr[])
    {
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i=0; i<arr.length; i++)
        {
            if(!hashSet.contains(arr[i]))
            {
                System.out.print(arr[i] + " ");
                hashSet.add(arr[i]);
            }
        }
//	Arrays.sort(arr, 0, arr.length);
//        int curind = 0;
//        System.out.print(arr[curind] + " ");
//        for(int i=1; i<arr.length; i++){
//            if(arr[curind] == arr[i])
//            {
//                continue;
//            }else{
//                curind  = i;
//                System.out.print(arr[curind] + " ");
//            }
//        }
    }
    
}
