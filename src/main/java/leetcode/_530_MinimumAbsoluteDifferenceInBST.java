package leetcode;

import leetcode.common.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class _530_MinimumAbsoluteDifferenceInBST {

    public static void main(String[] args) {
        _530_MinimumAbsoluteDifferenceInBST obj = new _530_MinimumAbsoluteDifferenceInBST();

        BinaryTreeNode root = new BinaryTreeNode().createTree(new Integer[]{1,0,48,null,null,12,49});
        System.out.println(obj.getMinimumDifference(root));
    }

    //since given tree is a BST, we cna use list otherwise we need to use Priority Queue
    private final List<Integer> list = new ArrayList<>();

    /*
        Approach: Inorder traversal with list
     */
    public int getMinimumDifference(BinaryTreeNode root) {
        inorderTraversal(root);


        int answer = Integer.MAX_VALUE;

        for (int i = 1; i < list.size(); i++) {
            answer = Math.min(answer, list.get(i) - list.get(i-1));
        }
        return answer;
    }

    private void inorderTraversal(BinaryTreeNode node) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left);
        list.add(node.val);
        inorderTraversal(node.right);
    }
}
