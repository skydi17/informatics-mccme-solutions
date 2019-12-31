package dynamicProgramming.oneDimensionalDynamic;

import java.math.BigInteger;
import java.util.Scanner;

public class SequenceWith0and1 {
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

        BigInteger[] arr = new BigInteger[n];
        arr[0] = BigInteger.valueOf(2);
        arr[1] = BigInteger.valueOf(3);
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i-1].add(arr[i-2]);
        }
        System.out.println(arr[n-1]);
    }
}
