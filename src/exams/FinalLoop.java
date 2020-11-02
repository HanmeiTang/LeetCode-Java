//package exams;
//
//import java.util.*;
//
//public class FinalLoop {
//    public boolean hasInfiniteLoop(String[] names) {
//        // corner cases
//        if (names == null || names.length <= 1) {
//            return false;
//        }
//
//        // Create two hashmap storing initials and ends
//        Map<Character, Integer> ini = new HashMap<>();
//        Map<Character, Integer> end = new HashMap<>();
//        Map<Character, Integer> dupNames = new HashMap<>();
//
//        for (String name : names) {
//            ini.put(name.charAt(0), ini.getOrDefault(name.charAt(0), 0) + 1);
//            end.put(name.charAt(name.length() - 1), end.getOrDefault(name.charAt(name.length() - 1), 0) + 1);
//            if (name.charAt(0) == name.charAt(name.length() - 1)) {
//                dupNames.put(name.charAt(0), dupNames.getOrDefault(name.charAt(0), 0) + 1);
//            }
//        }
//
//        // check if the two hashmaps are the same
//        for (Character key: ini.keySet()) {
//            if (!end.containsKey(key) || (end.get(key) != ini.get(key))) {
//                return false;
//            }
//        }
//
//
//        // return
//    }
//}