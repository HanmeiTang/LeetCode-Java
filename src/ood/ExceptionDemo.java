package ood;


public class ExceptionDemo {
    // throws exception list
    static void fun() throws IllegalAccessError, NullPointerException {
        try {
            throw new NullPointerException("demo");
        } catch (NullPointerException e) {
            System.out.println("Caught inside fun().");
            e.printStackTrace();
            // this is "re-throw"
            // usually this is for log
            throw e;
        } catch (IllegalAccessError | LayerInstantiationException e) { // Java grammar!
            e.printStackTrace();
        } catch (Exception e) { // Usually put it at the end
            // log(e); // This is the last try...
            e.printStackTrace();
            throw e;
        }
    }

    public static void main(String[] args) {
        try {
            fun();
        } catch (NullPointerException e) {
            System.out.println("Caught in Main");
        }
    }
}
