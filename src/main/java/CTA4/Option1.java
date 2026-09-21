package CTA4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Option1 {
    public int evaluate(String expression) {
        Deque<Integer> args = new ArrayDeque<>();
        try {
            for (String token : expression.split(" ")) {
                if (token.matches("\\d+")) args.push(Integer.parseInt(token));
                else {
                    int b = args.pop();
                    int a = args.pop();
                    switch (token) {
                        case "+" -> args.push(a + b);
                        case "-" -> args.push(a - b);
                        case "*" -> args.push(a * b);
                        case "/" -> args.push(a / b);
                        case "%" -> args.push(a % b);
                        default -> throw new IllegalArgumentException();
                    }
                }
            }
            if (args.size() != 1) throw new IllegalArgumentException();
            return args.pop();
        } catch (Exception e) {
            throw new IllegalArgumentException("Error: Invalid postfix expression");
        }
    }

    public static void main(String[] args) throws IOException {
        Option1 calculator = new Option1();
        Path file = Path.of("postfix.txt");

        // operands spell "Hello, World" with a null terminator!!
        Files.write(file, List.of(
            "72 101 +",
            "108 108 * 111 -",
            "44 32 %",
            "87 111 114 108 - + *",
            "100 0 /",
            "+",
            "0"
        ));

        for (String line : Files.readAllLines(Path.of("postfix.txt"))) {
            try {
                System.out.println(line + " = " + calculator.evaluate(line));
            } catch (IllegalArgumentException e) {
                System.out.println(line + " = " + e.getMessage());
            }
        }

        // Postfix example 1: Valid Expression
        String postfix1 = "4 2 * 3 +";
        System.out.println("Postfix result 1: " + calculator.evaluate(postfix1));
        // Should display `Postfix result 1: 11`

        // Postfix example 2: Valid Expression
        String postfix2 = "5 3 + 7 *";
        System.out.println("Postfix result 2: " + calculator.evaluate(postfix2));
        // Should display `Postfix result 2: 56`

        // Postfix example 3: Invalid Expression
        String postfix3 = "4 2 * +"; // Missing operand
        try {
            System.out.println("Postfix result 3: " + calculator.evaluate(postfix3));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        // Should display `Error: Invalid postfix expression`
    }
}