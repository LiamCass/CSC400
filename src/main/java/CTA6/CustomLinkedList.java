/*
Implement a custom LinkedList ADT with an iterator in Java. The LinkedList should support the basic operations:
    insertion
    deletion
    traversal using an iterator
*/

package CTA6;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomLinkedList {

    // The LinkedList should support the basic operations:
    // Inserts a new node with the given data.
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    // Deletes the first occurrence of a node with the given data.
    public void delete(int data) {
        if (head == null) return;
        if (head.data == data) {
            head = head.next;
            return;
        }
        Node curr = head;
        while (curr.next != null && curr.next.data != data) {
            curr = curr.next;
        }
        if (curr.next != null) {
            curr.next = curr.next.next;
        }
    }

    // Returns an iterator for traversing the linked list.
    public Iterator<Integer> iterator() {
        return new LinkedListIterator();
    }

    // Implement a custom LinkedList ADT with an iterator in Java.
    private Node head;
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Implement an inner class named LinkedListIterator within CustomLinkedList to serve as the iterator.
    private class LinkedListIterator implements Iterator<Integer> {
        // The iterator should have the following methods:
        private Node current = head;

        // Returns true if there is a next element, false otherwise.
        @Override
        public boolean hasNext() {
            return current != null;
        }

        // Returns the next element and moves the iterator to the next position.
        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int data = current.data;
            current = current.next;
            return data;
        }
    }
}