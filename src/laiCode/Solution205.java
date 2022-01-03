//package solution;
//
//import java.util.*;
//
//public class Solution205<K, V> {
//    private K head;
//    private K tail;
//    private final int capacity;
//    private int size;
//    private Map<K, V> map;
//
//    // limit is the max capacity of the cache
//    public Solution205(int capacity) {
//        map = new HashMap<>();
//        this.capacity = capacity;
//        size = 0;
//    }
//
//    public void set(K key, V value) {
//        // if the key alread there!!!!
//        if (map.containsKey(key)) {
//            // update node
//            map.get(key).val = value;
//            moveToHead(key);
//            return;
//        }
//
//        if (size == 0) {
//            head = key;
//            tail = key;
//            map.put(key, new Node(key, value));
//            size++;
//        } else {
//            Node node = new Node(key, value);
//            node.next = map.get(head);
//            map.get(head).prev = node;
//            head = key;
//            map.put(key, node);
//            size++;
//        }
//
//        if (size > capacity) {
//            // remove the tail
//            popTail();
//        }
//    }
//
//    public V get(K key) {
//        // if not in this cache
//        if (!map.containsKey(key)) return -1;
//        else {
//            moveToHead(key);
//            return map.get(key).val;
//        }
//    }
//
//    private void popTail() {
//        // debonding
//        Node curTail = map.get(tail);
//        Node newTail = curTail.prev;
//        curTail.prev = null;
//        newTail.next = null;
//
//        // remove from the dict
//        map.remove(curTail.key);
//
//        // reset tail
//        this.tail = newTail.key;
//
//        // update size
//        size--;
//    }
//
//    private void moveToHead(K key) {
//        if (!map.containsKey(key) || head == key) return;
//
//        // update the tail if necessary
//        if (tail == key && size > 1) {
//            tail = map.get(key).prev.key;
//        }
//
//        // debonding  (HEAD) A<->B<->C (TAIL)
//        V node = removeNode(key);
//
//        // rebonding
//        node.next = map.get(head);
//        map.get(head).prev = node;
//        head = key;
//        map.put(key, node);
//    }
//
//    // debonding  (HEAD) A<->B<->C (TAIL)
//    // return the isolated node, no record in map
//    private V removeNode(K key) {
//        if (!map.containsKey(key)) return null;
//
//        V node = map.get(key);
//        if (node.prev != null) node.prev.next = node.next;
//        if (node.next != null) node.next.prev = node.prev;
//        node.prev = null;
//        node.next = null;
//
//        map.remove(key);
//
//        return node;
//    }
//
//    class V {
//        Integer key;
//        Integer val;
//        V next;
//        V prev;
//
//        public V(Integer key, Integer val) {
//            this.key = key;
//            this.val = val;
//        }
//    }
//}
