package com.aditya.personal.javadatastructures.stacks;

public class ArrayStack<T> implements Stack<T> {

    // the backing field to store the data
    private T[] data;

    private int stackPointer;

    public ArrayStack() {
        // where 1000 is a hard-coded value of size it's not optimal though.
        this.data = (T[]) new Object[1000];
        this.stackPointer = 0;
    }

    public void push(T item) {
        // the ++ is a post increment so it'll first add to data then increment pointer
        data[stackPointer++] = item;
    }

    public T pop() {

        if (stackPointer == 0)
            return null;

        // the -- is a pre decrement so it'll first decrement the value and then return the value in the new pointer
        return data[--stackPointer];
    }

    public boolean contains(T item) {

        for (int i = 0; i < stackPointer; i++) {
            if (data[i].equals(item))
                return true;
        }
        return false;
    }


    public T access(T item) {

        while (stackPointer > 0) {
            T toReturn = this.pop();
            if (toReturn.equals(item))
                return toReturn;
        }
        return null;
    }

    public int size() {
        return stackPointer;
    }
}
