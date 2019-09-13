
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

// For example, in this diagram, 6 and 8 have a common ancestor of 4.

//          14  13
//          |   |
// 1   2    4   12
//  \ /   / | \ /
//   3   5  8  9
//    \ / \     \
//     6   7     11

// parentChildPairs1 = [
//     (1, 3), (2, 3), (3, 6), (5, 6), (5, 7), (4, 5),
//     (4, 8), (4, 9), (9, 11), (14, 4), (13, 12), (12, 9)
// ]

// Write a function that takes the graph, as well as two of the individuals in our dataset, as its inputs and returns true if and only if they share at least one ancestor.

// Sample input and output:

// hasCommonAncestor(parentChildPairs1, 3, 8) => false
// hasCommonAncestor(parentChildPairs1, 5, 8) => true
// hasCommonAncestor(parentChildPairs1, 6, 8) => true
// hasCommonAncestor(parentChildPairs1, 6, 9) => true
// hasCommonAncestor(parentChildPairs1, 1, 3) => false
// hasCommonAncestor(parentChildPairs1, 7, 11) => true
// hasCommonAncestor(parentChildPairs1, 6, 5) => true
// hasCommonAncestor(parentChildPairs1, 5, 6) => true

// Additional example: In this diagram, 4 and 12 have a common ancestor of 11.

//         11
//        /  \
//       10   12
//      /  \
// 1   2    5
//  \ /    / \
//   3    6   7
//    \        \
//     4        8

// parentChildPairs2 = [
//     (11, 10), (11, 12), (10, 2), (10, 5), (1, 3),
//     (2, 3), (3, 4), (5, 6), (5, 7), (7, 8),
// ]

// hasCommonAncestor(parentChildPairs2, 4, 12) => true
// hasCommonAncestor(parentChildPairs2, 1, 6) => false
// hasCommonAncestor(parentChildPairs2, 1, 12) => false

public class ParentChildPair {

  public static int getParent(int ind, Map<Integer, ArrayList<Integer>> mp)
  {
      
      
      return 0;
  }
  public static boolean hasCommonAncestor(int[][] parentChildPairs, int p1, int p2)
  {
    Map<Integer, ArrayList<Integer>> mp = new HashMap<Integer, ArrayList<Integer>>();  
    
    
    for(int i=0; i<parentChildPairs.length; i++)
    {
      if(mp.get(parentChildPairs[i][1]) != null)
      {
        List<Integer> tempList =  mp.get(parentChildPairs[i][1]);
        tempList.add(parentChildPairs[i][0]);
      }
    }
    
    
    Map<Integer, Integer> hmp1 = new HashMap<Integer, Integer>();
    List<Integer> l1 = mp.get(p1);
    
    for(Integer i: l1){
       
    }
    
    return true;
  }
  public static void main(String[] argv) {
    

    

  }
}
