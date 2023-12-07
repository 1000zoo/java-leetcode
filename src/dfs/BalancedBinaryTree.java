//2023-12-07
//https://leetcode.com/problems/balanced-binary-tree/

package dfs;

import _util.TreeNode;

public class BalancedBinaryTree {

    //Runtime: 0.0ms (100.00%), Memory: 42.75MB (89.03%)
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return dfs(root) != -1;
    }

    private int dfs(TreeNode curr) {
        if (curr == null) return 0;
        int left = dfs(curr.left);
        int right = dfs(curr.right);

        if (Math.abs(left - right) > 1) return -1;
        if (left == -1 || right == -1) return -1;

        return Math.max(left, right) + 1;
    }
}
