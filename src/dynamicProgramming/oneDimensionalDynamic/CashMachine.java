package dynamicProgramming.oneDimensionalDynamic;

import java.util.Arrays;
import java.util.Scanner;

public class CashMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLong();
        }
        Arrays.sort(arr);
        int s = scanner.nextInt();

        long[] res = new long[s+1];
        res[0] = 0;
        for (int i = 1; i <= s; ++i) {
            res[i] = Integer.MAX_VALUE;
            for (int j = 0; j < n; ++j) {
                if (i >= arr[j] && ((res[(int)(i-arr[j])]+1)<res[i])) {
                    res[i] = res[(int)(i-arr[j])] + 1;
                }
            }
        }

        String result = "";
        if (res[s] == Integer.MAX_VALUE) {
            System.out.println("No solution");
        } else {
            while (s>0) {
                for (int i = 0; i < n; ++i) {
                    if (res[(int)(s-arr[i])] == (res[s] - 1)) {
                        //System.out.print(arr[i] + " ");
                        result = arr[i] + " " + result;
                        s-=arr[i];
                        break;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
