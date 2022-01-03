import java.util.Deque;
import java.util.LinkedList;

public class Solution280 {
    public void sort(LinkedList<Integer> s1) {
        // coner cases
        if (s1 == null || s1.size() == 1) {
            return;
        }

        LinkedList<Integer> s2 = new LinkedList<Integer>();
        int size = s1.size();
        int toBeSorted = size;

        while (toBeSorted != 0) {
            //System.out.print(toBeSorted);
            int i = sort(s1, s2, toBeSorted);
            toBeSorted -= i;
        }
    }

    // s1: sorted | unsorted
    // s2: buffer
    // returns: number being sorted this round
    private int sort(Deque<Integer> s1, Deque<Integer> s2, int toBeSorted) {
        int curMin = Integer.MAX_VALUE;
        int count = 0;

        // unsorted s1 -> s2, and count min
        for (int i = 0; i < toBeSorted; i++) {
            int element = s1.pollFirst();
            if (element < curMin) {
                curMin = element;
                count = 1;
            } else if (element == curMin) {
                count++;
            }
            s2.offerFirst(element);
        }

        // move all recored min to s1
        for (int i = 0; i < count; i++) {
            s1.offerFirst(curMin);
        }

        // move non-min to s1
        while (!s2.isEmpty()) {
            if (s2.peekFirst() == curMin) {
                s2.pollFirst();
            } else {
                s1.offerFirst(s2.pollFirst());
            }
        }

        // return count int
        System.out.println(count);
        return count;
    }
    private void printStack(Deque<Integer> s) {
        while(!s.isEmpty()) {
            System.out.println(s.pollFirst());
        }
    }

    public static void main(String[] args) {
        Solution280 s = new Solution280();
        LinkedList<Integer> test = new LinkedList<>();
        test.offerFirst(1);
        test.offerFirst(7);
        test.offerFirst(8);
        test.offerFirst(1);
        s.sort(test);
        //s.printStack(test);

    }

}