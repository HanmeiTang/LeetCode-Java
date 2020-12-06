package ood.LinkedList;


public class MyLinkedList {
    private int size;
    private Node head;
    private Node tail;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        this.size = 0;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index >= size) return -1;

        // scan from head
        Node cur = head;
        while (index > 0) {
            cur = cur.next;
            index--;
        }

        return cur.val;
    }

    /**
     * Add a node of value val before the first element of the linked list.
     * After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node newHead = new Node(val);

        if (size == 0) {
            this.head = newHead;
            this.tail = newHead;
            size++;
            return;
        }

        // connect and update head
        newHead.next = head;
        head.prev = newHead;
        head = newHead;

        // update size
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node newTail = new Node(val);

        if (size == 0) {
            this.tail = newTail;
            this.head = newTail;
            size++;
            return;
        }

        // connect and update tail
        tail.next = newTail;
        newTail.prev = tail;
        this.tail = newTail;
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list.
     * If index equals to the length of linked list, the node will be appended to the end of linked list.
     * If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index == 0 && size == 0) {
            addAtHead(val);
            return;
        }

        if (index > size) return;

        Node newNode = new Node(val);
        Node dummy = new Node(0);
        dummy.next = head;
        Node pre = dummy;
        Node cur = head;

        if (index == 0) this.head = newNode;
        if (index == size) {
            this.tail.next = newNode;
            newNode.prev = tail;
            this.tail = newNode;
            size++;
            return;
        }

        // locate
        while (index > 0) {
            pre = cur;
            cur = cur.next;
            index--;
        }

        // insert
        pre.next = newNode;
        newNode.prev = pre;
        newNode.next = cur;
        cur.prev = newNode;

        // update size
        size++;
        //dummy.next = null;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index >= size) return;

        if (size == 1) {
            this.head = null;
            this.tail = null;
            this.size = 0;

        } else if (size == 2) {
            size--;
            if (index == 0) {
                this.head.next = null;
                this.tail.prev = null;
                this.head = this.tail;
            } else {
                this.tail.prev = null;
                this.head.next = null;
                this.tail = this.head;
            }
        } else {
            Node dummy = new Node(0);
            dummy.next = head;
            Node pre = dummy;
            Node cur = head;

            // locate the node
            while (index > 0) {
                pre = cur;
                cur = cur.next;
                index--;
            }

            // reconnect
            pre.next = cur.next;
            if (cur.next != null) cur.next.prev = pre;
            cur.next = null;
            cur.prev = null;

            // update size, head and tail
            if (index == 0) {
                this.head = dummy.next;
                this.head.prev = null;
            } else if (index == size - 1) {
                this.tail = pre;
                this.tail.next = null;
            }

            size--;

            // remove dummy bond
            dummy.next = null;
        }

    }

    private class Node {
        int val;
        Node next;
        Node prev;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        MyLinkedList ml = new MyLinkedList();
        ml.addAtHead(7);
        ml.addAtHead(2);
        ml.addAtHead(1);
        ml.addAtIndex(3, 0);
        ml.deleteAtIndex(2);
        ml.addAtHead(6);
        ml.addAtTail(4);
        ml.get(4);
        ml.addAtHead(4);
        ml.addAtIndex(5, 0);
        ml.addAtHead(6);

        System.out.println(ml.size);
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */