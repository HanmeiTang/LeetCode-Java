package ood;

// Object
// Throwable
// Error | 紅色Exception - checked exception
//       | 藍色RuntimeException - unchecked exception | IOException etc.
public class MyRuntimeException extends RuntimeException {
    public MyRuntimeException() {
        super();
    }

    public MyRuntimeException(String msg) {
        super(msg + " My Runtime Exception");
    }
}
