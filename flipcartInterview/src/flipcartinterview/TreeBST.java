/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flipcartinterview;

/**
 *
 * @author rajeshkumar.yadav
 */
class Value{
    
    int val;

    public Value(int val) {
        this.val = val;
    }

    
    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
    
    
}
public class TreeBST {
    
    Node root;

    public TreeBST() {
        root = null;
    }
    
    public void printInorder(Node rt)
    {
        if(rt == null)
            return;
        printInorder(rt.left);
        System.out.println(rt.getVal() + " ");
        printInorder(rt.right);
    }
    
    public Node insertVal(int val, Node rt)
    {
        if(rt == null)
        {
            Node newNode = new Node(val);
                return newNode;
        }
        if(rt.getVal() < val)
        {
            rt.right = insertVal(val, rt.right);
        }
        else
        {
            rt.left = insertVal(val, rt.left);
        }
        return rt;
    }
    
    public void createBST(int arr[])
    {
        for(int i=0; i<arr.length; i++)
        {
            root = insertVal(arr[i], root);
        }
    }

    
    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
    
    public boolean hasNext(Node rt)
    {
        if(rt == null)
            return false;
        boolean b = hasNext(rt.getLeft());
        if(rt.isVisited() == false)
            return true;
        boolean b1 = false;
        if(b == false)
            b1 = hasNext(rt.getRight());
        return b || b1;
    }
    
    public Value next(Node rt, Value v)
    {
        if(rt == null)
            return v;
        
        v = next(rt.left, v);
        
        if(v == null && rt.isVisited() == false)
        {
            rt.setVisited(true);
            v = new Value(rt.getVal());
            return  v;
        }
        
        if(v == null)
        {
            v = next(rt.getRight(), v);
        }
        return v;
    }
    public static void main(String[] args) {
        
        int arr[] = {10, 5, 15, 3, 7, 13, 17, 1, 4, 6, 8, 11, 14, 16, 18};
        TreeBST bst = new TreeBST();
        bst.createBST(arr);
        //bst.printInorder(bst.root);
        
        while(bst.hasNext(bst.root))
        {
            Value v = null;
            v = bst.next(bst.root, v);
            if(v!=null)
            System.out.println(v.getVal());
            else
            {
                System.out.println("got null v");
            }
        }
        System.out.println("flipcartinterview.TreeBST.main() terminate " );
        
    }
    
    
    
}
