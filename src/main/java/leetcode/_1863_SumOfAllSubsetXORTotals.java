package leetcode;

public class _1863_SumOfAllSubsetXORTotals {

    public static void main(String[] args) {
        _1863_SumOfAllSubsetXORTotals obj = new _1863_SumOfAllSubsetXORTotals();

        int[] nums = {3,4,5,6,7,8};
        System.out.println(obj.subsetXORSum(nums));
    }

    /*
        On observing the output its evident, for all outputs right most (LSB) N-1 bits are all 0, N is length of input array.

        For rest of the bits (MSB), these bits are result of bitwise OR operator of all input elements.
     */
    public int subsetXORSum(int[] nums) {

        //Following is the code to generate all subsets of the input array. If taking this approach after subsets are found
        //calculate the XOR of each subset and add them all.

        /*List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(List.of(nums[0]));

        for (int i = 1; i < nums.length; i++) {
            List<List<Integer>> temp = new ArrayList<>();
            for (List<Integer> list : subsets) {
                List<Integer> subset = new ArrayList<>(list);
                subset.add(nums[i]);
                temp.add(subset);
            }
            subsets.addAll(temp);
            subsets.add(List.of(nums[i]));
        }

        System.out.println(subsets);
        System.out.println(subsets.size());*/

        int result = 0;

        for (int num: nums) {
            result = result | num;
        }

        return result << nums.length - 1;
    }
}
