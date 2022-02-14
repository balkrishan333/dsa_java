package hackerrank.interviewkit.warmup;

public final class CountingValleys {

    public static void main(String[] args) {
        String str = "UDDDUDUU";
        CountingValleys valleys = new CountingValleys();
        int count = valleys.count(str);
        System.out.println("count = " + count);
    }

    int count(String str) {
        int stepCount = 0;
        int valleyCount = 0;

        for (int i = 0 ; i < str.length() ; i++) {
            if (str.charAt(i) == 'U') {
                if (stepCount == -1) {
                    valleyCount++;
                }
                stepCount++;
            } else {
                stepCount--;
            }
        }
        return valleyCount;
    }
}
