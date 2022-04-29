package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SmallestSubStringWithSwaps_1202 {

    private static final int MAX_LENGTH = 100000;
    private List<Integer>[] adjacencyList = new ArrayList[MAX_LENGTH];
    private boolean[] visited = new boolean[MAX_LENGTH];

    public static void main(String[] args) {
        SmallestSubStringWithSwaps_1202 obj = new SmallestSubStringWithSwaps_1202();
        String s = "dcab";
        List<List<Integer>> pairs = new ArrayList<>();

        List<Integer> l1 = List.of(0,3);
        List<Integer> l2 = List.of(1,2);
        List<Integer> l3 = List.of(0,2);

        pairs.add(l1);
        pairs.add(l2);
        pairs.add(l3);

        System.out.println(obj.smallestStringWithSwaps(s, pairs));
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        prepareAdjacencyList(s, pairs);

        char[] answer = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {

            if (!visited[i]) {
                List<Character> characters = new ArrayList<>();
                List<Integer> indices = new ArrayList<>();
                DFS(s, i, characters, indices);

                Collections.sort(characters);
                Collections.sort(indices);

                for (int j = 0; j < characters.size(); j++) {
                    answer[indices.get(j)] = characters.get(j);
                }
            }
        }
        return new String(answer);
    }

    private void DFS(String s, int i, List<Character> characters, List<Integer> indices) {
        characters.add(s.charAt(i));
        indices.add(i);

        visited[i] = true;

        for (Integer adjacentVertices : adjacencyList[i]) {
            if (!visited[adjacentVertices]) {
                DFS(s, adjacentVertices, characters, indices);
                visited[adjacentVertices] = true;
            }
        }
    }

    private void prepareAdjacencyList(String s, List<List<Integer>> pairs) {

        for (int i = 0; i < s.length(); i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (List<Integer> pair : pairs) {
            int source = pair.get(0);
            int destination = pair.get(1);

            adjacencyList[source].add(destination);
            adjacencyList[destination].add(source);
        }
    }
}
