package leetcode;

public class _880_DecodedStringAtIndex {

    public static void main(String[] args) {
        _880_DecodedStringAtIndex obj = new _880_DecodedStringAtIndex();

        String s = "leet2code3";
        int k = 10;
        System.out.println(obj.decodeAtIndex(s, k));
    }

    /*
        Approach: We don't maintain the whole string, that will give the answer but submission will run out of memory

        Calculate the total length of decoded string and then start wiping out characters starting from end of string to trim the string
        to required length

        why start from end of string not from beginning: because string is repetition of characters from start, if we start trimming
        string from start, we will lose the characters

        when trimming the string, we might end of having a length which is less than k, now how do we get index at char k when length is
        less than k

        Trick is when trimming the length of string, update k to mod of remaining length

        why mod: because string which was trimmed, was repetition of what is left, so same characters will be there
     */
    public String decodeAtIndex(String s, int k) {

        long curLength = 0;
        char ch;

        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                curLength *= ch - '0';  //digit - multiply the current length with digit
            } else {
                curLength++; //character - increment by 1
            }
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                curLength /= ch - '0';  //digit - trim the string by dividing, opposite of multiplication above

                //this will come in to play, if after division, length is less th k. update k to mod of remaining length because if
                // string was expanded characters will be repetition of this string
                k %= (int) curLength;
            } else {
                if (k == 0 || k == curLength) {
                    return "" + ch;
                }
                curLength--; //character - decrement by 1
            }
        }
        return "";
    }
}
