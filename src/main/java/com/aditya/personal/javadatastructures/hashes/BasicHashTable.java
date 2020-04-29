package com.aditya.personal.javadatastructures.hashes;

public class BasicHashTable<TKey, YValue> {

    private HashEntry<TKey, YValue>[] data;

    private int capacity;

    private int size;

    public BasicHashTable(int tableSize) {
        this.capacity = tableSize;
        this.data = new HashEntry[this.capacity];
        this.size = 0;
    }

    public YValue get(TKey key) {

        int hash = calculateHash(key);

        if (data[hash] == null)
            return null;

        return data[hash].getValue();
    }

    public void put(TKey key, YValue value) {
        int hash = calculateHash(key);
        data[hash] = new HashEntry<>(key, value);
        this.size++;
    }

    public YValue delete(TKey key) {

        int hash = calculateHash(key);
        if (data[hash] == null)
            return null;

        YValue toReturn = data[hash].getValue();
        this.size--;

        hash = (hash + 1) % capacity;

        while (data[hash] != null) {
            HashEntry he = data[hash];
            data[hash] = null;
            put((TKey) he.getKey(), (YValue) he.getValue());
            size--;
            hash = (hash + 1) % capacity;
        }
        return toReturn;
    }

    public boolean hasKey(TKey key) {

        int hash = calculateHash(key);

        if (data[hash] == null)
            return false;

        return data[hash].getKey().equals(key);
    }

    public boolean hasValue(YValue value) {

        for (int i = 0; i < capacity; i++) {
            if (data[i] != null && data[i].getValue().equals(value))
                return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    private int calculateHash(TKey key) {
        int hash = key.hashCode() % this.capacity;

        while (data[hash] != null && !data[hash].getKey().equals(key))
            hash = (hash + 1) % this.capacity;
        return hash;
    }

    private class HashEntry<TKey, YValue> {
        private TKey key;

        private YValue value;

        public HashEntry(TKey key, YValue value) {
            this.key = key;
            this.value = value;
        }

        public TKey getKey() {
            return key;
        }

        public void setKey(TKey key) {
            this.key = key;
        }

        public YValue getValue() {
            return value;
        }

        public void setValue(YValue value) {
            this.value = value;
        }
    }

}
