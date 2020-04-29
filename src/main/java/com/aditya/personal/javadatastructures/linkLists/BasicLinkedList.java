package com.aditya.personal.javadatastructures.linkLists;

public class BasicLinkedList<T> {

    private Node first;

    private Node last;

    private int nodeCount;

    public BasicLinkedList() {
        first = null;
        last = null;
        nodeCount = 0;
    }

    public void add(T item) {
        //this condition means we are adding something for the first time.
        if (first == null) {
            first = new Node(item);
            last = first;
        }
        //otherwise, we want to grab the last node and update it's value
        else {
            Node newLastNode = new Node(item);
            last.setNextNode(newLastNode);
            last = newLastNode;
        }
        nodeCount++;
    }

    public void add(int position, T item) {
        if (size() < position) {
            throw new IllegalStateException("The LinkedList is smaller than the position you are trying to insert at: " + position);
        }

        Node currentNode = first;

        //start at 1 because we are already on the first node
        for (int i = 1; i < position && currentNode != null; i++) {
            currentNode = currentNode.getNextNode();
        }

        if (currentNode == null)
            throw new IllegalStateException("The LinkedList is smaller than the position you are trying to insert at: " + position);

        //severs the link chain and reconnects with the new node
        Node newNode = new Node(item);
        Node nextNode = currentNode.getNextNode();
        currentNode.setNextNode(newNode);
        newNode.setNextNode(nextNode);
        nodeCount++;
    }

    public T remove(int position) {
        if (first == null) {
            throw new IllegalStateException("The LinkedList is empty and there are no items to remove");
        }

        Node currentNode = first;
        Node prevNode = first;

        //start at 1 because we are already on the first node
        for (int i = 1; i < position && currentNode != null; i++) {
            prevNode = currentNode;
            currentNode = currentNode.getNextNode();
        }

        if (currentNode == null)
            return null;

        //now update the pointers and throw away the old first
        T nodeItem = currentNode.getNodeItem();
        prevNode.setNextNode(currentNode.getNextNode());
        nodeCount--;
        return nodeItem;

    }

    public T remove() {
        if (first == null) {
            throw new IllegalStateException("The LinkedList is empty and there are no items to remove");
        }

        T nodeItem = first.getNodeItem();

        //now update the first pointer and throw away the old first
        first = first.getNextNode();
        nodeCount--;
        return nodeItem;
    }

    public T get(int position) {
        if (first == null) {
            throw new IllegalStateException("The LinkedList is empty and there are no items to get");
        }

        Node currentNode = first;
        for (int i = 1; i < size() && currentNode != null; i++) {
            if (i == position) {
                return currentNode.getNodeItem();
            }

            currentNode = currentNode.getNextNode();
        }

        //if we didn't find it then return null
        return null;
    }

    public int indexOf(T item) {
        if (first == null) {
            throw new IllegalStateException("The LinkedList is empty and there are no items to find");
        }

        Node currentNode = first;
        for (int i = 1; i < size() && currentNode != null; i++) {
            if (currentNode.getNodeItem().equals(item)) {
                return i;
            }

            currentNode = currentNode.getNextNode();
        }

        //if we didn't find it, then return -1
        return -1;
    }

    //useful for pretty print
    public String toString() {
        StringBuilder contents = new StringBuilder();
        Node curNode = first;

        while (curNode != null) {
            contents.append(curNode.getNodeItem());
            curNode = curNode.getNextNode();

            if (curNode != null) {
                contents.append(", ");
            }
        }
        return contents.toString();
    }


    public int size() {
        return nodeCount;
    }

    private class Node {
        private Node nextNode;
        private final T nodeItem;

        public Node(T item) {
            this.nextNode = null;
            this.nodeItem = item;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public T getNodeItem() {
            return nodeItem;
        }

    }
}
