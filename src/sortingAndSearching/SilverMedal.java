package sortingAndSearching;

import java.util.Scanner;

public class SilverMedal {

    public static void main(String[] args) {
        int preMax, max;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        preMax = scanner.nextInt();
        max = scanner.nextInt();
        if (preMax > max) {
            int temp = preMax;
            preMax = max;
            max = temp;
        }

        for (int i = 0; i < n - 2; i++) {
            int current = scanner.nextInt();
            if (max == current) {
                continue;
            } else if (max < current) {
                preMax = max;
                max = current;
            } else if (preMax < current) {
                preMax = current;
            }
        }

        System.out.println(preMax);
        scanner.close();
    }
}
