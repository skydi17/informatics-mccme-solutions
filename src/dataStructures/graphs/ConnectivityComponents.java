package dataStructures.graphs;

import java.util.Scanner;

public class ConnectivityComponents {

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
        new Thread(null, new Runnable() {
            public void run() {
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

                int c = 0;
                depthFirstTraversal(0, n, nodes, c);
                c++;
                for (int i = 0; i < n; i++) {
                    if (marked[i][0] == 0) {
                        depthFirstTraversal(i, n, nodes, c);
                        c++;
                    }
                }

                System.out.println(c);
                c--;
                while (c >= 0) {
                    //StringBuilder res = new StringBuilder();
                    int count = 0;
                    System.out.println(count);
                    for (int i = 0; i < n; i++) {
                        if (marked[i][1] == c) {
                            //res.append((i + 1) + " ");
                            System.out.println((i + 1) + " ");
                            count++;
                        }
                    }
                    //System.out.println(count + "\n" + res.toString());
                    c--;
                }
            }

        }, "1", 1 << 23).start();
    }
}
