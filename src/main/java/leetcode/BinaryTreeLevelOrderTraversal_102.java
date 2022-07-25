package leetcode;

import leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal_102 {

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal_102 obj = new BinaryTreeLevelOrderTraversal_102();

        Integer[] input = {3,9,20,null,null,15,7};
        TreeNode root = new TreeNode().createTree(input);
        List<List<Integer>> levelOrder = obj.levelOrder(root);

        System.out.println(levelOrder);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null) {
            return result;
        }

        Queue<TreeNode> nodes = new ArrayDeque<>();
        nodes.add(root);

        while(!nodes.isEmpty()) {
            List<Integer> vals = new ArrayList<>();
            int size = nodes.size();

            for(int i=0; i< size; i++) {
                TreeNode node = nodes.poll();

                if(node.left != null) {
                    nodes.add(node.left);
                }

                if(node.right != null) {
                    nodes.add(node.right);
                }

                vals.add(node.val);
            }
            result.add(vals);
        }
        return result;
    }
}
