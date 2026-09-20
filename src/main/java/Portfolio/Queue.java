package Portfolio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// You will need to create a Queue class
public class Queue<T extends Record> {
    // A Queue class that will store each Person in the queue (Option #1)
    // A Queue class that will store each Instructor in the queue (Option #2)
    private final List<T> contents = new ArrayList<>();

    public void enqueue(T item) { contents.add(item); };
    public T dequeue() { return contents.remove(0); }

    // can sort the Queue based on their last name and age (Option #1)
    // can sort the Queue based on last name or the number of courses teaching. (Option #2)
    public void sort(Comparator<T> by) { quickSort(0, contents.size() - 1, by); }

    private void quickSort(int lo, int hi, Comparator<T> by) {
        if (lo >= hi) return;
        T pivot = contents.get(hi);
        int i = lo;
        for (int j = lo; j < hi; j++)
            if (by.compare(contents.get(j), pivot) < 0) Collections.swap(contents, i++, j);
        Collections.swap(contents, i, hi);
        quickSort(lo, i - 1, by);
        quickSort(i + 1, hi, by);
    }

    @Override
    public String toString() { return contents.toString(); }
}