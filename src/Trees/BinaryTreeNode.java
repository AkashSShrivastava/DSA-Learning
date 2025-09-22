package Trees;

import java.util.Queue;

public class BinaryTreeNode {

    int data;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(int data) {
        this.data = data;
    }

    public static void main(String[] args) {
        BinaryTreeNode tree = new BinaryTreeNode(1);
        tree.left = new BinaryTreeNode(2);
        tree.right = new BinaryTreeNode(3);
        tree.left.left = new BinaryTreeNode(4);
        tree.left.right = new BinaryTreeNode(5);
        tree.right.left = new BinaryTreeNode(6);
        tree.right.right = new BinaryTreeNode(7);
        System.out.print("\nPREORDER TRAVERSAL: ");
        tree.printPreorder(tree);
        System.out.print("\nINORDER TRAVERSAL: ");
        tree.printInorder(tree);
        System.out.print("\nPOSTORDER TRAVERSAL: ");
        tree.printPostorder(tree);
        System.out.print("\nLEVELORDER TRAVERSAL: ");
        tree.printLevelOrder(tree);
        System.out.println("\nMAX ELEMENT IN TREE: "+ tree.maxInBinaryTree(tree));
    }

    public int maxInBinaryTree(BinaryTreeNode root) {
        int maxValue = Integer.MIN_VALUE;
        if (root != null) {
            int leftMax = maxInBinaryTree(root.left);
            int rightMax = maxInBinaryTree(root.right);
            if (leftMax > rightMax)
                maxValue = leftMax;
            else
                maxValue = rightMax;
            if (root.data > maxValue)
                maxValue = root.data;
        }
        return maxValue;
    }

    public void printInorder(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        printInorder(root.left);
        System.out.print(root.data+" ");
        printInorder(root.right);
    }

    public void printPostorder(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        printPostorder(root.left);
        printPostorder(root.right);
        System.out.print(root.data+ " ");
    }

    public void printPreorder(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data+ " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }


    /**
     * 1
     * 2             3
     * 4   5        6      7
     *
     * @param root
     */
    public void printLevelOrder(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new java.util.LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode binaryTree = queue.poll();
            System.out.print(binaryTree.data + " ");

            if (binaryTree.left != null)
                queue.add(binaryTree.left);

            if (binaryTree.right != null)
                queue.add(binaryTree.right);
        }
    }
}
