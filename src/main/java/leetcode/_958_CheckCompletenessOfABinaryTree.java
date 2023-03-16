package leetcode;

import leetcode.common.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _958_CheckCompletenessOfABinaryTree {

    public static void main(String[] args) {
        _958_CheckCompletenessOfABinaryTree obj = new _958_CheckCompletenessOfABinaryTree();

//        BinaryTreeNode root = new BinaryTreeNode().createTree(new Integer[]{1,2,3,null,null,4,5});
//        BinaryTreeNode root = new BinaryTreeNode().createTree(new Integer[]{1,2,3,4,5,6});
        BinaryTreeNode root = new BinaryTreeNode().createTree(new Integer[]{1,null,2});
        System.out.println(obj.isCompleteTree(root));
    }

    public boolean isCompleteTree(BinaryTreeNode root) {
        if (root == null) {
            return true;
        }

        boolean nullFound = false;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();

            if (node == null) {
                nullFound = true;
            } else {
                if (nullFound) {
                    return false;
                }
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return true;
    }
}
