package Practices;

import java.util.Stack;

public class MathematicalExpressions {
    public static boolean isBalanced(String expression) {
        // Declare variables
        char[][] DELIMITERS = {{'(', '{', '['}, {')', '}', ']'}};
        char[] expressionArray;
        Stack<Character> delimiterStack = new Stack<>();

        // Traverse the expression
        expressionArray = expression.toCharArray();
        for (int x = 0; x < expressionArray.length; x++) {
            // Traverse constants DELIMITERS
            for (int y = 0; y < DELIMITERS[0].length; y++) {
                if (DELIMITERS[0][y] == expressionArray[x])
                    delimiterStack.add(expressionArray[x]); // Add at stack the opening delimiter
                if (DELIMITERS[1][y] == expressionArray[x]) {
                    if (delimiterStack.peek() == DELIMITERS[0][y])
                        delimiterStack.pop(); // Pop the delimiter if the inverted delimiter is on top of the stack
                }
            }
        }
        return delimiterStack.isEmpty();
    }

    public static int solveExpression(String expression) {
        // Declare variables
        Stack<Character> signalStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        int sum;

        // Insert at stacks
        for (char character : expression.toCharArray()) {
            if (character == '*' || character == '+') {
                signalStack.add(character);
            } else {
                numStack.add(Character.getNumericValue(character));
            }
        }

        // Make sums
        while (numStack.size() != 1){
            if (!signalStack.isEmpty()) {
                char pop = signalStack.pop();
                if (pop == '*') {
                    numStack.add(numStack.pop() * numStack.pop());
                } else if (!signalStack.isEmpty() && pop == '+'){
                    if (signalStack.peek() == '*'){
                        signalStack.pop();
                        int num = numStack.pop();
                        numStack.add(numStack.pop() * numStack.pop());
                        numStack.add(num);
                        signalStack.add('+');
                    } else {
                        numStack.add(numStack.pop() + numStack.pop());
                    }
                }
            } else {
                numStack.add(numStack.pop() + numStack.pop());
            }

        }
        return numStack.pop();
    }
}
/*
Tatic:
{[2+3+(2*3)] /8}*4
{([] []) ([])}
{([] --> If next element matches the peek, do not offer, pop the last element. At the end,
if the stack is not null, return false.
*/
