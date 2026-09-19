package CTA2;

// Write a Java program that demonstrates the usage of the additional methods.
public class Main {
    // Your program should perform the following operations:
    public static void main(String[] args) {
        // Create two instances of the `Bag` class.
        Bag<String> bag1 = new Bag<>();
        Bag<String> bag2 = new Bag<>();

        // Add elements to each bag, including duplicates. (bag1)
        System.out.println("Adding elements A,A,B to bag1");
        bag1.add("A");
        bag1.add("A");
        bag1.add("B");

        // Add elements to each bag, including duplicates. (bag2)
        System.out.println("Adding elements B,B,C to bag2");
        bag2.add("B");
        bag2.add("B");
        bag2.add("C");

        // Print the size of each bag using the `size` method.
        System.out.println("bag1.size(): " + bag1.size());
        System.out.println("bag2.size(): " + bag2.size());

        // Merge the two bags together using the `merge` method.
        System.out.println("\nMerging bag2 into bag1 using bag1.merge(bag2)");
        bag1.merge(bag2);

        // Print the merged bag contents.
        System.out.println("Merged bag1 contents: " + bag1);

        // Create a new bag containing only the distinct elements using the `distinct` method.
        System.out.println("\nCreating bag3 from bag1.distinct()");
        Bag<String> bag3 = bag1.distinct();

        // Print the distinct bag contents.
        System.out.println("bag3 contents: " + bag3);
    }
}