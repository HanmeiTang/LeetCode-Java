package solution;

import java.util.*;

public class Solutoin91 {
    public int minJump(int[] array, int index) {
        if (index < 0 || index >= array.length) return -1;
        if (index == array.length - 1) return 0;
        if (array[index] == 0) return -1;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(index);
        int step = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;

            for (int i = 0; i < size; i++) {
                int cur = queue.poll();

                for (int j = 1; j <= array[cur]; j++) {
                    // try left
                    if (cur - j >= 0 && array[cur - j] > 0) queue.offer(cur - j);

                    // try right
                    if (cur + j >= array.length - 1) return step;
                    if (cur + j < array.length && array[cur + j] > 0) queue.offer(cur + j);
                }
                array[cur] = 0;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solutoin91 s = new Solutoin91();
        System.out.println(s.minJump(new int[]{1, 2, 0}, 1));
    }
}

/*
   0 1 2
   1 2 0
   1 0 0
queue | 1





*/