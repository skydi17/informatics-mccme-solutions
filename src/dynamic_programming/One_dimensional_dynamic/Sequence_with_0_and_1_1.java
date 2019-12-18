package dynamic_programming.One_dimensional_dynamic;

import java.util.Scanner;

public class Sequence_with_0_and_1_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 1) {
            System.out.println(2);
            return;
        } else if (n == 2) {
            System.out.println(3);
            return;
        }

        int[] arr = new int[n];
        arr[0] = 2;
        arr[1] = 4;
        for (int i = 2; i < n; i++) {
            arr[i] =
        }
        System.out.println(arr[n-1]);
    }
}
