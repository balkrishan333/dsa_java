package leetcode;

import java.util.Arrays;

public class _859_BuddyStrings {

    public static void main(String[] args) {
        _859_BuddyStrings obj = new _859_BuddyStrings();

        String s = "ab", goal  = "ba";
        System.out.println(obj.buddyStrings(s, goal));
    }

    /*
        Approach: Two strings should differ at max 2 positions and character count should be same in both strings.

        If 2 strings are equal, there needs to be at least 1 character whose frequency is more than 1, so that we can swap that character
         with itself. If this happens return true.
     */
    public boolean buddyStrings(String s, String goal) {

        //if length of strings are not equals they can never be made equal with 1 swap
        if (s.length() != goal.length()) {
            return false;
        }

        int[] frequency = new int[26];

        if (s.equals(goal)) {
            //if 2 strings are equal, return true if there exists at least 1 character whose frequency is more than 1, we can swap that
            // character with itself, return true
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                frequency[ch-'a']++;
                if (frequency[ch-'a'] >= 2) {
                    return true;
                }
            }
            return false;
        }

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = goal.charAt(i);

            //count frequency of each character. increase by 1 over one and decrease by 1 over 2nd array, so that at end, of characters
            // are same frequency of each char will be 0
            frequency[ch1-'a']++;
            frequency[ch2-'a']--;

            if (ch1 != ch2) {
                //increase the count of character don't match at given index
                count++;
                if (count > 2) {
                    //if count is more than 2, we can't make 2 strings equal with single swap.
                    return false;
                }
            }
        }

        //if characters are not same in both strings,  we can't make 2 strings equal with single swap.
        if (Arrays.stream(frequency).filter(val -> val > 0).count() != 0) {
            return false;
        }

        //if only 2 chars differ in their position, strings can be made equal with single swap
        return count == 2;
    }
}
