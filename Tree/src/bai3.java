import java.io.*;
import java.util.*;

class Node {
    int val;
    int ht;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
        this.ht = 0;
        this.left = null;
        this.right = null;
    }
}

public class bai3 {

    static int height(Node n) {
        if (n == null) return -1;
        return n.ht;
    }

    static int getBalance(Node n) {
        if (n == null) return 0;
        return height(n.left) - height(n.right);
    }

    static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.ht = Math.max(height(y.left), height(y.right)) + 1;
        x.ht = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.ht = Math.max(height(x.left), height(x.right)) + 1;
        y.ht = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    static Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        } else {
            return root;
        }

        root.ht = Math.max(height(root.left), height(root.right)) + 1;

        int balance = getBalance(root);

        if (balance > 1 && val < root.left.val) {
            return rightRotate(root);
        }

        if (balance < -1 && val > root.right.val) {
            return leftRotate(root);
        }

        if (balance > 1 && val > root.left.val) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        if (balance < -1 && val < root.right.val) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.val + "(BF=" + getBalance(root) + ") ");
            inOrder(root.right);
        }
    }

    static void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.val + "(BF=" + getBalance(root) + ") ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Node root = null;

        for(int i = 0; i < n; i++) {
            int val = scan.nextInt();
            root = insert(root, val);
        }

        int valToInsert = scan.nextInt();
        root = insert(root, valToInsert);
        scan.close();

        inOrder(root);
        System.out.println();

        preOrder(root);
        System.out.println();
    }
}