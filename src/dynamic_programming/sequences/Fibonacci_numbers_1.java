package dynamic_programming.sequences;

import java.util.Scanner;

public class Fibonacci_numbers_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 1 || n == 2) {
            System.out.println(1);
            return;
        }
        long a = 1, b = 1, temp;
        for (int i = 2; i < n; i++) {
            temp = b;
            b = b + a;
            a = temp;
        }
        System.out.println(b);
    }
}
