package geekforgeeks;

public class LargestNumberInKSwaps {

    public static void main(String[] args) {
        String answer = LargestNumberInKSwaps.findMaximumNum("1034", 2);
        System.out.println(answer);
    }

    private static String result;

    public static String findMaximumNum(String str, int k) {
        result = str;
        findMaximum(str.toCharArray(), k, 0);
        return result;
    }

    private static void findMaximum(char[] str, int k, int startIndex) {
        if (k == 0 || startIndex == str.length - 1) {
            return;
        }

        char largestChar = largestCharInStr(str, startIndex);
        char startChar = str[startIndex];

        for (int i = startIndex+1; i < str.length; i++) {
            char currChar = str[i];
            if (currChar > startChar && currChar == largestChar) {
                swap(str, i, startIndex);
                String val = new String(str);
                if (val.compareTo(result) > 0) {
                    result = val;
                }
                findMaximum(str, k-1, startIndex+1);
                swap(str, i, startIndex);
            }
        }
        findMaximum(str, k, startIndex+1);
    }

    private static char largestCharInStr(char[] str, int startIndex) {
        char largest = str[startIndex];
        for (int i = startIndex+1; i < str.length; i++) {
            if (largest < str[i]) {
                largest = str[i];
            }
        }
        return largest;
    }

    private static void swap(char[] str, int i, int j) {
        char ch = str[i];
        str[i] = str[j];
        str[j] = ch;
    }
}
