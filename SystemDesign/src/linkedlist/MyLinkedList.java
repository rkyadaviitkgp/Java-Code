/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

/**
 *
 * @author rajeshkumar.yadav
 */
class MyLinkedList {

    private LinkedListNode head;
    private LinkedListNode tail;
    private int size;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public LinkedListNode getIthNode(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        LinkedListNode iterator = head;
        for (int i = 0; i < index; i++) {
            iterator = iterator.getNext();
        }

        return iterator;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is
     * invalid, return -1.
     */
    public int get(int index) {

        LinkedListNode temp = getIthNode(index);
        if (temp != null) {
            return temp.getVal();
        }

        return -1;
    }

    /**
     * Add a node of value val before the first element of the linked list.
     * After the insertion, the new node will be the first node of the linked
     * list.
     */
    public void addAtHead(int val) {
        
        addAtIndex(0, val);

    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        
        addAtIndex(size, val);

    }

    /**
     * Add a node of value val before the index-th node in the linked list. If
     * index equals to the length of linked list, the node will be appended to
     * the end of linked list. If index is greater than the length, the node
     * will not be inserted.
     */
    public void addAtIndex(int index, int val) {

        if (index > size) {
            return;
        }

        if (index <= 0) {
            if (head == null) {
                head = tail = new LinkedListNode(val);
                size++;
            } else {
                LinkedListNode temp = new LinkedListNode(val);
                temp.setNext(head);
                head = temp;
                size++;
            }
            return;
        } else if (index == size) {
            if (head == null) {
                head = tail = new LinkedListNode(val);
                size++;
            } else {
                LinkedListNode temp = new LinkedListNode(val);
                tail.setNext(temp);
                tail = temp;
                size++;
            }
            return;
        }
        
        LinkedListNode temp = getIthNode(index-1);
        LinkedListNode nexttemp = temp.getNext();
        LinkedListNode newNode = new LinkedListNode(val);
        temp.setNext(newNode);
        newNode.setNext(nexttemp);
        size++;
        
        

    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        
        if(index >= size)
            return;
        
        if (index == 0) {
            if (head == null) {
                return;
            } else {
                LinkedListNode temp = head;
                head = head.getNext();
                temp.setNext(null);
                if(size == 1)
                    tail = null;
                size--;
            }
            return;
        } else if (index == size - 1) {
                LinkedListNode temp = tail;
                tail = getIthNode(size-2);
                tail.setNext(null);
                size--;
            
            return;
        }
        
        LinkedListNode temp = getIthNode(index-1);
        LinkedListNode nexttemp = temp.getNext().getNext();
        temp.setNext(nexttemp);
        size--;

    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList(); int param_1 = obj.get(index);
 * obj.addAtHead(val); obj.addAtTail(val); obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
