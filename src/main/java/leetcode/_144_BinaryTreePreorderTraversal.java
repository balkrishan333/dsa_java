package leetcode;

import leetcode.common.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class _144_BinaryTreePreorderTraversal {

    private final List<Integer> preOrder = new ArrayList<>();

    public static void main(String[] args) {
        _144_BinaryTreePreorderTraversal obj = new _144_BinaryTreePreorderTraversal();
        BinaryTreeNode root = new BinaryTreeNode().createTree(new Integer[]{1, null, 2,3});

        System.out.println(obj.preorderTraversal(root));
    }

    public List<Integer> preorderTraversal(BinaryTreeNode root) {
        if (root == null) {
            return preOrder;
        }

        preOrder.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);

        return preOrder;
    }
}
