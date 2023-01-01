package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _290_WordPattern {

    public static void main(String[] args) {
        _290_WordPattern obj = new _290_WordPattern();

        String pattern = "abba";
        String s = "dog cat cat dog";
        System.out.println(obj.wordPattern(pattern, s));
    }

    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        String[] tokens = s.split(" ");

        if (tokens.length != pattern.length()) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String str = tokens[i];

            if (map.get(ch) != null){
                if (!map.get(ch).equals(str)) {
                    return false;
                }
            } else {
                //check if this str has already been mapped to some other character
                if (map.containsValue(str)) {
                    return false;
                }
                map.putIfAbsent(ch, str);
            }
        }
        return true;
    }
}
