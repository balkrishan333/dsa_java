package leetcode;

public class _769_MaxChunksToMakeSorted {

    public static void main(String[] args) {
        _769_MaxChunksToMakeSorted obj = new _769_MaxChunksToMakeSorted();

        int[] arr = {4, 3, 2, 1, 0};
        System.out.println(obj.maxChunksToSorted(arr));
    }

    public int maxChunksToSorted(int[] arr) {
        int maxSeen = -1;
        int noOfChunks = 0;

        for (int i = 0; i < arr.length; i++) {
            maxSeen = Math.max(maxSeen, arr[i]);
            if (maxSeen == i) {
                noOfChunks++;
            }
        }
        return noOfChunks;
    }
}
