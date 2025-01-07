package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _1408_StringMatchingInAnArray {

    public static void main(String[] args) {
        _1408_StringMatchingInAnArray obj = new _1408_StringMatchingInAnArray();

        String[] words = {"mass","as","hero","superhero"};
        System.out.println(obj.stringMatching(words));
    }

    public List<String> stringMatching(String[] words) {
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            String pattern = words[i];

            for (int j = 0; j < words.length; j++) {
                if (i == j) {
                    continue;
                }
                String text = words[j];
                if (text.contains(pattern)) {
                    answer.add(pattern);
                    break;
                }
            }
        }
        return answer;
    }
}
