package dynamicProgramming.Two_dimensional_dynamic;

import java.util.Scanner;

public class TheCheapestWay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long[][] prices = new long[n][m];
        long[][] res = new long[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                prices[i][j] = scanner.nextInt();
            }
        }

        res[0][0] = prices[0][0];

        for(int j = 1; j < m; ++j) {
            res[0][j] = res[0][j - 1] + prices[0][j];
        }

        for (int i = 1; i < n; ++i) {
            res[i][0] = res[i - 1][0] + prices[i][0];
            for (int j = 1; j < m; ++j) {
                if (res[i][j - 1] < res[i - 1][j]) {
                    res[i][j] = prices[i][j] + res[i][j - 1];
                } else {
                    res[i][j] = prices[i][j] + res[i - 1][j];
                }
            }
        }
        System.out.println(res[n-1][m-1]);
    }
}
