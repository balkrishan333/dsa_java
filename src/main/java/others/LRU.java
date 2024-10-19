package others;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *  To implement LRU cache, simply extend the class with LinkedHashMap class and make sure initialize the LinkedHashMap
 *  with accessOrder to true. Setting accessOrder to true is the key to LRU. It makes sure that keys are retrieved based
 *  on order they were accessed (this includes reads. updates and inserts) and eldest(oldest) entry in the map is decided
 *  accordingly.
 * <p>
 *  2nd and last important step is, to override removeEldestEntry method. If this method returns true, the eldest entry
 *  will be removed before inserting a new entry. Simply compare the size of map with maxCapacity, this will tell
 *  LinkedHashMap that size is exceeding the maxCapacity, and it needs to remove before insert.
 *  </p>
 */

public class LRU extends LinkedHashMap<String, String> {

    private final int maxCapacity;

    public LRU(int size) {
        super(size, 0.7f, true) ;
        this.maxCapacity = size;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return this.size() > this.maxCapacity;
    }
}

class LRUClient {

    public static void main(String[] args) {

        LRU lru = new LRU(5);
        lru.put("key1", "value1");
        lru.put("key2", "value2");
        lru.put("key3", "value3");
        lru.put("key4", "value4");
        lru.put("key5", "value5");

        System.out.println(lru);

        //key1 is the eldest entry. should remove key1. After operation key2 is the eldest entry
        lru.put("key6", "value6");
        System.out.println(lru);

        //with key2 updated, key 3 is eldest entry. should remove key3. After operation key4 is the eldest entry
        lru.put("key2", "updated");
        lru.put("key7", "value7");

        System.out.println(lru);

        //with key4 accessed, key is the eldest entry. should remove key5. key 6 is the eldest entry
        lru.get("key4");
        lru.put("key8", "value8");

        System.out.println(lru);
    }
}
