package crackingcodinginterviewbook.ch1;

public final class StringCompression_6 {

    public static void main(String[] args) {
        String str = "aabcccccaaa";
        String result = compress(str);
        System.out.println("result = " + result);
    }

    public static String compress(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] chars = str.toCharArray();

        char curr = chars[0];
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (char aChar : chars) {
            if (aChar == curr) {
                count++;
            } else {
                sb.append(curr).append(count);
                count = 1;
                curr = aChar;
            }
        }
        sb.append(curr).append(count);

        return sb.length() < str.length() ? sb.toString() : str;
    }
}
