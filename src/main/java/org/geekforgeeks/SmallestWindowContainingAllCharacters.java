package org.geekforgeeks;

/*
https://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/

*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public final class SmallestWindowContainingAllCharacters {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testsCount = Integer.parseInt(reader.readLine());

        String[] strings = new String[testsCount];
        String[] patterns = new String[testsCount];

        for (int i = 0 ; i < testsCount ; i++) {
            String string = reader.readLine();
            String pattern = reader.readLine();

            strings[i] = string;
            patterns[i] = pattern;
        }

        for (int i = 0 ; i < testsCount ; i++) {
            SmallestWindowContainingAllCharacters solution = new SmallestWindowContainingAllCharacters();
            String results = solution.findSubString(strings[i], patterns[i]);
            System.out.println(results);
        }
    }

    String findSubString(String str, String pattern) {

        int[] patChars = new int[256];
        int[] strChars = new int[256];

        for(int i = 0 ; i < pattern.length() ; i++) {
            patChars[pattern.charAt(i)]++;
        }

        int count = 0 , start = 0, startIndex = -1, minLength = Integer.MAX_VALUE;
        for(int i = 0 ; i < str.length() ; i++) {
            char currentChar = str.charAt(i);
            strChars[currentChar]++;

            if (patChars[currentChar] > 0 && strChars[currentChar] <= patChars[currentChar]) {
                count++;
            }

            if (count == pattern.length()) {

                char testChar = str.charAt(start);

                while (patChars[testChar] == 0 || strChars[testChar] > patChars[testChar]) {
                    if (strChars[testChar] > patChars[testChar]) {
                        strChars[testChar]--;
                    }
                    start++;
                    testChar = str.charAt(start);
                }

                int length = i - start + 1;
                if (length < minLength) {
                    minLength = length;
                    startIndex = start;
                }
            }
        }

        if (startIndex == -1) {
            return "-1";
        }
        return str.substring(startIndex, startIndex+minLength);
    }
}
