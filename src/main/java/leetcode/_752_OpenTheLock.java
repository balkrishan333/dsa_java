package leetcode;

import java.util.*;

public class _752_OpenTheLock {

    public static void main(String[] args) {
        _752_OpenTheLock obj = new _752_OpenTheLock();
        String[] deadends = {"8887","8889","8878","8898","8788","8988","7888","9888"};
        String target = "8888";

        System.out.println(obj.openLock(deadends, target));
    }

    public int openLock(String[] deadends, String target) {
        Map<Character, Character> next_char = Map.of('1', '2',
                '2', '3',
                '3', '4',
                '4', '5',
                '5', '6',
                '6', '7',
                '7', '8',
                '8', '9',
                '9', '0',
                '0', '1');

        Map<Character, Character> prev_char = Map.of('2', '1',
                '3', '2',
                '4', '3',
                '5', '4',
                '6', '5',
                '7', '6',
                '8', '7',
                '9', '8',
                '0', '9',
                '1', '0');

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));

        if (visited.contains("0000")) {
            return -1;
        }

        queue.add("0000");
        visited.add("0000");
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int j = 0; j < size; j++) {
                String currentPattern = queue.poll();

                if (currentPattern.equals(target)) {
                    return steps;
                }

                for (int i = 0; i < 4; i++) {
                    // Generate the new combination by turning the i to the next digit.
                    StringBuilder newCombination = new StringBuilder(currentPattern);
                    newCombination.setCharAt(i, next_char.get(newCombination.charAt(i)));

                    if (!visited.contains(newCombination.toString())) {
                        queue.add(newCombination.toString());
                        visited.add(newCombination.toString());
                    }

                    // Generate the new combination by turning the i to the previous digit.
                    newCombination = new StringBuilder(currentPattern);
                    newCombination.setCharAt(i, prev_char.get(newCombination.charAt(i)));

                    if (!visited.contains(newCombination.toString())) {
                        queue.add(newCombination.toString());
                        visited.add(newCombination.toString());
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
