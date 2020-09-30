import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Solution645 {
    private Deque<Integer> s1;
    private Deque<Integer> s2;
    private Deque<Integer> buffer;

    public Solution645() {
        s1 = new ArrayDeque<Integer>(); // head
        s2 = new ArrayDeque<Integer>(); // tail
        buffer = new ArrayDeque<Integer>(); // buffer
    }

    public void offerFirst(int element) {
        s1.offerFirst(element);
    }

    public void offerLast(int element) {
        s2.offerFirst(element);
    }

    public Integer pollFirst() {
        if (isEmpty()) {
            return null;
        }

        if (s1.isEmpty()) {
            balance(s2, s1);
        }
        return s1.pollFirst();
    }

    public Integer pollLast() {
        if (isEmpty()) {
            return null;
        }

        if (s2.isEmpty()) {
            balance(s1, s2);
        }
        return s2.pollFirst();
    }

    public Integer peekFirst() {
        if (isEmpty()) {
            return null;
        }

        if (s1.isEmpty()) {
            balance(s2, s1);
        }

        return s1.peekFirst();
    }

    public Integer peekLast() {
        if (isEmpty()) {
            return null;
        }

        if (s2.isEmpty()) {
            balance(s1, s2);
        }

        return s2.peekFirst();
    }

    public int size() {
        return s1.size() + s2.size();
    }

    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    // Migrate n element from origStack to targetStack
    public void migrate(Deque<Integer> origStack, Deque<Integer> targetStack, int n) {
        if (origStack == null || targetStack == null || n == 0) {
            return;
        }

        while (origStack.size() != 0 && n > 0) {
            targetStack.offerFirst(origStack.pollFirst());
            n--;
        }
    }

    // 1. fullStack -All-> buffer (s3)
    // 2. buffer -Half-> emptyStack
    // 3. buffer -Half-> fullStack
    public void balance(Deque<Integer> fullStack, Deque<Integer> emptyStack) {
        if (fullStack == null || emptyStack == null) {
            return;
        }
        if (fullStack.isEmpty()) {
            return;
        }

        int all = fullStack.size();
        int half = (all + 1) / 2; // half stack

        migrate(fullStack, buffer, all);
        System.out.println(buffer.peekFirst());
        migrate(buffer, emptyStack, half);
        migrate(buffer, fullStack, all - half);
    }

    public static void main(String[] args) {
//        Solution645 s = new Solution645();
//        s.offerFirst(1);
//        s.offerFirst(2);
//        s.offerFirst(3);
//        s.offerFirst(4);
////        System.out.println(s.pollFirst()); // 4
////        System.out.println(s.pollFirst()); // 4
////        System.out.println(s.pollFirst()); // 4
////        System.out.println(s.pollFirst()); // 4
//        System.out.println(s.pollLast()); // 4
//        System.out.println(s.pollLast()); // 4
//        System.out.println(s.pollLast()); // 4
//        System.out.println(s.pollLast()); // 4
//        System.out.println(s.pollFirst()); // 4
        Integer[] array = new Integer[5];
        ArrayList<Integer> arrayNew = new ArrayList<Integer>(100);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] == null);
        }
        System.out.println(arrayNew.size());
        for (int i = 0; i < arrayNew.size(); i++) {
            System.out.println(arrayNew.get(i) == null);
        }

    }

}