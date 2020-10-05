/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yearwise;

import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author rajeshkumar.yadav
 */
class MySolution{
    int len;
    int arr[];
    public MySolution(int l, int a[]){
        len = l;
        arr = a;
    }
}

class Reactangle{
    
    int n;
    int arr[][];
    
    public Reactangle(int len, int a[][]){
        
        arr = a;
        n = len;
    }
    
    
    
}
public class CodeChefDSA {
    
    

    public static void main() {
        int t;
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        t = sc.nextInt();
        while (t > 0) {
            t--;
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
        }
        
    }

}
