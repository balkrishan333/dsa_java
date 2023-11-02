package leetcode;

import leetcode.common.BinaryTreeNode;

public class _2265_CountNodesEqualToAverageOfSubtree {

    public static void main(String[] args) {
        _2265_CountNodesEqualToAverageOfSubtree obj = new _2265_CountNodesEqualToAverageOfSubtree();

        BinaryTreeNode root = new BinaryTreeNode().createTree(new Integer[]{4,8,5,0,1,null,6});
        System.out.println(obj.averageOfSubtree(root));
    }

    private int count = 0;
    public int averageOfSubtree(BinaryTreeNode root) {
        traverseTree(root);
        return this.count;
    }

    private NodeStatus traverseTree(BinaryTreeNode node) {
        if (node == null) {
            return null;
        }

        NodeStatus left = traverseTree(node.left);
        NodeStatus right = traverseTree(node.right);

        int sum = node.val, count = 1;

        if (left != null) {
            sum = sum + left.sum;
            count = count + left.count;
        }

        if (right != null) {
            sum = sum + right.sum;
            count = count + right.count;
        }

        if (Math.floor((double) sum / count) == node.val) {
            this.count++;
        }

        return new NodeStatus(sum, count);
    }

    static class NodeStatus {
        int sum;
        int count;

        NodeStatus(int sum, int count) {
            this.sum = sum;
            this.count = count;
        }
    }
}
