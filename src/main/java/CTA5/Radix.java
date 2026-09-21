package CTA5;

// Radix sort for integers. Takes advantage of every integer having 4 bytes, sorts by those.
public class Radix {
    static int[] radixSort(int[] a) {
        // Empty and singleton cases
        if (a == null || a.length <= 1) return a;

        // Build histogram
        int[][] histogram = new int[4][257];
        for (int v : a) {
            histogram[0][((v >>  0) & 0xFF) + 1]++; // Byte 0 O(1)
            histogram[1][((v >>  8) & 0xFF) + 1]++; // Byte 1 O(1)
            histogram[2][((v >> 16) & 0xFF) + 1]++; // Byte 2 O(1)
            histogram[3][(((v >> 24) & 0xFF) ^ 0x80) + 1]++;
            // ^^ Byte 3 w/ sign toggle O(1)
        } // O(n)
        System.out.println("Histogram: O(n) -> " + a.length + " elements, 4 bytes each at O(1)");

        // Prefix sums for each byte partition independently
        // Determines offset for each byte.
        for (int i = 1; i < 257; i++) {
            histogram[0][i] += histogram[0][i - 1];
            histogram[1][i] += histogram[1][i - 1];
            histogram[2][i] += histogram[2][i - 1];
            histogram[3][i] += histogram[3][i - 1];
        }
        System.out.println("Prefix sums: O(b) -> 4 partitions x 256 buckets");

        // Scatter
        int[] b = new int[a.length]; // temp buffer
        for (int v : a) b[histogram[0][(v >>  0) & 0xFF]++] = v;
        System.out.println("Scatter byte 0: O(n) -> " + a.length + " elements");
        for (int v : b) a[histogram[1][(v >>  8) & 0xFF]++] = v;
        System.out.println("Scatter byte 1: O(n) -> " + a.length + " elements");
        for (int v : a) b[histogram[2][(v >> 16) & 0xFF]++] = v;
        System.out.println("Scatter byte 2: O(n) -> " + a.length + " elements");
        for (int v : b) a[histogram[3][((v >> 24) & 0xFF) ^ 0x80]++] = v;
        System.out.println("Scatter byte 3: O(n) -> " + a.length + " elements");
        System.out.println("Total: O(n) + O(b) + 4 x O(n) = O(n) for fixed b = 256");
        return a;
    }
}