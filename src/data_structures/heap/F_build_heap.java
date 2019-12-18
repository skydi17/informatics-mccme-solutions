package data_structures.heap;

import java.util.Scanner;

public class F_build_heap {
    static long[] heap;
    static int size = 0;

    static int getParent(int i) {
        return (i-1)/2;
    }

    static void siftUp(int i) {
        while (size > 0 && heap[getParent(i)] < heap[i]) {
            swap(getParent(i), i);
            i = getParent(i);
        }
    }

    static void swap(int a, int b) {
        long temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        heap = new long[n];
        for (int i = 0; i < n; i++) {
            heap[size] = scanner.nextLong();
            siftUp(size);
            size++;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(heap[i] + " ");
        }
    }
}
