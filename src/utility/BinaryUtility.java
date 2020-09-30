package utility;

import java.util.Arrays;

public class BinaryUtility {
    public static final int INTEGER_BIT = 32;
    public static final int LONG_BIT = 64;

    // Assume int is 32 bit
    // Convert an integer to its binary representation string
    public static void printIntegerBinaryString(int input) {

        char[] output = new char[INTEGER_BIT];
        for (int i = 0; i < INTEGER_BIT; i++) {
            output[INTEGER_BIT - 1 - i] = (char) (((input >> i) & 1) + '0');

        }

        System.out.println("0b " + new String(output));
    }

    public static void printLongBinaryString(long input) {
        char[] output = new char[LONG_BIT];
        for (int i = 0; i < LONG_BIT; i++) {
            output[LONG_BIT - 1 - i] = (char) (((input >> i) & 1) + '0');

        }

        System.out.println("0b " + new String(output));
    }

    public static void main(String[] args) {
        int i = 100;
        printIntegerBinaryString(i);
        i ^= (1 << 2);
        printIntegerBinaryString(i);
        i ^= (1 << 2);
        printIntegerBinaryString(i);

    }
}
