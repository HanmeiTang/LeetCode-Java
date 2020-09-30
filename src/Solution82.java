import java.util.*;

public class Solution82 {
    public String deDup(String input) {
        // corner cases
        if (input == null || input.length() <= 1) {
            return input;
        }

        // create a stack
        Deque<Character> stack = new ArrayDeque<>();
        char[] array = input.toCharArray();

        // scan through input string
        for (int i = 0; i < input.length(); i++) {
            Character top = stack.peekFirst();
            if (top == null || array[i] != top) {
                stack.offerFirst(array[i]);
            } else if (i == input.length() - 1 && array[i] == top) {
                stack.pollFirst();
            }
            else if (array[i] == top && array[i+1] != top) {
                stack.pollFirst();
            }
        }

        int size = stack.size();
        char[] result = new char[size];
        for (int i = size - 1; i >= 0 ; i--) {
            result[i] = stack.pollFirst();
        }

        return new String(result);
    }

    public static void main(String[] args) {
//        Solution82 s = new Solution82();
//        String result = s.deDup("aababab");
//        System.out.println();
//        System.out.println(result);
//        char[] array = "abbab".toCharArray();
//        Deque<Character> stack = new ArrayDeque<>();
//        stack.offer(array[0]);
//        System.out.println(stack.peekFirst() == array[0]);

        Deque<Integer> test = new LinkedList<>();
        test.offerFirst(null);
        System.out.println(test.size());


        Queue<Integer> test2 = new PriorityQueue<>(10, new Comparator<Integer> () {
            @Override
            public int compare(Integer a, Integer b) {
                if (a == null && b != null) {
                    return -1;
                } else if (b == null && a != null) {
                    return 1;
                } else if (a == null && b == null) {
                    return 0;
                } else {
                    return Integer.compare(a, b);
                }

            }
        });
//        test2.offer(null);
        test2.offer(1);
//        test2.offer(null);

    }
}
