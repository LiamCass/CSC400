/*
Final Program:
Write a program that creates a Person/Instructor class that contains string that represent the first and last name of a person and their age/number of courses teaching. You will need to create a Queue class that will store each person/instructor in the queue and can sort the queue based on last name or age/courses.

Prompt the user of the program to add five people/instructors to the queue. Your program should provide the contents of the queue and then sort the queue using the quick sort in two ways:

Descending order by last name
Descending order by age/courses
*/

package Portfolio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

// Write a program
public class Portfolio {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // OPTION #1
        // Prompt the user of the program to add five people to the queue.
        Queue<Person> people = new Queue<>();
        System.out.println("\nadd five people (first last age)");
        for (int i = 1; i <= 5; i++) {
            System.out.print("person " + i + ": ");
            people.enqueue(new Person(input.next(), input.next(), input.nextInt()));
        }

        // Your program should provide the contents of the queue and then sort the queue using the quick sort in two ways:
        System.out.println(people);
        System.out.println("\nPerson queue sorted descending by last name");
        people.sort(Comparator.comparing(Person::lastName).reversed()); // Descending order by last name
        System.out.println(people);
        System.out.println("\nPerson queue sorted descending by age");
        people.sort(Comparator.comparing(Person::age).reversed());      // Descending order by age
        System.out.println(people);

        // OPTION #2
        // Prompt the user of the program to add five instructors to the queue.
        Queue<Instructor> instructors = new Queue<>();
        System.out.println("\nadd five instructors (first last courses)");
        for (int i = 1; i <= 5; i++) {
            System.out.print("instructor " + i + ": ");
            instructors.enqueue(new Instructor(input.next(), input.next(), input.nextInt()));
        }

        // Your program should provide the contents of the queue and then sort the queue using quick sort in two ways:
        System.out.println(instructors);
        System.out.println("\nInstructor queue sorted descending by last name");
        instructors.sort(Comparator.comparing(Instructor::lastName).reversed()); // Descending order by last name
        System.out.println(instructors);
        System.out.println("\nInstructor queue sorted descending by courses");
        instructors.sort(Comparator.comparing(Instructor::courses).reversed());  // Descending order by number of courses teaching
        System.out.println(instructors);
        input.close();
    }
}

// program that creates a Person class (Option #1)
record Person(
    // contains string that represent
    String firstName, // the first
    String lastName,  // and last name
    int age           // and their age
) {}

// program that creates an Instructor class (Option #2)
record Instructor(
    // contains string that represent
    String firstName, // the first
    String lastName,  // and last name
    int courses       // and the number of courses the instructor teaches
) {}

// You will need to create a Queue class
class Queue<T extends Record> {
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