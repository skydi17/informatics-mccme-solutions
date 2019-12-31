package dataStructures.heap;

import java.util.Scanner;

public class HeapSort {
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

    static long extractMax() {
        if (size == 0) {
            return - 1;
        }

        long max = heap[0];
        heap[0] = heap[--size];
        siftDown(0);
        printHeap();
        return max;
    }

    static void printHeap() {
        boolean wereInLoop = false;
        for (int i = 0; i < size; i++) {
            wereInLoop = true;
            System.out.print(heap[i] + " ");
        }
        if (wereInLoop) {
            System.out.println();
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
        printHeap();
        String sortedArray = "";
        for (int i = 0; i < n - 1; i++) {
            sortedArray = extractMax() + " " + sortedArray;
        }
        System.out.println(extractMax() + " " + sortedArray);
    }
}
