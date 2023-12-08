package leetcode;

import leetcode.common.BinaryTreeNode;

public class _606_ConstructStringFromBinaryTree {

    public static void main(String[] args) {
        _606_ConstructStringFromBinaryTree obj = new _606_ConstructStringFromBinaryTree();

        BinaryTreeNode root = new BinaryTreeNode().createTree(new Integer[]{1,2,3,null,4});
        System.out.println(obj.tree2str(root));
    }

    public String tree2str(BinaryTreeNode root) {
       StringBuilder sb = new StringBuilder();
       preorder(root, sb);

       return sb.substring(1, sb.length()-1);
    }

    private void preorder(BinaryTreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }

        sb.append("(").append(node.val);
        if (node.left == null && node.right != null) {
            sb.append("()");
        }
        preorder(node.left, sb);
        preorder(node.right, sb);
        sb.append(")");
    }
}
