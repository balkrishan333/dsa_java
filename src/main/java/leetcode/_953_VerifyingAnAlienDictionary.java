package leetcode;

public class _953_VerifyingAnAlienDictionary {

    public static void main(String[] args) {
        _953_VerifyingAnAlienDictionary obj = new _953_VerifyingAnAlienDictionary();

        String[] words = {"hello","leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";

        System.out.println(obj.isAlienSorted(words, order));
    }

    public boolean isAlienSorted(String[] words, String order) {
        int[] ordinals = new int[26];

        int i = 0;
        for (char ch : order.toCharArray()) {
            ordinals[ch-'a'] = i++;
        }

        for (int j = 1; j < words.length; j++) {
            String w1 = words[j-1];
            String w2 = words[j];

            for (int k = 0; k < w1.length(); k++) {

                //if all characters are in order so far but 2nd string is shorter than return false
                //as 2ns string should come before the first. Ex: w1 - apple, w2 - app
                if (k == w2.length()) {
                    return false;
                }

                int o1 = ordinals[w1.charAt(k)-'a'];
                int o2 = ordinals[w2.charAt(k)-'a'];

                //if characters not in order, return false as words are not in order
                if (o1 > o2) {
                    return false;
                }

                //if characters are in order, break and move to next set of strings, else if they are equal continue to
                //next character
                if (o1 < o2) {
                    break;
                }
            }
        }
        return true;
    }
}
