package com.nagpal.bala.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*
        Populating Next Right Pointers in Each Node: https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/994/
        Populating Next Right Pointers in Each Node2: https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/1016/
 */

public class NextRightPointer {

    private static final Integer[] input = {1,2,3,4,5,null,7};

    public static void main(String[] args) {
        TreeNode root = new TreeNode().createTree(input);
        TreeNode result = connect(root);
        System.out.println("result = " + result);
    }

    /*
        Algo: Similar to BFS (Breadth first search)
        1. Add non-null children of root to queue. Don't add root because there is nothing to right of it
        2. Iterate over queue until its empty
        2.1 Note current size of queue. current size depicts the no of nodes at a level
        2.2 Get top of queue - n1
        2.3 Add non-null children of n1 to queue
        2.4 Get top of queue - n2
        2.4 Point the next of n1 to n2
        2.5 Assign n2 to n1
     */
    public static TreeNode connect(TreeNode root) {

        if(root == null) {
            return null;
        }

        Queue<TreeNode> q = new LinkedList<>();

        if(root.left != null) {
            q.offer(root.left);
        }

        if(root.right != null) {
            q.offer(root.right);
        }

        while(q.size() > 0) {
            int size = q.size();
            TreeNode n1 = q.poll();
            size--;

            if(n1.left != null) {
                q.offer(n1.left);
            }

            if(n1.right != null) {
                q.offer(n1.right);
            }

            while(size > 0) {
                TreeNode n2 = q.poll();
                n1.next = n2;

                if(n2.left != null) {
                    q.offer(n2.left);
                }

                if(n2.right != null) {
                    q.offer(n2.right);
                }
                n1 = n2;
                size--;
            }
        }
        return root;
    }
}