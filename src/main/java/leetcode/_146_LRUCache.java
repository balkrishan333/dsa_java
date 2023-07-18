package leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class _146_LRUCache {

    private final int capacity;
    private final Map<Integer, Integer> cache;
    private final Deque<Integer> queue;

    public _146_LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        queue = new LinkedList<>();
    }

    public int get(int key) {
        int retValue = -1;
        if(cache.containsKey(key)) {
            retValue = cache.get(key);
            queue.remove(key);
            queue.offerLast(key); //put at the end of queue
        }
        return retValue;
    }

    public void put(int key, int value) {

        if(cache.containsKey(key)) {
            cache.put(key,value);
            queue.remove(key);
            queue.offerLast(key); //put at the end of queue
            return;
        }

        if(cache.size() < this.capacity) {
            cache.put(key, value);
            queue.offerLast(key);
        } else {
            int removed = queue.pollFirst(); //poll first element from queue
            cache.remove(removed);
            cache.put(key, value);
            queue.offerLast(key);
        }
    }
}
