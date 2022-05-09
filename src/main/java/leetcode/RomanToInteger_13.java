package leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger_13 {

    private static final Map<Character, Integer> BASE_ROMANS;

    static {
        BASE_ROMANS = new HashMap<>();
        BASE_ROMANS.put('I', 1);
        BASE_ROMANS.put('V', 5);
        BASE_ROMANS.put('X', 10);
        BASE_ROMANS.put('L', 50);
        BASE_ROMANS.put('C', 100);
        BASE_ROMANS.put('D', 500);
        BASE_ROMANS.put('M', 1000);
    }

    public static void main(String[] args) {
        RomanToInteger_13 obj = new RomanToInteger_13();
        String s = "III";
        System.out.println(obj.romanToInt(s));
    }

    public int romanToInt(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] chars = s.toCharArray();
        int result = 0;

        for (int i = 0; i < chars.length; i++) {
            int val = BASE_ROMANS.get(chars[i]);
            //check if next character is greater or less than current
            if (i +1 < chars.length) {
                int val2 = BASE_ROMANS.get(chars[i+1]);
                if (val >= val2) {
                    result += val;
                } else {
                    //if next character is greater, subtract the curr value from next and move pointer 1 step
                    result += (val2 - val);
                    i++;
                }
            } else {
                result += val;
            }
        }
        return result;
    }
}
