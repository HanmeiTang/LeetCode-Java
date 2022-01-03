import java.util.Random;

public class Solution548 {
    public static int random(int a, int b) {
        Random rnd = new Random();
        return rnd.nextInt(b - a + 1) + a;
    }
    public static void main(String[] args) {
        System.out.println(random(1, 3));
    }
}
