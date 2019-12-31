package dataStructures.tree;

import java.util.Scanner;

public class TreeHeight {

    static TreeNode root;

    static class TreeNode {
        public int value;
        public TreeNode rightChild;
        public TreeNode leftChild;

        TreeNode(int value) {
            this.value = value;
        }
    }

    public static void add(int value) {
        if (root == null) {
            root = new TreeNode(value);
        } else {
            add(root, value);
        }

    }

    public static void add(TreeNode node, int value) {
        if (node.value == value) {
            return;
        }

        if (node.value < value){
            if (node.rightChild == null) {
                node.rightChild = new TreeNode(value);
            } else {
                add(node.rightChild, value);
            }
        } else {
            if (node.leftChild == null) {
                node.leftChild = new TreeNode(value);
            } else {
                add(node.leftChild, value);
            }
        }
    }

    public static int height(TreeNode node) {
        int h1, h2, hMax = 0;
        if (node != null) {
            h1 = height(node.leftChild);
            h2 = height(node.rightChild);
            hMax = Math.max(h1, h2) + 1;
        }
        return hMax;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n != 0) {
            add(n);
            n = scanner.nextInt();
        }

        System.out.println(height(root));
    }
}
