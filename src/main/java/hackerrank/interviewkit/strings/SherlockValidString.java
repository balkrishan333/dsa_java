package hackerrank.interviewkit.strings;

public final class SherlockValidString {

    public static void main(String[] args) {
        String str = "abcc";
        SherlockValidString validString = new SherlockValidString();
        String result = validString.check(str);
        System.out.println("result = " + result);
    }

    public String check(String str) {
        int[] charCount = new int[26];
        for (int i = 0; i < str.length(); i++) {
            charCount[str.charAt(i)-97]++;
        }

        boolean oneCharRemoved = false;
        int benchMarkCount = 0;
        for (int i = 0; i < 26; i++) {
            if (charCount[i] == 0) {
                continue;
            }
            if (benchMarkCount == 0) {
                benchMarkCount = charCount[i];
            }
            if (benchMarkCount != charCount[i]) {
                if (charCount[i] == 1 && !oneCharRemoved) {
                    oneCharRemoved =true;
                } else if (Math.abs(benchMarkCount - charCount[i]) > 1 || oneCharRemoved) {
                    return "NO";
                } else {
                    oneCharRemoved = true;
                }
            }
        }
        return "YES";
    }
}
