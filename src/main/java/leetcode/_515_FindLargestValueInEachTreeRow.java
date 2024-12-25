package leetcode;

import leetcode.common.BinaryTreeNode;

import java.util.*;

public class _515_FindLargestValueInEachTreeRow {

    public static void main(String[] args) {
        _515_FindLargestValueInEachTreeRow obj = new _515_FindLargestValueInEachTreeRow();
        System.out.println(obj.largestValues(new BinaryTreeNode().createTree(new Integer[]{1,3,2,5,3,null,9})));
    }

    public List<Integer> largestValues(BinaryTreeNode root) {
        if (root == null) {
            return Collections.EMPTY_LIST;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<Integer> answer = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                BinaryTreeNode node = queue.poll();
                max = Math.max(max, node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            answer.add(max);
        }
        return answer;
    }
}
