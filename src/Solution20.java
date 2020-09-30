import java.util.Dictionary;
import java.util.Hashtable;

public class Solution20 {
    public static int search(Dictionary<Integer, Integer> dict, int target) {
        // Corner cases: 0 element
        if (dict.get(0) == null) {
            return -1;
        }
        // Corner case: while loop need more than one element
        if (dict.get(1) == null) {
            if (dict.get(0) == target) {
                return 0;
            } else {
                return -1;
            }
        }

        // Find the end of this dict from ind = 2^0 = 1
        // Keep doubling the index until hit a bound
        int ind = 1; // 2^0

        while (dict.get(ind * 2) != null) {
            ind *= 2;
        }

        // Loop binary search to find the index between 2^ind, 2^(ind+1)
        int left = ind;
        int right = ind * 2;
        while (right - left > 1) {
            int mid = (left + right) / 2;
            if (dict.get(mid) == null) {
                right = mid;
            } else {
                left = mid;
            }
            System.out.printf("mid, %d\n", mid);
        }

        // Now we know `left` is the final index of this dict
        int l = 0;
        int r = left;
        System.out.printf("left, %d\n", left);
        System.out.printf("right, %d\n", right);
        // Classic binary search loops
        while (r - l > 1) {
            int m = (l + r) / 2;
            if (dict.get(m) > target) {
                r = m;
            } else if (dict.get(m) < target) {
                l = m;
            } else {
                return m;
            }
        }

        if (dict.get(l) == target) {
            return l;
        } else if (dict.get(r) == target) {
            return r;
        } else {
            // If unfortunately found nothing
            return -1;
        }

        // Double checks: one element
        // test examples
        // duplicate elements
    }

    public static void main(String[] args) {
        Dictionary d = new Hashtable();
        for (int i = 0; i < 100; i++) {
            d.put(i, i -100);
        }

        System.out.println(d);
        System.out.println(search(d, 1000));
    }

}
