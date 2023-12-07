//2023-12-08
//https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/

package dfs;

import _util.TreeNode;
import java.util.*;

public class SecondMinimumNodeInBinaryTree {

    //Runtime: 0.ms (100.00%), Memory: 39.58MB (77.83%)
    public int findSecondMinimumValue(TreeNode root) {
        Set<Integer> set = new HashSet<>();
        traversal(root, set);
        return findAnswer(set);
    }

    private void traversal(TreeNode node, Set<Integer> set) {
        if (node == null) return;
        set.add(node.val);
        traversal(node.left, set);
        traversal(node.right, set);
    }

    private int findAnswer(Set<Integer> set) {
        if (set.size() <= 1) return -1;
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        return list.get(1);
    }
}
