package laiCode;

import java.util.*;

public class Solution681 {
    public int numOfSteps(int[] values) {
        int[] init = new int[8];
        for (int i = 0; i < 8; i++) {
            init[i] = i;
        }
        if (values.equals(init)) {
            return 0;
        }

        // set
        Set<String> seen = new HashSet<>();
        seen.add(Arrays.toString(init));

        // bfs
        Queue<int[]> q = new LinkedList<>();
        q.offer(init);
        int step = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            step++;

            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();

                for (char dir : new char[]{'r', 'l', 'd', 'u'}) {
                    int[] moved = move(cur, dir);
                    if (Arrays.equals(moved, values)) {
                        return step;
                    }
                    if (seen.add(Arrays.toString(moved))) {
                        q.offer(moved);
                    }
                }
            }
        }

        return -1;
    }

    private int[] move(int[] status, char direction) {
        int[] output = Arrays.copyOfRange(status, 0, status.length);
        int zero = -1;

        for (int i = 0; i < output.length; i++) {
            if (output[i] == 0) {
                zero = i;
                break;
            }
        }

        if (direction == 'l' && zero != 0 && zero != 4) {
            swap(output, zero, zero - 1);
        } else if (direction == 'r' && zero != 3 && zero != 7) {
            swap(output, zero, zero + 1);
        } else if (direction == 'u' && zero >= 4) {
            swap(output, zero, zero - 4);
        } else if (direction == 'd' && zero <= 3) {
            swap(output, zero, zero + 4);
        }

        return output;
    }

    private void swap(int[] status, int i, int j) {
        int temp = status[i];
        status[i] = status[j];
        status[j] = temp;
    }

    public static void main(String[] args) {
        Solution681 s = new Solution681();
        int step = s.numOfSteps(new int[]{2, 6, 7, 5, 3, 1, 0, 4});
        System.out.println(step);
    }
}


/**
 * 0123   1023   1203   1230
 * 4567   4567   4567   4567
 * <p>
 * 4123   1523   1263   1237
 * 0567   4067   4507   4560
 * <p>
 * a
 * /|\
 * 4 status,  - boundary; - status seen
 */