public class Solution161 {
    public int l;
    public Integer memory = new Integer(1);
    public static int sqrt(int x) {
        // Write your solution here
        // Rule out corner cases
        if (x == 0 || x == 1) {
            return x;
        }

        long l = 0;
        long r = x;
        long m = (l + r) / 2;
        System.out.printf("Debug l, m, r: %d, %d, %d\n", l, m, r);

        while (r - l > 1) {
            if (m * m > x) {
//                System.out.printf("inner m*m, x: %d, %d\n", m * m, x);
                r = m;
            } else if (m * m < x) {
                l = m;
//                System.out.printf("inner m*m, x: %d, %d\n", m * m, x);
            } else {
                return (int) m;
            }
            m = (l + r) / 2;
            System.out.printf("Debug l, m, r: %d, %d, %d\n", l, m, r);
        }

        // Post processing
        return (int) l;


        // Check 2, 3, 4, 20

    }

    public static void main(String[] args) {
        int x = 100200;
        int x_M;
//        System.out.printf("%d vs. %f\n", sqrt(x), Math.sqrt(x));
    }
}
