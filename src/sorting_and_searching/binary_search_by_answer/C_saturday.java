package sorting_and_searching.binary_search_by_answer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class C_saturday {

    public static int formCommands(int c, long mid, List<Long> heights, int r) {
        int start = 0, end = c - 1, count = 0;
        while (end < heights.size()) {

            if ((heights.get(end) - heights.get(start)) <= mid) {
                count++;
                start = end+1;
                end += c;
            } else {
                start++;
                end++;
            }
            if (count >= r) {
                return count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        List<Long> heights = new ArrayList(n);

        for (int i = 0; i < n; i++) {
            heights.add(scanner.nextLong());
        }

        heights.sort(Comparator.naturalOrder());

        long left = 0, right = heights.get(n - 1) - heights.get(0), mid;

        while (left < right) {
            mid = (left + right) / 2;
            if (formCommands(c, mid, heights, r) < r) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        System.out.println(right);
    }
}
