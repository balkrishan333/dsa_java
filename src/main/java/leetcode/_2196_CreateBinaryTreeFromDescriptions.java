package leetcode;

import leetcode.common.BinaryTreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _2196_CreateBinaryTreeFromDescriptions {

    public static void main(String[] args) {
        _2196_CreateBinaryTreeFromDescriptions obj = new _2196_CreateBinaryTreeFromDescriptions();

        int[][] descriptions = {{20,15,1},{20,17,0},{50,20,1},{50,80,0},{80,19,1}};
        System.out.println(obj.createBinaryTree(descriptions));
    }

    /*
        Maintain the set of values which can't be root i.e. they have appeared as a child in any one node

        As we move along, add all the nodes to the map be it parent or child.

        In the end, remove all nodes from the map which are not candidate fro being root. This will leave us with only root node in the
        map.
     */
    public BinaryTreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, BinaryTreeNode> map = new HashMap<>();
        Set<Integer> nonRootCandidates = new HashSet<>();

        for (int[] description : descriptions) {
            int parent = description[0];
            int child = description[1];
            int isLeft = description[2];

            //remove the child from root candidates if it exists
            nonRootCandidates.add(child);

            BinaryTreeNode parentNode = map.getOrDefault(parent, new BinaryTreeNode(parent));
            BinaryTreeNode childNode = map.getOrDefault(child, new BinaryTreeNode(child));
            if (isLeft == 1) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }
            map.put(parent, parentNode);
            map.put(child, childNode);
        }
        map.keySet().removeAll(nonRootCandidates);
        return map.entrySet().iterator().next().getValue(); //return the only node in the map
    }
}
