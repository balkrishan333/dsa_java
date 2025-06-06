package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _2434_UsingARobotToPrintTheLexicographicallySmallestString {

    public static void main(String[] args) {
        _2434_UsingARobotToPrintTheLexicographicallySmallestString obj = new _2434_UsingARobotToPrintTheLexicographicallySmallestString();
        String s = "zza";
        System.out.println(obj.robotWithString(s));
    }

    /*
        Approach: Count the occurrences of each character. Start with minimum char as 'a'
        Push each char into stack and reduce the count (to indicate char has been processed).

        if count of minimum char reaches zero, move to next character (increment minimum character by 1)

        pop from stack till top is less than equal to minimum character.
     */
    public String robotWithString(String s) {

        //count the occurrences of each char
        char[] charArray = s.toCharArray();

        int[] charCount = new int[26];
        for (char ch : charArray) {
            charCount[ch-'a']++;
        }

        StringBuilder result = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        char minimumChar = 'a';

        for (char ch : charArray) {
            stack.push(ch);
            charCount[ch-'a']--;

            while (minimumChar != 'z' && charCount[minimumChar-'a'] == 0) {
                minimumChar++;
            }

            while (!stack.isEmpty() && stack.peek() <= minimumChar) {
                result.append(stack.pop());
            }
        }
        return result.toString();
    }
}
