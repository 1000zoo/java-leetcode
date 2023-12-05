package dfs;

import _util.TreeNode;

public class PathSum {

    private boolean answer = false;

    // Runtime: 0ms(100.00%), Memory: 43.31MB (45.48%)
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        dfs(root, 0, targetSum);
        return answer;
    }

    private void dfs(TreeNode node, int sum, int target) {
        sum += node.val;
        if (node.left == null && node.right == null) {
            answer = sum == target || answer;
        }
        if (node.left != null) {
            dfs(node.left, sum, target);
        }
        if (node.right != null) {
            dfs(node.right, sum, target);
        }
    }
}
