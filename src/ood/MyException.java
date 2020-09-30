package ood;

import java.io.FileInputStream;
import java.io.IOException;

// Object
// Throwable
// Error | 紅色Exception - checked exception
//       | RuntimeException - unchecked exception | IOException etc.
public class MyException extends Exception {
    public MyException() {
        super();
    }

    public MyException(String msg) {
        super(msg + " My Exception");
    }

    public static void main(String[] args) {
        String file = "~/test.txt";
        try {
            FileInputStream fs = new FileInputStream(file);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
