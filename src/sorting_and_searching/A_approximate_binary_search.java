package sorting_and_searching;

import java.util.Scanner;

public class A_approximate_binary_search {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] arrN = new int[n];
        int[] arrK = new int[k];

        for (int i = 0; i < n; i++) {
            arrN[i] = scanner.nextInt();
        }

        for (int i = 0; i < k; i++) {
            arrK[i] = scanner.nextInt();
        }

        int l, r, mid;

        for (int i = 0; i < k; i++) {
            l = 0; r = n - 1;
            while (l < r) {
                mid = (l + r)/2;
                if (arrK[i] > arrN[mid]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }

            if (r != 0 && (Math.abs(arrN[r] - arrK[i])) >= Math.abs(arrN[r-1] - arrK[i])) {
                r = r - 1;
            }

            System.out.println(arrN[r]);
        }
    }
}
