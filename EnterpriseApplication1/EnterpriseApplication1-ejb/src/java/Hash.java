
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
class FindElements {

    //Map<Integer, Boolean> mp;
    Set<Integer> set;//
    public void fillHashMap(TreeNode root, int x){
        if(root == null)
            return;
        root.val = x;
        set.add(x);
        //mp.put(x, Boolean.TRUE);
        fillHashMap(root.left, 2*x + 1);
        fillHashMap(root.right, 2*x + 2);
    }
    public FindElements(TreeNode root) {
        //mp = new HashMap<>();
        set = new HashSet<>();
        fillHashMap(root, 0);
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }
}
public class Hash {
    
}
