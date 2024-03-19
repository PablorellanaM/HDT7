package com.uvg.edu.gt;

public class BinaryTree<K extends Comparable<K>, V> {

    private Node root;

    private class Node {
        Association<K, V> association;
        Node left;
        Node right;

        public Node(Association<K, V> association) {
            this.association = association;
            this.left = null;
            this.right = null;
        }
    }

    public BinaryTree() {
        root = null;
    }

    public void insert(K key, V value) {
        root = insertRec(root, new Association<>(key, value));
    }

    private Node insertRec(Node current, Association<K, V> association) {
        if (current == null) {
            return new Node(association);
        }

        int compare = association.getKey().compareTo(current.association.getKey());
        if (compare < 0) {
            current.left = insertRec(current.left, association);
        } else if (compare > 0) {
            current.right = insertRec(current.right, association);
        } else {
            current.association.setValue(association.getValue());
        }

        return current;
    }

    public V search(K key) {
        Node node = searchNode(root, key);
        return node == null ? null : node.association.getValue();
    }

    private Node searchNode(Node current, K key) {
        if (current == null) {
            return null;
        }

        int compare = key.compareTo(current.association.getKey());
        if (compare < 0) {
            return searchNode(current.left, key);
        } else if (compare > 0) {
            return searchNode(current.right, key);
        } else {
            return current;
        }
    }

    public void inOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(Node node) {
        if (node != null) {
            inOrderRec(node.left);
            System.out.println(node.association);
            inOrderRec(node.right);
        }
    }
}
