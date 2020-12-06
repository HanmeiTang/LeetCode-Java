package ood.lru;

// Cache is a storage to optimized read performance
// In general, cache is a key value store ==> look up something by a key

// About `Least Recently Used (LRU)`
// LRU Eviction Strategy: remove the oldest entry in the cache in terms visit timestamp

// Requirement analysis
//  1. This cache should support lookup value by a given key
//     --> BST (if key has a order)
//         or HashMap (more general)
//  2. when this cache is full and you want to add a new key value pair,
//     then the oldest key value pair should be evicted
//     --> this implies we should store key value pairs based on
//         visit time stamp in ascending order

// Possible LRU cache solutions
// 1. BST<timestamp, <key, value>>  // work but way too complex
// 2. ArrayList<map.Entry<key, val>> // a stupid solution, O(n)
// 3. optimized solution 2: use doubly-linked list LinkedList<Entry<key, val>>, O(1)
// 3. optimized solution 3: use ArrayDeque<map.Entry<key, val>>

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

// Implementation
// Index is built from storage (storage create, update, delete affects index)


// Java Implementation
public class LRUCache extends LinkedHashMap {
    int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return (int) super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eledest) {
        return size() > capacity;
    }
}

class MyLRUCache {

    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    private void addNode(DLinkedNode node) {
        /**
         * Always add the new node right after head.
         */
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        /**
         * Remove an existing node from the linked list.
         */
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void moveToHead(DLinkedNode node) {
        /**
         * Move certain node in between to the head.
         */
        removeNode(node);
        addNode(node);
    }

    private DLinkedNode popTail() {
        /**
         * Pop the current tail.
         */
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }


    public MyLRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        // head.prev = null;

        tail = new DLinkedNode();
        // tail.next = null;

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) return -1;

        // move the accessed node to the head;
        moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);

        if (node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            cache.put(key, newNode);
            addNode(newNode);

            ++size;

            if (size > capacity) {
                // pop the tail
                DLinkedNode tail = popTail();
                cache.remove(tail.key);
                --size;
            }
        } else {
            // update the value.
            node.value = value;
            moveToHead(node);
        }
    }

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
    }
}

