//


  //Definition for singly-linked list.
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

  
class Solution {
//    public ListNode mergeKLists(ListNode[] lists) {
//        
//        ListNode headNode = null;
//        ListNode tempNode = null;
//        int minInd;
//        int flag = 1;
//        
//        while(flag == 1)
//        {
//            flag = 0;
//            minInd = 0;
//            for(int i=0; i<lists.length; i++)
//            {
//                if(lists[i] != null)
//                {
//                    flag = 1;
//                    if(lists[minInd] == null || lists[minInd].val > lists[i].val)
//                    {
//                        minInd = i;
//                    }
//                }
//            }
//            if(tempNode == null)
//            {
//                headNode = tempNode = lists[minInd];
//            }else{
//                tempNode.next = lists[minInd];
//            }
//            lists[minInd] = lists[minInd].next;
//        }
//        
//        return headNode;
//    }
    /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

    
public ListNode mergeKLists(ListNode[] lists) {
        
    
    
    
        
        ListNode headNode = null;
        ListNode tempNode = null;
        boolean loopChecker = true;
        while(loopChecker)
        {
            loopChecker = false;
            int minind = -1;
            for(int i = 0; i<lists.length; i++)
            {
                if(lists[i] != null)
                {
                    if(minind == -1)
                        minind = i;
                    loopChecker = true;
                    if(lists[i].val < lists[minind].val)
                    {
                        minind = i;
                    }
                }
            }
            if(headNode == null)
            {
                headNode = lists[minind];
                tempNode = lists[minind];
                lists[minind] = lists[minind].next;
            }
            else if(loopChecker){
                
                tempNode.next = lists[minind];
                tempNode = tempNode.next;
                lists[minind] = lists[minind].next;
            }
        }
        
        return headNode;
        
    }

}