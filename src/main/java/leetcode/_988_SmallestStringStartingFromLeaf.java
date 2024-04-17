package leetcode;

import leetcode.common.BinaryTreeNode;

public class _988_SmallestStringStartingFromLeaf {

    public static void main(String[] args) {
        _988_SmallestStringStartingFromLeaf obj = new _988_SmallestStringStartingFromLeaf();

        BinaryTreeNode root = new BinaryTreeNode().createTree(new Integer[]{0,1,2,3,4,3,4});
        System.out.println(obj.smallestFromLeaf(root));
    }

    public String smallestFromLeaf(BinaryTreeNode root) {
        inorderTraversal(root, "");
        return answer;
    }

    private String answer;
    private void inorderTraversal(BinaryTreeNode node, String string) {

        if (node == null) {
            return;
        }
        char ch = (char) (node.val + 97);
        string = ch + string;
        if (node.left == null && node.right == null) {
            if (answer == null || answer.compareTo(string) > 0) {
                answer = string;
            }
        }
        if (node.left != null) {
            inorderTraversal(node.left, string);
        }

        if (node.right != null) {
            inorderTraversal(node.right, string);
        }
    }
}
