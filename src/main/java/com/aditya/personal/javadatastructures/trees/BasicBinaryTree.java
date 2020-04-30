package com.aditya.personal.javadatastructures.trees;

public class BasicBinaryTree<T extends Comparable<T>> {

    private Node root;

    private int size;

    public BasicBinaryTree() {
        this.root = null;
    }

    public void add(T item) {

        Node node = new Node(item);

        if (this.root == null) {
            this.root = node;
            size++;
            return;
        }

        this.insert(this.root, node);
    }

    private void insert(Node parent, Node child) {
        if (child.getItem().compareTo(parent.getItem()) < 0) {
            if (parent.getLeft() == null) {
                parent.setLeft(child);
                child.setParent(parent);
                this.size++;
            } else
                this.insert(parent.getLeft(), child);

        } else if (child.getItem().compareTo(parent.getItem()) > 0) {
            if (parent.getRight() == null) {
                parent.setRight(child);
                child.setParent(parent);
                this.size++;
            } else
                this.insert(parent.getRight(), child);
        } else
            throw new IllegalArgumentException("Cannot have duplicate values");
    }

    public Node contains(T item) {

        if (this.root == null)
            return null;

        Node current = root;

        while (current != null) {

            int comparison = item.compareTo(current.getItem());

            if (comparison == 0)
                return current;

            else if (comparison < 0)
                current = current.getLeft();

            else
                current = current.getRight();
        }
        return null;
    }

    public boolean delete(T item) {

        boolean deleted = false;

        if (this.root == null)
            return false;

        Node currentNode = contains(item);

        if (currentNode == null)
            return false;

        if (currentNode.getLeft() == null && currentNode.getRight() == null) {
            unlink(currentNode, null);
            this.size--;
            return true;
        }

        if (currentNode.getLeft() == null && currentNode.getRight() != null) {
            unlink(currentNode, currentNode.getRight());
            this.size--;
            return true;
        }

        if (currentNode.getLeft() != null && currentNode.getRight() == null) {
            unlink(currentNode, currentNode.getLeft());
            this.size--;
            return true;
        }

        /*
        Basically now we can pick either ways,
        if we go to the left side then we need to pick the right side every time till we reach the right leaf node.
        if we go to the right side then we need to pick the left side every time till we reach the left leaf node.

        because the way BST works, we'll always have the leaf nodes of the opposite side we choose as the best successor.
         */

        Node child = currentNode.getLeft();

        if (child == null)
            return false;

        while (child.getRight() != null && child.getLeft() != null)
            child = child.getRight();

        child.getParent().setRight(null);
        child.setLeft(currentNode.getLeft());
        child.setRight(currentNode.getRight());
        unlink(currentNode, child);
        this.size--;
        return true;
    }

    private void unlink(Node currentNode, Node newNode) {

        if (currentNode == this.root) {
            newNode.setLeft(currentNode.getLeft());
            newNode.setRight(currentNode.getRight());
            this.root = newNode;
        } else if (currentNode.getParent().getRight() == currentNode)
            currentNode.getParent().setRight(newNode);
        else currentNode.getParent().setLeft(newNode);

    }

    public int size() {
        return this.size;
    }

    private class Node {

        private Node left;

        private Node right;

        private Node parent;

        private final T item;


        private Node(T item) {
            this.item = item;
            this.left = null;
            this.right = null;
            this.parent = null;
        }


        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public T getItem() {
            return item;
        }
    }

}
