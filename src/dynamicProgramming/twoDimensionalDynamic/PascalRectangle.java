package dynamicProgramming.Two_dimensional_dynamic;

import java.util.Scanner;

public class PascalRectangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (n == 0) {
            return;
        }

        long[][] arr = new long[n+1][n+1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (j== (i-1) || (j== 0)) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
