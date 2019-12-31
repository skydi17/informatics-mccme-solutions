package dynamicProgramming.Two_dimensional_dynamic;

import java.util.Scanner;

public class BinomialCoefficient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long[][] arr = new long[n][m];
        for (int i = 0; i < n; i++) {
            arr[i][0] = 1;
        }
        for (int i = 0; i < m; i++) {
            arr[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
            }
        }
        System.out.println(arr[n-1][m-1]);
    }
}
