import java.util.List;
import java.util.ArrayList;

public class Exam1 {
}


// Assumptions:
// 1. A & B are ascending sorted
// 2. If A or B is null, then return null
// 3.

class Problem2 {
    public List<Integer> getSmallest(int[] a, int[] b, int k) {
        // corner cases
        if (a == null || b == null || k < 0 || k > (a.length + b.length)) {
            return null;
        }
        if (k == 0) {
            return new ArrayList<Integer>();
        }

        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;

        for (int n = 0; n < k; n++) {
            if (i < a.length && j < b.length) {
                if (a[i + 1] + b[j] < a[i] + b[j + 1]) {
                    result.add(a[i + 1] + b[j]);
                    i++;
                } else {
                    result.add(a[i] + b[j + 1]);
                    j++;
                }
            } else if (i < a.length) {
                result.add(a[i] + b[j]);
                i++;
            } else { // j < b.length
                result.add(a[i] + b[j]);
                j++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Problem2 p1 = new Problem2();
        int[] a = new int[]{1, 3, 4, 5};
        int[] b = new int[]{2, 9, 11};
        int k = 3;
        List<Integer> result = p1.getSmallest(a, b, k);
        System.out.println(result);
    }
}
