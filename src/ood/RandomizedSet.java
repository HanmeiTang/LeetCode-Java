package ood;
import java.util.*;
class RandomizedSet {

    private Map<Integer, Integer> map; // val1: 0
    private List<Integer> index;       // [val1, val2]
    private Random rand;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        map = new HashMap<>();
        index = new ArrayList<>();
        rand = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        index.add(val);
        map.put(val, index.size() - 1);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int ind = map.get(val);
        swap(ind, index.size() - 1);
        index.remove(index.size() - 1);
        map.remove(val);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int randInt = rand.nextInt(index.size());
        return index.get(randInt);
    }

    private void swap(int i, int j) {
        // swap the index in list
        Collections.swap(index, i, j);

        // update the map
        int val1 = index.get(i);
        int val2 = index.get(j);

        map.put(val1, i);
        map.put(val2, j);
    }

    public static void main(String[] args) {
        RandomizedSet set = new RandomizedSet();
        set.insert(0);
        set.insert(1);
        set.remove(0);
        set.insert(2);
        set.remove(1);
        System.out.println(set.getRandom());
    }

}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

// private set()
// allow random access O(1)
// array
// [         ]
// [1, 5, 3, 4, 2]
// {1, 3, 4, 5}