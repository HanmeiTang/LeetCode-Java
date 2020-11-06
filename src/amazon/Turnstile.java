package amazon;

import java.util.*;

public class Turnstile {
    public int[] getPassTime(int numCustomers, int[] arrTime, int[] direction) {
        // corner cases


        // initialization
        int ind = 0;
        int count = numCustomers;
        int preTime = arrTime[0];
        int curTime = arrTime[0];
        int endTime = arrTime[arrTime.length - 1];
        int door = 1; // 1 = exit; 0 = enter
        int[] result = new int[numCustomers];
        Queue<Integer> enterQ = new LinkedList<>();
        Queue<Integer> exitQ = new LinkedList<>();

        // when queue is not empty
        // curTime within range
        // curTime <= endTime || (!enterQ.isEmpty()) || (!exitQ.isEmpty())
        while (count > 0) {
            // set door status
            if (curTime - preTime > 1) {
                door = 1;
            }

            // offer if possible
            while (ind < numCustomers && arrTime[ind] == curTime) {
                if (direction[ind] == 0) {
                    enterQ.offer(ind++);
                } else {
                    exitQ.offer(ind++);
                }
            }

            // poll once
            if (enterQ.isEmpty() && exitQ.isEmpty()) {
                if (ind + 1 < numCustomers) {
                    curTime = arrTime[ind + 1];
                } else {
                    break;
                }

            } else {
                if (door == 1) {
                    if (!exitQ.isEmpty()) {
                        result[exitQ.poll()] = curTime;
                        preTime = curTime++;
                        count--;
                    } else if (!enterQ.isEmpty()) {
                        result[enterQ.poll()] = curTime;
                        door = 0;
                        preTime = curTime++;
                        count--;
                    }
                } else { // door == 0
                    if (!enterQ.isEmpty()) {
                        result[enterQ.poll()] = curTime;
                        preTime = curTime++;
                        count--;
                    } else if (!exitQ.isEmpty()) {
                        result[exitQ.poll()] = curTime;
                        door = 1;
                        preTime = curTime++;
                        count--;
                    }
                }
            }


//            // find next time
//            preTime = curTime;
//            if ((!enterQ.isEmpty()) || (!exitQ.isEmpty())) {
//                curTime++;
//            } else {
//                if (ind + 1 < numCustomers) {
//                    curTime = arrTime[ind + 1];
//                } else {
//                    break;
//                }
//            }
        }

        // return
        return result;
    }

    public static void main(String[] args) {
        Turnstile t = new Turnstile();
//        int[] result = t.getPassTime(5, new int[]{0, 10, 10, 30, 30}, new int[]{0, 1, 0, 0, 1});
//        for (int i : result) {
//            System.out.println(i);
//        }
//
//        System.out.println();
//        result = t.getPassTime(5, new int[]{0, 1, 1, 3, 3}, new int[]{0, 1, 0, 0, 1});
//        for (int i : result) {
//            System.out.println(i);
//        }

        System.out.println();
        int[] result = t.getPassTime(4, new int[]{0, 0, 1, 6}, new int[]{0, 1, 1, 0});
        for (int i : result) {
            System.out.println(i);
        }
    }
}
