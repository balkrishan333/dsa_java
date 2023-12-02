package leetcode;

public class _1160_FindWordsThatCanBeFormedByCharacters {

    public static void main(String[] args) {
        _1160_FindWordsThatCanBeFormedByCharacters obj = new _1160_FindWordsThatCanBeFormedByCharacters();

        String[] words = {"cat","bt","hat","tree"};
        String chars = "atach";

        System.out.println(obj.countCharacters(words, chars));
    }

    public int countCharacters(String[] words, String chars) {
        int[] charsCount = new int[26];
        for (char ch : chars.toCharArray()) {
            charsCount[ch-'a']++;
        }

        int answer = 0;
        for (String word : words) {
            int[] wordCharCount = new int[26];
            for (char ch : word.toCharArray()) {
                wordCharCount[ch-'a']++;
            }

            boolean consider = true;
            for (int i = 0; i < 26; i++) {
                if (wordCharCount[i] > charsCount[i]) {
                    consider = false;
                    break;
                }
            }

            if (consider) {
                answer += word.length();
            }
        }
        return answer;
    }
}
