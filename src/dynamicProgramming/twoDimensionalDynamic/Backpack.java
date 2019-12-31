package dynamicProgramming.twoDimensionalDynamic;

import java.util.Scanner;

public class Backpack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] weights = new int[n];
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }

        long[][] res = new long[n+1][m+1];
        for (int i = 0; i <= m; ++i) {
            res[0][i] = 0;
        }
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                res[i][j] = res[i-1][j];
                if (j>=weights[i-1] && (res[i-1][j-weights[i-1]]+prices[i-1] > res[i][j])) {
                    res[i][j] = res[i-1][j-weights[i-1]]+prices[i-1];
                }
            }
        }

        System.out.println(res[n][m]);
    }
}
