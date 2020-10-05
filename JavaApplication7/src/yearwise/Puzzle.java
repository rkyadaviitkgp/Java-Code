/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yearwise;

import java.util.Arrays;
import java.util.Stack;

/**
 *
 * @author rajeshkumar.yadav
 */
class Pair {

    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        //return "(" + x + "," + y + ") ";
        return x * 4 + y + 1 + "";
    }

}

public class Puzzle {

    public static void main(String[] args) {
        Puzzle sol = new Puzzle();
        sol.calculateTime();
    }
    
    public void calculateTime(){
        Puzzle sol = new Puzzle();
        long alltime = 0;
        long noOfTimes = 1;
        for (int i = 0; i < noOfTimes; i++) {
            alltime += sol.puzzle();
        }
        System.out.println("Total time :" + (alltime / 10) + " ns");
    }

    public void recursive(int[][] arr, int x, int y, int count, Stack<Pair> st) {

        if (x == 0 && y == 3 && arr[x][y] == 0 && count == 15) {
            st.push(new Pair(x, y));
            System.out.println(st);
            st.pop();
            return;
        }

        if (x < 0 || x >= arr.length || y < 0 || y >= arr[0].length) {
            return;
        }

        if (arr[x][y] >= 1 && !(x == 3 && y == 0)) {
            /* already visisted and not cell 13 then return */
            return;
        }

        if (arr[x][y] == 0) {
            /* only increament if its not visisted */
            count++;
        }

        arr[x][y]++;
        st.push(new Pair(x, y));

        recursive(arr, x + 1, y, count, st);
        recursive(arr, x - 1, y, count, st);
        recursive(arr, x, y + 1, count, st);
        recursive(arr, x, y - 1, count, st);

        arr[x][y]--;
        st.pop();

    }

    public long puzzle() {
        long start = System.nanoTime();
        int len = 4;
        Stack<Pair> st = new Stack();
        int arr[][] = new int[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(arr[i], 0);
        }
        recursive(arr, 3, 0, 0, st);
        return System.nanoTime() - start ;
    }

}
