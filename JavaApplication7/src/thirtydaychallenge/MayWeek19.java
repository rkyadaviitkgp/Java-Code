/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thirtydaychallenge;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rajeshkumar.yadav
 */
public class MayWeek19 {

    public static void main(String[] args) {
        System.out.println("hi");
    }
    
    public int dfs(List<List<Integer>> tree, int startindex, int length, List<Boolean> apple) {

        int ans = 0;

        for (int i = 0; i < tree.get(startindex).size(); i++) {
            ans = ans + dfs(tree, tree.get(startindex).get(i), length + 1, apple);
        }

        if (apple.get(startindex) == true || ans != 0) {
            ans = length * 2;
        }

        return ans;

    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {

        List<List<Integer>> tree = new ArrayList<>(n);

        for (int i = 0; i < edges.length; i++) {
            tree.get(edges[i][0]).add(edges[i][1]);
        }
       
        return dfs(tree, 0, 0, hasApple);

    }

}
