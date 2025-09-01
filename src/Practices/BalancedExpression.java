package Practices;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BalancedExpression {
    public static boolean isBalanced(String expression) {
        // Declare variables
        char[][] DELIMITERS = {{'(', '{', '['}, {')', '}', ']'}};
        char[] expressionArray;
        Stack<Character> delimiterStack = new Stack<>();

        // Traverse the expression
        expressionArray = expression.toCharArray();
        for (int x = 0; x < expressionArray.length; x++){
            // Traverse constants DELIMITERS
            for (int y = 0; y < DELIMITERS[0].length; y++){
                if (DELIMITERS[0][y] == expressionArray[x]) delimiterStack.add(expressionArray[x]); // Add at stack the opening delimiter
                if(DELIMITERS[1][y] == expressionArray[x]){
                    if(delimiterStack.peek() == DELIMITERS[0][y]) delimiterStack.pop(); // Pop the delimiter if the inverted delimiter is on top of the stack
                }
            }
        }
        return delimiterStack.isEmpty();
    }
}
/*
Tatic:
{[2+3+(2*3)] /8}*4
{([] []) ([])}
{([] --> If next element matches the peek, do not offer, pop the last element. At the end,
if the stack is not null, return false.
*/