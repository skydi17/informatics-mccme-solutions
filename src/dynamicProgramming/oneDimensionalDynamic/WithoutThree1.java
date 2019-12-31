package dynamicProgramming.oneDimensionalDynamic;

import java.util.Scanner;

public class WithoutThree1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 1) {
            System.out.println(2);
            return;
        } else if (n == 2) {
            System.out.println(4);
            return;
        } else if (n == 3) {
            System.out.println(7);
            return;
        }

        long[] arr = new long[n];
        arr[0] = 2;
        arr[1] = 4;
        arr[2] = 7;
        for (int i = 3; i < n; i++) {
            arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
        }
        System.out.println(arr[n-1]);
    }
}
