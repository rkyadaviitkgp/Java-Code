
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rajeshkumar.yadav
 */
public class HackerEarthDataStructureCodingChallenge {

    public static void SieveOfEratosthenes(int n, boolean[] prime) {
        // Create a boolean array "prime[0..n]" and initialize 
        // all entries it as true. A value in prime[i] will 
        // finally be false if i is Not a prime, else true. 
       //
       Arrays.fill(prime, true);
       prime[0] = prime[1] = false;
        for (int p = 2; p * p <= n; p++) {
            // If prime[p] is not changed, then it is a prime 
            if (prime[p] == true) {
                // Update all multiples of p greater than or  
                // equal to the square of it 
                // numbers which are multiple of p and are 
                // less than p^2 are already been marked.  
                for (int i = p * p; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }

//        // Print all prime numbers 
//        for (int p = 2; p <= n; p++) {
//            if (prime[p]) {
//                System.out.println(p + " ");
//            }
//        }
    }

    public static void main(String[] args) throws IOException {
        boolean[] prime = new boolean[1000001]; 
        SieveOfEratosthenes(1000000, prime);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();                // Reading input from STDIN
        int q = Integer.parseInt(input);
          
        while(q-- > 0){
            
            input = br.readLine(); 
            int n = Integer.parseInt(input);
            int count  = 0;
            for(int i=4; i<n; i++){
                if(n%i != 0 && prime[i]==false)
                    count++;
            }
            System.out.println(count);
        }
    }

}
