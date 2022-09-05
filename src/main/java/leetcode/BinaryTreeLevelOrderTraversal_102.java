package leetcode;

import leetcode.common.BinaryTreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal_102 {

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal_102 obj = new BinaryTreeLevelOrderTraversal_102();

        Integer[] input = {3,9,20,null,null,15,7};
        BinaryTreeNode root = new BinaryTreeNode().createTree(input);
        List<List<Integer>> levelOrder = obj.levelOrder(root);

        System.out.println(levelOrder);
    }

    public List<List<Integer>> levelOrder(BinaryTreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null) {
            return result;
        }

        Queue<BinaryTreeNode> nodes = new ArrayDeque<>();
        nodes.add(root);

        while(!nodes.isEmpty()) {
            List<Integer> vals = new ArrayList<>();
            int size = nodes.size();

            for(int i=0; i< size; i++) {
                BinaryTreeNode node = nodes.poll();

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
