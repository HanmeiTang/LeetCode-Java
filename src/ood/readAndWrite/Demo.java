package ood.readAndWrite;

import java.io.*;

public class Demo {
    public static void main(String[] args) {
        int[] x = new int[0];
        int[] y = new int[3];
        int[][] z = new int[4][];
        z[0] = x;
        z[1] = y;
        System.out.println(z.length);
        InputStreamReader cin = null;
        try {
            cin = new InputStreamReader(System.in); // standard input is from terminal
            System.out.println("Enter character, `q` to quit.");

        } finally {
            // close whatever
        }

    }
}

