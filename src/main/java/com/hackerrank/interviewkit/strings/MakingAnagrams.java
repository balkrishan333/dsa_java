package com.hackerrank.interviewkit.strings;

public final class MakingAnagrams {

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "cde";
        MakingAnagrams anagrams = new MakingAnagrams();
        int count = anagrams.countDeletions(str1, str2);
        System.out.println("count = " + count);
    }

    int countDeletions(String str1, String str2) {
        int[] str1CharCount = new int[26];
        int[] str2CharCount = new int[26];

        int i = 0;
        for ( ; i < str1.length() && i < str2.length() ; i++) {
            str1CharCount[str1.charAt(i)-97]++;
            str2CharCount[str2.charAt(i)-97]++;
        }

        if (str1.length() != str2.length()) {
            if (i < str1.length()) {
                for (; i< str1.length() ; i++) {
                    str1CharCount[str1.charAt(i)-97]++;
                }
            } else {
                for (; i< str2.length() ; i++) {
                    str2CharCount[str2.charAt(i)-97]++;
                }
            }
        }
        int deletionCount = 0;
        for (int ii = 0 ; ii <= 25 ; ii++) {
            deletionCount += Math.abs(str1CharCount[ii] - str2CharCount[ii]);
        }
        return deletionCount;
    }
}
