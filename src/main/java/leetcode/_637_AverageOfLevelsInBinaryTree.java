package leetcode;

import leetcode.common.BinaryTreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _637_AverageOfLevelsInBinaryTree {

    public static void main(String[] args) {
        _637_AverageOfLevelsInBinaryTree obj = new _637_AverageOfLevelsInBinaryTree();
        BinaryTreeNode root = new BinaryTreeNode().createTree(new Integer[]{3,9,20,null,null,15,7});

        System.out.println(obj.averageOfLevels(root));
    }

    public List<Double> averageOfLevels(BinaryTreeNode root) {

        if (root == null) {
            return null;
        }

        List<Double> result = new ArrayList<>();
        Deque<BinaryTreeNode> que = new ArrayDeque<>();
        que.add(root);

        while (!que.isEmpty()) {
            int size = que.size();
            int x=0;
            double sum=0;

            while (x < size) {
                BinaryTreeNode node = que.poll();
                sum += node.val;
                if (node.left != null) {
                    que.add(node.left);
                }

                if (node.right != null) {
                    que.add(node.right);
                }
                x++;
            }
            result.add(sum/size);
        }
        return result;
    }
}
