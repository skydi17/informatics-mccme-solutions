package dataStructures.graphs;

import java.util.Scanner;

public class ImportantRoots {

    private static int[][] marked;

    private static void depthFirstTraversal(int s, int n, int[][] nodes, int c) {
        marked[s][0] = 1;
        marked[s][1] = c;
        for (int i = 0; i < n; i++) {
            if (marked[i][0] != 1 && nodes[i][s] == 1) {
                depthFirstTraversal(i, n, nodes, c);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] nodes = new int[n][n];
        marked = new int[n][2];
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;
            nodes[a][b] = 1;
            nodes[b][a] = 1;
        }

        int q = scanner.nextInt();
    }
}
