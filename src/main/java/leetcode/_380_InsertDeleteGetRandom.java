package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class _380_InsertDeleteGetRandom {

    public static void main(String[] args) {
        _380_InsertDeleteGetRandom obj = new _380_InsertDeleteGetRandom();

        /*System.out.println(obj.insert(1));
        System.out.println(obj.remove(2));
        System.out.println(obj.insert(2));
        System.out.println(obj.getRandom());
        System.out.println(obj.remove(1));
        System.out.println(obj.insert(2));
        System.out.println(obj.getRandom());*/

        System.out.println(obj.remove(0));
        System.out.println(obj.remove(0));
        System.out.println(obj.insert(0));
        System.out.println(obj.getRandom());
        System.out.println(obj.remove(0));
        System.out.println(obj.insert(0));
    }

    private final int[] vals;
    private final Map<Integer, Integer> valToIndexMap;
    private int index;
    public _380_InsertDeleteGetRandom() {
        vals = new int[200000];
        valToIndexMap = new HashMap<>();
    }

    public boolean insert(int val) {
        if (valToIndexMap.containsKey(val)) {
            return false;
        }
        vals[index] = val;
        valToIndexMap.put(val, index);
        index++;
        return true;
    }

    public boolean remove(int val) {
        if (!valToIndexMap.containsKey(val)) {
            return false;
        }
        int valIndex = valToIndexMap.remove(val);
        int lastVal = vals[index - 1];
        vals[valIndex] = lastVal;

        if(valToIndexMap.containsKey(vals[index-1])){
            valToIndexMap.put(vals[index-1],valIndex);
        }
        index--;
        return true;
    }

    public int getRandom() {
        return vals[new Random().nextInt(index)];
    }
}
