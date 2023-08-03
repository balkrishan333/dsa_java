package leetcode;

import java.util.*;

public class _17_LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        _17_LetterCombinationsOfAPhoneNumber obj = new _17_LetterCombinationsOfAPhoneNumber();

        String digits = "234";
        System.out.println(obj.letterCombinations(digits));
    }
    private static final Map<Character, List<String>> MAPPING;

    static {
        MAPPING = new HashMap<>();
        MAPPING.put('2', List.of("a", "b", "c"));
        MAPPING.put('3', List.of("d", "e", "f"));
        MAPPING.put('4', List.of("g", "h", "i"));
        MAPPING.put('5', List.of("j", "k", "l"));
        MAPPING.put('6', List.of("m", "n", "o"));
        MAPPING.put('7', List.of("p", "q", "r", "s"));
        MAPPING.put('8', List.of("t", "u", "v"));
        MAPPING.put('9', List.of("w", "x", "y", "z"));
    }

    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0) {
            return List.of();
        }
        
        if (digits.length() == 1) {
            return MAPPING.get(digits.charAt(0));
        }

        char[] chars = digits.toCharArray();
        Deque<String> result = new LinkedList<>();

        for (char aChar : chars) {
            List<String> characters = MAPPING.get(aChar);

            if (result.size() == 0) {
                for (String ch : characters) {
                    result.offer(ch);
                }
            } else {
                int size = result.size();
                /*
                    Take out all elements from queue until length is less than desired,
                    and we need to do this for all elements which are in queue
                    before an iteration starts
                 */
                while (result.peek() != null && result.peek().length() < digits.length() && size > 0) {
                    String str = result.poll();
                    for (String character : characters) {
                        result.offer(str + character);
                    }
                    size--;
                }
            }
        }

        return new LinkedList<>(result);
    }
}
