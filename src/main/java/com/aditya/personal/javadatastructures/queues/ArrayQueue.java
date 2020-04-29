package com.aditya.personal.javadatastructures.queues;

public class ArrayQueue<T> implements Queue<T> {

    private final T[] data;

    private int front;

    private int end;

    public ArrayQueue() {
        this(1000);
    }

    public ArrayQueue(int size) {
        this.data = (T[]) new Object[size];
        this.front = -1;
        this.end = -1;
    }

    /**
     * Adds a new element to the queue
     *
     * @param item the element to add
     */
    public void enQueue(T item) {

        if ((end + 1) % data.length == front)
            throw new IllegalStateException("The Queue is full");

        if (size() == 0)
            front++;

        end++;
        data[end] = item;
    }

    /**
     * Removes an element from the queue in FIFO fashion
     *
     * @return the fist element of the queue
     */
    public T deQueue() {

        if (size() == 0)
            return null;

        T toReturn = data[front];

        // so that the GC can clean up the removed element.
        data[front] = null;

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

        if (size() == 0)
            return false;

        for (int i = front; i < end; i++) {
            if (data[i].equals(item))
                return true;
        }
        return false;
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

        int trueIndex = 0;
        for (int i = front; i < end; i++) {
            if (trueIndex == index)
                return data[i];
            trueIndex++;
        }
        return null;
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
