package amazon;

import java.util.*;

public class TransactionLogs {
    public List<String> getFraudId(String[] input, int threshold) {
        // corner cases

        // parse input
        List<String> result = new ArrayList<String>();
        Map<String, Integer> map = new HashMap<>();
        for (String s : input) {
            String[] items = s.split(" +");
            if (items[0].equals(items[1])) {
                map.put(items[0], map.getOrDefault(items[0], 0) + 1);
            } else {
                map.put(items[0], map.getOrDefault(items[0], 0) + 1);
                map.put(items[1], map.getOrDefault(items[1], 0) + 1);
            }
        }

        // get potential targets
        for (String userId : map.keySet()) {
            if (map.get(userId) >= threshold) {
                result.add(userId);
            }
        }

        // sort by actual integer value
        Collections.sort(result, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.valueOf(s1).compareTo(Integer.valueOf(s2));
            }
        });

        // return
        return result;
    }

    public static void main(String[] args) {
        TransactionLogs t = new TransactionLogs();
        List<String> result = t.getFraudId(
                new String[]{"345366 89921 45",
                        "029323 38239 23",
                        "38239 345366 15",
                        "029323 38239 77",
                        "345366 38239 23",
                        "029323 345366 13",
                        "38239 38239 23"}, 3);
        System.out.println(result);
    }
}


// Analysis
// TC:
// split - N
// add to map = len(userId) * len(input)
// loop the map = len(input)
// SC: map - O(len(userId) * len(input))
