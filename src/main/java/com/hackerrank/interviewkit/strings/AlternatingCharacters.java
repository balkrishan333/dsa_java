package com.hackerrank.interviewkit.strings;

public final class AlternatingCharacters {

    public static void main(String[] args) {
        String str = "ABBABAB"; //1
        AlternatingCharacters alternatingCharacters = new AlternatingCharacters();
        int result = alternatingCharacters.count(str);
        System.out.println("result = " + result);
    }

    private int count(String s) {
        int count = 0;
        for(int i = 0 ; i <= s.length()-2; i++) {
            if(s.charAt(i) == s.charAt(i+1)){
                count++;
            }
        }
        return count;
    }
}
