package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DesignHashSet_705 {

    //ideally would want to start with 16 but some issue with resize leading to test case failure. So switching to higher value
    private static final int INITIAL_CAPACITY = 100000;
    private List<Integer>[] set;
    private int capacity = INITIAL_CAPACITY;
    private int size;

    public DesignHashSet_705() {
        set = (ArrayList<Integer>[])new ArrayList[INITIAL_CAPACITY];
    }

    public void add(int key) {

        if (contains(key)) {
            return;
        }

        if (size == capacity) {
            resize();
        }
        int hash = calculateHashCode(key);

        List<Integer> val = set[hash];

        if (val == null) {
            val = new ArrayList<>();
            val.add(key);
            set[hash] = val;
        } else {
            val.add(key);
        }
        size++;
    }

    private int calculateHashCode(int key) {
        int hash = Integer.hashCode(key);
        return hash % capacity;
    }

    private void resize() {
        capacity = capacity*2;
        List<Integer>[] newSet = (ArrayList<Integer>[])new ArrayList[capacity];
        List<Integer>[] temp = set;

        set = newSet;

        for(int i = 0; i < temp.length; i++) {
            if (temp[i] != null) {
                for(int item : temp[i]) {
                    add(item);
                }
            }
        }
    }

    public void remove(int key) {
        int hash = calculateHashCode(key);
        List<Integer> val = set[hash];
        if (val == null) {
            return;
        }

        if (val.size() == 1) {
            val = null;
            set[hash] = null;
        } else {
            Iterator<Integer> iterator = val.iterator();
            while (iterator.hasNext()) {
                int item = iterator.next();
                if (item == key) {
                    iterator.remove();
                }
            }
        }
    }

    public boolean contains(int key) {
        int hash = calculateHashCode(key);
        List<Integer> val = set[hash];
        if (val == null) {
            return false;
        }

        if (val.size() == 1 && val.get(0) == key) {
            return true;
        } else {
            Iterator<Integer> iterator = val.iterator();
            while (iterator.hasNext()) {
                int item = iterator.next();
                if (item == key) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DesignHashSet_705 obj = new DesignHashSet_705();
        /*obj.contains(72);
        obj.remove(91);
        obj.add(48);
        obj.add(41);
        obj.contains(96);
        obj.remove(87);
        obj.contains(48);
        obj.contains(49);
        obj.add(84);
        obj.add(82);
        obj.add(24);
        obj.add(7);
        obj.remove(56);
        obj.add(87);
        obj.add(81);
        obj.add(55);
        obj.add(19);
        obj.add(40);
        obj.add(68);
        obj.add(23);
        obj.add(80);
        obj.add(53);
        obj.add(76);
        obj.contains(93);
        obj.add(95);
        obj.contains(95);
        obj.add(67);
        obj.add(31);
        System.out.println(obj.contains(80));*/


    }
}
