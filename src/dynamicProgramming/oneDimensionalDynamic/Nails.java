package dynamicProgramming.oneDimensionalDynamic;

import java.util.Arrays;
import java.util.Scanner;

public class Nails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        long sum = 0;
        for (int i = 0; i < n; i=i+2) {
            if (n == (i+1)) {
                sum += arr[i] - arr[i-1];
                continue;
            }
            sum += arr[i+1] - arr[i];
        }
        System.out.println(sum);
    }
}
