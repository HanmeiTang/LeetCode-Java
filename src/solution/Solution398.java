package solution;

import java.util.*;

public class Solution398 {
    public List<Integer> allAnagrams(String s, String l) {
        if (l.length() == 0) {
            return new ArrayList<Integer>();
        }

        List<Integer> result = new ArrayList<Integer>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i <= l.length() - s.length(); i++) {
            System.out.println(map);
            if (match(l, i, i + s.length() - 1, map)) {
                result.add(i);
            }
        }

        return result;
    }

    private boolean match(String l, int left, int right, Map<Character, Integer> map) {
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = left; i <= right; i++) {
            map2.put(l.charAt(i), map2.getOrDefault(l.charAt(i), 0) + 1);
        }
        System.out.println(map2);
        System.out.println(map);
        for (Character c : map.keySet()) {
            if (!map.get(c).equals(map2.get(c))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution398 s = new Solution398();
//        List<Integer> output = s.allAnagrams("aab", "ababacbbaac");
//        for (int i : output) {
//            System.out.println(i);
//        }

        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 1);
        map.put('b', 2);
        map.put('c', 1);
        System.out.println(s.match("abbc", 0, 3, map));
    }
}

