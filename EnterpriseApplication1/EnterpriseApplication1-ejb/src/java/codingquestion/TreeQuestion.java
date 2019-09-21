/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codingquestion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.util.Pair;

// Definition for a binary tree node.
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/**
 *
 * @author rajeshkumar.yadav
 */
public class TreeQuestion {

    public void utilVerticalTraversal(TreeNode root, Map<Integer, List<Pair>> mp, int xCordinate, int yCordinate) {
        if (root == null) {
            return;
        }
        List<Pair> l1 = mp.get(xCordinate);
        if (l1 == null) {
            l1 = new ArrayList<>();
        }
        Pair p = new Pair(root.val, yCordinate);
        l1.add(p);
        mp.put(xCordinate, l1);

        utilVerticalTraversal(root.left, mp, xCordinate - 1, yCordinate - 1);
        utilVerticalTraversal(root.right, mp, xCordinate + 1, yCordinate - 1);

    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        Map<Integer, List<Pair>> mp = new HashMap<Integer, List<Pair>>();
        utilVerticalTraversal(root, mp, 0, 0);

        int max = 0, min = 0;
        for (Integer key : mp.keySet()) {
            if (max < key) {
                key = max;
            }
            if (min > key) {
                min = key;
            }
        }
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        for (int i = min; i <= max; i++) {
            if (mp.get(i) != null) {
                List<Pair> l1 = mp.get(i);
                l1.sort(new Comparator<Pair<Integer, Integer>>() {
                   @Override
                    public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                        if (o1.getValue() > o2.getValue()) {
                            return -1;
                        } else if (o1.getValue().equals(o2.getValue())) {
                            return 0; // You can change this to make it then look at the
                            //words alphabetical order
                        } else {
                            return 1;
                        }
                    }
                });
            }
        }

    }

    public TreeNode mergeUtil(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        int val = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);
        TreeNode newNode = new TreeNode(val);
        newNode.left = mergeUtil(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        newNode.right = mergeUtil(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
        return newNode;
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        return mergeUtil(t1, t2);
    }

}
