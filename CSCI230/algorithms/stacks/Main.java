package algorithms.stacks;

import algorithms.stacks.StackArray;
import java.util.ArrayList;


public class Main {
    public static void stackTest() {
        StackArray stack = new StackArray();
        stack.push("Foo");
        stack.push("Bar");
        stack.print();
        System.out.println(stack.peek());
        stack.pop();
        stack.print();
        stack.pop();
        stack.print();

        // Causes exception
        // stack.pop();
    }

    public static String infixToPostfix(String expression) {

        // Assume our input is a valid arithmetic expression in infix, only containing
        // digits, +, /, -, *, (, and )
        // Algorithm:
        // - Always push operands to final string
        // - Always push ( to stack
        // - When we encounter ), pop the stack back (sending operators to output) until we find (
        // and pop it off (do not send to output)
        // - When we encounter an operator, make a precedence determination:
        // - If the current operator is of equal or higher precedence than top of stack, push.
        // - If the current operator is of lower precendene than top of stack, pop top and send to
        // output, then push current.

        ArrayList<Character> infixExpression = new ArrayList<Character>();
        ArrayList<Character> stack = new ArrayList<Character>();
        for (int i = 0; i < expression.length(); i++) {
            Character c = expression.charAt(i);
            if (c == '+' || c == '-') {
            }
            if (c == '*' || c == '/') {
            }
        }
        return infixExpression.toString();
    }

    public static void main(String[] args) {

    }
}
