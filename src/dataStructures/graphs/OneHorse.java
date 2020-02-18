package dataStructures.graphs;

import java.util.LinkedList;
import java.util.Scanner;

public class OneHorse {

    private static String breadthFirstSearch(int n, int x1, int y1, int x2, int y2) {
        LinkedList<Integer> queue = new LinkedList<>();
        String[][] marked = new String[n][n];
        int[] nX = new int[8];
        nX[0] = -1;
        nX[1] = 1;
        nX[2] = 2;
        nX[3] = 2;
        nX[4] = 1;
        nX[5] = -1;
        nX[6] = -2;
        nX[7] = -2;
        int[] nY = new int[8];
        nY[0] = 2;
        nY[1] = 2;
        nY[2] = 1;
        nY[3] = -1;
        nY[4] = -2;
        nY[5] = -2;
        nY[6] = -1;
        nY[7] = 1;

        marked[x1][y1] = (x1 + 1) + " " + (y1 + 1);
        queue.add(x1);
        queue.add(y1);
        while (!queue.isEmpty()) {
            int currX = queue.removeFirst();
            int currY = queue.removeFirst();
            for (int i = 0; i < 8; i++) {
                int nextX = currX + nX[i];
                int nextY = currY + nY[i];
                if (marked[nextX][nextY] == null && nextX >= 0 && nextX < n && nextY >= 0 && nextY < n) {
                    marked[nextX][nextY] = "";
                    if (nextX == x2 && nextY == y2) {
                        return marked[nextX][nextY] + " " + (nextX + 1) + " " + (nextY + 1);
                    }
                    marked[nextX][nextY] = marked[currX][currY] + " " + (nextX + 1) + " " + (nextY + 1);
                    queue.addLast(currX);
                    queue.addLast(currY);
                }
            }

        }
        return "-1";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        String res = breadthFirstSearch(n, x1-1, y1-1, x2-1, y2-1);
        System.out.println(res.split("\n").length - 1);
        System.out.println(res);
    }
}
