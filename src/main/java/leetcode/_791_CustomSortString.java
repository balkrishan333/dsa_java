package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _791_CustomSortString {

    public static void main(String[] args) {
        _791_CustomSortString obj = new _791_CustomSortString();

        String order = "bcafg";
        String s = "abcd";
        System.out.println(obj.customSortString(order, s));
    }

    public String customSortString(String order, String s) {
        Map<Character,Integer> map = new HashMap<>();

        for(int i=0;i < s.length();i++) {    // creating the frequency of each character using hashmap
            map.merge(s.charAt(i), 1, Integer::sum);
        }

        StringBuilder answer = new StringBuilder();

        for(int i=0;i < order.length();i++) {
            char ch = order.charAt(i);
            if(map.containsKey(ch)) {      //  If the string character is not present in the order string
                int freq = map.get(ch);
                for (int j = 0; j < freq; j++) {
                    answer.append(ch);     // appending the result
                }
                map.remove(ch);         // freeing the hashmap
            }
        }

        for(Character key : map.keySet()) { // Appending Remaining characters that are not present in the order string
            int freq = map.get(key);
            for(int j=0; j < freq; j++)
                answer.append(key);
        }
        return answer.toString();
    }
}
