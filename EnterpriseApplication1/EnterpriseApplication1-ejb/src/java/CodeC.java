
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rajeshkumar.yadav
 */
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
public class CodeC {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        if(root == null)
            return "";
        
        String leftpart = serialize(root.left);
        String rightpart = serialize(root.right);
        String finalString = "";
        
        finalString = Integer.toString(root.val) + "l" + Integer.toString(leftpart.length()) + ";"  + leftpart + "r" +
                  Integer.toString(rightpart.length()) + ";" + rightpart;
                
        return finalString;
        
    }
    
     public static int subarraySum(int[] nums, int k) {
        
        int len = nums.length;
        int[] sum = new int[len];
        sum[0] = nums[0];
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        list.add(0);
        map.put(sum[0], list);
        
        int count = 0;
        for(int i=1; i<len; i++)
        {
            sum[i] = sum[i-1] + nums[i];
            list = new ArrayList<Integer>();
            if(map.get(sum[i]) != null)
            {
                list = map.get(sum[i]);
                list.add(i);
                
            }
            else{
                list = new ArrayList<Integer>();
                list.add(i);
            }
            map.put(sum[i], list);
            
        }
        for(int i=0; i<len; i++)
        {
            if(k == sum[i])
            {
                count++;
            }else if(map.get(sum[i] - k) != null)
            {
                list = map.get(sum[i] - k);
                for(Integer item: list)
                {
                    if(i>item)
                        count++;
                    else
                        break;
                           
                }
            }
            System.out.println("sum[i] i count " + sum[i] + " " + i + " " + count);
            System.out.println("list.indexOf(sum[i] - k) " + list.lastIndexOf(sum[i] - k));
        }
        return count;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        //
        if(data == null || data.equalsIgnoreCase(""))
            return null;
        int index = data.indexOf("l");
        
        int val = Integer.valueOf(data.substring(0, index));
        System.out.println("val = " + val);
        TreeNode tempnode = new TreeNode(val);
        data = data.substring(index+1);
        System.out.println("data = " + data);
        index = data.indexOf(";");
        int lefttreelen = Integer.valueOf(data.substring(0, index));
        System.out.println("leftlen = " + lefttreelen);
        String lefttree = data.substring(index+1, index+1+lefttreelen);
        System.out.println("lefttree = " + lefttree);
        
        String righttree = data.substring(index+1+lefttreelen+1);
        index = righttree.indexOf(";");
        int rightlen = Integer.valueOf(righttree.substring(0, index));
        righttree = righttree.substring(index+1);
        System.out.println("righttreelen = " + rightlen);
         System.out.println("righttree = " + righttree);
         if(lefttreelen != 0)
        tempnode.left = deserialize(lefttree);
         if(rightlen != 0)
        tempnode.right = deserialize(righttree);
        return tempnode;
        
    }
    
    public static void main(String args[])
    {
//        CodeC cdc = new CodeC();
//        
//        System.out.println("hi");
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        String str = cdc.serialize(root);
//        System.out.println(str);
//        cdc.deserialize(str);
        int arr[] = {-1,-1,1};
          subarraySum(arr, 0);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
 //4L4;5L3;R5;