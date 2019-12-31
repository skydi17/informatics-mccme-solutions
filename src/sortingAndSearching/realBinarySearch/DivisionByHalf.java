package sortingAndSearching.realBinarySearch;

import java.util.Scanner;

public class DivisionByHalf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        int n = scanner.nextInt();
        final double EPS = 0.000001;

        if (a == 0) {
            System.out.println(a);
            return;
        }

        double l = 1, r = a, mid;
        while (Math.abs(l - r) > EPS) {
            mid = (l + r)/2;
            if (Math.pow(mid, n) < a) {
                l = mid;
            } else {
                r = mid;
            }
        }

        System.out.println(r);
    }
}
