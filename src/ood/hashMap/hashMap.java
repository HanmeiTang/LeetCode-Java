package ood.hashMap;

import java.util.*;
// 1. organization
// key, val <Integer, Integer>
// Node <Integer, Integer>
// maintain a node of a linked list → deal with possible data colision
//

// 2. public methods
// boolean put(K key, V val)
// check if the key is already there
// true → update the key, val pair
// false →  create a new pair; update size
// check if the load factor is achieved
// true → rehash the hashMap
// false → do nothing


// V getValue(K key)
// check key is in the map
// true → return the value
// return null
// boolean set(K key, V val)
// check if the key already there
// true → update
// false → return false

// boolean  remove(K key)
// check if the key already there
// true →
// check if the entry is a size-1 linked list
// true → set current bucket to null, return true
// false --> remove the pair from the end of the linked list; return ture
// false → return false

// int size()
// get interal field size
// boolean isEmpty()
// return size() == 0;
// boolean containsKey(K key)
// hash(K key) and check if it is in the map
// boolean containsValue()

// 3. internal pro/method
// initial cap
// load factor & rehash
// Node[]

// implementation


import java.util.HashMap;

public class hashMap<K, V> {
    private final float LOAD_FACTOR = 0.75f;
    private static final int DEFAULT_CAP = 10;
    private int capacity;
    private int size;
    private Entry<K, V>[] nodeList;

    /**
     * Class constructor
     *
     * @param cap the initial capacity
     */
    public hashMap(int cap) {
        capacity = cap;
        size = 0;
        // java doesn't allow generic array
        // so create a non-generic array
        // then cast type
        nodeList = (Entry<K, V>[]) new Entry[capacity];
    }

    /**
     * Class constructor using default capacity DEFAULT_CAP
     */
    public hashMap() {
        this(DEFAULT_CAP);
    }

    // boolean containsKey(K key)
    // hash(K key) and check if it is in the map
    public boolean containsKey(K key) {
        if (key == null) {
            return false;
        }

        int index = getIndex(key);
        if (nodeList[index] == null) {
            return false;
        }

        Entry<K, V> cur = nodeList[index];
        while (cur != null) {
            if (cur.key.equals(key)) {
                return true;
            }
            cur = cur.next;
        }

        return false;
    }


