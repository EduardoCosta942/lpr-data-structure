package queue;

import java.util.*;

public class QueueMenu {
    public static void main(String[] args) {
        // Declare variables
        Scanner sc = new Scanner(System.in);
        int option;
        Queue<String> stringQueue = new LinkedList<>();
        String insert;

        // Makes Menu
        option = 0;
        do {
            menu();
            try{
                option = sc.nextInt();
                System.out.println('\n');
            } catch (InputMismatchException ime){
                System.out.println("The input must be a number. Message: " + ime.getMessage());
            }

            switch (option){
                case 1 ->{
                    System.out.println("Peek: " + stringQueue.peek());
                }
                case 2 ->{
                    System.out.println("Size: " + stringQueue.size());
                }
                case 3 ->{
                    System.out.println("Is empty? " + stringQueue.isEmpty());
                }
                case 4 ->{
                    System.out.println("Poll: " + stringQueue.poll());
                }
                case 5 ->{
                    System.out.println("Type the content for the queue: ");
                    sc.nextLine(); // Clear buffer
                    try{
                        stringQueue.offer(sc.nextLine());
                    } catch (InputMismatchException ime){
                        System.out.println("The input must be a number. Message: " + ime.getMessage());
                    }
                }
                case 6 -> {
                    System.out.println(stringQueue.toString());
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

    public static void menu(){
        System.out.print("""
                -----------------
                [1] Peek
                [2] Size
                [3] isEmpty
                [4] poll
                [5] Offer
                [6] toString
                [7] Leave
                Select your option: 
                """);
    }

}