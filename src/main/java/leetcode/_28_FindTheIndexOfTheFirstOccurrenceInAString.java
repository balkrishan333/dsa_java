package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _28_FindTheIndexOfTheFirstOccurrenceInAString {

    public static void main(String[] args) {
        _28_FindTheIndexOfTheFirstOccurrenceInAString obj = new _28_FindTheIndexOfTheFirstOccurrenceInAString();

        String haystack = "sadbutsad";
        String needle = "sad";
        System.out.println(obj.strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle) {

        if (needle.length() > haystack.length()) {
            return -1;
        }

        List<Integer> indexes = new ArrayList<>();
        char ch = needle.charAt(0);

        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == ch) {
                indexes.add(i);
            }
        }

        if (indexes.size() == 0) {
            return -1;
        }

        for(Integer index : indexes) {
            if (index+needle.length() > haystack.length()) {
                break;
            }
            String str = haystack.substring(index, index+needle.length());
            if (str.equals(needle)) {
                return index;
            }
        }
        return -1;
    }

    /*
        Using built-in function
     */
    public int strStr_v1(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