    public Entry<K, V> getEntry(K key) {
        if (key == null || !containsKey(key)) {
            return null;
        }

        int index = getIndex(key);
        Entry<K, V> entry = nodeList[index];
        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry;
            }
            entry = entry.next;
        }

        return null;
    }

    // V getValue(K key)
    // check key is in the map
    //  true → return the value
    //  return null
    public V getValue(K key) {
        if (key == null) {
            return null;
        }

        Entry<K, V> entry = getEntry(key);
        if (entry == null) {
            return null;
        } else {
            return entry.val;
        }
    }

    // boolean set(K key, V val)
    // check if the key already there
    //      true → update
    //      false → return false
    public boolean set(K key, V val) {
        if (key == null) {
            return false;
        }
        if (!containsKey(key)) {
            return false;
        }

        Entry<K, V> entry = getEntry(key);
        entry.val = val;
        return true;
    }

    // boolean put(K key, V val)
    // check if the key is already there
    //      true → update the key, val pair
    //      false →  create a new pair; update size
    //      check if the load factor is achieved
    //          true → rehash the hashMap
    //          false → do nothing
    public boolean put(K key, V val) {
        if (key == null) {
            return false;
        }

        if (containsKey(key)) {
            this.set(key, val);
            return true;
        } else {
            int index = getIndex(key);
            if (nodeList[index] == null) {
                nodeList[index] = new Entry<K, V>(key, val);
            } else {
                Entry<K, V> entry = nodeList[index];
                while (entry.next != null) {
                    entry = entry.next;
                }
                entry.next = new Entry<K, V>(key, val);
            }

            // check if we need to rehash
            size++;
            if ((float) size / capacity > LOAD_FACTOR) {
                rehash();
            }
            return true;
        }
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    // boolean  remove(K key)
    // check if the key already there
    // true →
    //      check if the entry is a size-1 linked list
    //          true → set current bucket to null, return true
    //          false --> remove the pair from the end of the linked list; return ture
    // false → return false

    public boolean remove(K key) {
        if (key == null || !containsKey(key)) {
            return false;
        }

        // if size == 1
        Entry<K, V> cur = nodeList[getIndex(key)]; // head node
        if (cur.next == null) {
            cur = null;
            size--;
            return true;
        }

        // if the size > 1
        Entry<K, V> dummy = new Entry<>(cur.key, cur.val);
        Entry<K, V> pre = dummy;
        dummy.next = cur;

        while (cur != null) {
            if (cur.key.equals(key)) {
                pre.next = cur.next;
                cur.next = null;
                size--;
                return true;
            }
            pre = cur;
            cur = cur.next;
        }
        return false;
    }

    public void clear() {
        Arrays.fill(nodeList, null);
    }

    private boolean equalsKey(K key1, K key2) {
        return key1 == key2 || (key1 != null && key1.equals(key2));
    }

    private void rehash() {
        this.capacity *= 2;
        Entry<K, V>[] newList = new Entry[capacity];

        for (Entry<K, V> entry : nodeList) {
            int index = getIndex(entry.key);
        }

        // create a new Entry[]
        //
    }

    /**
     * Helper function to get bucket index
     *
     * @param key the input key
     * @return index of the bucket
     */
    private int getIndex(K key) {
        int hashCode = Math.abs(key.hashCode());
        return hashCode % capacity;
    }


    static class Entry<K, V> {
        private int size;
        private K key;
        private V val;
        private Entry<K, V> next;

        public Entry(K key, V val) {
            this.key = key;
            this.val = val;
            this.size = 1;
            next = null;
        }

        // public boolean set(K key, V val)
        // check if the key in the linked List
        // true → update and return true
        // false → return false
        public boolean set(K key, V val) {
            if (key == null) {
                return false;
            }

            Entry<K, V> cur = this;
            while (cur != null) {
                if (key.equals(cur.key)) {
                    cur.val = val;
                    return true;
                }
                cur = cur.next;
            }

            return false;
        }

        // private boolean append(K key, V val)
        // check if the key already in the linked list
        // true → return false
        // false → append pair to the end; update size; return true
        private boolean append(K key, V val) {
            if (key == null) {
                return false;
            }

            Entry<K, V> cur = this;
            Entry<K, V> pre = null;
            boolean hasKey = false;

            while (cur != null) {
                if (cur.key.equals(key)) {
                    hasKey = true;
                    break;
                }
                pre = cur;
                cur = cur.next;
            }
            if (hasKey) {
                return false;
            } else {
                pre.next = new Entry<K, V>(key, val);
                this.size++;
                return true;
            }
        }

        // private boolean remove(K key)
        // check if the key in the linked list
        // true → remove the pair; size--
        // false → return false
        private boolean remove(K key) {
            if (key == null) {
                return false;
            }


            Entry<K, V> cur = this;
            Entry<K, V> pre = new Entry<>(cur.key, cur.val);
            pre.next = cur;

            while (cur != null) {

                if (cur.key.equals(key)) {
                    pre.next = cur.next;
                    cur.next = null;
                    this.size--;
                    return true;
                }
                pre = cur;
                cur = cur.next;
            }
            return false;
        }

        // public V get(K key)
        // check the key in the linked list or not
        // true → return the corresponding value
        // false → return null
        public V get(K key) {
            if (key == null) {
                return null;
            }

            Entry<K, V> cur = this;
            while (cur != null) {
                if (cur.key.equals(key)) {
                    return cur.val;
                }
                cur = cur.next;
            }
            return null;
        }
    }
}
