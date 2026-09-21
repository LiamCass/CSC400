package CTA5;

import java.util.Arrays;

// Main class for testing the Radix class. Provides input list as requested.
public class Main {
    public static void main(String[] args) {
        // Analyze the algorithm by documenting the steps taken when radix sort sorts the following array
        int[] ints = {783, 99, 472, 182, 264, 543, 356, 295, 692, 491, 94};
        // Review output for trace and analysis results.

        System.out.println("Before: " + Arrays.toString(ints));
        Radix.radixSort(ints);
        System.out.println("After:  " + Arrays.toString(ints));
    }
}