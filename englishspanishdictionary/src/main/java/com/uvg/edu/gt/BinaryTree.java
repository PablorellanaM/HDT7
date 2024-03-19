package com.uvg.edu.gt;

/**
 * Clase que implementa un árbol binario de búsqueda genérico (BST).
 * 
 * @param <K> Tipo genérico para la clave que debe extender de Comparable.
 * @param <V> Tipo genérico para el valor asociado a la clave.
 */
public class BinaryTree<K extends Comparable<K>, V> {

    private Node root;

    /**
     * Clase interna para representar un nodo del árbol binario de búsqueda.
     */
    private class Node {
        Association<K, V> association;
        Node left;
        Node right;

        /**
         * Crea un nodo con una asociación.
         * 
         * @param association La asociación de clave-valor para este nodo.
         */
        public Node(Association<K, V> association) {
            this.association = association;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * Constructor para crear un árbol binario de búsqueda vacío.
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * Inserta un nuevo nodo en el árbol binario de búsqueda con una clave y un
     * valor asociado.
     * 
     * @param key   La clave del nuevo nodo a insertar.
     * @param value El valor asociado a la clave.
     */
    public void insert(K key, V value) {
        root = insertRec(root, new Association<>(key, value));
    }

    /**
     * Método auxiliar recursivo para insertar un nuevo nodo en el árbol.
     * 
     * @param current     El nodo actual en la recursión.
     * @param association La asociación a insertar.
     * @return El nodo insertado o actualizado.
     */
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

    /**
     * Busca un valor asociado a una clave en el árbol.
     * 
     * @param key La clave a buscar en el árbol.
     * @return El valor asociado si la clave existe, de lo contrario null.
     */
    public V search(K key) {
        Node node = searchNode(root, key);
        return node == null ? null : node.association.getValue();
    }

    /**
     * Método auxiliar recursivo para buscar un nodo en el árbol.
     * 
     * @param current El nodo actual en la recursión.
     * @param key     La clave del nodo a buscar.
     * @return El nodo si la clave existe, de lo contrario null.
     */
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

    /**
     * Realiza un recorrido inOrder del árbol y muestra cada nodo.
     */
    public void inOrder() {
        inOrderRec(root);
    }

    /**
     * Método auxiliar recursivo para realizar un recorrido inOrder.
     * 
     * @param node El nodo actual en la recursión.
     */
    private void inOrderRec(Node node) {
        if (node != null) {
            inOrderRec(node.left);
            System.out.println(node.association);
            inOrderRec(node.right);
        }
    }
}
