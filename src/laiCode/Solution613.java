import java.util.Arrays;
import java.util.Random;

import static java.lang.Integer.max;

class MyCircularDeque {
    public Integer[] array;
    public int size;
    private int head;
    private int tail;
    private int k;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        this.array = new Integer[k];
        this.k = k;
        this.head = 0;
        this.tail = 0;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (size == k) {
            return false;
        }

        if (size == 0) {
            array[head] = value;
            size++;
            return true;
        }

        if (head != 0) {
            head--;
        } else {
            head = k - 1;
        }

        array[head] = value;
        size++;
        return true;

    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (size == k) {
            return false;
        }

        if (size == 0) {
            array[tail] = value;
            size++;
            return true;
        }

        if (tail != k - 1) {
            tail++;
        } else {
            tail = 0;
        }
        array[tail] = value;
        size++;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (size == 0) {
            return false;
        }

        if (head != k - 1) {
            head++;
        } else {
            head = 0;
        }

        size--;

        if (size == 0) {
            array[head] = null;
        }

        return true;

    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (size == 0) {
            return false;
        }

        if (tail != 0) {
            tail--;
        } else {
            tail = k - 1;
        }
        size--;

        if (size == 0) {
            array[head] = null;
        }

        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public Integer getFront() {
        if (size == 0) {
            return null;
        }
        return array[head];
    }

    /**
     * Get the last item from the deque.
     */
    public Integer getRear() {
        if (size == 0) {
            return null;
        }

        return array[tail];
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return size == k;
    }
}

public class Solution613 {
    public static void main(String[] args) {
        MyCircularDeque circularDeque = new MyCircularDeque(3);
        circularDeque.insertLast(1);

        circularDeque.insertLast(2);

        circularDeque.insertLast(3);

        circularDeque.deleteFront();

        circularDeque.deleteFront();

        circularDeque.deleteFront();
        System.out.println(Arrays.toString(circularDeque.array));
        circularDeque.insertLast(4);
        System.out.println(Arrays.toString(circularDeque.array));
        circularDeque.isEmpty();

        max(1, 2);
//        int l = circularDeque.getFront();

//        int l = circularDeque.getFront(); // 4
//        System.out.println(l);
        Random rand = new Random();
        System.out.println(rand.nextInt(1));
        System.out.println(Math.random());
        System.out.println((int) 0.4);
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */