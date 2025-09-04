package Practices;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Palindrome {
    public static boolean isPalindrome(String text) {
        // Declare variables
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        // Insert into queue and stack
        for (char character:text.toCharArray()){
            queue.add(character);
            stack.add(character);
        }

        // Traverse objects and compare characters
        for (int x = 0; x < queue.size(); x++){
            if (queue.poll() != stack.pop()) return false;
        }
        return true;
    }
}
/*
String: abcde
queue:
(a)bcde
Stack:
abcde


*/
