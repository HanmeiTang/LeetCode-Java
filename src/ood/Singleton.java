package ood;

/**
 * JVM 中僅有一個
 * 比如Trashcan, login都是僅此一份
 * Top-level classes
 * either 'public' or 'protected'
 */
public class Singleton {
    private String name;
    private static final Singleton instance = new Singleton();

    private Singleton() {
        this.name = "John";
    }

    public static Singleton getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        // Singleton a = new Singleton(); // No in another class
        Singleton a = getInstance();
        Singleton b = getInstance();
        System.out.println(b == a); // true
    }
}
