package leetcode;

import java.util.*;

public class _3016_MinimumNumberOfPushesToTypeWord_II {

    public static void main(String[] args) {
        _3016_MinimumNumberOfPushesToTypeWord_II obj = new _3016_MinimumNumberOfPushesToTypeWord_II();

        String word = "aabbccddeeffgghhiiiiii";
        System.out.println(obj.minimumPushes(word));
    }

    public int minimumPushes(String word) {
        Map<Character, Integer> frequency = new HashMap<>();
        for (char ch : word.toCharArray()) {
            frequency.merge(ch, 1, Integer::sum);
        }
        List<CharFrequency> list = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {
            list.add(new CharFrequency(entry.getKey(), entry.getValue()));
        }

        list.sort((item1, item2) -> Integer.compare(item2.frequency, item1.frequency));

        int minPushes = 0;
        for (int i = 0; i < list.size(); i++) {
            if (i < 8) {
                minPushes += list.get(i).frequency;
            } else if (i < 16) {
                minPushes += (list.get(i).frequency * 2);
            } else if (i < 24) {
                minPushes += (list.get(i).frequency * 3);
            } else {
                minPushes += (list.get(i).frequency * 4);
            }
        }
        return minPushes;
    }

    static class CharFrequency {
        char ch;
        int frequency;

        CharFrequency(char ch, int frequency) {
            this.ch = ch;
            this.frequency = frequency;
        }
    }
}
