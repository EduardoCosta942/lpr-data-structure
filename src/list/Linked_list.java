package list;

import java.util.*;

/*Compare the execution time this class to Array_list class. Observe how both of them work.*/
public class Linked_list {
    public static void main(String[] args) {
        // Declare variables
        Random rd = new Random();
        List<Integer> linked_list = new LinkedList<>(Arrays.asList(0,1));
        long start = System.nanoTime();

        /*// Insert values at list
        for (int x = 0; x < 10000000; x++){
            linked_list.add(rd.nextInt());
        }*/

        // Insert values at a specif index
        for (int x = 0; x < 10000000; x++){
            linked_list.add(1, rd.nextInt());
        }
        System.out.println(linked_list.toString());
        System.out.println((System.nanoTime() - start) / 1_000_000 + " ms");
    }
}
