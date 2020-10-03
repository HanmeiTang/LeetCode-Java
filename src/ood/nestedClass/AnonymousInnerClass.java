package ood.nestedClass;

// Top level class
// Nested class
//    Static nested class
//    Non static nested class (Inner class)
//    Local class
//        Anonymous class (Comparators, etc. <- Lambda)

public class AnonymousInnerClass {
    public void test() {
        // Runnable is an interface
        new Thread(new Runnable() {
            @Override
            public void run() {
            }
        }).start();

        // non-anonymous
        class NonAnonymousClass implements Runnable {
            @Override
            public void run() {
            }
        }

        NonAnonymousClass t = new NonAnonymousClass();
        new Thread(t).start();
    }
}
