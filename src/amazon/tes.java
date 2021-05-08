package amazon;

import java.util.*;

public class tes {
    public static int camera_unobservation_scope(int L, List<List<Integer>> cameras_scope) {
        // corner case
        // assuming all inputs are valid
        // scope[i] are all 2-element sized
        if (cameras_scope == null || cameras_scope.size() == 0) return L;

        // sort and add, sort using end, O(NlogN) time complex
        Collections.sort(cameras_scope, (List<Integer> a, List<Integer> b) -> {
            return a.get(1).compareTo(b.get(1));
        });
        int end = cameras_scope.get(0).get(1);
        int iniGap = Math.max(0, cameras_scope.get(0).get(0));
        int gap = 0;

        for (int i = 1; i < cameras_scope.size(); i++) {
            int start = cameras_scope.get(i).get(0);
            if (start >= 0) iniGap = Math.min(iniGap, start);

            if (start > end) { // find a gap
                gap += start - end;
                end = cameras_scope.get(i).get(1);
            } else { // no gap
                end = cameras_scope.get(i).get(1);
            }
        }

        // add last gap
        gap += iniGap;
        gap += Math.max(0, L - end);

        // return gap
        return gap;
    }

    public static void main(String[] args) {
        tes n = new tes();
        List<List<Integer>> g = new ArrayList<>();
        g.add(Arrays.asList(15, 30));
        g.add(Arrays.asList(10, 20));
        g.add(Arrays.asList(0, 3));
        int output = n.camera_unobservation_scope(50, g);
        System.out.println(output);
    }
}
