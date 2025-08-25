package others;

public class MajorityVoteAlgorithm {

    public static void main(String[] args) {
        int[] arr = new int[] {5, 5, 0, 0, 0, 5, 0, 0, 5,4,0,4,0,4,0,3,3};
        MajorityVoteAlgorithm obj = new MajorityVoteAlgorithm();

        System.out.println(obj.boyerMooreAlgorithm(arr));
    }

    public int boyerMooreAlgorithm(int[] arr) {
        int candidate = 0;
        int count = 0;

        for (int val : arr) {
            if (count == 0) {
                candidate = val;
            }
            if (candidate == val) {
                count++;
            } else {
                count--;
            }
        }
        if (count > 0) {

            int candidateCount = 0;
            for (int val : arr) {
                if (val == candidateCount) {
                    candidateCount++;
                }
            }

            if (candidateCount > arr.length/2) {
                return candidate;
            }

        }
        return -1;
    }
}
