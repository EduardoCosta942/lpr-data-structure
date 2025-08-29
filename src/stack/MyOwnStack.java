package stack;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

public class MyOwnStack {
    public static void main(String[] args) {
        // Declare variables
        Scanner sc = new Scanner(System.in);
        int option;
        Stack<String> stringStack = new Stack<>();
        String insert;

        // Makes Menu
        option = 0;
        do {
            menu();
            try {
                option = sc.nextInt();
                System.out.println('\n');
            } catch (InputMismatchException ime) {
                System.out.println("The input must be a number. Message: " + ime.getMessage());
                sc.nextLine(); // Clear buffer
            }

            switch (option) {
                case 1 -> {
                    if (!stringStack.isEmpty()) {
                        System.out.println("Peek: " + stringStack.peek());
                    } else {
                        System.out.println("Stack is empty.");
                    }
                }
                case 2 -> {
                    System.out.println("Size: " + stringStack.size());
                }
                case 3 -> {
                    System.out.println("Is empty? " + stringStack.isEmpty());
                }
                case 4 -> {
                    if (!stringStack.isEmpty()) {
                        System.out.println("Pop: " + stringStack.pop());
                    } else {
                        System.out.println("Stack is empty.");
                    }
                }
                case 5 -> {
                    System.out.println("Type the content for the stack: ");
                    sc.nextLine(); // Clear buffer
                    try {
                        insert = sc.nextLine();
                        stringStack.push(insert);
                    } catch (InputMismatchException ime) {
                        System.out.println("The input must be a valid string. Message: " + ime.getMessage());
                    }
                }
                case 6 -> {
                    System.out.println(stringStack.toString());
                }
                case 7 -> {
                    option = -1;
                }
                default -> {
                    option = 0;
                }
            }
        } while (option != -1);
        sc.close();
    }

    public static void menu() {
        System.out.print("""
                -----------------
                [1] Peek
                [2] Size
                [3] isEmpty
                [4] Pop
                [5] Push
                [6] toString
                [7] Leave
                Select your option: 
                """);
    }
}