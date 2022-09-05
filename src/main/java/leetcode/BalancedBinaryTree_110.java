package leetcode;

import leetcode.common.BinaryTreeNode;

public class BalancedBinaryTree_110 {

    public static void main(String[] args) {
        BalancedBinaryTree_110 obj = new BalancedBinaryTree_110();
        Integer[] input = {1,2,3,4,5,6,null,8};
        BinaryTreeNode root = new BinaryTreeNode().createTree(input);

        System.out.println(obj.isBalanced(root));
    }

    public boolean isBalanced(BinaryTreeNode root) {

        if(root == null) {
            return true;
        }

        HeightBalanced left = height(root.left);
        HeightBalanced right = height(root.right);

        return left.isBalanced && right.isBalanced && Math.abs(left.height-right.height) < 2;
    }

    private HeightBalanced height(BinaryTreeNode node) {
        if(node == null) {
            return new HeightBalanced(0, true);
        }

        HeightBalanced left = height(node.left);
        HeightBalanced right = height(node.right);

        boolean isBalanced = left.isBalanced && right.isBalanced && Math.abs(left.height-right.height) < 2;

        HeightBalanced node1 = new HeightBalanced(Math.max(left.height, right.height) +1, isBalanced);

        return node1;
    }

    class HeightBalanced {
        int height;
        boolean isBalanced;

        HeightBalanced(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }
}
