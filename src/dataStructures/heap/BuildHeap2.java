package dataStructures.heap;

import java.util.Scanner;

public class BuildHeap2 {
    static long[] heap;
    static int size = 0;

    static int getLeftChild(int i) {
        return i*2 + 1;
    }

    static int getRightChild(int i) {
        return i*2 + 2;
    }

    static void buildHeap(int s) {
        int startIdx = (s / 2) - 1;
        for (int i = startIdx; i >= 0; i--) {
            siftDown(i);
        }
    }

    static void siftDown(int i) {
        int maxIndex = i;
        if (getLeftChild(i) < size && heap[getLeftChild(i)] > heap[maxIndex]) {
            maxIndex = getLeftChild(i);
        }
        if (getRightChild(i) < size && heap[getRightChild(i)] > heap[maxIndex]) {
            maxIndex = getRightChild(i);
        }
        if (maxIndex != i) {
            swap(i, maxIndex);
            siftDown(maxIndex);
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
        size = n;
        for (int i = 0; i < n; i++) {
            heap[i] = scanner.nextLong();
        }
        buildHeap(size);
        for (int i = 0; i < n; i++) {
            System.out.print(heap[i] + " ");
        }
    }
}
