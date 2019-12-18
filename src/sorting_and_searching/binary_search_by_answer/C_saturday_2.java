package sorting_and_searching.binary_search_by_answer;

import java.util.Arrays;
import java.util.Scanner;

public class C_saturday_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        long[] heights = new long[n];

        for (int i = 0; i < n; i++) {
            heights[i] = scanner.nextLong();
        }

        Arrays.sort(heights);

        int left = 0, right = n - 1, mid;

        mid = (left+right)/r;
        while (mid > c) {
            mid = (left+right)/r;

            if ((heights[mid] - heights[left]) < (heights[right] - heights[mid + 1])) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        while ((right - left + 1) != c && right > 0 && left < n - 1) {
            if ((heights[right - 1] - heights[left]) > (heights[right] - heights[left + 1])) {
                right = right - 1;
            } else {
                left = left + 1;
            }
        }
        System.out.println(heights[right] - heights[left]);
    }
}
