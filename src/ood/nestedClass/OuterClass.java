package ood.nestedClass;

// Prefer nested static class to inner class
// Only use the inner class when you have to access instance info.

public class OuterClass {
    private static String msg1 = "Static Message";
    private String msg2 = "Non-Static Message";

    // Example of a Nested Static Class, preferred (E.g. Map.Entry)
    // non-static members are not accessible
    public static class NestedStaticClass {
        public void printMessage() {
            // msg1 --> msg2 will produce a compile error
            System.out.println("Message from nested static class:" + msg1);
        }

        private static void printOut() {
        }

        private void printOut2() {
        }

    }

    // Example of an Inner Class, rare (E.g. LinkedList.Enumerator)
    public class InnerClass {
        // Both static & non-static members of Outer class are
        // accessible in this Inner class
        public void display() {
            System.out.println("Message from non-static nested class: " + msg2);
        }

        // You CAN NOT declare a static method inside a non-static inner class
        // private static void printOut1() {}
        public OuterClass getOuterClass() {
            return OuterClass.this;
        }

    }
}
