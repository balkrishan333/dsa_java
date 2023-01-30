package leetcode;

import java.util.*;

public class _472_ConcatenatedWords {

    private final List<String> answer = new ArrayList<>();

    public static void main(String[] args) {
        _472_ConcatenatedWords obj = new _472_ConcatenatedWords();

        String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        System.out.println(obj.findAllConcatenatedWordsInADict(words));
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> dict = new HashSet<>(Arrays.asList(words));

        for (String word : words) {
            boolean[] visited = new boolean[word.length()+1]; // we need to store values for length of string, so +1
            if (traverse(word, dict, 0, visited)) {
                answer.add(word);
            }
        }
        return answer;
    }

    private boolean traverse(String word, Set<String> dict, int length, boolean[] visited) {
        if (length == word.length()) {
            return true;
        }

        if (visited[length]) {
            return false;
        }

        visited[length] = true;
        int endIndex = length == 0 ? 1 : 0; //leave last character out
        for (int i = word.length()-endIndex; i > length; i--) {
            String substr = word.substring(length, i);
            if (dict.contains(substr) && traverse(word, dict, i, visited)) {
                return true;
            }
        }
        return false;
    }
}
