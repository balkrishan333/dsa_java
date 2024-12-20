package leetcode;

import leetcode.common.BinaryTreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _2415_ReverseOddLevelsOfBinaryTree {

    public static void main(String[] args) {
        _2415_ReverseOddLevelsOfBinaryTree obj = new _2415_ReverseOddLevelsOfBinaryTree();
        BinaryTreeNode root = new BinaryTreeNode().createTree(new Integer[]{2,3,5,8,13,21,34});
        BinaryTreeNode reversedRoot = obj.reverseOddLevels(root);
        System.out.println(reversedRoot);
    }

    private final List<Integer> list = new LinkedList<>();

    public BinaryTreeNode reverseOddLevels(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        reverseOddLevelsUtil(root);
        return buildReversedTree();
    }

    private BinaryTreeNode buildReversedTree() {
        BinaryTreeNode root = new BinaryTreeNode(list.get(0));
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;

        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();

            if (i < list.size()) {
                node.left = new BinaryTreeNode(list.get(i++));
                queue.offer(node.left);
            }

            if (i < list.size()) {
                node.right = new BinaryTreeNode(list.get(i++));
                queue.offer(node.right);
            }
        }

        return root;
    }

    private void reverseOddLevelsUtil(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            List<Integer> levelList = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                BinaryTreeNode node = queue.poll();
                levelList.add(node.val);

                if (node.left != null && node.right != null) {
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }

            if (level % 2 == 1) {
                levelList = levelList.reversed();
            }
            list.addAll(levelList);
        }
    }
}
