package leetCode;

public class LeetCode123 {
    public int getProfit(int[] prices) {
        int x1 = Integer.MIN_VALUE;
        int y1 = Integer.MIN_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y2 = Integer.MIN_VALUE;

        System.out.println("x1  y1   x2   y2");
        for (int price : prices) {
            x1 = Math.max(x1, -price);
            y1 = Math.max(y1, x1 + price);
            x2 = Math.max(x2, y1 - price);
            y2 = Math.max(y2, x2 + price);
            System.out.printf("%d   %d   %d   %d\n", x1, y1, x2, y2);
        }

        return y2;
    }

    public static void main(String[] args) {
        LeetCode123 s = new LeetCode123();
        System.out.println(s.getProfit(new int[]{2, 5, 3, 8}));
    }
}
