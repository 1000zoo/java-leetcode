//2023-12-06
//https://leetcode.com/problems/minimum-depth-of-binary-tree/

package dfs;

import _util.TreeNode;

public class MinimumDepthOfBinaryTree {

    // Runtime: 4ms (73.85%), Memory: 66.77MB (11.69%)
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return dfs(root, 1);
    }

    private int dfs(TreeNode node, int depth) {
        if (node.left == null && node.right == null) {
            return depth;
        }

        int min = Integer.MAX_VALUE;

        if (node.left != null) {
            min = Math.min(min, dfs(node.left, depth + 1));
        }
        if (node.right != null) {
            min = Math.min(min, dfs(node.right, depth + 1));
        }

        return min;
    }
}
