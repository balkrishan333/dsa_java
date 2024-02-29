package leetcode;

import leetcode.common.BinaryTreeNode;

import java.util.LinkedList;
import java.util.List;

public class _1609_EvenOddTree {

    public static void main(String[] args) {
        _1609_EvenOddTree obj = new _1609_EvenOddTree();

        BinaryTreeNode root = new BinaryTreeNode().createTree(new Integer[]{1,10,4,3,null,7,9,12,8,6,null,null,2});
        System.out.println(obj.isEvenOddTree(root));
    }

    public boolean isEvenOddTree(BinaryTreeNode root) {
        if (root == null) {
            return true;
        }

        List<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean valueShouldBeOdd = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            valueShouldBeOdd = !valueShouldBeOdd; //switch the flag

            int prev = -1;
            while (size > 0) {
                BinaryTreeNode node = queue.removeFirst();
                if (valueShouldBeOdd) {
                    if (node.val % 2 == 0 || (prev != -1 && node.val <= prev)) {
                        return false;
                    }
                } else {
                    if (node.val % 2 == 1 || (prev != -1 && node.val >= prev)) {
                        return false;
                    }
                }
                prev = node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
                size--;
            }
        }
        return true;
    }
}
