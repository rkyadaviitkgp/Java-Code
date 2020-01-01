
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rajeshkumar.yadav
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
public class Tree {
    
    public TreeNode mergeTree(TreeNode root1, TreeNode root2){
        
        if(root1 == null)
            return root2;
        TreeNode rightPart = root2.right;
        root2.right = null;
        if(root1.val > root2.val)
        {
            root1.left = mergeTree(root1.left, root2);
        }else if(root1.val < root2.val){
            root1.right = mergeTree(root1.right, root2);
        }else if(root1.val == root2.val){
            TreeNode leftPart = root2.left;
            root2.left = null;
            root1.left = mergeTree(root1.left, leftPart);
            root1.right = mergeTree(root1.right, root2);
        }
        root1 = mergeTree(root1, rightPart);
        return root1;
        
    }
    
    public void inorderTraversal(TreeNode root1, List<Integer> list){
        if(root1 == null)
            return;
        inorderTraversal(root1.left, list);
        list.add(root1.val);
        inorderTraversal(root1.right, list);
    }
    
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list = new ArrayList<Integer>();
        root1 = mergeTree(root1, root2);
        inorderTraversal(root1, list);
        return  list;
    }
    
    public List<List<Integer>> levelOrder(Node root) {
        
        List<List<Integer>> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        int count = 1;
        int tempcount = 0;
        queue.add(root);
        
        while(!queue.isEmpty())
        {
            List<Integer> listItem = new ArrayList<>();
            tempcount = 0;
            
            while(count != 0)
            {
                Node n = queue.poll();
                listItem.add(n.val);
                count--;
                for(int i=0; i<n.children.size(); i++){
                    queue.add(n.children.get(i));
                    tempcount++;
                }
            }
            list.add(listItem);
            count = tempcount;
        }
        
        return list;
    }
    
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        
    }
    
}
