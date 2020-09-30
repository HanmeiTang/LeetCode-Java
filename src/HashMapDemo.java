import java.util.HashMap;

public class HashMapDemo {
    public int x;
    public int y;

    public HashMapDemo(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public static void main(String[] args) {
        HashMap<HashMapDemo, Integer> map = new HashMap<>();
        map.put(new HashMapDemo(1, 2), 1);
        map.put(new HashMapDemo(1, 2), 2);
        System.out.println(map.size());
        System.out.println(map.get(new HashMapDemo(1, 2)));


        String test = "1234";
        String test2 = "1234";
        System.out.println(test.hashCode());
        System.out.println(test2.hashCode());

    }
}
