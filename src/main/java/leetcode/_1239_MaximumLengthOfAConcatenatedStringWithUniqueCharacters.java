package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _1239_MaximumLengthOfAConcatenatedStringWithUniqueCharacters {

    public static void main(String[] args) {
        _1239_MaximumLengthOfAConcatenatedStringWithUniqueCharacters obj =
                new _1239_MaximumLengthOfAConcatenatedStringWithUniqueCharacters();

        List<String> arr = List.of("cha","r","act","ers");
        System.out.println(obj.maxLength(arr));
    }

    public int maxLength(List<String> arr) {
        //Find strings with unique chars
        List<Integer> uniqueStrs = new ArrayList<>();

        for (String str : arr) {
            int bitStr = 0;
            for (char ch : str.toCharArray()) {
                bitStr += 1 << (ch - 'a');
            }
            if (Integer.bitCount(bitStr) == str.length()) {
                uniqueStrs.add(bitStr);
            }
        }

        int maxLen = 0;
        List<Integer> concatStr = new ArrayList<>(List.of(0));

        //concatenate the strings which don't have overlapping chars
        for (Integer str : uniqueStrs) {
            for (int i = 0; i < concatStr.size(); i++) {
                int concat = concatStr.get(i);
                if((concat & str) == 0) {
                    int newConcat = concat | str;
                    concatStr.add(newConcat);
                    maxLen = Math.max(maxLen, Integer.bitCount(newConcat));
                }
            }
        }
        return maxLen;
    }
}
