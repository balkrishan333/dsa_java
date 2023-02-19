package leetcode;

import leetcode.common.BinaryTreeNode;

import java.util.*;

public class _103_BinaryTreeZigzagLevelOrderTraversal {

    public static void main(String[] args) {
        _103_BinaryTreeZigzagLevelOrderTraversal obj = new _103_BinaryTreeZigzagLevelOrderTraversal();

        BinaryTreeNode root = new BinaryTreeNode().createTree(new Integer[]{3,9,20,null,null,15,7});
        System.out.println(obj.zigzagLevelOrder(root));
    }

    public List<List<Integer>> zigzagLevelOrder(BinaryTreeNode root) {
        if (root == null) {
            return  new ArrayList<>();
        }

        List<List<Integer>> answer = new ArrayList<>();
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();

            while (size-- > 0) {
                BinaryTreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (!leftToRight) {
                Collections.reverse(list);

            }
            answer.add(list);

            leftToRight = !leftToRight;
        }
        return answer;
    }
}
