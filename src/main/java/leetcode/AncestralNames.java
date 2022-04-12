package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AncestralNames {

    private static final Map<Character, Integer> romanBase;

    static {
        romanBase = new HashMap<>();
        romanBase.put('I', 1);
        romanBase.put('V', 5);
        romanBase.put('X', 10);
        romanBase.put('L', 50);
        romanBase.put('C', 100);
        romanBase.put('D', 500);
        romanBase.put('M', 1000);
    }

    public static void main(String[] args) {
        String[] names = {"Steven XL", "Steven XVI", "David IX", "Mary XV", "Mary XIII", "Mary XX"};
        AncestralNames obj = new AncestralNames();
        System.out.println("Before sort : " + Arrays.toString(names));
        obj.sort(names);
        System.out.println("After sort : " + Arrays.toString(names));
    }

    private void sort(String[] names) {

        Arrays.sort(names, (s1, s2) -> {
            String[] tokens1 = s1.split(" ");
            String[] tokens2 = s2.split(" ");

            //if names are equal, sort on number
            if (tokens1[0].equals(tokens2[0])) {
                int roman1 = romanToInt(tokens1[1]);
                int roman2 = romanToInt(tokens2[1]);

                return Integer.compare(roman1, roman2);
            } else {
                //names not equal, sort on name
                return tokens1[0].compareTo(tokens2[0]);
            }
        });
    }

    private int romanToInt(String roman) {
        char[] chars = roman.toCharArray();
        int total = 0;
        for (int i = 0; i < chars.length; i++) {
            //if value of next char is more, substact the two
            if (i+1 < chars.length && romanBase.get(chars[i]) < romanBase.get(chars[i+1])){
                total += romanBase.get(chars[i+1]) - romanBase.get(chars[i]);
                i++;
            } else {
                total += romanBase.get(chars[i]);
            }
        }
        return total;
    }
}
