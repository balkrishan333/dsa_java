package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _2391_MinimumAmountOfTimeToCollectGarbage {

    public static void main(String[] args) {
        _2391_MinimumAmountOfTimeToCollectGarbage obj = new _2391_MinimumAmountOfTimeToCollectGarbage();

        String[] garbage = {"G","P","GP","GG"};
        int[] travel = {2,4,3};
        System.out.println(obj.garbageCollection(garbage, travel));
    }

    public int garbageCollection(String[] garbage, int[] travel) {
        int[] travelPrefixSum = new int[travel.length+1];
        travelPrefixSum[0] = 0;

        for (int i = 1; i <= travel.length; i++) {
            travelPrefixSum[i] = travelPrefixSum[i-1] + travel[i-1];
        }

        Map<Character, Integer> garbageCount = new HashMap<>();
        Map<Character, Integer> garbageLastIndex = new HashMap<>();

        for (int j = 0; j < garbage.length; j++) {
            String str = garbage[j];
            for (int i = 0; i < str.length(); i++) {
                garbageCount.merge(str.charAt(i), 1, Integer::sum);
                garbageLastIndex.put(str.charAt(i), j);
            }
        }

        int answer = 0;
        answer += garbageCount.getOrDefault('M', 0) + travelPrefixSum[garbageLastIndex.getOrDefault('M', 0)];
        answer += garbageCount.getOrDefault('P', 0) + travelPrefixSum[garbageLastIndex.getOrDefault('P', 0)];
        answer += garbageCount.getOrDefault('G', 0) + travelPrefixSum[garbageLastIndex.getOrDefault('G', 0)];

        return answer;
    }
}
