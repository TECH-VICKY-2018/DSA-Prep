package tree;

import java.util.*;

public class BinaryTree {

    // Method to perform level-order traversal
    public static void levelOrder(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> Q = new ArrayDeque<>();
        Q.add(root);

        while (!Q.isEmpty()) {
            Node curr = Q.poll();
            System.out.print(curr.val + " ");

            if (curr.left != null) {
                Q.add(curr.left);
            }

            if (curr.right != null) {
                Q.add(curr.right);
            }
        }
        System.out.println();
    }

    // Method to perform enhanced level-order traversal
    public static ArrayList<ArrayList<Integer>> enhancedLevelOrder(Node root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<Node> Q = new ArrayDeque<>();
        Q.add(root);

        while (!Q.isEmpty()) {
            int levelSize = Q.size();
            ArrayList<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                Node curr = Q.poll();
                currentLevel.add(curr.val);

                if (curr.left != null) {
                    Q.add(curr.left);
                }

                if (curr.right != null) {
                    Q.add(curr.right);
                }
            }

            result.add(currentLevel);
        }

        return result;
    }

    // Method to perform pre-order traversal
    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // Method to perform in-order traversal
    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    // Method to perform post-order traversal
    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
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

        ZigZag zigZag = new ZigZag();

        while (true) {
            System.out.println("Enter the type of traversal you want to perform:");
            System.out.println("1. Level Order");
            System.out.println("2. Pre Order");
            System.out.println("3. In Order");
            System.out.println("4. Post Order");
            System.out.println("5. Enhanced Level Order");
            System.out.println("6. Zig Zag Level Order");
            System.out.println("7. Stop");
            int choice = scanner.nextInt();

            if (choice == 7) {
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
                case 5:
                    System.out.println("Enhanced level order traversal of binary tree:");
                    ArrayList<ArrayList<Integer>> levels = enhancedLevelOrder(root);
                    for (ArrayList<Integer> level : levels) {
                        System.out.print(level+" ");
                    }
                    break;
                case 6:
                    System.out.println("Zig Zag traversal of binary tree:");
                    List<List<Integer>> zigZagLvl = zigZag.zigzagLevelOrder(root);
                    for (List<Integer> level : zigZagLvl) {
                        System.out.print(level+" ");
                    }
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }

        scanner.close();
    }
}
