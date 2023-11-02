//https://leetcode.com/problems/maximum-depth-of-binary-tree/
//2022-09-25

package tree;

import java.util.HashMap;
import java.util.Stack;

public class MaximumDepthOfBinaryTree {

    //solution1
    //recursive
    //================================================================================================================
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Depth of Binary Tree.
    //Memory Usage: 43 MB, less than 55.98% of Java online submissions for Maximum Depth of Binary Tree.
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return dfs(root, 0, 0);
    }

    private int dfs(TreeNode node, int depth, int max) {
        depth += 1;
        if (node.left == null && node.right == null) {
            return Math.max(depth, max);
        } else if (node.right == null) {
            return dfs(node.left, depth, max);
        } else if (node.left == null) {
            return dfs(node.right, depth, max);
        }
        max = dfs(node.left, depth, max);
        max = dfs(node.right, depth, max);

        return max;
    }
    //================================================================================================================
}

