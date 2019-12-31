package dataStructures.heap;

import java.util.Scanner;

public class IncreasePriority {

    static long[] heap;
    static int size;

    static int getParent(int i) {
        return (i-1)/2;
    }

    static int getLeftChild(int i) {
        return 2*i + 1;
    }

    static int getRightChild(int i) {
        return 2*i + 2;
    }

    static long increasePriority(int i, long x) {
        if (x == 0) {
            return i;
        }
        heap[i] = heap[i] + x;
        return siftUp(i);
    }

    static long siftUp(int i) {
        int parent;
        while (i > 0 && heap[getParent(i)] < heap[i]) {
            parent = getParent(i);
            swap(parent, i);
            i = parent;
        }
        return i;
    }

    static void swap(int a, int b) {
        long temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        size = scanner.nextInt();
        heap = new long[size];

        for (int i = 0; i < size; i++) {
            heap[i] = scanner.nextLong();
        }

        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            System.out.println(increasePriority(scanner.nextInt() - 1, scanner.nextLong()) + 1);
        }

        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
    }
}
