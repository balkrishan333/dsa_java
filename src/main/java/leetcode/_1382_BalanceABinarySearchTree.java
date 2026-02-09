package leetcode;

import leetcode.common.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class _1382_BalanceABinarySearchTree {

    private List<Integer> inorderList = new ArrayList<>();

    public static void main(String[] args) {
        _1382_BalanceABinarySearchTree obj =
                new _1382_BalanceABinarySearchTree();

        BinaryTreeNode root = new BinaryTreeNode().createTree(new Integer[]{1,null,2,null,3,null,4,null,null});
        System.out.println(obj.balanceBST(root));
    }

    public BinaryTreeNode balanceBST(BinaryTreeNode root) {
        inorderTravesal(root);
        return createBalancedBST(0, inorderList.size() - 1);
    }

    private void inorderTravesal(BinaryTreeNode node) {
        if (node == null) {
            return;
        }

        inorderTravesal(node.left);
        inorderList.add(node.val);
        inorderTravesal(node.right);
    }

    private BinaryTreeNode createBalancedBST(int start, int end) {

        if (start > end ) {
            return null;
        }

        int mid = start + (end - start) / 2;
        BinaryTreeNode node = new BinaryTreeNode(inorderList.get(mid));
        node.left = createBalancedBST(start, mid - 1);
        node.right = createBalancedBST(mid + 1, end);

        return node;
    }
}
