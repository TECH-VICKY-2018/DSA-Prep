package tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {

    // Definition for a binary tree node.
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    // Method to perform level-order traversal
    public static void levelOrder(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> Q = new ArrayDeque<>();
        Q.add(root);

        while (!Q.isEmpty()) {
            Node curr = Q.poll();
            System.out.print(curr.data + " ");

            if (curr.left != null) {
                Q.add(curr.left);
            }

            if (curr.right != null) {
                Q.add(curr.right);
            }
        }
        System.out.println();
    }

    // Method to perform pre-order traversal
    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // Method to perform in-order traversal
    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    // Method to perform post-order traversal
    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    // Helper method to create a sample binary tree
    public static Node createTree() {
        // Creating the following binary tree
        //       1
        //      / \
        //     2   3
        //    / \   \
        //   4   5   6
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        return root;
    }

    public static void main(String[] args) {
        Node root = createTree();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter the type of traversal you want to perform:");
            System.out.println("1. Level Order");
            System.out.println("2. Pre Order");
            System.out.println("3. In Order");
            System.out.println("4. Post Order");
            System.out.println("5. Stop");
            int choice = scanner.nextInt();

            if (choice == 5) {
                break;
            }

            switch (choice) {
                case 1:
                    System.out.println("Level order traversal of binary tree:");
                    levelOrder(root);
                    break;
                case 2:
                    System.out.println("Pre-order traversal of binary tree:");
                    preOrder(root);
                    System.out.println();
                    break;
                case 3:
                    System.out.println("In-order traversal of binary tree:");
                    inOrder(root);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Post-order traversal of binary tree:");
                    postOrder(root);
                    System.out.println();
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }

        scanner.close();
    }
}
