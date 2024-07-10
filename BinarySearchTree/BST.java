/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BinarySearchTree;

import java.util.ArrayList;

/**
 *
 * @author Emre
 */
public class BST {

    public enum TreeTrevarsal {
        preOrder, inOrder, postOrder
    };
    
    private Node root = null;
    
    public ArrayList walkInTree(TreeTrevarsal treeTrevarsal){
        ArrayList<Integer> arrayList = new ArrayList<>();
        switch(treeTrevarsal){
            case preOrder: 
                return preOrder(root, arrayList);
            case inOrder:
                return inOrder(root, arrayList);
            case postOrder:
                return postOrder(root, arrayList);
        }
        return null;
    }

    private ArrayList preOrder(Node node, ArrayList arrayList) {
        if (node != null) {
            arrayList.add(node.data);
            preOrder(node.left, arrayList);
            preOrder(node.right, arrayList);
        }
        return arrayList;
    }
    
    private ArrayList inOrder(Node node, ArrayList arrayList) {
        if (node != null) {
            inOrder(node.left, arrayList);
            arrayList.add(node.data);
            inOrder(node.right, arrayList);
        }
        return arrayList;
    }
    
    private ArrayList postOrder(Node node, ArrayList arrayList) {
        if (node != null) {
            postOrder(node.left, arrayList);
            postOrder(node.right, arrayList);
            arrayList.add(node.data);
        }
        return arrayList;
    }

    public void add(int data) {
        root = add(root, data);
    }

    private Node add(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }

        if (data < node.data) {
            node.left = add(node.left, data);
        } else if (data > node.data) {
            node.right = add(node.right, data);
        }

        return node;
    }

    public boolean rfind(int data) {
        return rfind(root, data);
    }

    private boolean rfind(Node node, int data) {
        if (node == null) {
            return false;
        }

        if (node.data > data) {
            return rfind(node.left, data);
        } else if (node.data < data) {
            return rfind(node.right, data);
        }

        return true;
    }

    public boolean find(int data) {
        return find(root, data);
    }

    private boolean find(Node node, int data) {
        Node temp = node;

        while (temp != null) {
            if (temp.data > data) {
                temp = temp.left;
            } else if (temp.data < data) {
                temp = temp.right;
            } else {
                return true;
            }
        }
        return false;
    }

    public void delete(int data) {
        delete(root, data);
    }

    private Node delete(Node node, int data) {
        if (node == null) {
            return null;
        }

        if (node.data > data) {
            node.left = delete(node.left, data);
        } else if (node.data < data) {
            node.right = delete(node.right, data);
        } else {
            if (node.left != null && node.right != null) {
                node.data = inOrderSuccessor(node.right);
                node.right = delete(node.right, node.data);
            } else if (node.left == null) {
                return node.right;
            } else {
                return node.left;
            }
        }
        return node;
    }

    private int inOrderSuccessor(Node node) {
        Node temp = node;
        int data = node.data;

        while (temp != null) {
            data = temp.data;
            temp = temp.left;
        }
        return data;
    }
    
    public int getHeight() {
        return getHeight(root);
    }
    
    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }
    
    public boolean isBalanced() {
        return isBalanced(root);
    }
    
    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }
        
        if (Math.abs(getHeight(node.left) - getHeight(node.right)) <= 1) {
            return isBalanced(node.left) && isBalanced(node.right);
        }
        return false;
    }

    private class Node {

        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
