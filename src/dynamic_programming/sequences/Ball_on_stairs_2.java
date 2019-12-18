package dynamic_programming.sequences;

import java.util.Scanner;

public class Ball_on_stairs_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (n == 0) {
            System.out.println(0);
            return;
        } else if (n == 1) {
            System.out.println(1);
            return;
        } else if (n == 2) {
            System.out.println(2);
            return;
        } else if (n == 3){
            System.out.println(4);
            return;
        }
        int[] res = new int[n];
        res[0] = 1;
        res[1] = 2;
        res[2] = 4;
        for (int i = 3; i < n; i++) {
            res[i] = res[i-1] + res[i-2] + res[i-3];
        }
        System.out.println(res[n-1]);
    }
}
