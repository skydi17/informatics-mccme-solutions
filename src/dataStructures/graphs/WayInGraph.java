package dataStructures.graphs;

import java.util.LinkedList;
import java.util.Scanner;

public class WayInGraph {

    private static String breadthFirstSearch(int n1, int n2, int n, int[][] nodes) {
        LinkedList<Integer> queue = new LinkedList();
        String[] marked = new String[n];
        marked[n1] = String.valueOf(n1 + 1);
        queue.add(n1);
        while (!queue.isEmpty()) {
            int node = queue.removeFirst();
            for (int i = 0; i < n; i++) {
                if (marked[i] == null && nodes[node][i] == 1) {
                    marked[i] = "";
                    if (i == n2) {
                        return marked[node] + " " + (i + 1);
                    }
                    queue.addLast(i);
                    marked[i] = marked[node] + " " + (i + 1);
                }
            }
        }
        return "-1";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] nodes = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nodes[i][j] = scanner.nextInt();
            }
        }
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();

        if (n1 == n2) {
            System.out.println(0);
            return;
        }

        String res = breadthFirstSearch(n1-1, n2-1, n, nodes);
        if ("-1".equals(res)) {
            System.out.println(res);
        } else {
            System.out.println(res.split(" ").length - 1);
            System.out.println(res);
        }
    }
}
