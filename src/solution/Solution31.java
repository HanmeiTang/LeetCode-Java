import java.util.Deque;
import java.util.LinkedList;

// Java: Implement a queue by using two stacks. 
// The queue should provide 
// size(), isEmpty(), offer(), poll() and peek() operations. 
// When the queue is empty, 
// poll() and peek() should return null.

public class Solution31 {
    private Deque<Integer> s1;
    private Deque<Integer> s2;

    public Solution31() {
        // Initialize a Queue using two stacks (Deque)
        // offerFirst(), pollFirst(), peekFirst(), size()
        s1 = new LinkedList<>();
        s2 = new LinkedList<>();

    }

    public Integer poll() {
        if (s1.isEmpty() && s2.isEmpty()) {
            return null;
        }

        if (s1.isEmpty()) {
            migrateAll();
        }

        return s1.pollFirst();
    }

    public void offer(int element) {
        s2.offerFirst(element);
    }

    public Integer peek() {
        if (s1.isEmpty() && s2.isEmpty()) {
            return null;
        }

        if (s1.isEmpty()) {
            migrateAll();
        }

        return s1.peekFirst();
    }

    public int size() {

        return s1.size() + s2.size();
    }

    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    // move all elements from s2 to s1
    private void migrateAll() {
        if (s2.isEmpty()) {
            return;
        }

        int size2 = s2.size();
        for (int i = 0; i < size2; i++) {
            int temp = s2.pollFirst();
            s1.offerFirst(temp);
        }
    }
}