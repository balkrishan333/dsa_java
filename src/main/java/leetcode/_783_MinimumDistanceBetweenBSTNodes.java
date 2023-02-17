package leetcode;

import leetcode.common.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class _783_MinimumDistanceBetweenBSTNodes {

    private final List<Integer> inorder = new ArrayList<>();

    public static void main(String[] args) {
        _783_MinimumDistanceBetweenBSTNodes obj = new _783_MinimumDistanceBetweenBSTNodes();

        BinaryTreeNode root = new BinaryTreeNode().createTree(new Integer[]{90,69,null,49,89,null,52});
        System.out.println(obj.minDiffInBST(root));
    }

    /*
        Approach: Inorder traversal will give list in sorted order. Find difference between
        consecutive elements and find min.

        if we try to find difference between only parent and child, following test case fails:
        {90,69,null,49,89,null,52}. Answer should be 1 but return would be 3.
     */
    public int minDiffInBST(BinaryTreeNode root) {
        inorderTraverse(root);

        int min = Integer.MAX_VALUE;
        for(int i=1; i < inorder.size(); i++) {
            min = Math.min((inorder.get(i) - inorder.get(i-1)), min);
        }

        return min;
    }

    private void inorderTraverse(BinaryTreeNode node) {
        if(node == null) {
            return;
        }

        inorderTraverse(node.left);
        inorder.add(node.val);
        inorderTraverse(node.right);
    }
}
