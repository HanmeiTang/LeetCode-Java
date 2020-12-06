package amazon;

import java.util.*;

class LeetCode127New {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // corner cases

        // construct the generic hashmap "form": Set of words
        Map<String, Set<String>> map = getMap(wordList);
        Set<String> visited = new HashSet<>();
        int step = 0;

        // bfs and count the step
        Queue<String> queue = new LinkedList<>();
        for (String key : getTransformation(beginWord)) {
            if (map.containsKey(key)) {
                for (String s : map.get(key)) {
                    if (!visited.contains(key)) {
                        queue.offer(s);
                        visited.add(s);
                    }
                }
            }
        }

        if (!queue.isEmpty()) step = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(endWord)) return step;
                for (String form : getTransformation(cur)) {
                    if (map.containsKey(form)) {
                        for (String nei : map.get(form)) {
                            if (!visited.contains(nei)) {
                                queue.offer(nei);
                                visited.add(nei);
                            }
                        }
                    }
                }
            }
        }


        // return the num of steps
        return 0;
    }


    // private method constructing the map
    private Map<String, Set<String>> getMap(List<String> wordList) {
        Map<String, Set<String>> map = new HashMap<>();
        for (String word : wordList) {
            // try all possible patterns On
            for (int i = 0; i < word.length(); i++) {
                char[] array = word.toCharArray();
                array[i] = '*';
                String genKey = new String(array);

                // if find, add the word
                if (map.containsKey(genKey)) {
                    map.get(genKey).add(word);
                } else { // else, create new key
                    Set<String> set = new HashSet<>();
                    set.add(word);
                    map.put(genKey, set);
                }

            }
        }

        return map;
    }

    private String[] getTransformation(String s) {
        String[] result = new String[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char[] temp = s.toCharArray();
            temp[i] = '*';
            result[i] = new String(temp);
        }

        return result;
    }

    public static void main(String[] args) {
        LeetCode127New s = new LeetCode127New();
        List<String> wordList = Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        int i = s.ladderLength("hit", "cog", wordList);
        System.out.println(i);
    }
}


//