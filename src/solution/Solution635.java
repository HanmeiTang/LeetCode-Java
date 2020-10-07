import java.util.*;

public class Solution635 {
    public int sumOfSquare(List<Integer> list) {
        // Write your solution here
        // Corner cases
        if (list == null || list.size() == 0) {
            return 0;
        }

        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += i * i;
        }
        return sum;
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<Integer>(5);
        ArrayList<String> list = new ArrayList<String>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");
        list.add(0, "Hello");
//        list.clear();
        list.set(1, "3");

        Iterator it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        for (String sth : list) {
            System.out.println("test");
        }
        System.out.println(list);
        System.out.println(list.get(2));
        Collections.sort(list);
        System.out.println(list.size());
        System.out.print(list.getClass().getName());
//        System.out.println(Solution635.sumOfSquare());
    }
}
