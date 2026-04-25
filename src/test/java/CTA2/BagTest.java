package CTA2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class BagTest {
    private Bag<String> bag;

    @Before
    public void setUp() {
        bag = new Bag<>();
    }

    @Test
    public void testAddAndPrint() {
        // Add several elements to the bag, including duplicates
        bag.add("apple");
        bag.add("banana");
        bag.add("apple");
        bag.add("orange");
        bag.add("banana");
        bag.add("apple");

        // Print the bag contents using toString
        System.out.println("After adding: " + bag);
    }

    @Test
    public void testContains() {
        // Add several elements to the bag
        bag.add("apple");
        bag.add("banana");
        bag.add("orange");

        // Test the contains method for a few elements
        assertTrue(bag.contains("apple"));
        assertTrue(bag.contains("banana"));
        assertFalse(bag.contains("grape"));

        System.out.println("Bag: " + bag);
        System.out.println("Contains apple: " + bag.contains("apple") + ", banana: " + bag.contains("banana"));
    }

    @Test
    public void testCount() {
        // Add several elements with duplicates
        bag.add("apple");
        bag.add("apple");
        bag.add("banana");
        bag.add("apple");
        bag.add("orange");
        bag.add("banana");

        // Test the count method for a few elements
        assertEquals(3, bag.count("apple"));
        assertEquals(2, bag.count("banana"));
        assertEquals(1, bag.count("orange"));
        assertEquals(0, bag.count("grape"));

        System.out.println("Bag: " + bag);
    }

    @Test
    public void testRemove() {
        // Add several elements to the bag
        bag.add("apple");
        bag.add("banana");
        bag.add("apple");
        bag.add("orange");

        System.out.println("Before removal: " + bag);

        // Remove an element from the bag
        bag.remove("apple");

        // Print the bag contents and test
        assertEquals(1, bag.count("apple"));
        System.out.println("After removal: " + bag);
    }

    @Test
    public void testContainsAfterRemoval() {
        bag.add("apple");
        bag.add("banana");

        System.out.println("Before removal: " + bag);

        // Remove the element completely
        bag.remove("banana");

        // Test the contains method for the removed element
        assertFalse(bag.contains("banana"));
        assertTrue(bag.contains("apple"));

        System.out.println("After removal: " + bag);
    }

    @Test
    public void testCountAfterRemoval() {
        bag.add("apple");
        bag.add("apple");
        bag.add("apple");

        System.out.println("Before removal: " + bag);

        bag.remove("apple");
        assertEquals(2, bag.count("apple"));

        System.out.println("After removal: " + bag);
    }

    @Test
    public void testSizeNoDuplicates() {
        bag.add("apple");
        bag.add("banana");
        bag.add("cherry");

        assertEquals(3, bag.size());
    }

    @Test
    public void testSizeWithDuplicates() {
        bag.add("apple");
        bag.add("apple");
        bag.add("banana");
        bag.add("banana");
        bag.add("banana");

        assertEquals(5, bag.size());
    }

    @Test
    public void testMergeDisjointBags() {
        bag.add("apple");
        bag.add("banana");

        Bag<String> other = new Bag<>();
        other.add("cherry");
        other.add("date");

        System.out.println("Bag size  : " + bag.size());    // 2
        System.out.println("Other size: " + other.size());  // 2

        bag.merge(other);
        System.out.println("Merged    : " + bag);

        assertEquals(4, bag.size());
    }

    @Test
    public void testMergeOverlappingBags() {
        bag.add("apple");
        bag.add("banana");

        Bag<String> other = new Bag<>();
        other.add("banana");
        other.add("cherry");

        System.out.println("Bag size  : " + bag.size());    // 2
        System.out.println("Other size: " + other.size());  // 2

        bag.merge(other);
        System.out.println("Merged    : " + bag);

        assertEquals(4, bag.size());
        assertEquals(2, bag.count("banana"));
    }

    @Test
    public void testDistinct() {
        bag.add("apple");
        bag.add("apple");
        bag.add("banana");
        bag.add("banana");
        bag.add("banana");
        bag.add("cherry");

        Bag<String> distinct = bag.distinct();
        System.out.println("Distinct  : " + distinct);

        assertEquals(3, distinct.size());
        assertEquals(1, distinct.count("apple"));
        assertEquals(1, distinct.count("banana"));
        assertEquals(1, distinct.count("cherry"));
    }
}