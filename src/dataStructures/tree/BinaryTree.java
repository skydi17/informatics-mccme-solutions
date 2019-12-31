package dataStructures.tree;

public class BinaryTree {
    TreeNode root;
    int height;

    static class TreeNode {
        public int value;
        public TreeNode rightChild;
        public TreeNode leftChild;

        TreeNode(int value) {
            this.value = value;
        }
    }

    public void add(int value) {
        if (root == null) {
            root = new TreeNode(value);
        } else {
            add(root, value);
        }

    }

    public void add(TreeNode node, int value) {
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

    private void traversal(TreeNode node, int height) {
        if (node != null) {
            height++;
            traversal(node.leftChild, height);
            traversal(node.rightChild, height);
        } else {
            if (height > this.height) {
                this.height = height;
            }
        }
    }
}
