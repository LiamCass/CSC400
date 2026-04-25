package CTA2;
import java.util.HashMap;
import java.util.Map;

// Java class called Bag that implements the bag data structure.
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

    // This method should return the total number of elements in the bag, including duplicates.
    public int size() {
        int[] total = {0};
        elements.values().forEach(count ->
            total[0] += count
        );
        return total[0];
    }

    // This method should merge the elements of otherBag into the current bag.
    public void merge(Bag<T> otherBag) {
        otherBag.elements.forEach((key, count) ->
            elements.merge(key, count, Integer::sum)
        );
    }

    // This method should return a new bag that contains only the distinct elements from the current bag.
    public Bag<T> distinct() {
        Bag<T> result = new Bag<>();
        this.elements.keySet().forEach(item ->
            result.add(item)
        );
        return result;
    }

    @Override
    public String toString() { return "" + elements; }
}