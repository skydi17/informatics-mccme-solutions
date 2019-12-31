package dataStructures.heap;

import java.util.Scanner;

public class DecreasePriority {

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

    static long decreasePriority(int i, long x) {
        if (x == 0) {
            return i;
        }
        heap[i] = heap[i] - x;
        return siftDown(i);
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
        heap = new long[size];

        for (int i = 0; i < size; i++) {
            heap[i] = scanner.nextLong();
        }

        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            System.out.println(decreasePriority(scanner.nextInt() - 1, scanner.nextLong()) + 1);
        }

        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
    }
}
