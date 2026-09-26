package CTA6;

import java.util.Iterator;
import java.util.Random;

// There is no need for file I/O. Test your program using an array of ten random integers.
public class Main {
    public static void main(String[] args) {
        // Create an array of 10 random integers.
        Random rand = new Random();
        int[] numbers = new int[10];

        System.out.print("\nArray: \n");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(100);
            System.out.print(numbers[i] + " ");
        }

        // CustomDeque DEMONSTRATION
        CustomDeque customDeque = new CustomDeque();

        // Enqueue array elements
        for (int n : numbers) { customDeque.enqueueFront(n); }

        // Iterate and display elements
        Iterator<Integer> iterator1 = customDeque.iterator();
        System.out.print("\nDeque: \n");
        while (iterator1.hasNext()) {
            System.out.print(iterator1.next() + " ");
        }

        // CustomLinkedList DEMONSTRATION
        CustomLinkedList linkedList = new CustomLinkedList();

        // Insert array elements
        for (int n : numbers) { linkedList.insert(n); }

        // Iterate and display elements
        System.out.print("\nLinked List: \n");
        Iterator<Integer> iterator2 = linkedList.iterator();
        while (iterator2.hasNext()) {
            System.out.print(iterator2.next() + " ");
        } System.out.println();
    }
}