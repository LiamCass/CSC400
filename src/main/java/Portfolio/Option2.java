package Portfolio;

import java.util.Comparator;
import java.util.Scanner;

public class Option2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt the user of the program to add five instructors to the queue.
        Queue<Instructor> instructors = new Queue<>();
        System.out.println("add five instructors (first last courses)");
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

// program that creates an Instructor class (Option #2)
record Instructor(
    // contains string that represent
    String firstName, // the first
    String lastName,  // and last name
    int courses       // and the number of courses the instructor teaches
) {}