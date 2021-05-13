package com.hackerrank.interviewkit.dictionaryandhashmap;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    public static void main(String[] args) {
        String magazine = "ive got a lovely bunch of coconuts";
        String note = "ive got some coconuts";
//        String magazine = "give me one grand today night";
//        String note = "give one grand today";
//        String magazine = "two times three is not four";
//        String note = "two times two is four";

        RansomNote ransomNote = new RansomNote();
        String result = ransomNote.checkMagazine(note.split(" "), magazine.split(" "));
        System.out.println("result = " + result);
    }

    public String checkMagazine(String[] notes, String[] magazines) {
        Map<String, Integer> map = new HashMap<>();

        for(String s: magazines) {
            if (map.containsKey(s)) {
                int oldVal = map.get(s);
                map.put(s, oldVal+1);
            } else {
                map.put(s, 1);
            }
        }

        for (String s: notes) {
            Integer val = map.get(s);
            if (val == null || val == 0) {
                return "No";
            }
            map.put(s, val-1);
        }

        return "Yes";
    }
}
