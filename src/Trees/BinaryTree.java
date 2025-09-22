package Trees;

import java.util.*;

public class BinaryTree {
    BinaryTree left;
    BinaryTree right;
    int data;

    public BinaryTree(int data) {
        this.left = null;
        this.right = null;
        this.data = data;
    }


    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(2);
        tree.right = new BinaryTree(3);

        tree.left.left = new BinaryTree(4);
        tree.left.right = new BinaryTree(5);
        tree.right.left = new BinaryTree(6);
        tree.right.right = new BinaryTree(7);

        tree.left.left.left = new BinaryTree(8);
        tree.left.left.right = new BinaryTree(9);

        //tree.displayTrees(tree);
        tree.preOrderTraversal(tree);
        System.out.println("->preOrderTraversal.");
        tree.inOrderTraversal(tree);
        System.out.println("->inOrderTraversal.");
        tree.postOrderTraversal(tree);
        System.out.println("->postOrderTraversal.");
        tree.levelOrderTraversal(tree);
        System.out.println("->levelOrderTraversal.");

        System.out.println("Maximum element is:: "+maximumElement(tree, tree.data));
        System.out.println("Maximum element without recursion is:: "+maximumElementWithoutRecursion(tree, tree.data));

        tree.sizeOfBinaryTree(tree);
        System.out.println("Height of binary tree is:: "+tree.heightOfBinaryTree(tree));
        System.out.println("Height of binary tree using recursion is:: "+tree.heightOfBinaryTreeRecursive(tree));
    }

    private int minimumHeightOfBinaryTree(BinaryTree root) {
        if(root==null) {
            return 0;
        }
        return 1+Math.min(minimumHeightOfBinaryTree(root.left), minimumHeightOfBinaryTree(root.right));
    }

    private int heightOfBinaryTreeRecursive(BinaryTree root) {
        if(root==null) {
            return 0;
        }
        return 1 + Math.max(heightOfBinaryTreeRecursive(root.left), heightOfBinaryTreeRecursive(root.right));
    }

    private int heightOfBinaryTree(BinaryTree root) {
        int height = 0;
        while(root!=null) {
            height++;
            if(root.left!=null) {
                root = root.left;
            } else if(root.right!=null) {
                root = root.right;
            } else {
                return height;
            }
        }
        return height;
    }

    private static int maximumElementWithoutRecursion(BinaryTree tree, int max) {
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(tree);

        while(!queue.isEmpty()) {
            BinaryTree current = queue.poll();
            if(current.data>max) {
                max = current.data;
            }
            if(current.left!=null) {
                queue.add(current.left);
            }
            if(current.right!=null) {
                queue.add(current.right);
            }
        }

        return max;
    }

    private static int maximumElement(BinaryTree root, int max) {
        if(root!=null) {
            max = Math.max(root.data, max);
            max = maximumElement(root.left, max);
            max = maximumElement(root.right, max);
        }
        return max;
    }

    public void preOrderTraversal(BinaryTree root) {
        if(root!=null) {
             System.out.print(root.data + " ");
             preOrderTraversal(root.left);
             preOrderTraversal(root.right);
         }
    }

    public void inOrderTraversal(BinaryTree root) {
        if(root!=null) {

            inOrderTraversal(root.left);
            System.out.print(root.data + " ");
            inOrderTraversal(root.right);
        }
    }

    public void postOrderTraversal(BinaryTree root) {
        if(root!=null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.data + " ");
        }
    }

    /**
     *                1
     *            2         3
     *         4     5    6     7
     *      8     9
     * @param root
     */
    public void levelOrderTraversal(BinaryTree root) {
        if (root == null) return;

        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTree current = queue.poll(); // Remove front
            System.out.print(current.data + " ");

            // Add children to queue
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }


    public void sizeOfBinaryTree(BinaryTree root) {
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(root);

        int size = 0;

        while(!queue.isEmpty()) {
            BinaryTree current = queue.poll();
            size++;
            if(current.left!=null) {
                queue.add(current.left);
            }
            if(current.right!=null) {
                queue.add(current.right);
            }
        }

        System.out.println("Size of binary tree is:: "+size);
    }
}
