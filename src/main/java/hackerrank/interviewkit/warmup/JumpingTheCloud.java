package hackerrank.interviewkit.warmup;

public final class JumpingTheCloud {

    public static void main(String[] args) {

        int[] arr = {0, 0, 1, 0, 0, 1, 0};

        JumpingTheCloud cloud = new JumpingTheCloud();
        int count = cloud.countJump(arr);
        System.out.println("count = " + count);
    }

    int countJump(int[] arr) {
        int count = 0;

        for (int i = 2 ; i < arr.length-1 ; ) {
            if (arr[i] == 1) {
                i--;
            } else {
                i += 2;
                count++;
            }
        }
        return count+1;
    }
}
