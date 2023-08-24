package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _68_TextJustification {

    public static void main(String[] args) {
        _68_TextJustification obj = new _68_TextJustification();

        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        System.out.println(obj.fullJustify(words, maxWidth));
    }

    public List<String> fullJustify(String[] words, int maxWidth) {

        int i = 0;
        List<String> ans = new ArrayList<>();
        while (i < words.length) {
            List<String> line = getWordsPerLine(words, maxWidth, i);
            i += line.size();
            ans.add(formatLine(line, maxWidth, words, i));
        }
        return ans;
    }

    private List<String> getWordsPerLine(String[] words, int maxWidth, int i) {
        List<String> line = new ArrayList<>();
        int currLength = 0;

        while (i < words.length && currLength + words[i].length() <= maxWidth) {
            currLength += words[i].length() + 1;
            line.add(words[i]);
            i++;
        }
        return line;
    }

    private String formatLine(List<String> line, int maxWidth, String[] words, int j) {
        int length = -1;

        for (String str : line) {
            length += str.length() + 1;
        }

        int extraSpaces = maxWidth - length;

        if (line.size() == 1 || j == words.length) {
            return String.join(" ", line) + " ".repeat(extraSpaces);
        }

        int wordCount = line.size()-1;
        int spacePerWord = extraSpaces / wordCount;
        int moreExtraSpace = extraSpaces % wordCount;

        for (int i = 0; i < moreExtraSpace; i++) {
            line.set(i, line.get(i) + " ");
        }

        for (int i = 0; i < line.size()-1; i++) {
            line.set(i, line.get(i) + " ".repeat(spacePerWord));
        }
        return String.join(" ",  line);
    }
}
