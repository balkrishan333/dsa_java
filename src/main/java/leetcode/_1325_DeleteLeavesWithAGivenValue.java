package leetcode;

import leetcode.common.BinaryTreeNode;

public class _1325_DeleteLeavesWithAGivenValue {

    public static void main(String[] args) {
        _1325_DeleteLeavesWithAGivenValue obj = new _1325_DeleteLeavesWithAGivenValue();

        BinaryTreeNode root = new BinaryTreeNode().createTree(new Integer[]{1,2,3,2,null,2,4});
        int target = 2;
        System.out.println(obj.removeLeafNodes(root, target));
    }

    public BinaryTreeNode removeLeafNodes(BinaryTreeNode root, int target) {
        if (root == null) {
            return null;
        }

        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);

        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }
        return root;
    }
}
