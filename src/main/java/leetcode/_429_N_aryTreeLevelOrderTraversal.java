package leetcode;

import leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _429_N_aryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = createNAryTree();

        _429_N_aryTreeLevelOrderTraversal obj = new _429_N_aryTreeLevelOrderTraversal();
        System.out.println(obj.levelOrder(root));
    }

    private static TreeNode createNAryTree() {
        TreeNode root = new TreeNode(1);

        TreeNode node1 = new TreeNode(3);

        {
            TreeNode node4 = new TreeNode(5);
            TreeNode node5 = new TreeNode(6);

            node1.children = List.of(node4, node5);
        }
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(4);

        root.children = List.of(node1, node2, node3);
        return root;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int i =0;
            List<Integer> level = new ArrayList<>();
            while (i < size) {
                TreeNode node = queue.poll();
                level.add(node.val);
                pushChildrenToQueue(node, queue);
                i++;
            }
            result.add(level);
        }

        return result;
    }

    private void pushChildrenToQueue(TreeNode node, Deque<TreeNode> queue) {

        if (node == null || node.children == null || node.children.size() == 0) {
            return;
        }

        for (TreeNode child : node.children) {
            if (child != null) {
                queue.add(child);
            }
        }
    }
}
