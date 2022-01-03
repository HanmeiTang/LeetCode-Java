import utility.BinaryUtility;

class test {

}
public class Solution626 {
    /**
     *
     * @param n
     * @return
     */
    protected long reverseBits(long n) {
        int i = 0;
        int j = 31;

        while (i < j) {
            // if not the same, flip both
            boolean isDiff = (((n >> i) & 1) ^ ((n >> j) & 1)) == 1;
            //BinaryUtility.printLongBinaryString((n >> i) & 1);
            //BinaryUtility.printLongBinaryString((n >> j) & 1);
            //System.out.println(isDiff);
            if (isDiff) {
                //System.out.println(i);
                //System.out.println(j);
                //BinaryUtility.printLongBinaryString(n);
                n ^= (1L << i);
                //BinaryUtility.printLongBinaryString(n);
                n ^= (1L << j);
                //BinaryUtility.printLongBinaryString(n);
            }
            // if same, do nothing

            i++;
            j--;
            //BinaryUtility.printLongBinaryString(n);
        }

        return n;
    }

    public static void main(String[] args) {
        Solution626 s = new Solution626();

//        long input = 1260388352;
        long input = 3081669670L;

        BinaryUtility.printLongBinaryString(input);

        long output = s.reverseBits(input);


        BinaryUtility.printLongBinaryString(output);
        System.out.println("hello World!".substring(6, 12));
        StringBuilder sb = new StringBuilder();

    }
}
