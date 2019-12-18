package sorting_and_searching.binary_search_by_answer;

import java.util.Scanner;

public class B_tortoise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int v = scanner.nextInt();
        int d = scanner.nextInt();
        int n = scanner.nextInt();
        int[] arrX = new int[n];
        int[] arrT = new int[n];
        for (int i = 0; i < n; i++){
            arrX[i] = scanner.nextInt();
            String[] time = scanner.nextLine().substring(1).split(":");
            arrT[i] = Integer.valueOf(time[0])*60+Integer.valueOf(time[1]);
        }
        int l = 0, r = Integer.MAX_VALUE, mid, res, t = 0, current_T, current_X;

        while (l < r) {
            mid = (l+r)/2;
            res = 0;
            current_T = 0;
            while (current_T < mid && t < n - 1) {
                current_T = arrX[t]/v;
                current_T = current_T + d;
                if (current_T < arrT[t]) {
                    current_T = current_T + (arrT[t] - current_T);
                }
                t++;
            }
            if (res < arrX[n-1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        System.out.println(r);
        //System.out.println(Math.round(r/60) + ":" + r % 60);
    }
}
