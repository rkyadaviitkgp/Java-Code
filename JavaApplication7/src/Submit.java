
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rajeshkumar.yadav
 */
public class Submit {

    public void problem1(long n) {

        if (n == 1) {
            System.out.print(n);
            return;
        }
        System.out.print(n + " ");
        if (n % 2 == 0) {
            problem1(n / 2);
        } else {
            problem1(n * 3 + 1);
        }
    }
    
    public int numUniqueEmails(String[] emails) {
        
        HashSet<String> hs = new HashSet<String>();
        for(int i=0; i<emails.length; i++){
            String email = emails[i];
            String name, domain;
            int ind = email.lastIndexOf('@');
            name = email.substring(0, ind);
            domain = email.substring(ind+1, email.length());
            if(name.indexOf('+') != -1){
                name = name.substring(0, name.indexOf('+'));
            }
            StringBuffer sb = new StringBuffer();
            for(char c : name.toCharArray()){
                if(c != '.')
                    sb.append(c);
            }
            name = sb.toString();
            email = name+ "@" + domain;
            hs.add(email);
        }
        return hs.size();
    }

    public void problem2(long n, long sum) {
        long res = (n * (n + 1)) / 2 - sum;
        System.out.println(res);
    }

    public void problem3() {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        String s = sc.next();
        int max = 1;
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                count++;
            } else {
                if (max < count) {
                    max = count;
                }
                count = 1;
            }
        }
        if (max < count) {
            max = count;
        }
        System.out.println(max);
    }

    public void problem4() {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        long turn = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] > arr[i]) {
                turn = turn + arr[i - 1] - arr[i];
                arr[i] = arr[i - 1];
            }
        }
        System.out.println(turn);
    }

    public void problem5() {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int n = sc.nextInt();
        if (n == 1) {
            System.out.print(n);
            return;
        }
        if (n >= 2 && n <= 3) {
            System.out.println("NO SOLUTION");
            return;
        }
        StringBuffer sb = new StringBuffer();
        if (n % 2 == 0) {
            
            for (int i = 2; i <= n; i = i + 2) {
                sb.append(i + " ");
                //System.out.print();
            }
            for (int i = 1; i < n; i = i + 2) {
                sb.append(i + " ");
                //System.out.print(i + " ");
            }
            System.out.println(sb.toString());
        } else {
            for (int i = n - 1; i > 0; i = i - 2) {
                //System.out.print(i + " ");
                sb.append(i + " ");
            }
            for (int i = n; i > 0; i = i - 2) {
                //System.out.print(i + " ");
                sb.append(i + " ");
            }
            System.out.println(sb.toString());
            
        }

    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(new InputStreamReader(System.in));
//        int n = sc.nextInt();
//        long sum = 0;
//        for(int i=0; i<n-1; i++)
//            sum = sum + sc.nextInt();
        Submit ob = new Submit();
        ob.problem5();
        //ob.problem4();
        //ob.problem3();
        //ob.problem2(n, sum);
        //ob.problem1(n);
    }

}
