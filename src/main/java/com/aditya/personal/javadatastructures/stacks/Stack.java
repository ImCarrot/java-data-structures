package com.aditya.personal.javadatastructures.stacks;

public interface Stack<T> {

    /**
     * Adds a new item to the stack
     *
     * @param item the item to add
     */
    void push(T item);

    /**
     * removes and returns an item from the stack
     *
     * @return the item that was removed
     */
    T pop();

    /**
     * Checks if an item exists in a stack
     *
     * @param item the item to check
     * @return True if the item exists else false
     */
    boolean contains(T item);

    /**
     * Removes all elements from the stack until it reaches
     * the element passed
     *
     * @param item the item to go to.
     * @return The item that was fetched
     */
    T access(T item);

    /**
     * the number of elements in the stack
     *
     * @return returns the size of the stack
     */
    int size();
}
