
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rajeshkumar.yadav
 */
  //Definition for a binary tree node.
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
class Forest1 {
    
    
public TreeNode deleteNode(List<TreeNode> forest, Set<Integer> set, TreeNode root){
        if(root == null)
            return root;
        root.left = deleteNode(forest, set, root.left);
        root.right = deleteNode(forest, set, root.right);
        if(set.contains(root.val))
        {
            if(root.left != null)
                forest.add(root.left);
            if(root.right != null)
                forest.add(root.right);
            return  null;
        }
        return root;
 }
    
public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        
    List<TreeNode> forest = new ArrayList<>();
    Set<Integer> set = new HashSet<Integer>();
    for(int i : to_delete){
        set.add(i);
    }
    deleteNode(forest,set, root);
    if(!set.contains(root.val))
        forest.add(root);
    return forest; 
} 
public int[] searchRange(int[] nums, int target) {
    
    Arrays.sort(nums);
    int[] arr = new int[2];
    for(int i=0; i<nums.length; i++)
        if(nums[i] == target)
        {
            arr[0] = i;
            while(i<nums.length && arr[i] == target)
                i++;
            arr[1] = i-1;
        }
        return arr;
    }



}
