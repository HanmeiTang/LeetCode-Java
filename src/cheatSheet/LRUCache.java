package cheatSheet;

import java.util.*;

public class LRUCache {
    private Integer head;
    private Integer tail;
    private final int capacity;
    private int size;
    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        size = 0;
    }

    public int get(int key) {
        // if not in this cache
        if (!map.containsKey(key)) return -1;
        else {
            moveToHead(key);
            return map.get(key).val;
        }
    }

    public void put(int key, int value) {
        // if the key alread there!!!!
        if (map.containsKey(key)) {
            // update node
            map.get(key).val = value;
            moveToHead(key);
            return;
        }

        if (size == 0) {
            head = key;
            tail = key;
            map.put(key, new Node(key, value));
            size++;
        } else {
            Node node = new Node(key, value);
            node.next = map.get(head);
            map.get(head).prev = node;
            head = key;
            map.put(key, node);
            size++;
        }

        if (size > capacity) {
            // remove the tail
            popTail();
        }
    }

    private void popTail() {
        // debonding
        Node curTail = map.get(tail);
        Node newTail = curTail.prev;
        curTail.prev = null;
        newTail.next = null;

        // remove from the dict
        map.remove(curTail.key);

        // reset tail
        this.tail = newTail.key;

        // update size
        size--;
    }

    public int size() {
        return this.size;
    }

    private void moveToHead(int key) {
        if (!map.containsKey(key) || head == key) return;

        // update the tail if necessary
        if (tail == key && size > 1) {
            tail = map.get(key).prev.key;
        }

        // debonding  (HEAD) A<->B<->C (TAIL)
        Node node = removeNode(key);

        // rebonding
        node.next = map.get(head);
        map.get(head).prev = node;
        head = key;
        map.put(key, node);
    }

    // debonding  (HEAD) A<->B<->C (TAIL)
    // return the isolated node, no record in map
    private Node removeNode(int key) {
        if (!map.containsKey(key)) return null;

        Node node = map.get(key);
        if (node.prev != null) node.prev.next = node.next;
        if (node.next != null) node.next.prev = node.prev;
        node.prev = null;
        node.next = null;

        map.remove(key);

        return node;
    }

    class Node {
        Integer key;
        Integer val;
        Node next;
        Node prev;

        public Node(Integer key, Integer val) {
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        LRUCache c = new LRUCache(2);
        c.put(1, 1);
        c.put(2, 2);
        c.get(1);
        c.put(3, 3);
        System.out.println(c.get(2));
        c.put(4, 4);
        c.get(1);
        c.get(3);
        c.get(4);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

