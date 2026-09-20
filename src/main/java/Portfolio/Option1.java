package Portfolio;

import java.util.Comparator;
import java.util.Scanner;

public class Option1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt the user of the program to add five people to the queue.
        Queue<Person> people = new Queue<>();
        System.out.println("add five people (first last age)");
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