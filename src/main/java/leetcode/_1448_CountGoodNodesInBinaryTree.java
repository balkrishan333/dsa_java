package leetcode;

import leetcode.common.BinaryTreeNode;

public class _1448_CountGoodNodesInBinaryTree {

    private int count;

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode().createTree(new Integer[]{3,1,4,3,null,1,5});

        _1448_CountGoodNodesInBinaryTree obj = new _1448_CountGoodNodesInBinaryTree();
        System.out.println(obj.goodNodes(root));
    }

    public int goodNodes(BinaryTreeNode root) {
        traverse(root, root.val);
        return count;
    }

    private void traverse(BinaryTreeNode node, int max) {
        if(node == null) {
            return;
        }

        if(node.val >= max) {
            count++;
            max = node.val;
        }
        traverse(node.left, max);
        traverse(node.right, max);
    }
}
