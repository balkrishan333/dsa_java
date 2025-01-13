package leetcode;

public class _3223_MinimumLengthOfStringAfterOperations {

    public static void main(String[] args) {
        _3223_MinimumLengthOfStringAfterOperations obj = new _3223_MinimumLengthOfStringAfterOperations();

        String s = "abaacbcbb";
        System.out.println(obj.minimumLength(s));
    }

    public int minimumLength(String s) {
        int[] charFrequency = new int[26];

        for(char currCh :s.toCharArray()) {
            charFrequency[currCh - 'a']++;
        }

        int minLength = 0;
        for (int i = 0; i < 26; i++) {
            if (charFrequency[i] == 0) {
                continue;
            }

            //count is even
            if (charFrequency[i] % 2 == 0) {
                minLength +=2;
            }else { //count is odd
                minLength +=1;
            }
        }
        return minLength;
    }
}
