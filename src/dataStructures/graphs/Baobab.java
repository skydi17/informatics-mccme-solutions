package dataStructures.graphs;

import java.util.Scanner;

public class Baobab {

    private static int[] marked;

    private static boolean isTree(int s, int[][] nodes, int n) {
        if (depthFirstTraversal(s, nodes, n) == false) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            if (marked[i] == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean depthFirstTraversal(int s, int[][] nodes, int n) {
        marked[s] = 1;
        boolean hasParent = false;
        for (int i = 0; i < n; i++) {
            if (nodes[i][s] == 1) {
                if (marked[i] == 0) {
                    if (depthFirstTraversal(i, nodes, n) == false) {
                        return false;
                    }
                } else {
                    if (!hasParent) {
                        hasParent = true;
                    } else {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        marked = new int[n];

        int[][] nodes = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nodes[i][j] = scanner.nextInt();
            }
        }

        if (n==1) {
            System.out.println("YES");
        } else {
            System.out.println(isTree(0, nodes, n) ? "YES" : "NO");
        }
    }
}
