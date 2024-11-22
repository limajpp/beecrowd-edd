package av3.tadarvore.questao1195;

import java.util.Scanner;
import java.io.IOException;

public class Main {
    private static int type;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int numCases = scanner.nextInt();

        for (int c = 1; c <= numCases; c++) {
            TreeNode root = null;
            int size = scanner.nextInt();

            for (int d = 0; d < size; d++) {
                int value = scanner.nextInt();
                root = insertNode(root, value);
            }

            System.out.println("Case " + c + ":");

            System.out.print("Pre.:");
            type = 1;
            printTree(root);
            System.out.println();

            System.out.print("In..:");
            type = 2;
            printTree(root);
            System.out.println();

            System.out.print("Post:");
            type = 3;
            printTree(root);
            System.out.println();
            System.out.println();
        }
        scanner.close();
    }

    private static class TreeNode {
        int value;
        TreeNode left, right;

        TreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private static TreeNode findParent(TreeNode root, int value) {
        if (root == null) {
            return null;
        }

        if (value <= root.value) {
            if (root.left == null) {
                return root;
            } else {
                return findParent(root.left, value);
            }
        } else {
            if (root.right == null) {
                return root;
            } else {
                return findParent(root.right, value);
            }
        }
    }

    private static TreeNode insertNode(TreeNode root, int value) {
        TreeNode newNode = new TreeNode(value);

        if (root == null) {
            return newNode;
        }

        TreeNode parent = findParent(root, value);
        if (value <= parent.value) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }

        return root;
    }

    private static void printTree(TreeNode root) {
        if (root != null) {
            if (type == 1) {
                System.out.print(" " + root.value);
                printTree(root.left);
                printTree(root.right);
            } else if (type == 2) {
                printTree(root.left);
                System.out.print(" " + root.value);
                printTree(root.right);
            } else if (type == 3) {
                printTree(root.left);
                printTree(root.right);
                System.out.print(" " + root.value);
            }
        }
    }
}
