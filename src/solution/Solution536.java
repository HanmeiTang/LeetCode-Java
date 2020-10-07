public class Solution536 {
    public int sumOfSquares(int n) {
        // I assume that Math.sqrt() is allowed in this question
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            double sqrt = Math.sqrt(i);
            if ((int) sqrt == sqrt) {
                sum += i;
            }

        }
        return sum;
    }

}
