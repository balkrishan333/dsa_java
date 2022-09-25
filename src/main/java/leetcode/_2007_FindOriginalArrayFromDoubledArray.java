package leetcode;

import java.util.*;

public class _2007_FindOriginalArrayFromDoubledArray {

    public static void main(String[] args) {
        _2007_FindOriginalArrayFromDoubledArray obj = new _2007_FindOriginalArrayFromDoubledArray();
        int[] changed = {1,3,4,2,6,8};

        System.out.println(Arrays.toString(obj.findOriginalArray(changed)));
    }

    public int[] findOriginalArray(int[] changed) {
        return new int[]{};
        //Will not work
       /* if (changed.length % 2 == 1) {
            return new int[]{};
        }

        int[] result = new int[changed.length/2];
        int index = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < changed.length; i++) {
            map.merge(changed[i], 1, Integer::sum);
        }

        for (int i = 0; i < changed.length; i++) {
            if (changed[i] % 2 == 1) {
                if (map.containsKey(changed[i]*2)) {
                    map.merge(changed[i], -1, Integer::sum);
                    map.merge(changed[i]*2, -1, Integer::sum);

                    result[index++] = changed[i];
                } else {
                    return new int[]{};
                }
            } else {
                if (map.containsKey(changed[i]/2)) {
                    map.merge(changed[i], -1, Integer::sum);
                    map.merge(changed[i]/2, -1, Integer::sum);

                    result[index++] = changed[i];
                } else if (map.containsKey(changed[i]*2)) {
                    map.merge(changed[i], -1, Integer::sum);
                    map.merge(changed[i]*2, -1, Integer::sum);

                    result[index++] = changed[i];
                } else {
                    return new int[]{};
                }
            }
        }

        return result;*/
    }
}
