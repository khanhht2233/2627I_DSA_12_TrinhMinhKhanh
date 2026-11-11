import java.util.Scanner;

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

    public class bai6 {

        static int getHeight(Node root) {
            if (root == null) {
                return -1;
            }
            return root.ht;
        }

        static void updateHeight(Node root) {
            if (root != null) {
                root.ht = 1 + Math.max(getHeight(root.left), getHeight(root.right));
            }
        }

        static int getBalanceFactor(Node root) {
            if (root == null) {
                return 0;
            }
            return getHeight(root.left) - getHeight(root.right);
        }

        static Node rotateRight(Node y) {
            Node x = y.left;
            Node T2 = x.right;

            x.right = y;
            y.left = T2;

            updateHeight(y);
            updateHeight(x);

            return x;
        }

        static Node rotateLeft(Node x) {
            Node y = x.right;
            Node T2 = y.left;

            y.left = x;
            x.right = T2;

            updateHeight(x);
            updateHeight(y);

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

            updateHeight(root);

            int balance = getBalanceFactor(root);

            if (balance > 1 && val < root.left.val) {
                return rotateRight(root);
            }

            if (balance < -1 && val > root.right.val) {
                return rotateLeft(root);
            }

            if (balance > 1 && val > root.left.val) {
                root.left = rotateLeft(root.left);
                return rotateRight(root);
            }

            if (balance < -1 && val < root.right.val) {
                root.right = rotateRight(root.right);
                return rotateLeft(root);
            }

            return root;
        }

        static void inOrder(Node root) {
            if (root != null) {
                inOrder(root.left);
                System.out.print(root.val + "(BF=" + getBalanceFactor(root) + ") ");
                inOrder(root.right);
            }
        }

        static void preOrder(Node root) {
            if (root != null) {
                System.out.print(root.val + "(BF=" + getBalanceFactor(root) + ") ");
                preOrder(root.left);
                preOrder(root.right);
            }
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            if (!scanner.hasNextInt()) return;

            int n = scanner.nextInt();
            Node root = null;
            for (int i = 0; i < n; i++) {
                int val = scanner.nextInt();
                root = insert(root, val);
            }

            int valToInsert = scanner.nextInt();
            root = insert(root, valToInsert);

            inOrder(root);
            System.out.println();
            preOrder(root);

            scanner.close();
        }
    }

