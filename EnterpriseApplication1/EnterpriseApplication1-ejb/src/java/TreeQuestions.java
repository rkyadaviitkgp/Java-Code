
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

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
        children = new ArrayList<>();
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}


class Tree{
    
    Map<Integer, Node> nodeMap;
    Map<Node, Boolean> rootTrack;
    Node treeRoot;
    int[][] matrix;
    int matrixRow;
    int matrixColumn;
    
    public Tree(int mat[][]){
        
        matrixRow = mat.length;
        matrixColumn = mat[0].length;
        treeRoot = null;
        matrix = new int[matrixRow][matrixColumn];
        for(int i=0; i<matrixRow; i++)
        {
            System.arraycopy(mat[i], 0, matrix[i], 0, matrixColumn);
        }
        nodeMap = new HashMap<>();
        rootTrack = new HashMap<>();
    }
    
    private void populateHashTable(){
        
        for(int i=0; i<matrixRow; i++){
            for(int j=0; j<matrixColumn; j++){
                if(nodeMap.get(matrix[i][j]) == null){
                    Node n = new Node(matrix[i][j]);
                    nodeMap.put(matrix[i][j], n);
                    rootTrack.put(n, Boolean.TRUE);
                }
            }
        }
        
    }

    @Override
    public String toString() {
         for(int i=0; i<matrixRow; i++){
            for(int j=0; j<matrixColumn; j++){
                System.out.print(matrix[i][j] + " ");
            }
             System.out.println("");
        }
        return "Tree{" + "nodeMap=" + nodeMap + ", rootTrack=" + rootTrack + ", treeRoot=" + treeRoot + ", matrix=" + matrix + ", matrixRow=" + matrixRow + ", matrixColumn=" + matrixColumn + '}';
    }
    
    
    
    public void printLevelOrderTraversal(){
        
        if(treeRoot == null)
        {
            System.err.println("Tree root is null");
        }
        
        Queue<Node> q = new LinkedList<>();
        q.add(treeRoot);
        
        while(!q.isEmpty()){
            
            int size = q.size();
            while(size > 0){
                size--;
                Node curNode = q.poll();
                System.out.print(curNode.val + " ");
                for(Node childNode : curNode.children){
                    q.add(childNode);
                }
            }
            System.out.println("");
        }
        
    }
    
    public void buildTree(){
        
        populateHashTable();
        
        for(int i=0; i<matrixRow; i++)
        {
            Node iterationParent = nodeMap.get(matrix[i][0]);
            for(int j=1; j<matrixColumn; j++){
                Node iterationChild = nodeMap.get(matrix[i][j]);
                iterationParent.children.add(iterationChild);
                    //rootTrack.put(iterationChild, Boolean.FALSE);
                rootTrack.replace(iterationChild, Boolean.FALSE);
            }
        }
        
        for(Node n : rootTrack.keySet()){
            //System.out.println(n.val + " " + rootTrack.get(n));
            if(rootTrack.get(n) == true)
            {
                treeRoot = n;
                break;
            }
        }
        printLevelOrderTraversal();
    }
    
}

class BinaryTree{
    
    int val;
    BinaryTree leftChild;
    BinaryTree rightChild;

    public BinaryTree(int val) {
        this.val = val;
        leftChild = rightChild = null;
    }
    
    private boolean isNumber(String s){
        
        try{
            
            int val  = Integer.parseInt(s);
            return true;
            
        }catch(NumberFormatException e){
            return false;
        }
        
    }
    
    void inorderTraversal(BinaryTree root, Stack<BinaryTree> st){
        
        if(root == null)
            return;
        inorderTraversal(root.leftChild, st);
        st.push(root);
        //System.out.println(root.val + " ");
        inorderTraversal(root.rightChild, st);
        
    }
    
    BinaryTree bToDLL(BinaryTree root)
    {
	    Stack<BinaryTree> st = new Stack<BinaryTree>();
	    inorderTraversal(root, st);
            
	       System.out.println("size of stack" + st.size());
               
	    if(st.isEmpty())
	        return root;
	        
	    BinaryTree prev = null;
	    BinaryTree next = null;
	    
	    while(!st.isEmpty()){
	        
	        prev = st.pop();
	        System.out.println("Processing " + prev.val);
	        prev.rightChild = next;
	        
	        if(next != null)
	        {
	            next.leftChild = prev;
	        }
	        next = prev;
	    }
	    //head = next;
	    next.leftChild = null;
	    return next;
    }
    
    
    public void printTree(BinaryTree head){
        BinaryTree h1 = head;
        BinaryTree l1 = null;
        while(h1 != null){
            System.out.print(h1.val + " -> ");
            l1 = h1;
            h1 = h1.rightChild;
        }
        System.out.println("NULL");
        
        
        while(l1 != null){
            System.out.print(l1.val + " -> ");
            l1 = l1.leftChild;
        }
        System.out.println("NULL");
        
    }
    
