package dataStructures.hashTables;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Long> sums = new ArrayList();
        for (int i = 0; i < n; i++) {
            sums.add(scanner.nextLong());
        }

        sums.sort(Comparator.naturalOrder());

        double res = 0;
        while (sums.size() > 1) {
            sums.add(sums.remove(0) + sums.remove(0));
            res += sums.get(sums.size()-1)*0.05;
            sums.sort(Comparator.naturalOrder());
        }
        System.out.printf("%.2f %n", res);
    }
}
