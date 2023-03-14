package leetcode;

import leetcode.common.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class _129_SumRootToLeafNumbers {

    private final List<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) {
        _129_SumRootToLeafNumbers obj = new _129_SumRootToLeafNumbers();

        BinaryTreeNode root = new BinaryTreeNode().createTree(new Integer[]{4});
        System.out.println(obj.sumNumbers(root));
    }

    public int sumNumbers(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }

        preorder(root, new StringBuilder());
//        System.out.println(numbers);
        return numbers.stream().mapToInt(num-> num).sum();
    }

    private void preorder(BinaryTreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }

        StringBuilder curr = sb.append(node.val);
        if (node.left == null && node.right == null && sb.length() > 0) {
            numbers.add(Integer.parseInt(sb.toString()));
        }
        preorder(node.left, new StringBuilder(curr));
        preorder(node.right, new StringBuilder(curr));
    }
}
