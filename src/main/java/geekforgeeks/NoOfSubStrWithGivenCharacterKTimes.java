package geekforgeeks;

/*
https://www.geeksforgeeks.org/number-of-sub-strings-that-contain-the-given-character-exactly-k-times/

 */

public final class NoOfSubStrWithGivenCharacterKTimes {

    public static void main(String[] args) {
        NoOfSubStrWithGivenCharacterKTimes solution = new NoOfSubStrWithGivenCharacterKTimes();
        String str = "abada";
        int k = 2;
        char ch = 'a';

        int subStrCount = solution.findSubStrCount(str, ch, k);
        System.out.println(subStrCount);
    }

    public int findSubStrCount(String str, char ch, int k) {
        int strCount = 0, left = 0, chCount = 0;

        for (int i = 0 ; i < str.length()  ; i++) {
            if (str.charAt(i) == ch) {
                if (chCount == 0) {
                    // initialize left pointer when ch is found first time.
                    left = i;
                }
                chCount++;
            }

            if (chCount > k) {
                //if chCount is more than required number, shrink the window by moving left pointer 1 place
                if (str.charAt(left) == ch) {
                    chCount--;
                }
                left++;
            }

            if (chCount == k) {
                strCount++;
            }

            //if i reached end of loop, we want to check sub strings from left to (str.length -k)
            if (i == str.length()-1 && left < str.length()-k) {
                i = left;
                chCount = 0;
                left++;
            }
        }

       return strCount;
    }
}
