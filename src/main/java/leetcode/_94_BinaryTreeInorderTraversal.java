package leetcode;

import leetcode.common.BinaryTreeNode;

import java.util.LinkedList;
import java.util.List;

public class _94_BinaryTreeInorderTraversal {

    public static void main(String[] args) {
        _94_BinaryTreeInorderTraversal obj = new _94_BinaryTreeInorderTraversal();

        BinaryTreeNode root = new BinaryTreeNode().createTree(new Integer[]{1,null,2,3});
        System.out.println(obj.inorderTraversal(root));
    }

    public List<Integer> inorderTraversal(BinaryTreeNode root) {
       List<Integer> answer = new LinkedList<>();
       traverse(root, answer);
       return answer;
    }

    private void traverse(BinaryTreeNode node, List<Integer> answer) {
        if (node == null) {
            return;
        }

        traverse(node.left, answer);
        answer.add(node.val);
        traverse(node.right, answer);
    }
}
