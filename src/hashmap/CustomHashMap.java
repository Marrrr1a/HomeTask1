package hashmap;

import java.util.Objects;

public class CustomHashMap <K, V> {

    private static class Node <K, V> {
        private K key;
        private V value;
        private Node <K, V> next;
        private Node <K, V> previous;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node <K, V> [] buckets;
    private int size = 0;

    public int sizeValue (){
        return size;
    }

    @SuppressWarnings("unchecked")
    public CustomHashMap () {
        int capacity = 16;
        buckets = new Node[capacity];
    }


    /**
     * Puts a key-value pair to the map. Replaces value, if the key already exists.
     * @param key - the key
     * @param value - the value associated with the key
     */
    public void put (K key, V value){
        int index = calculateBucketsIndex(key);
        Node <K, V> currentNode = buckets [index];

        while (currentNode != null){
            if (Objects.equals(currentNode.key, key)){
                currentNode.value = value;
                return;
            }
            currentNode = currentNode.next;
        }

        Node <K, V> newNode = new Node<>(key, value);
        newNode.next = buckets [index];
        buckets [index] = newNode;

        size ++;
    }


    /**
     * Returns the value associated with the exact key
     * @param key - the key
     * @return the associated value, or null if the key is not found
     */
    public V get (K key){
        int index = calculateBucketsIndex(key);
        Node <K, V> currentNode = buckets [index];

        while (currentNode != null){
            if (Objects.equals(currentNode.key, key)){
               return currentNode.value;
            }
            currentNode = currentNode.next;
        }

        return null;
    }


    /**
     * Removes the value by the exact key
     * @param key - the key
     */
    public void remove (K key){
        int index = calculateBucketsIndex(key);
        Node <K, V> currentNode = buckets [index];

        while (currentNode != null){
            if (Objects.equals(currentNode.key, key)){
                if (currentNode.previous == null){
                    buckets[index] = currentNode.next;
                } else {
                    currentNode.previous.next = currentNode.next;
                }
                size --;
                return;
            }
            currentNode.previous = currentNode;
            currentNode = currentNode.next;
        }
    }

    public int calculateBucketsIndex (K key){
        int hash = key == null ? 0 : key.hashCode();
        return (hash & 0x7fffffff) % buckets.length;
    }

}
