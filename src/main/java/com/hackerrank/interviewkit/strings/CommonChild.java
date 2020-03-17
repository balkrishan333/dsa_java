package com.hackerrank.interviewkit.strings;

public class CommonChild {

    public static void main(String[] args) {
        String str1 = "HARRY";
        String str2 = "SALLY";

        CommonChild commonChild = new CommonChild();
        int length = commonChild.count(str1, str2);
        System.out.println("length = " + length);
    }

    int count(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        int[][] result = new int[len1+1][len2+1];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                if (i == 0 || j ==0) {
                    result[i][j] =0;
                }
            }
        }

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    result[i][j] = result[i-1][j-1]+1;
                } else {
                    result[i][j] = Math.max(result[i-1][j], result[i][j-1]);
                }
            }
        }
        return result[len1][len2];
    }
}
