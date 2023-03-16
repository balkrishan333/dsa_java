package leetcode;

import leetcode.common.BinaryTreeNode;

import java.util.HashMap;
import java.util.Map;

public class _106_ConstructBinaryTreeFromInorderAndPostorderTraversal {

    private final Map<Integer, Integer> postOrderMap = new HashMap<>();

    public static void main(String[] args) {
//        int[] inorder = {9,3,15,20,7}, postorder = {9,15,7,20,3};
        int[] inorder = {3,2,1}, postorder = {3,2,1};
        _106_ConstructBinaryTreeFromInorderAndPostorderTraversal obj = new _106_ConstructBinaryTreeFromInorderAndPostorderTraversal();

        System.out.println(obj.buildTree(inorder, postorder));
    }

    /*
        Approach:

        In post order traversal root is at the end. Take last element in post order as root, find the index of that
        element in inorder array, all elements to left root in inorder array are left subtree and all elements to right
        of root in inorder array are right subtree.

        Tricky part is to figure out the correct index of root in postorder array.

        See buildTree_v1 -- It uses linear search, solution works but times out for huge input. When we use map for
        postorder index, it passes but run time is very high. It beats only 5%

        So, we need a smart way to figure out the index of root in post order array. See inline comments for details
        about how to do it.
     */
    public BinaryTreeNode buildTree(int[] inorder, int[] postorder) {

        //use map to store index of inorder elements. This will avoid linear search when we need to find index of
        //root in inorder array to figure out left and right subtrees.
        Map<Integer, Integer> inorderIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndex.put(inorder[i], i);
        }

        int postStart = 0;
        int inStart = 0;
        int postEnd = postorder.length-1;
        int inEnd = inorder.length-1;

        return buildTree(postStart, postEnd, inStart, inEnd, postorder, inorderIndex);

    }

    private BinaryTreeNode buildTree(int postStart, int postEnd, int inStart, int inEnd, int[] postorder,
                                     Map<Integer, Integer> map) {

        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }

        BinaryTreeNode root = new BinaryTreeNode(postorder[postEnd]);
        int rootPosition = map.get(root.val); //find position of root in inorder array to detect left and right subtrees
        int numbersLeft = rootPosition - inStart; // find number of elements in left subtree

        /*
           inStart and inEnd are fairly straight forward to figure out. Leave the root, left start to root-1 is left subtree and root+1
           to end is right subtree.

           Tricky part is postStart and postEnd. This is not very tricky, if you understand how postorder array is organized. postorder
           array contains left subtree then right subtree and then root. once you know number of elements in left subtree, take that many
           elements from postorder array for left subtree and rest for right subtree
         */

        // for postEnd -1 is required to exclude the current node (root)
        root.left =  buildTree(postStart, postStart+ numbersLeft-1, inStart, rootPosition-1, postorder,map);
        root.right = buildTree(postStart+numbersLeft, postEnd-1, rootPosition+1, inEnd, postorder,map);

        return root;
    }

    public BinaryTreeNode buildTree_v1(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length) {
            return null;
        }

        if (inorder.length == 0) {
            return null;
        }
        for (int i = 0; i < postorder.length; i++) {
            postOrderMap.put(postorder[i], i);
        }
        return buildTree(inorder, postorder, 0, postorder.length-1);
    }

    private BinaryTreeNode buildTree(int[] inorder, int[] postorder, int left, int right) {
        if (left == right) {
            return new BinaryTreeNode(inorder[left]);
        }

        if (left > right) {
            return null;
        }

        int rootIndex = maxIndex(postorder, inorder, left, right);
        BinaryTreeNode root = new BinaryTreeNode(postorder[rootIndex]);
        int index = findElementInArr(inorder, root.val);

        root.right = buildTree(inorder, postorder, index+1, right);
        root.left = buildTree(inorder, postorder, left, index-1);

        return root;
    }

    private int findElementInArr(int[] arr, int element) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                return i;
            }
        }
        return -1;
    }

    private int maxIndex(int[] postorder, int[] inorder, int left, int right) {
        int max = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
//            max = Math.max(max, findElementInArr(postorder, inorder[i]));
            max = Math.max(max, postOrderMap.get(inorder[i]));
        }
        return max;
    }
}
