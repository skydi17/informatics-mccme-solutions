package dataStructures.heap;

import java.util.Scanner;

public class PriorityQueueWithDeletion {

    static long[] heap;
    static int size = 0;
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
            System.out.println(-1);
            return;
        }
        long max = heap[0];
        heap[0] = heap[--size];
        if (size == 0) {
            System.out.println("0 " + max);
        } else {
            long position = siftDown(0);
            System.out.println((position + 1) + " " + max);
        }
    }

    static void delete(int value) {
        if (size == 0 || value == 0 || value  > size) {
            System.out.println(-1);
            return;
        }

        System.out.println(heap[value - 1]);
        if (value == size) {
            size--;
            return;
        }
        heap[value - 1] = heap[size - 1];
        size--;
        if (heap[getParent(value - 1)] < heap[value - 1]) {
            siftUp(value - 1);
        } else {
            siftDown(value - 1);
        }
    }

    static void add(long value) {
        if (n < size + 1) {
            System.out.println(-1);
            return;
        }

        heap[size++] = value;
        System.out.println(siftUp(size - 1) + 1);
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

        n = scanner.nextInt();
        int m = scanner.nextInt();
        heap = new long[n];

        for (int i = 0; i < m; i++) {
            switch (scanner.nextInt()) {
                case 1:
                    extractMax();
                    break;
                case 2:
                    add(scanner.nextLong());
                    break;
                case 3:
                    delete(scanner.nextInt());
                    break;
            }
        }

        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
    }
}
