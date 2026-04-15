// Designs a Java class called Bag that implements the bag data structure.
package CTA1;

/*

Write a Java program that demonstrates the usage of the Bag class.
Your program should perform the following operations:
    Create an instance of the Bag class.
    Add several elements to the bag, including duplicates.
    Print the bag contents.
    Test the contains method for a few elements.
    Test the count method for a few elements.
    Remove an element from the bag.
    Print the bag contents again
    Test the contains method for the removed element.
    Test the count method for the removed element.
Comment your code appropriately to explain the functionality of each method

┌───────────┬─────────┬───────────┬────────────┬──────────┬──────────┐
│ Operation │ HashMap │ ArrayList │ LinkedList │ Multiset │ TreeMap  │
├───────────┼─────────┼───────────┼────────────┼──────────┼──────────┤
│ add       │ O(1)    │ O(1)      │ O(1)       │ O(1)     │ O(log n) │
│ contains  │ O(1)    │ O(n)      │ O(n)       │ O(1)     │ O(log n) │
│ count     │ O(1)    │ O(n)      │ O(n)       │ O(1)     │ O(log n) │
│ remove    │ O(1)    │ O(n)      │ O(n)       │ O(1)     │ O(log n) │
└───────────┴─────────┴───────────┴────────────┴──────────┴──────────┘
*/

// In most scenarios, I'd prefer the following package
// Google Guava multiset:
//  https://github.com/google/guava/blob/master/guava/src/com/google/common/collect/Multiset.java
//  https://github.com/google/guava/blob/master/guava/src/com/google/common/collect/Multisets.java

import java.util.HashMap;
import java.util.Map;

// Design a Java class called Bag that implements the bag data structure.
public class Bag<T> {
    private final Map<T, Integer> elements;

    // Constructor. Initializes empty Bag
    public Bag() { this.elements = new HashMap<>(); }

    // This method should return true if the item exists in the bag; otherwise, it should return false.
    public boolean contains(T item) { return elements.containsKey(item); }

    // This method should return the number of occurrences of the specified item in the bag. If the item does not exist, it should return 0.
    public int count(T item) { return elements.getOrDefault(item, 0); }

    // This method should add an item of type T to the bag.
    public void add(T item) { elements.merge(item, 1, Integer::sum); }

    // This method should remove one occurrence of the item from the bag, if it exists.
    public void remove(T item) {
        elements.computeIfPresent(item, (key, count) -> {
            int newCount = count - 1;
            return (newCount == 0) ? null : newCount;
        });
    }

    @Override
    public String toString() { return "" + elements; }
}