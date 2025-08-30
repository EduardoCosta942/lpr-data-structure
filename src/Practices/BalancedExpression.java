package Practices;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BalancedExpression {
    public static boolean isBalanced(String expression) throws NullPointerException{
        // Declare variables
        char[] OPENDELIMITERS = new char[]{'(', '{', '['};
        char[] CLOSEDELIMITERS = new char[]{')', '}', ']'};
        char[] expressionArray;
        Stack<Character> delimiterStack = new Stack<>();

        // Traverse the expression
        expressionArray = expression.toCharArray();
        for (int x = 0; x < expressionArray.length; x++){
            // Traverse constants OPENDELIMITERS and CLOSEDELIMITERS
            for (int y = 0; y < OPENDELIMITERS.length; y++){
                if (OPENDELIMITERS[y] == expressionArray[x]) delimiterStack.add(expressionArray[x]); // Add at stack the opening delimiter
                if(CLOSEDELIMITERS[y] == expressionArray[x]){
                    if(delimiterStack.peek() == OPENDELIMITERS[y]) delimiterStack.pop(); // Pop the delimiter if the inverted delimiter is on top of the stack
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