package leetcode;

import leetcode.common.BinaryTreeNode;

import java.util.*;

public class _2471_MinimumNumberOfOperationsToSortABinaryTreeByLevel {

    public static void main(String[] args) {
        _2471_MinimumNumberOfOperationsToSortABinaryTreeByLevel obj = new _2471_MinimumNumberOfOperationsToSortABinaryTreeByLevel();
        System.out.println(obj.minimumOperations(new BinaryTreeNode().createTree(new Integer[]{1,4,3,7,6,8,5,null,null,null,null,9,null,10})));
    }

    /*
        Approach:

        If elements are not at their correct position, there will be a cycle. we need to find the cycle size.
        No. of swaps required = cycle size - 1

        1. Find elements at each level.
        2. Find swaps required to sort elements at each level.
        3. Return total swaps.
     */

    public int minimumOperations(BinaryTreeNode root) {
        int swaps = 0;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int[] elements = findElementsAtLevel(queue, size);
            swaps += findSwaps(elements);
        }
        return swaps;
    }

    private int findSwaps(int[] elements) {
        SortedMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < elements.length; i++) {
            treeMap.put(elements[i], i);
        }
        Arrays.sort(elements);
        boolean[] visited = new boolean[elements.length];
        int iterations = 0;

        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            int index = entry.getValue();
            if (visited[index] || index == entry.getKey()) {
                //element at its correct position or already visited
                continue;
            }
            int cycleSize = 0;
            int j = index;
            while (!visited[j]) {
                visited[j] = true;
                j = treeMap.get(elements[j]);
                cycleSize++;
            }
            if (cycleSize > 0) {
                iterations += cycleSize - 1;
            }
        }
        return iterations;
    }

    private int[] findElementsAtLevel(Queue<BinaryTreeNode> queue, int size) {
        int[] elements = new int[size];
        for (int i = 0; i < size; i++) {
            BinaryTreeNode node = queue.poll();
            elements[i] = node.val;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return elements;
    }
}
