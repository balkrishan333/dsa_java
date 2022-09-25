package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _128_LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};

        _128_LongestConsecutiveSequence obj = new _128_LongestConsecutiveSequence();
        System.out.println(obj.longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> repo = new HashSet<>();
        int length = 0;

        //Put all elements in set for O(1) access
        for (int num : nums) {
            repo.add(num);
        }

        //only look for numbers on right side i.e. greater than current number
        for (int num :  nums) {
            //look only if lesser number does not exist. if lesser number exists, this number will be part of different sequence
            if (!repo.contains(num-1)) {
                int currLen = 1;
                while (repo.contains(++num)) {
                    currLen++;
                }
                length = Math.max(length, currLen);
            }
        }

        return length;
    }


    public int longestConsecutive_v1(int[] nums) {
        Map<Integer, Boolean> repo = new HashMap<>();
        int length = 0;

        //Put all elements in map. for O(1) access and tracking
        for (int num : nums) {
            repo.put(num, true);
        }

        for (int num :  nums) {

            //if element has already been visited, it is already part of some other sequence, skip it
            if (!repo.get(num)) {
                continue;
            }

            int currLen = 1;

            int i = 1;
            boolean left = true; // track elements less than current element
            boolean right = true; // track elements more than current element

            repo.put(num, false);

            while (true) {

                if (left && repo.containsKey(num-i)) {
                    repo.put(num-i, false); //mark element visited
                    currLen += 1;
                } else {
                    left = false;
                }

                if (right && repo.containsKey(num+i)) {
                    repo.put(num+i, false); //mark element visited
                    currLen += 1;
                } else {
                    right = false;
                }

                if (!left & !right) { //iterate until we can find consecutive elements on either side
                    break;
                }
                i++;
            }
            length = Math.max(length, currLen);
        }
        return length;
    }
}
