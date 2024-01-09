package leetcode;

import leetcode.common.BinaryTreeNode;

public class _872_LeafSimilarTrees {

    public static void main(String[] args) {
        _872_LeafSimilarTrees obj = new _872_LeafSimilarTrees();

        BinaryTreeNode root1 = new BinaryTreeNode().createTree(new Integer[]{3,5,1,6,2,9,8,null,null,7,4});
        BinaryTreeNode root2 = new BinaryTreeNode().createTree(new Integer[]{3,5,1,6,7,4,2,null,null,null,null,null,null,9,8});

        System.out.println(obj.leafSimilar(root1, root2));
    }

    public boolean leafSimilar(BinaryTreeNode root1, BinaryTreeNode root2) {
        StringBuilder builder1 = new StringBuilder();
        StringBuilder builder2 = new StringBuilder();

        traverse(root1, builder1);
        traverse(root2, builder2);

        return builder1.toString().contentEquals(builder2.toString());
    }

    private void traverse(BinaryTreeNode node, StringBuilder seq) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
           seq.append("#");
           seq.append(node.val);
        }

        traverse(node.left, seq);
        traverse(node.right, seq);
    }
}
