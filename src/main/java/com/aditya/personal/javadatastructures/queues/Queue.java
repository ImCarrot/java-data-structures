package com.aditya.personal.javadatastructures.queues;

public interface Queue<T> {

    /**
     * Adds a new element to the queue
     *
     * @param item the element to add
     */
    void enQueue(T item);

    /**
     * Removes an element from the queue in FIFO fashion
     *
     * @return the fist element of the queue
     */
    T deQueue();

    /**
     * Checks if the queue contains an element
     *
     * @param item the item to search for
     * @return True if the element exists else false.
     */
    boolean contains(T item);

    /**
     * returns the element at the position
     *
     * @param index the index position of the element
     * @return the element at that index
     */
    T access(int index);

    /**
     * returns the size of the queue
     *
     * @return the size of the queue
     */
    int size();
}
