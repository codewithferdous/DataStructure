 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bstdemo;

public class BSTDemo
{
    public static void main(String[] args)
    {
        BST tree = new BST();
        tree.insertRoot(5);
        tree.insert(7);
        tree.insert(8);
        tree.insert(7);
        tree.insert(6);
        System.out.print("Pre-order traversal: ");
        tree.traverse();
        tree.delete(7);
      System.out.println(tree.search(5));
        tree.traverse();
 
    }

}


class BST {

    Node root;

    class Node {

        Node left;
        int data;
        Node right;

        public Node(int data) {
            this.data = data;
        }

    }

    public void insertRoot(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            System.out.println("Root already present");
        }
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node n, int value) {
        if (n == null) {
            return new Node(value);
        } else if (value < n.data) {
            n.left = insert(n.left, value);
        } else {
            n.right = insert(n.right, value);
        }
        return balance(n);
    }

    public void traverse() {
        preOrder(root);
    }

    public void preOrder(Node n) {
        if (n == null) {
            return;
        }
        System.out.print(n.data + " ");
        preOrder(n.left);
        preOrder(n.right);
    }

    private Node search(Node n, int key) {
        if (n == null || n.data == key) {
            return n;
        }

        if (key < n.data) {
            return search(n.left, key);
        }

        return search(n.right, key);
    }

    public boolean search(int key) {
        Node temp = search(root, key);
        return temp != null;
    }

    public Node delete(Node n, int key) {
        if (n == null) {
            System.out.println("Key is not present");
            return null;
        }

        if (key < n.data) {
            n.left = delete(n.left, key);
        } else if (key > n.data) {
            n.right = delete(n.right, key);
        } else {
            if (n.left == null) {
                return n.right;
            } else if (n.right == null) {
                return n.left;
            }

            Node suc = findSuccessor(n.right);

            n.data = suc.data;

            n.right = delete(n.right, suc.data);
        }

        return balance(n);
    }

    public Node balance(Node n) {
        int balanceFactor = balanceFactor(n);
        if (balanceFactor > 1) {
            if (balanceFactor(n.left) >= 0) {
                n = rotateRight(n);
            } else {
                n.left = rotateLeft(n.left);
                n = rotateRight(n);
            }
        } else if (balanceFactor < -1) {
            if (balanceFactor(n.right) <= 0) {
                n = rotateLeft(n);
            } else {
                n.right = rotateRight(n.  right);
                n = rotateLeft(n);
            }
        }
        return n;
    }

    public Node rotateRight(Node n) {
        Node t1 = n;
        Node t2 = n.left.right;
        n = n.left;
        n.right = t1;
        n.right.left = t2;
        return n;
    }

    public Node rotateLeft(Node n) {
        Node t1 = n;
        Node t2 = n.right.left;
        n = n.right;
        n.left = t1;
        n.left.right = t2;
        return n;
    }

    private int balanceFactor(Node n) {
        return height(n.left) - height(n.right);
    }

    public int height(Node n) {
        if (n == null) {
            return -1;
        }
        return Math.max(height(n.left), height(n.right)) + 1;
    }

    public Node findSuccessor(Node n) {
        while (n.left != null) {
            n = n.left;
        }
        return n;
    }

    public void delete(int key) {
        root = delete(root, key);
    }
}
