/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singlylinklist;
/**
 *
 * @author rajeshkumar.yadav
 */
public class SolveQuestions {

    public LinkList mergeList(LinkList l1, LinkList l2) {

        LinkListNode res = null;
        LinkListNode h1 = l1.head;
        LinkListNode h2 = l2.head;
        LinkListNode temp = null;

        while (h1 != null && h2 != null) {
            LinkListNode nextNode = null;
            if (h1.val > h2.val) {
                nextNode = h2;
                h2 = h2.next;
            } else {
                nextNode = h1;
                h1 = h1.next;
            }
            if (res == null) {
                res = temp = nextNode;
            } else {
                temp.next = nextNode;
                temp = temp.next;
            }
        }
        if (h1 != null && temp != h1) {
            if (temp != null) {
                temp.next = h1;
            } else {
                temp = res = h1;
            }
        }
        if (h2 != null && temp != h2) {
            if (temp != null) {
                temp.next = h2;
            } else {
                temp = res = h2;
            }
        }
        return res == l1.head ? l1 : l2;
    }
    
    public void testMergeList(int[] arr1, int[] arr2){
        LinkList l1 = new LinkList(arr1);
        l1.printList();
        LinkList l2 = new LinkList(arr2);
        l2.printList();
        LinkList l3 = mergeList(l1, l2);
        l3.printList();
    }

    public void testMergeList() {
        
        int[] arr1 = {4, 15, 26, 37};
        int[] arr2 = {1, 4, 13, 28, 35, 48};
        testMergeList(arr1, arr2);
        int[] arr3 = {100, 101, 110};
        int[] arr4 = {1, 4, 13, 28, 35, 48};
        testMergeList(arr3, arr4);
        int[] arr5 = {};
        int[] arr6 = {1, 4, 13, 28, 35, 48};
        testMergeList(arr5, arr6);
        
    }

    //merge sort for linklist
    public void linkListMergeSort(LinkList list) {
        list.head = linkListMergeSort(list.head);
    }

    //util function
    public LinkListNode linkListMergeSort(LinkListNode h1) {

        //base condition
        if(h1 == null || h1.next == null)
            return h1;
        // get middle node
        LinkListNode middle = getMiddleNode(h1);
        // separte give list in two list
        LinkListNode h2 = ((middle != null) ? middle.next : middle);
        if (middle != null) {
            middle.next = null;
        }
        // apply merge sort on both list
        h1 = linkListMergeSort(h1);
        h2 = linkListMergeSort(h2);
        // merge sorted list
        LinkList res = mergeList(new LinkList(h1), new LinkList(h2));
        return res.head;
        // return head of sorted list  
    }

    // get middle element of list 
    public LinkListNode getMiddleNode(LinkListNode head) {

        if(head == null || head.next == null)
            return head;
        LinkListNode temp = head.next.next;
        while (temp != null) {
            head = head.next;
            temp = temp.next;
            if (temp != null) {
                temp = temp.next;
            }
        }
        return head;
    }
    
    //test merge sort
    public void testMergeSort(){
        int[] arr = {4,3,5,8,10,1,2,3};
        LinkList l1 = new LinkList(arr);
        l1.printList();
        linkListMergeSort(l1);
        l1.printList();
        
        int[] arr2 = {};
        l1 = new LinkList(arr2);
        l1.printList();
        linkListMergeSort(l1);
        l1.printList();
        
        int[] arr3 = {5,4,3,2,1};
        l1 = new LinkList(arr3);
        l1.printList();
        linkListMergeSort(l1);
        l1.printList();
    }
    
    public void revreseInChunkOfK(LinkList list, int k){
        
        LinkListNode newHead = null;
        LinkListNode temp = list.head;
        LinkListNode lastEndNode = null;
        
        while(temp != null){
           
           LinkListNode startSubListNode = temp;
           
           //revrese each k chunk 
           LinkListNode prev = null;
           for(int i=0; i<k && temp != null; i++){
               LinkListNode nextNode = temp.next;
               temp.next = prev;
               prev = temp;
               temp = nextNode;
           }
           
           if(newHead == null){
               newHead = prev;
               lastEndNode = startSubListNode;
           }else{
               lastEndNode.next = prev;
               lastEndNode = startSubListNode;
           }
            
        }
        
        list.head = newHead;
    }
    
    public void testRevreseInChunkOfK(){
        int[] arr = {4,3,5,8,10,1,2,3};
        int k = 2;
        LinkList l1 = new LinkList(arr);
        l1.printList();
        revreseInChunkOfK(l1, k);
        l1.printList();
    }
    
    //test isLoop function
    public void testIsLoop(LinkList l1){
         if(l1.isLoop()){
            System.out.println("Constains Loop ");
        }else{
            System.out.println("Does Not Constains Loop ");
        }
    }
    public void testIsLoop(){
//        int[] arr = {4,3,5,8,10,1,2,3};
//        LinkList l1 = new LinkList(arr);
//        l1.printList();
//        testIsLoop(l1);
//        l1.createLoop(4);
//        testIsLoop(l1);
//        l1.removeLoop();
//        testIsLoop(l1);
//        l1.printList();
        
        int[] arr1 = {4,3,5,8,10,1,2};
        LinkList l1 = new LinkList(arr1);
        l1.printList();
        testIsLoop(l1);
        l1.createLoop(1);
        testIsLoop(l1);
        l1.removeLoop();
        testIsLoop(l1);
        l1.printList();
    }
    
    public static void main(String[] args) {
        SolveQuestions sq = new SolveQuestions();
        //sq.testMergeList();
        //sq.testMergeSort();
        //sq.testRevreseInChunkOfK();
        sq.testIsLoop();
    }

}
