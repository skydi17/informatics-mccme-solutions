package data_structures.hash_tables;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class C_Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        LinkedList<Long> sums = new LinkedList();
        for (int i = 0; i < n; i++) {
            sums.add(scanner.nextLong());
        }

        sums.sort(Comparator.naturalOrder());

        double res = 0;
        while (sums.size() > 1) {
            sums.add(sums.remove(0) + sums.remove(0));
            res += sums.getLast()*0.05;
        }
        System.out.printf("%.2f %n", res);
    }
}
