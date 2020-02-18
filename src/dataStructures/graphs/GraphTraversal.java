package dataStructures.graphs;

import java.util.Scanner;

public class GraphTraversal {
    private static int depthFirstTraversal(int s, int[][] nodes, int n, int[] marked) {
        marked[s] = 1;
        int count = 1;
        for (int i = 0; i < n; i++) {
            if (nodes[i][s] == 1 && marked[i] == 0) {
                count += depthFirstTraversal(i, nodes, n, marked);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();

        int[][] nodes = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nodes[i][j] = scanner.nextInt();
            }
        }

        System.out.println(depthFirstTraversal(s-1, nodes, n, new int[n]));
    }
}
