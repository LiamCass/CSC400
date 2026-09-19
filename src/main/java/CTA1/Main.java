package CTA1;

// Write a Java program that demonstrates the usage of the `Bag` class.
public class Main {

    // Your program should perform the following operations:
    public static void main(String[] args) {
        // Create an instance of the `Bag` class.
        Bag<String> bag = new Bag<>();

        // Add several elements to the bag, including duplicates.
        System.out.println("Adding A, A, and B to Bag");
        bag.add("A");
        bag.add("A");
        bag.add("B");

        // Print the bag contents.
        System.out.println("Bag contents: " + bag);

        // Test the `contains` method for a few elements.
        System.out.println("Contains A?: " + bag.contains("A"));
        System.out.println("Contains B?: " + bag.contains("B"));
        System.out.println("Contains C?: " + bag.contains("C"));

        // Test the `count` method for a few elements.
        System.out.println("Count of A: " + bag.count("A"));
        System.out.println("Count of B: " + bag.count("B"));
        System.out.println("Count of C: " + bag.count("C"));

        // Remove an element from the bag.
        System.out.println("Removing a B from the bag");
        bag.remove("B");

        // Print the bag contents again.
        System.out.println("Bag contents after removing B: " + bag);

        //Test the `contains` method for the removed element.
        System.out.println("Contains B? " + bag.contains("poop"));
    }
}