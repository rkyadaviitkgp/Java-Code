/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rajeshkumar.yadav
 */
import java.util.*;
import java.lang.*;
import  java.io.*;
//Definition for a binary tree node.
//  class TreeNode {
//      int val;
//      TreeNode left;
//      TreeNode right;
//      TreeNode(int x) { val = x; }
//  }
public class Greedy {
    
//    public static void main(String args[]) throws IOException
//    {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String inputN = br.readLine();                // Reading input from STDIN
//        int n  = Integer.parseInt(inputN);
//        String nos = br.readLine();
//        StringTokenizer st = new StringTokenizer(nos, " ");
//        int[] arr = new int[st.countTokens()];
//        int index = 0;
//        while(st.hasMoreElements())
//        {
//            arr[index++] = Integer.parseInt(st.nextToken());
//        }
//    }
    
   
    
    public void zigzagLevelOrderUtil(TreeNode root, List<List<Integer>> l){
        
        
        Queue<TreeNode> qu = new java.util.LinkedList<>();
        int count = 0;
        if(root != null)
        {
            qu.add(root);
            count++;
        }
        int oddEven = 0;
        while(!qu.isEmpty()){
            int count1 = count;
            count = 0;
            List<Integer> level = new ArrayList<>();
            while(count1 > 0){
                //count1--;
                TreeNode t = qu.poll();
                level.add(t.val);
                if(t.left != null)
                {
                    qu.add(t.left);
                    count++;
                }
                if(t.right != null)
                {
                    qu.add(t.right);
                    count++;
                }
                count1--;
            }
            if(oddEven == 1)
            {
                Collections.reverse(level);
                oddEven = 0;
            }else{
                oddEven = 1;
            }
            l.add(level);
            
        }
    }
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<>();
        levelOrderUtil(root, ans);
        return ans;
    }
    
    public void levelOrderUtil(TreeNode root, List<List<Integer>> l){
        
        
        Queue<TreeNode> qu = new java.util.LinkedList<>();
        int count = 0;
        if(root != null)
        {
            qu.add(root);
            count++;
        }
        while(!qu.isEmpty()){
            int count1 = count;
            count = 0;
            List<Integer> level = new ArrayList<>();
            while(count1 > 0){
                //count1--;
                TreeNode t = qu.poll();
                level.add(t.val);
                if(t.left != null)
                {
                    qu.add(t.left);
                    count++;
                }
                if(t.right != null)
                {
                    qu.add(t.right);
                    count++;
                }
                count1--;
            }
            l.add(level);
            
        }
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<>();
        levelOrderUtil(root, ans);
        return ans;
    }
    
    public void rightSideViewUtil(TreeNode root, List<Integer> l){
        
        
        Queue<TreeNode> qu = new java.util.LinkedList<>();
        int count = 0;
        if(root != null)
        {
            qu.add(root);
            count++;
        }
        while(!qu.isEmpty()){
            int count1 = count;
            count = 0;
            while(count1 > 0){
                //count1--;
                TreeNode t = qu.poll();
                if(count1 == 1)
                    l.add(t.val);
                if(t.left != null)
                {
                    qu.add(t.left);
                    count++;
                }
                if(t.right != null)
                {
                    qu.add(t.right);
                    count++;
                }
                count1--;
            }
            
            
        }
    }
    
    
    
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> l = new ArrayList<Integer>();
        rightSideViewUtil(root,l);
        return l;
    }
    
    public int getPivotElementUtil(int[] arr, int start, int end){
        
        if(start > end)
            return -1;
        
        int mid = start + (end-start)/2;
        
        if(arr[mid] > arr[mid+1])
            return mid;
        else if(arr[start] < arr[mid]){
            return getPivotElementUtil(arr, mid+1, end);
        }else{
            return getPivotElementUtil(arr, start, mid);
        }
        
    }
    
    public void getPivotElement(int arr[]){
        System.out.println(getPivotElementUtil(arr, 0, arr.length-1));
    }
    
    public void sortStackUtil(Stack<Integer> s){
        
        if(s.isEmpty())
            return;
        int m = s.pop();
        while(!s.isEmpty() && m < s.peek()){
            int n = m;
            m = s.pop();
            s.push(n);
            sortStackUtil(s);
        }
        sortStackUtil(s);
        s.push(m);
    }
    
    public void sortStackUtil1(Stack<Integer> s){
        
        if(s.isEmpty())
            return;
        
        int m = s.pop();
        sortStackUtil1(s);
        sortInsertStackItem(s, m);
        
    }
    
    public void sortInsertStackItem(Stack<Integer> s, int a){
        
        if(s.isEmpty())
        {
            s.push(a);
            return;
        }
        if(a < s.peek())
        {
            s.push(a);
            return;
        }
        
        int m = s.pop();
        sortInsertStackItem(s,a); 
        s.push(m);
        
    }
    
    public Stack<Integer> sortStack(Stack<Integer> s){
        
        sortStackUtil1(s); 
        return s;
        
    }
    
    public int getPrecedence(char c){
        if(c == '-' || c == '+')
            return 1;
        else if(c == '*')
            return 2;
        return -1;
    }
    
    public boolean  isOperand(char c){
        if(c >= '0' && c <= '9')
            return true;
        return false;
    }
    
    public String infixToPostFixConversion(String s){
        
        String postfix = new String("");
        Stack<Character> st = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            
            if(isOperand(s.charAt(i)))
            {
                postfix = postfix + s.charAt(i);
                continue;
            }else if(s.charAt(i) == '(')
                st.push(s.charAt(i));
            else if(s.charAt(i) == ')'){
                
                while(!st.isEmpty() && st.peek() != '(')
                    postfix += st.pop();
                if(!st.isEmpty() && st.peek() != '(')
                    return "Invalid";
                st.pop();
                
            }else{
                
                while(!st.isEmpty() && getPrecedence(s.charAt(i)) <= getPrecedence(st.peek()) ){
                    if(!st.isEmpty() && st.peek() == '(')
                        return "Invalid";
                    postfix += st.pop();
                }
                
                 st.push(s.charAt(i));
            }
            
        }
        while(!st.isEmpty())
        {
            if(st.peek() == '(')
                return "Invalid";
            postfix += st.pop();
        }
        //System.out.println(" postfix " + postfix);
        return postfix;
    }
    
    public int EvalauteExpression(int a, int b, char c){
        if(c == '+')
            return a + b;
        if(c == '-')
            return a-b;
        if(c == '*')
            return a*b;
        return -1;
    }
    
    public int evaluatePostfix(String postfix){
        
        Stack<Integer> st = new Stack<>();
        int value = 0;
        
        for(int i=0; i<postfix.length(); i++){
            
            char c = postfix.charAt(i);
            if(isOperand(postfix.charAt(i)))
            {
                st.push(Integer.parseInt(c+""));
                continue;
            }else {
                int b = Integer.parseInt(st.pop()+"");
                int a = Integer.parseInt(st.pop() + "");
                value = EvalauteExpression(a,b,c);
                st.push(value);
            }
            
            
        }
        if(st.size() > 1)
            return -1;
        
        return value;
    }
    
    public String generateExpressionWithParenthesis(String s){
        
        int i = 0;
        while(i < s.length()){
            
            while(i < s.length() && s.charAt(i) != '*')
                i++;
            if(i == s.length())
                break;
            String s1 = s.substring(0, i-1);
            s1 = s1.concat("(");
            //System.out.println(s1);
            int j = i - 1;
            while(i<s.length() && (s.charAt(i)!='+' || s.charAt(i) != '-'))
                i++;
            String s2 = s.substring(j,i);
            s2 = s2.concat(")");
            String s3 = s.substring(i);
            s1 = s1.concat(s2);
            s1 = s1.concat(s3);
            s = s1;
            i = i+2;
        }
        return s;
    }
    
    public void generateAllPossibleExpression(String num, int index, String exp, List<String> l, int target){
        
        if(index >= num.length())
            return;
        
        String[] operators = {"+","-","*"};
        
        if(index == num.length()-1)
        {
            //System.out.println("Greedy.generateAllPossibleExpression() starts "); 
            exp = exp.concat(Character.toString(num.charAt(index)));
            // System.out.println("Generated Expression " + exp);
            //make a call to enclose expreesion with brackets
            exp = generateExpressionWithParenthesis(exp);
            //System.out.println("Generated Expression with parenthesis " + exp);
            // convert expression in postfix
            exp = infixToPostFixConversion(exp);
            //System.out.println("Generated Postfix Expression " + exp);
            //call here evaluation function
            int val = evaluatePostfix(exp);
            //System.out.println("Evaluated Value  " + val);
            if(val == target)
                l.add(exp);
            //System.out.println("Greedy.generateAllPossibleExpression() terminate ");
            return;
        }
        String exp1 = exp;
        for(int i=0; i<operators.length; i++)
        {
            exp = exp1;
            exp = exp.concat(Character.toString(num.charAt(index)));
            exp = exp.concat(operators[i]);
            //System.out.println(exp);
            generateAllPossibleExpression(num,index+1,exp,l, target);
        }
       
    }
    
    public List<String> addOperators(String num, int target) {
        
        List<String> ans = new ArrayList<String>();
        String exp = "";
        generateAllPossibleExpression(num,0,exp,ans, target);
        for(int i=0; i<ans.size(); i++)
            System.out.println(ans.get(i));
        return ans;
    }
    
    public static void main(String args[]){
        
        Greedy dp = new Greedy();
        dp.addOperators("105", 5);
        
        //        Stack<Integer> s = new Stack<>();
        //        s.push(11);
        //        s.push(2);
        //        s.push(32);
        //        s.push(3);
        //        s.push(41);
        //        dp.sortStack(s);
        //        while(!s.isEmpty())
        //        {
        //            System.out.println(" item " + s.pop());
        //        }        
        //        int arr[] = {5,6,7,8,1,2,3,4};
        //        dp.getPivotElement(arr);    
        //        System.out.println("Greedy.main()");
        
    }
    
}
