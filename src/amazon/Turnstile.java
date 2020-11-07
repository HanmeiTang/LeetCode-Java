package amazon;

import java.util.*;

public class Turnstile {
    public int[] getPassTime(int numCustomers, int[] arrTime, int[] direction) {
        // corner cases
        // if numCustomers == arraTime.len == direction.len
        // numCustomers <= 0

        // initialization
        Queue<Integer> enterQ = new LinkedList<>();
        Queue<Integer> exitQ = new LinkedList<>();
        int curInd = 0;
        int curTime = arrTime[curInd];
        int preTime = 0;
        int door = 1; // default 1 = exit; 0 = enter
        int[] result = new int[numCustomers];

        while (numCustomers > 0) {
            System.out.printf("[%s, %s, %s, %s]\n", result[0], result[1], result[2], result[3]);
            // update to current time status
            int c = curInd;
            for (int person = c; person < arrTime.length; person++) {
                if (arrTime[person] == curTime) {
                    if (direction[person] == 0) {
                        enterQ.offer(person);
                        curInd++;
                    } else {
                        exitQ.offer(person);
                        curInd++;
                    }
                } else {
                    curInd = person;
                    break;
                }
            }

            // queue is still Empty?
            // true --> update curTime to next time; continue
            if (enterQ.isEmpty() && exitQ.isEmpty()) {
                preTime = curTime;
                if (curInd < arrTime.length) {
                    curTime = arrTime[curInd];
                }
                continue;
            }

            door = curTime - preTime > 1 ? 1 : door;

            // door & queue logic
            // update door & numCustomers & result
            if (door == 0) { // enter
                if (!enterQ.isEmpty()) {
                    result[enterQ.poll()] = curTime;
                    numCustomers--;
                } else {
                    result[exitQ.poll()] = curTime;
                    door = 1 - door;
                    numCustomers--;
                }
            } else { // door = 1, exit
                if (!exitQ.isEmpty()) {
                    result[exitQ.poll()] = curTime;
                    numCustomers--;
                } else {
                    result[enterQ.poll()] = curTime;
                    door = 1 - door;
                    numCustomers--;
                }
            }

            preTime = curTime++;
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
        System.out.println();
        int[] result = t.getPassTime(5, new int[]{0, 1, 1, 3, 3}, new int[]{0, 1, 0, 0, 1});
        for (int i : result) {
            System.out.println(i);
        }

        System.out.println();
        result = t.getPassTime(4, new int[]{0, 0, 1, 5}, new int[]{0, 1, 1, 0});
        for (int i : result) {
            System.out.println(i);
        }
    }
}


// ON
// SC