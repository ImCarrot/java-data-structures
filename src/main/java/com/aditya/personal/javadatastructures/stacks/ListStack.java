package com.aditya.personal.javadatastructures.stacks;

import java.util.ArrayList;
import java.util.List;

public class ListStack<T> implements Stack<T> {

    private final List<T> data;

    public ListStack() {
        data = new ArrayList<T>();
    }

    /**
     * Adds a new item to the stack
     *
     * @param item the item to add
     */
    public void push(T item) {
        data.add(item);
    }

    /**
     * removes and returns an item from the stack
     *
     * @return the item that was removed
     */
    public T pop() {

        if (data.size() == 0)
            return null;

        T lastElement = data.get(data.size() - 1);
        data.remove(data.size() -1);
        return lastElement;
    }

    /**
     * Checks if an item exists in a stack
     *
     * @param item the item to check
     * @return True if the item exists else false
     */
    public boolean contains(T item) {
        return data.contains(item);
    }

    /**
     * Removes all elements from the stack until it reaches
     * the element passed
     *
     * @param item the item to go to.
     * @return The item that was fetched
     */
    public T access(T item) {

        while (data.size() > 0) {
            T toReturn = this.pop();
            if (toReturn.equals(item))
                return toReturn;
        }
        return null;
    }

    /**
     * the number of elements in the stack
     *
     * @return returns the size of the stack
     */
    public int size() {
        return data.size();
    }
}
