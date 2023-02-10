package leetcode;

import java.util.*;

public class _2306_NamingACompany {

    public static void main(String[] args) {
        _2306_NamingACompany obj = new _2306_NamingACompany();

        String[] ideas = {"coffee","donuts","time","toffee"};
        System.out.println(obj.distinctNames(ideas));
    }

    /*
        Approach:

        prefix - first character of string
        suffix - rest of the string

        1. 2 strings with same suffix can't be paired ex: coffee, toffee
        2. 2 strings with different suffix but same prefix can't be paired. ex: toffee, time

        Groups the string with same prefix. (we can also do grouping by suffix but that would mean key in map
        could be large. With prefix being first character, their can be at most 26 keys in map)

        Strings in same group can't be paired (2. above)
        For every group in the map, check to see if any other group has same suffix (to check 1 above)
     */
    public long distinctNames(String[] ideas) {
        Map<Character, Set<String>> groups = new HashMap<>();

        //Group the strings by prefix
        for (String idea : ideas) {
            Set<String> set = groups.getOrDefault(idea.charAt(0), new HashSet<>());
            set.add(idea.substring(1));
            groups.put(idea.charAt(0), set);
        }

        List<Character> chars = new ArrayList<>(groups.keySet());

        long answer = 0;
        //check every group with every other group to see if there are any common suffixes
        for (int i = 0; i < chars.size(); i++) {
            Set<String> outer = groups.get(chars.get(i));

            for (int j = i+1; j < chars.size(); j++) {
                Set<String> inner = groups.get(chars.get(j));

                int common = 0;
                for (String str : outer) {
                    if (inner.contains(str)) {
                        //increase the count if there is common string between groups
                        common++;
                    }
                }
                //reduce the no of common suffixes from each group and multiply with 2
                //multiply with 2 because strings can be paired in other order as well
                answer += 2L*(outer.size() - common) * (inner.size()-common);
            }
        }
        return answer;
    }

    /*
        Works but Time limit exceeded
     */
    public long distinctNames_v1(String[] ideas) {
        Set<String> hash = new HashSet<>(List.of(ideas));

        long answer = 0;
        for (int i = 0; i < ideas.length; i++) {
            String A = ideas[i];
            for (int j = i+1; j < ideas.length; j++) {
                String B = ideas[j];

                char[] strA = A.toCharArray();
                strA[0] = B.charAt(0);

                char[] strB = B.toCharArray();
                strB[0] = A.charAt(0);

                if (hash.contains(new String(strA)) || hash.contains(new String(strB))) {
                    continue;
                } else {
                    answer += 2;

                }
            }
        }
        return answer;
    }
}
