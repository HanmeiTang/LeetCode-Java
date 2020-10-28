package ood.lru;

// Cache is a storage to optimized read performance
// In general, cache is a key value store ==> look up something by a key

// About `Least Recently Used (LRU)`
// LRU Eviction Strategy: remove the oldest entry in the cache in terms visit timestamp

// Requirement analysis
//  1. This cache should support lookup value by a given key
//     --> BST (if key has a order)
//         or HashMap (more general)
//  2. when this cache si full and you want to add a new key value pair,
//     then the oldest key value pair should be evicted
//     --> this implies we should store key value pairs based on
//         visit time stamp in ascending order

// Possible LRU cache solutions
// 1. BST<timestamp, <key, value>>  // work but way too complex
// 2. ArrayList<map.Entry<key, val>> // a stupid solution, O(n)
// 3. optimized solution 2: use doubly-linked list LinkedList<Entry<key, val>>, O(1)
// 3. optimized solution 3: use ArrayDeque<map.Entry<key, val>>

// Implementation
// Index is built from storage (storage create, update, delete affects index)
public class LRU {
}
