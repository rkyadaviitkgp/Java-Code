/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yearwise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rajeshkumar.yadav
 */
class TreeAncestor {

    int len;
    int arr[];
    HashMap<Integer, HashMap<Integer, Integer>> hm = new HashMap<Integer, HashMap<Integer, Integer>>();
    public TreeAncestor(int n, int[] parent) {
        arr = parent;
        len = n;
    }
    
    public int getKthAncestor(int node, int k) {
        if(hm.containsKey(node))
        {
            HashMap<Integer, Integer> h = hm.get(node);
            if(h.containsKey(k))
                return h.get(k);
        }
        int v = node;
        while(k > 0 && node != -1){
            node = arr[node];
            k--;
        }
        HashMap<Integer, Integer> h = new HashMap<>();
        h.put(k, node);
        hm.put(v, h);
        return node;
    }
}


class ReadInput{
    
    Scanner sc;
    BufferedReader br;

    public ReadInput() {
        sc = new Scanner(new InputStreamReader(System.in));
        br = new BufferedReader(new InputStreamReader(System.in));
    }
    
    public void voidreadUsingBuffredReader(){
        try {
            String s = br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(ReadInput.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}

public class JuneWeek24 {
    
    public boolean testRecursion(int source, int destination){
        Queue<Integer> q = new LinkedList<Integer>() ;
        q.add(source);
        HashSet<Integer> hs = new HashSet<>();
        while(!q.isEmpty())
        {
            int val = q.poll();
            
            if(val == destination)
                return true;
            
            System.out.println(val);
            hs.add(val);
            
            if(!hs.contains(val*2)){
                q.add(val*2);
            }
            
            if(!hs.contains(val + 2)){
                q.add(val + 2);
            }
           
            if(!hs.contains(val/2) ){
                q.add(val/2);
            }
            
        }
        System.out.println(" Not Found 1");
        return false;
    }
    
    public int depthFirstSearch(int row, int col, int [][] grid){
        
        if(row >= grid.length || col >= grid[0].length)
            return 0;
        if(grid[row][col] == 0 || grid[row][col] > 1)
            return 0;
        grid[row][col] = 2;
        int a = depthFirstSearch(row + 1, col, grid);
        int b = depthFirstSearch(row - 1, col, grid);
        int c = depthFirstSearch(row, col + 1, grid);
        int d = depthFirstSearch(row, col - 1, grid);
        grid[row][col] = 1 + a + b + c + d;
        return grid[row][col];
        
    }
    
    public int countServers(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int ans = 0;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                ans = ans + depthFirstSearch(i, j, grid);
            }
        }
        return ans;
    }
    
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<deck.length; i++)
        {
            hm.put(deck[i], hm.getOrDefault(deck[i], 0) + 1);
        }
        int count = hm.get(deck[0]);
        for(int key : hm.keySet()){
            if(hm.get(key) <= 1 || hm.get(key) != count)
                return false;
        }
        return true;
    }
    
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        
        
        int ind = 0;
        while(ind < flowerbed.length ){
            
            if(flowerbed[ind] == 0 && ind-1 >= 0 && flowerbed[ind-1] == 0 && ind+1 < flowerbed.length && flowerbed[ind+1] == 0)
            {
                n--;
                ind = ind + 2;
            }else{
                ind++;
            }
            
        }
        if(ind <= 0)
            return true;
        return false;
    }
    
    
    
    public void problem1(int n){
        
        if(n == 1)
        {
            System.out.print(n);
            return;
        }
        System.out.print(n + " ");
        if(n%2 == 0)
        {
            problem1(n/2);
        }else{
            problem1(n*3 + 1);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int n = sc.nextInt();
        JuneWeek24 ob = new JuneWeek24();
        ob.problem1(n);
    }
    
}
