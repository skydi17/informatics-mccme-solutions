package sortingAndSearching;

import java.util.Scanner;

public class RightAndLeftBinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arrN = new int[n];
        int[] arrM = new int[m];

        for (int i = 0; i < n; i++) {
            arrN[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            arrM[i] = scanner.nextInt();
        }

        for (int i = 0; i < m; i++) {
            int r = n - 1, l = 0;

            while(l < r) {
                int mid = (l+r)/2;
                if (arrM[i] > arrN[mid]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }

            if (arrM[i] == arrN[r]) {
                l = r;
                while ((r < n - 1) && arrM[i] == arrN[r + 1]) {
                    r++;
                }
                System.out.println((l + 1) + " " + (r + 1));
            } else {
                System.out.println(0);
            }
        }
    }
}
