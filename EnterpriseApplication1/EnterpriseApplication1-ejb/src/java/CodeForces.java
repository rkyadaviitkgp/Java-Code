
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
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
public class CodeForces {
    
    public static void Problem3(){
        
        Stack<Integer> st = new Stack<>();
        
    }
    
    public static void problem1(BufferedReader br) throws  IOException{
        
        int t;
        String st1 = br.readLine();
        t = Integer.parseInt(st1);
        while(t > 0){
            
            t--;
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            Double n = Double.parseDouble(st.nextToken());
            Double d = Double.parseDouble(st.nextToken());
            //System.out.println("n d " + n + " " + d);
            //System.out.println(" Math.sqrt(d) + Math.ceil(Math.sqrt(d)) " + Math.sqrt(d) + " " +  Math.ceil(Math.sqrt(d)));
            Double ans = Math.sqrt(d) + Math.ceil(Math.sqrt(d)) - 1;
            //System.out.println(ans);
            if(Math.floor(ans) <= n){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
    
    
    public static int getMinCount(int arr[], int evenCount, int oddCount, int index, int count){
        
        if(index >= arr.length)
        {
            count = 0;
            System.out.print(arr[0] + " ");
            for(int i=1; i<arr.length; i++){
                int a = arr[i-1] % 2 ;
                int b = arr[i] % 2;
                if(a != b)
                    count++;
                System.out.print(arr[i] + " ");
            }
            System.out.println("count " + count + " ");
            return count;
        }
        
        int min = Integer.MAX_VALUE;
        int tempMin1 = Integer.MAX_VALUE;
        
            if(arr[index] == 0 )
            {
                if(evenCount > 0)
                {
                    arr[index] = 2;
                    min = getMinCount(arr, evenCount-1, oddCount, index+1, count);
                }
                if(oddCount > 0)
                {
                    arr[index] = 1;
                    tempMin1 = getMinCount(arr, evenCount, oddCount-1, index+1, count);
                }
                return Math.min(min, tempMin1);
                //tempMin = Math.min(getMinCount(), getMinCount(arr, evenCount, oddCount, index, count));
            }else{
                return getMinCount(arr, evenCount, oddCount, index+1, count);
            }
                    
        
        
    }
    
    public static int problem2(BufferedReader br) throws  IOException{
        
        String str = br.readLine();
        int n = Integer.parseInt(str);
        
        str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int i = 0;
        int arr[] = new int[n];
        
        int oddCount = 0;
        int evenCount = 0;
        
        while(st.hasMoreElements()){
            
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] != 0){
                if(arr[i] %2 == 0)
                    evenCount++;
                else
                    oddCount++;
            }
            i++;
        }
        
        return getMinCount(arr, evenCount, oddCount, 0, 0);
        
    }
    
    public static void main(String[] args){
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            System.out.println(problem2(br));
        }catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
        
        
        
    }
}
