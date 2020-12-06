package amazon;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class Interview1 {

    /*
     * Complete the 'finalInstances' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER instances
     *  2. INTEGER_ARRAY averageUtil
     */

    public static int finalInstances(int instances, List<Integer> averageUtil) {
        // corner cases
        if (instances <= 0 || averageUtil == null || averageUtil.size() == 0) {
            return Integer.MIN_VALUE;
        }

        // iterate every status checking
        int statusIndex = 0;
        while (statusIndex < averageUtil.size()) {
            int aveUtil = averageUtil.get(statusIndex);
            if (aveUtil < 25) {
                if (instances > 1) {
                    instances = (instances + 1) / 2;  // take the ceiling
                    statusIndex += 10;  // stop monitoring for 10 sec
                }
            } else if (aveUtil >= 25 && aveUtil <= 60) {
                statusIndex++;
                continue;
            } else {  // average utilization > 60%
                if (instances <= Math.pow(10, 8)) {
                    instances *= 2;
                    statusIndex += 10;
                }
            }

            statusIndex++;
        }

        // return
        return instances;
    }

}

//1. Approach Description
//
//Only one iteration is needed to get the final number of instances loaded in the end.
// The worst case is to run exactly instances iterations. Within every iteration,
// instances needs to be updated according to the average utilization status
// (if/else blocks), which takes ~O(1) for each iteration. While no additional
// space is used, so the space complexity is O(1).
//
//Corner cases considered:
//
//if the number of instances is not a positive number
//utilization list is null or an empty list
//2. Analysis
//
//Time complexity: O(instances)
//Space complexity: O(1), no additional space is used