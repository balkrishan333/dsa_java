package leetcode;

import java.util.*;

public class _2191_SortTheJumbledNumbers {

    public static void main(String[] args) {
        _2191_SortTheJumbledNumbers obj = new _2191_SortTheJumbledNumbers();

        int[] mapping = {8,9,4,0,2,1,3,5,7,6};
        int[] nums = {991,338,38};
        System.out.println(Arrays.toString(obj.sortJumbled(mapping, nums)));
    }

    public int[] sortJumbled(int[] mapping, int[] nums) {
        List<Integer[]> mappedNums = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            StringBuilder mapped = new StringBuilder();
            String number = Integer.toString(num);

            for (int j = 0; j < number.length(); j++) {
                mapped.append(mapping[number.charAt(j) - '0']);
            }
            Integer[] mappedNum = new Integer[2];
            mappedNum[0] = Integer.parseInt(mapped.toString());
            mappedNum[1] = i;

            mappedNums.add(mappedNum);
        }

        mappedNums.sort(Comparator.comparingInt(n1 -> n1[0]));

        int[] answer = new int[nums.length];
        for (int i = 0; i < mappedNums.size(); i++) {
            answer[i] = nums[mappedNums.get(i)[1]];
        }
        return answer;
    }
}
