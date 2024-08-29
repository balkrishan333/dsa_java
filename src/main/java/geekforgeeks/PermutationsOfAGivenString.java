package geekforgeeks;

import java.util.*;

public class PermutationsOfAGivenString {

    public static void main(String[] args) {
        PermutationsOfAGivenString obj = new PermutationsOfAGivenString();

        String s = "AABC";
        System.out.println(obj.find_permutation(s));
    }

    public List<String> find_permutation(String S) {
        Set<String> permutations = new HashSet<>();
        findAllPermutations(S.toCharArray(), permutations, 0);
        List<String> list = new ArrayList<>(permutations);
        Collections.sort(list);
        return list;
    }

    private void findAllPermutations(char[] s, Set<String> permutations, int startIndex) {
        if (startIndex == s.length -1) {
            permutations.add(new String(s));
            return;
        }

        for (int i = startIndex; i < s.length; i++) {
           swap(s, i, startIndex);
           findAllPermutations(s, permutations, startIndex+1);
           swap (s, i, startIndex);
        }
    }

    private void swap(char[] s, int index1, int index2) {
        char ch = s[index1];
        s[index1] = s[index2];
        s[index2] = ch;
    }
}
