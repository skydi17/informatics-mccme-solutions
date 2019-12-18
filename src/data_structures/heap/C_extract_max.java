package data_structures.heap;

import java.util.Scanner;

public class C_extract_max {

    static long[] heap;
    static int size;
    static int n;

    static int getParent(int i) {
        return (i-1)/2;
    }

    static int getLeftChild(int i) {
        return 2*i + 1;
    }

    static int getRightChild(int i) {
        return 2*i + 2;
    }

    static void extractMax() {
        if (size == 0) {
            return;
        }

        long max = heap[0];
        heap[0] = heap[--size];
        long position = siftDown(0);
        System.out.println((position + 1) + " " + max);
    }

    static long siftDown(int i) {
        int maxIndex = i;
        if (getLeftChild(i) < size && heap[getLeftChild(i)] > heap[maxIndex]) {
            maxIndex = getLeftChild(i);
        }
        if (getRightChild(i) < size && heap[getRightChild(i)] > heap[maxIndex]) {
            maxIndex = getRightChild(i);
        }

        if (i != maxIndex) {
            swap(maxIndex, i);
            return siftDown(maxIndex);
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
        n = size;
        heap = new long[size];

        for (int i = 0; i < n; i++) {
            heap[i] = scanner.nextLong();
        }

        for (int i = 0; i < n - 1; i++) {
            extractMax();
        }
    }
}
