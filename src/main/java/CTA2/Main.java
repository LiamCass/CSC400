package CTA2;

public class Main {
    public static void main(String[] args) {
        // Create two instances of the Bag class
        Bag<String> bag1 = new Bag<>();
        Bag<String> bag2 = new Bag<>();

        // Add elements to bag1, including duplicates
        System.out.println("Adding elements to Bag 1:");
        bag1.add("apple");
        bag1.add("banana");
        bag1.add("apple");
        bag1.add("orange");
        bag1.add("banana");
        bag1.add("apple");

        // Add elements to bag2, including duplicates
        System.out.println("Adding elements to Bag 2:");
        bag2.add("banana");
        bag2.add("grape");
        bag2.add("apple");
        bag2.add("grape");
        bag2.add("kiwi");

        // Print the size of each bag
        System.out.println("\nSize of Bag 1: " + bag1.size());
        System.out.println("Size of Bag 2: " + bag2.size());

        // Print contents of both bags before merging
        System.out.println("\nBag 1 contents: " + bag1);
        System.out.println("Bag 2 contents: " + bag2);

        // Merge bag2 into bag1
        System.out.println("\nMerging Bag 2 into Bag 1...");
        bag1.merge(bag2);

        // Print the merged bag contents and size
        System.out.println("Merged Bag contents: " + bag1);
        System.out.println("Merged Bag size: " + bag1.size());

        // Create a new bag with only distinct elements
        System.out.println("\nCreating distinct bag from merged bag...");
        Bag<String> distinctBag = bag1.distinct();

        // Print the distinct bag contents and size
        System.out.println("Distinct Bag contents: " + distinctBag);
        System.out.println("Distinct Bag size: " + distinctBag.size());
    }
}