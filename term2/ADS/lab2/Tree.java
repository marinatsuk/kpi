package com.company;

public class Tree {
    Node root;
    //===================методи для додавання елементів=======================

    public void insert(int value){
        root = insertRecursive(root, value);
    }
    private Node insertRecursive(Node current, int value){
        if (current == null) {
            return new Node(value);
        }
        if (value < current.value) {
            current.left = insertRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = insertRecursive(current.right, value);
        } else {
            return current;
        }
        return current;
    }
    //==========================методи для видалення елементів===============
    public void delete(int value){
        root = deleteRecursive(root, value);
    }

    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }
        if (value == current.value) {
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.right == null) {
                return current.left;
            }
            if (current.left == null) {
                return current.right;
            }

            int smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
        }
        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        current.right = deleteRecursive(current.right, value);
        return current;
    }

    private int findSmallestValue(Node root) {
        if (root.left == null) {
            return root.value;
        } else {
            return findSmallestValue(root.left);
        }
    }
    //======================методи для знаходження суми====================================

    public void findSum() {
        sumCounter(root);
    }
    private long sumCounter(Node node) {
        long counter;
        if (node == null) return 0;
        counter = sumCounter(node.left) + node.value + sumCounter(node.right);
        return counter;
    }
    //====================== методи для знаходження елемента ==============

    public boolean findElement(int value) {
        return treeSearch(root, value);
    }

    boolean treeSearch(Node root, int key) {
        while (root != null) {
            if (key > root.value)
                root = root.right;
            else if (key < root.value)
                root = root.left;
            else
                return true;
        }
        return false;
    }



}
