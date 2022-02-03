package com.sparta.sortmanager.model;

import java.util.ArrayList;

public class BinarySearchTree {
    private class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) { this.value = value; }

        public int getValue() { return value; }
        public Node getLeft() { return left; }
        public Node getRight() { return right; }

        /* Adds a new value to the tree, using
         * recursion to find the correct placement.
         */
        public void addValue(int value) {
            if(value == this.value) return; // no duplicates allowed
            if(value < this.value) {
                if(left == null) left = new Node(value);
                else left.addValue(value);
            } else {
                if(right == null) right = new Node(value);
                else right.addValue(value);
            }
        }
    }

    private Node root;

    public BinarySearchTree(int[] arr) { for(int elem : arr) addValue(elem); }

    public Node getRoot() { return root; }

    /* Adds a new value to the tree.
     * To allow for recursion, checks the root
     * node manually before recurring through
     * the tree on the Node's method.
     */
    private void addValue(int value) {
        if(root == null) root = new Node(value);
        else root.addValue(value);
    }

    /* Instantiates the array list before calling
     * the traverse method to populate it
     * and then returning it.
     */
    public ArrayList<Integer> getOrderedList() {
        ArrayList<Integer> list = new ArrayList<>();
        traverse(root, list);
        return list;
    }

    /* Performs an inorder tree walk. When a node is visited,
     * it is added to the array list.
     */
    private void traverse(Node n, ArrayList<Integer> list) {
        if(n != null) {
            traverse(n.getLeft(), list);
            list.add(n.getValue()); // visit
            traverse(n.getRight(), list);
        }
    }

}
