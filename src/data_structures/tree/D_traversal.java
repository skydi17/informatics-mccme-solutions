package data_structures.tree;

import java.util.Scanner;

public class D_traversal {

    static TreeNode root;

    static class TreeNode {
        public long value;
        public TreeNode rightChild;
        public TreeNode leftChild;

        TreeNode(long value) {
            this.value = value;
        }
    }

    public static void add(long value) {
        if (root == null) {
            root = new TreeNode(value);
        } else {
            add(root, value);
        }

    }

    public static void add(TreeNode node, long value) {
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

    public static void traversal(TreeNode node) {
        if (node != null) {
            traversal(node.leftChild);
            System.out.println(node.value);
            traversal(node.rightChild);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n != 0) {
            add(n);
            n = scanner.nextInt();
        }

        traversal(root);
    }
}
