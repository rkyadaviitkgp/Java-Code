/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miscellaneous;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rajeshkumar.yadav
 */
public class Solution {

    public int getIndex(int arr[], int start, int end, int item) {

        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (arr[mid] == item) {
            return mid;
        } else if (arr[mid] < item) {
            return getIndex(arr, mid + 1, end, item);
        } else {
            return getIndex(arr, start, mid - 1, item);
        }

    }

//    public int getIndexOfMaxItem(int arr[], int start, int end){
//        
//        if(end >= arr.length)
//            return getIndexOfMaxItem(arr, start, end/2);
//        
//        if(start == end)
//            return start;
//       
//        if(arr[end-1] <= arr[end])
//            return getIndexOfMaxItem(arr, end, 2*end);
//        else
//            return getIndexOfMaxItem(arr, start, end/2);
//        
//    }
    public int getIndexOfMaxItem(int arr[], int start, int end) {

        if (start > end) {
            return -1;
        }

        if (start == end) {
            return start;
        }

        int mid = start + (end - start) / 2;

        if (arr[start] > arr[mid]) {
            return getIndexOfMaxItem(arr, start, mid - 1);
        } else {
            return getIndexOfMaxItem(arr, mid + 1, end);
        }

    }

    public int search(int[] nums, int target) {

        int ind = getIndexOfMaxItem(nums, 0, nums.length - 1);
        if (nums.length <= 2) {
            ind = 0;
        }
        int ans = getIndex(nums, 0, ind, target);
        if (ans != -1) {
            return ans;
        }
        ans = getIndex(nums, ind + 1, nums.length - 1, target);
        return ans;

    }

    int max_path_sum(int A[], int B[]) {
        int l1 = A.length;
        int l2 = B.length;
        int sum1 = 0;
        int sum2 = 0;
        int ind1 = 0;
        int ind2 = 0;
        while (ind1 < l1 && ind2 < l2) {
            if (A[ind1] == B[ind2]) {
                if (sum1 < sum2) {
                    sum1 = sum2;
                } else {
                    sum2 = sum1;
                }
                sum1 = sum1 + A[ind1];
                sum2 = sum2 + B[ind2];
                ind1++;
                ind2++;
            } else if (A[ind1] > B[ind2]) {
                sum2 = sum2 + B[ind2];
                ind2++;
            } else {
                sum1 = sum1 + A[ind1];
                ind1++;
            }
        }

        while (ind1 < l1) {
            sum1 = sum1 + A[ind1];
            ind1++;
        }

        while (ind2 < l2) {
            sum2 = sum2 + B[ind2];
            ind2++;
        }

        if (sum1 > sum2) {
            return sum1;
        }
        return sum2;
    }

    public void generateParenthesis(String str, int op, int cl, int n, List<String> list) {

        if (str.length() == 2 * n) {
            list.add(str);
            return;
        }

        if (op < cl && op <= n) {
            str = str + '(';
            generateParenthesis(str, op + 1, cl, n, list);
            return;

        } else {

            if (op <= n) {
                String str1 = str + '(';
                generateParenthesis(str1, op + 1, cl, n, list);
            }

            if (cl <= n && cl < op) {
                str = str + ')';
                generateParenthesis(str, op, cl + 1, n, list);
            }

        }

    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        String str = "";
        generateParenthesis(str, 1, 1, n, list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        return list;
    }
    
    private int recursiveCompare(String x, String y, int xind, int yind)
    {
        if(xind >= x.length() && yind >= y.length())
            return Integer.parseInt(x);
        if(xind >= x.length())
            return recursiveCompare(x, y, 0, yind);
        if(yind >= y.length())
            return recursiveCompare(x, y, xind, 0);
        if(x.charAt(xind) > y.charAt(yind))
            return Integer.parseInt(x);
        else if(x.charAt(xind) < y.charAt(yind))
            return Integer.parseInt(y);
        else
            return recursiveCompare(x, y, xind+1, yind+1);
    }
    
    public String largestNumber(int[] nums) {
        
        String ans = "";
        for(int i=0; i<nums.length; i++)
        {
            int max = nums[i];
            int maxind = i;
            
            for(int j=i+1; j<nums.length; j++)
            {
               int nmax = recursiveCompare(Integer.toString(max), Integer.toString(nums[j]), 0, 0);
               if(nmax != max)
               {
                   max = nmax;
                   maxind = j;
               }
            }
            if(maxind != i)
            {
                int a = nums[i];
                nums[i] = nums[maxind];
                nums[maxind] = a;
            }
            ans = ans + Integer.toString(max);
        }
        int i = 0;
        int flag = 0;
        while(i<ans.length())
        {
            if(ans.charAt(i) != '0')
                flag = 1;
            i++;
        }
        if(flag == 0)
            return "0";
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {121,121};
        System.out.println(s.largestNumber(arr));
        //s.generateParenthesis(3);
    }
    
    
    

}
