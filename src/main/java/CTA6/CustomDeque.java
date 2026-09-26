/*
Implement a custom Deque ADT with an iterator in Java. The Deque should support the basic operations:
    insertion
    deletion
    traversal using an iterator
*/

package CTA6;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class CustomDeque {
    // Implement a class named CustomDeque with the following methods:
    private Deque<Integer> deque;
    public CustomDeque() { this.deque = new LinkedList<>(); }

    // enqueueFront(int data): Inserts a new element at the front of the deque.
    public void enqueueFront(int data) { deque.addFirst(data); }

    // enqueueRear(int data): Inserts a new element at the rear of the deque.
    public void enqueueRear(int data) { deque.addLast(data); }

    // dequeueFront(): Removes and returns the element from the front of the deque.
    public int dequeueFront() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        return deque.removeFirst();
    }

    // dequeueRear(): Removes and returns the element from the rear of the deque.
    public int dequeueRear() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        return deque.removeLast();
    }

    // iterator(): Returns an iterator for traversing the deque.
    public Iterator<Integer> iterator() {
        return new DequeIterator();
    }

    public boolean isEmpty() { return deque.isEmpty(); }

    // Implement an inner class named DequeIterator within CustomDeque to serve as the iterator.
    private class DequeIterator implements Iterator<Integer> {
        // The iterator should have the following methods:
        private Iterator<Integer> iterator = deque.iterator();

        // Returns true if there is a next element, false otherwise.
        @Override
        public boolean hasNext() { return iterator.hasNext(); }

        // Returns the next element and moves the iterator to the next position.
        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return iterator.next();
        }
    }


}
