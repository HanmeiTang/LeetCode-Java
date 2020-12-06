package solution;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Solution13 {
    private static Map<Integer, Long> cache = new HashMap<Integer, Long>();

    public static long power(int a, int b) {
        if (b == 0) {
            return 1;
        } else if (b == 1) {
            return a;
        } else if (cache.containsKey(b)) {
            return cache.get(b);
        } else {
            if (b / 2 == b - b / 2) {
                cache.put(b, power(a, b / 2) * power(a, b / 2));
            } else {
                cache.put(b, power(a, b / 2) * power(a, b / 2) * a);
            }
            return cache.get(b);
        }

    }

    public static void main(String[] args) {
//        System.out.println(power(1, 1024));
//        int[] result = new int[4];
//        int i, j = 0;
    }
}
