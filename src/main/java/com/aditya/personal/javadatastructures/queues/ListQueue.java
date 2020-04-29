package com.aditya.personal.javadatastructures.queues;

import java.util.ArrayList;
import java.util.List;

public class ListQueue<T> implements Queue<T> {

    private final List<T> data;

    private int front;

    private int end;

    public ListQueue() {
        this.data = new ArrayList<T>();
        this.front = -1;
        this.end = -1;
    }

    /**
     * Adds a new element to the queue
     *
     * @param item the element to add
     */
    public void enQueue(T item) {

        if (size() == 0)
            front++;

        end++;
        data.add(end, item);
    }

    /**
     * Removes an element from the queue in FIFO fashion
     *
     * @return the fist element of the queue
     */
    public T deQueue() {
        if (size() == 0)
            return null;

        T toReturn = data.get(front);

        // so that the GC can clean up the removed element.
        data.add(front, null);

        if (end == front) {
            end = -1;
            front = -1;
        } else
            front++;

        return toReturn;
    }

    /**
     * Checks if the queue contains an element
     *
     * @param item the item to search for
     * @return True if the element exists else false.
     */
    public boolean contains(T item) {
        return data.contains(item);
    }

    /**
     * returns the element at the position
     *
     * @param index the index position of the element
     * @return the element at that index
     */
    public T access(int index) {

        if (index > size())
            throw new IllegalArgumentException("Index cannot be greater than the size of the queue.");

        if (size() == 0)
            return null;

        return data.get(index);
    }

    /**
     * returns the size of the queue
     *
     * @return the size of the queue
     */
    public int size() {
        if (end == -1 && front == -1)
            return 0;

        // adding the 1 since indexing is 0 based.
        return end - front + 1;
    }
}
