package dynamic_programming.sequences;

import java.util.Scanner;

public class last_fibonacci_number_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 1) {
            System.out.println(1);
            return;
        }
        long a = 1, b = 1, temp;
        for (int i = 2; i <= n; i++) {
            temp = b;
            b = ((b + a) > 9) ? ((b + a) % 10) : (b+a);
            a = temp;
        }
        System.out.println(b);
    }
}
