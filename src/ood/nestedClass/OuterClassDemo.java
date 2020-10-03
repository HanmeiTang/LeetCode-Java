package ood.nestedClass;

public class OuterClassDemo {
    // How to create instance of static and non static nested classes?
    public static void main(String[] args) {
        // 1. Create static nested class instance, preferred
        OuterClass.NestedStaticClass printer = new OuterClass.NestedStaticClass();
        printer.printMessage(); // this is a static method

        // 2.1 Init a new non-static inner class
        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner = outer.new InnerClass();
        inner.display();

        // 2.2 Or using one line
        OuterClass.InnerClass printer2 = new OuterClass().new InnerClass();
        printer2.display();
    }
}
