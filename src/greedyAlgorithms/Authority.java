package greedyAlgorithms;

import java.util.Scanner;

public class Authority {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long a0 = scanner.nextLong();
        long[] a = new long[n];
        long[] b = new long[n];
        int[] marked = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
            b[i] = scanner.nextLong();
        }

        StringBuilder res = new StringBuilder();
        int count = 0;
        boolean hasChanges;
        while (true) {
            hasChanges = false;
            for (int i = 0; i < n; i++) {
                if (b[i] > 0 && a0 >= a[i] && marked[i] == 0) {
                    hasChanges = true;
                    a0 += b[i];
                    res.append(i + " ");
                    count++;
                    marked[i] = 1;
                }
            }
            if (!hasChanges) {
                break;
            }
        }

        System.out.println(count);
        System.out.println(res.toString());
    }
}
