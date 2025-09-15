package Practices;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Hospital {
    public static void main(String[] args) {
        // Declare variables
        Queue<String> priorityQueue = new LinkedList<>();
        Queue<String> normalQueue = new LinkedList<>();
        Scanner scanner;

        // Fill Queues:
        File file = new File("src/Practices/text_files/pacientes.txt");
        try{
            scanner = new Scanner(file);

            String name = scanner.next().concat(" " + scanner.next());
            boolean isPriority = scanner.next().equals("sim");
            adicionarPaciente(name, isPriority, priorityQueue, normalQueue);

            name = scanner.next().concat(" " + scanner.next());
            isPriority = scanner.next().equals("sim");
            adicionarPaciente(name, isPriority, priorityQueue, normalQueue);

            System.out.println(chamarPaciente(priorityQueue, normalQueue));

            name = scanner.next().concat(" " + scanner.next());
            isPriority = scanner.next().equals("sim");
            adicionarPaciente(name, isPriority, priorityQueue, normalQueue);

            System.out.println(chamarPaciente(priorityQueue, normalQueue));

            name = scanner.next().concat(" " + scanner.next());
            isPriority = scanner.next().equals("sim");
            adicionarPaciente(name, isPriority, priorityQueue, normalQueue);

            System.out.println(chamarPaciente(priorityQueue, normalQueue));

            name = scanner.next().concat(" " + scanner.next());
            isPriority = scanner.next().equals("sim");
            adicionarPaciente(name, isPriority, priorityQueue, normalQueue);

            System.out.println(chamarPaciente(priorityQueue, normalQueue));
            System.out.println(chamarPaciente(priorityQueue, normalQueue));
        } catch (IOException ioe){
            System.out.println("File not Found");
        }



    }
    public static void adicionarPaciente(String name, boolean isPriority, Queue<String> priorityQueue, Queue<String> normalQUeue){
        if (isPriority) {
            priorityQueue.add(name);
        } else {
            normalQUeue.add(name);
        }
    }

    public static String chamarPaciente(Queue<String> priorityQueue, Queue<String> normalQueue){
        if (!priorityQueue.isEmpty()){
            return priorityQueue.poll();
        }
        return normalQueue.poll();
    }
}