    public BinaryTree populateBinaryTree(String[] arr){
        
        BinaryTree root = null;
        if(arr.length == 0)
            return root;
        int v = Integer.parseInt(arr[0]);
        root = new BinaryTree(v);
        int i = 1;
        Queue<BinaryTree> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty() && i<arr.length){
            
            int size = q.size();
            while(size > 0 && i < arr.length){
                
                size--;
                BinaryTree bt = q.poll();
                if(i<arr.length && isNumber(arr[i]))
                {
                    v = Integer.parseInt(arr[i]);
                    //System.out.println("v = " + v);
                    bt.leftChild = new BinaryTree(v);
                    q.add(bt.leftChild);
                }
                i++;
                if(i<arr.length && isNumber(arr[i]) ){
                    v = Integer.parseInt(arr[i]);
                    //System.out.println("v = " + v);
                    bt.rightChild = new BinaryTree(v);
                    q.add(bt.rightChild);
                }
                i++;
                
            }
        }
        
        levelOrderTraversal(root);
        return root;
    }
    
    public void levelOrderTraversal(BinaryTree root){
        
        if(root == null)
            return;
        
        Queue<BinaryTree> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            
            int size = q.size();
            while(size > 0){
                
                size--;
                BinaryTree bt = q.poll();
                System.out.print(bt.val + " ");
                
                if(bt.leftChild != null)
                    q.add(bt.leftChild);
                if(bt.rightChild != null)
                    q.add(bt.rightChild);
                
            }
            System.out.println();
        }
    }
    
}


public class TreeQuestions {
    
    public static void main(String[] args) {
        
//        int[][] mat = {{5,14,15,16},{2,11,12,13},{1,2,3,4},{3,5,6,7},{4,8,9,10}};
//        
//        Tree t = new Tree(mat);
//        //System.out.println(" " + t);
//        t.buildTree();
          String arr[] = {"1","2","3","4","5","NULL","NULL"};
          BinaryTree bt =  new BinaryTree(1);
          bt = bt.populateBinaryTree(arr);
          BinaryTree head = bt.bToDLL(bt);
          bt.printTree(head);
        
    }
    
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
    
    public void findDepth(TreeNode root, List<TreeNode> l, int depth){
        
        if(root == null)
            return ;
        
        findDepth(root.left, l, depth+1);
        
        if(root.left == null && root.right == null)
        {
            if(l.get(0).val < depth)
            {
                l.clear();
                l.add(new TreeNode(depth));
                //l.add(depth);
                l.add(root);
            }else if(l.get(0).val == depth){
                l.add(root);
            }
        }
        
        findDepth(root.right, l, depth+1);
        
    }
    
    public List<TreeNode> lcaDeepestLeavesUtil(TreeNode root) {
        
        List<TreeNode> l1 = new ArrayList<TreeNode>();
        TreeNode t = new TreeNode(0);
        l1.add(t);
        findDepth(root, l1, 0);
        l1.remove(0);
        
//        for(int i = 1; i<l1.size(); i++){
//            System.out.println(l1.get(i));
//        }
        return l1;
    }
    
    public void getPathToNode(TreeNode root, List<TreeNode> list, TreeNode targetNode){
        
        if(root == null)
            return;
        
        if(list.isEmpty() || list.get(list.size()-1) != targetNode)
            list.add(root);
        
        getPathToNode(root.left, list, targetNode);
        if(!list.isEmpty() && list.get(list.size()-1) != targetNode)
            list.remove(root);
        getPathToNode(root.right, list, targetNode);
        
    }
    
    public void compareTwoLca(List<TreeNode> lca, List<TreeNode> tempLca){
        int i = 0;
        
        while(i<lca.size() && i<tempLca.size() && lca.get(i) == tempLca.get(i)){
            i++;
        }
        
        for(int j=lca.size()-1; j>=i; j++){
            lca.remove(j);
        }
        
    }
    
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        
        List<TreeNode> list = new ArrayList<>();
        list = lcaDeepestLeavesUtil(root);
        
        if(list.size() == 1)
            return list.get(0);
        
        List<TreeNode> lca = null;// = new ArrayList<>();
        
        for(TreeNode node : list){
            
            List<TreeNode> lcaTemp = new ArrayList<>();
            getPathToNode(root,lcaTemp,node);
            if(lca == null)
                lca = lcaTemp;
            else{
                compareTwoLca(lca, lcaTemp);
                //compare and get min lca of current node and caltil now
                
            }
            
        }
        
        return lca.get(lca.size()-1);
    }
    
//    public int rangeSumBSTUtil(TreeNode root, int L, int R){
//        
//        
    //}
    
    public int rangeSumBST(TreeNode root, int L, int R) {
        
        
        
        if( root == null )
            return 0;
        
        int sum = 0;
        
        if(root.val >= L && root.val <= R )
            sum = sum + root.val;
        
        if(root.val > L )
            sum = sum +  rangeSumBST(root.left, L, R);
        if(root.val < R)
            sum = sum +  rangeSumBST(root.right, L, R);
        
        
        return sum;
    }
    
    
}
