package Daily;

import java.util.*;

public class Tree {
    public TreeNode root;

    // Constructor to initialize the tree from an array
    public Tree(Integer[] values) {
        this.root = createTree(values);
    }

    public Tree() {
    }

    // Helper method to create the tree from an array
    private TreeNode createTree(Integer[] values) {
        if (values == null || values.length == 0) {
            return null;
        }

        // Create the root node
        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1; // Start from the second element
        while (i < values.length) {
            TreeNode current = queue.poll();

            // Add left child if available
            if (i < values.length && values[i] != null) {
                current.left = new TreeNode(values[i]);
                queue.add(current.left);
            }
            i++;

            // Add right child if available
            if (i < values.length && values[i] != null) {
                current.right = new TreeNode(values[i]);
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

    // Utility to print the tree in level order (for debugging)
    public void printTree() {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print((current == null ? "null" : current.val) + " ");
            if (current != null) {
                queue.add(current.left);
                queue.add(current.right);
            }
        }
        System.out.println();
    }

    // Print tree in level order, each level on a new line
    public void printTreeByLevel() {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Number of nodes in the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                if (current != null) {
                    System.out.print(current.val + " ");
                    queue.add(current.left);
                    queue.add(current.right);
                } else {
                    System.out.print("null ");
                }
            }
            System.out.println(); // Move to the next line after printing one level
        }
    }
}
