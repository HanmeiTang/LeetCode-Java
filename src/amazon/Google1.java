//package amazon;
//import java.util.*;
//public class Google1 {
//}
//class Solution {
//    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
//        // corner case
//        if (words1.length != words2.length) return false;
//
//        // init data structure by union
//        Map<String, Set<String>> map = new HashMap<>();
//        for (List<String> pair : pairs) {
//            String w1 = pair.get(0);
//            String w2 = pair.get(1);
//
//            if (!map.containsKey(w1)) map.put(w1, new HashSet<String>());
//            if (!map.containsKey(w2)) map.put(w2, new HashSet<String>());
//
//            map.get(w1).add(w2);
//            map.get(w2).add(w1);
//
//            for (String next : map.get(w1)) {
//                if (!map.containsKey(next)) map.put(next, new HashSet<String>());
//                map.get(next).add(w2);
//                map.get(w2).add(next);
//            }
//
//            for (String next : map.get(w2)) {
//                if (!map.containsKey(next)) map.put(next, new HashSet<String>());
//                map.get(next).add(w1);
//                map.get(w1).add(next);
//            }
//        }
//
//        for (int i = 0; i < words1.length; i++) {
//            String w1 = words1[i];
//            String w2 = words2[i];
//
//            if (w1.equals(w2)) continue;
//            if (!map.containsKey(w1) || !map.get(w1).contains(w2)) return false;
//        }
//
//
//        // return true or false
//        return true;
//    }
//
//    public static void main(String[] args) {
//
//    }
//}
//
//
//
///*
//[Str1, Str2]
//Map<String, index>
//parent = [0,1,2]
//rank = [0, 0, 0]
//
//
//
//*/
//
