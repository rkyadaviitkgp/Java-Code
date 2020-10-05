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
public class LinkList {

    LinkListNode head;

    //craete an empty list
    public LinkList() {
        head = null;
    }

    //craete a list with elements given array
    public LinkList(int[] arr) {
        head = null;
        LinkListNode temp = null;
        for (int val : arr) {
            if (temp == null) {
                temp = head = new LinkListNode(val);
            } else {
                temp.next = new LinkListNode(val);
                temp = temp.next;
            }
        }
    }

    public LinkList(LinkListNode h) {
        head = h;
    }

    // does a link list contains loop
    public boolean isLoop() {

        LinkListNode h1 = head;
        LinkListNode h2 = (h1 != null ? h1.next : h1);

        while (h1 != h2 && h2 != null) {
            h1 = h1.next;
            h2 = h2.next;
            if (h2 != null) {
                h2 = h2.next;
            }
        }
        return (h2 != null);
    }

    //craete a loop in a link list
    public void createLoop(int location) {
        if (isLoop()) {
            return;
        }
        LinkListNode nodePtr = head;
        LinkListNode ref = null;
        while (location > 0 && nodePtr != null) {
            location--;
            nodePtr = nodePtr.next;
        }
        if (nodePtr == null || location < 0) {
            System.out.println("singlylinklist.LinkList.createLoop() invalid location");
            return;
        }
        ref = nodePtr;
        while (nodePtr.next != null) {
            nodePtr = nodePtr.next;
        }
        nodePtr.next = ref;
    }

    //detect postion of loop and remove it 
    public void removeLoop() {
        if (!isLoop()) {
            return;
        }
        LinkListNode h1 = head.next;
        LinkListNode h2 = head.next.next;
        while (h1 != h2) {
            h1 = h1.next;
            h2 = h2.next.next;
        }
        h1 = head;
        
        //circular link list case
        if(h1 == h2){
            h1 = h1.next;
            while(h1.next != h2){
                h1 = h1.next;
            }
            h1.next = null;
            return;
        }
        
        while(h1.next != h2.next)
        {
            h1 = h1.next;
            h2 = h2.next;
        }
        h2.next = null;
    }

    public void printList() {
        LinkListNode temp = head;
        System.out.println("Link List : ");
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }

}
