package data_structures.others;

import java.util.Scanner;
import java.util.Stack;

public class C_right_bracket_sequence {

    public static boolean ispair(char a, char b) {
        return (a == '[' && b == ']' || a == '{' && b == '}' || a == '(' && b == ')');
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String brackets = scanner.nextLine();

        Stack<Character> stack = new Stack();

        for (int i = 0; i < brackets.length(); i++) {
            if (stack.isEmpty() || !ispair(stack.peek(), brackets.charAt(i))) {
                stack.push(brackets.charAt(i));
            } else {
                stack.pop();
            }
        }

        if (stack.isEmpty()) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
