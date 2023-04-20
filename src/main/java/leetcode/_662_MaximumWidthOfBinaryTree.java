package leetcode;

import leetcode.common.BinaryTreeNode;

import java.util.LinkedList;

public class _662_MaximumWidthOfBinaryTree {

    public static void main(String[] args) {
        _662_MaximumWidthOfBinaryTree obj = new _662_MaximumWidthOfBinaryTree();

        BinaryTreeNode root = new BinaryTreeNode().createTree(new Integer[]{1,3,2,5,null,null,9,6,null,7});
        System.out.println(obj.widthOfBinaryTree(root));
    }

    /*
        Approach: BFS with relabelling the value as index

        Traverse tree in BFS. Update the value of node as left.val= parent.val *2, right.val=parent.val*2+1. key is do this only for
        non-null nodes

        Before starting traversal at each level find the difference between index of first and last element and update max accordingly.
     */
    public int widthOfBinaryTree(BinaryTreeNode root) {

        if (root == null) {
            return 0;
        }

        LinkedList<BinaryTreeNode> queue = new LinkedList<>();
        root.val = 0;
        queue.add(root);

        int maxWidth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            maxWidth = Math.max(maxWidth, queue.peekLast().val - queue.peekFirst().val + 1);
            for (int i = 0; i < size; i++) {
                BinaryTreeNode node = queue.poll();
                if (node.left != null) {
                    node.left.val = node.val * 2;
                    queue.add(node.left);
                }

                if (node.right != null) {
                    node.right.val = node.val * 2 + 1;
                    queue.add(node.right);
                }
            }
        }
        return maxWidth;
    }
}
