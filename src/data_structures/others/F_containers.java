package data_structures.others;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class F_containers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Stack<Integer>> shelves = new ArrayList<>();
        int k;
        for (int i = 0; i < n; i++) {
            k = scanner.nextInt();
            Stack stack = new Stack();
            if (k != 0) {
                for (int j = 0; j < k; j++) {
                    stack.push(scanner.nextInt());
                }
            }
            shelves.add(stack);
        }

        int counter = 0, temp;

        if (n == 1) {
            return;
        }

        boolean hasElementsUnder = false;
        if (n == 2) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Stack<Integer> stack : shelves) {
                while (!stack.isEmpty()) {
                    if (stack.peek() == (counter + 1)) {
                        stack.pop();
                        hasElementsUnder = true;
                    } else {
                        shelves.get(counter == 0 ? counter + 1 : counter - 1).push(stack.pop());
                        stringBuilder.append((counter + 1) + " " + (counter == 0 ? 2 : 1) +"\n");
                        if (hasElementsUnder) {
                            System.out.println("0");
                            return;
                        }
                    }
                }
                hasElementsUnder = false;
                counter++;
            }
            System.out.println(stringBuilder.toString());
            return;
        }


        Stack<Integer> lastStack = shelves.get(shelves.size() - 1);
        Stack<Integer> preLastStack = shelves.get(shelves.size() - 2);
        Stack<Integer> prePreLastStack = shelves.get(shelves.size() - 3);

        //Make last stack as buffer, pre last stack as reserve for last stack values
        for (Stack<Integer> stack : shelves) {
            if (counter + 1 == shelves.size()) {
                continue;
            }
            while (!stack.isEmpty()) {
                if (stack.peek() == counter + 1) {
                    shelves.get(counter+1).push(stack.pop());
                    System.out.println((counter + 1) + " " + (counter + 2));
                } else if (stack.peek() == (shelves.size() - 1)) {
                    temp = stack.pop();
                    preLastStack.push(temp);
                    System.out.println((counter + 1) + " " + (shelves.size() - 1));
                } else {
                    temp = stack.pop();
                    lastStack.push(temp);
                    System.out.println((counter + 1) + " " + shelves.size());
                }
            }
            counter++;
        }

        // Clear the last stack
        while (!lastStack.isEmpty()) {
            temp = lastStack.pop();
            if (temp == shelves.size()) {
                preLastStack.push(temp);
                System.out.println(shelves.size() + " " + (shelves.size() - 1));
            } else {
                shelves.get(temp - 1).push(temp);
                System.out.println(shelves.size() + " " + temp);
            }
        }

        //Clear the pre last stack
        while (!preLastStack.isEmpty()) {
            temp = preLastStack.pop();
            if (temp == shelves.size() - 1) {
                prePreLastStack.push(temp);
                System.out.println((shelves.size() - 1) + " " + (shelves.size() - 2));
            } else {
                lastStack.push(temp);
                System.out.println((shelves.size() - 1) + " " + shelves.size());
            }
        }

        //Clear pre pre last stack
        while (!prePreLastStack.isEmpty() && prePreLastStack.peek() != (shelves.size() - 2)) {
            temp = prePreLastStack.pop();
            preLastStack.push(temp);
            System.out.println((shelves.size() - 2) + " " + (shelves.size() - 1));
        }
    }
}
