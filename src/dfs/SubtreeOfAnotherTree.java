//2023-12-08
//https://leetcode.com/problems/subtree-of-another-tree/

package dfs;

import _util.TreeNode;

public class SubtreeOfAnotherTree {

    //Runtime: 2.0ms (96.58%), Memory: 43.26MB (45.65%)
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;
        return dfs(root, subRoot);
    }

    private boolean dfs(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (validate(root, subRoot)) {
            return true;
        }
        return dfs(root.left, subRoot) || dfs(root.right, subRoot);
    }

    private boolean validate(TreeNode node1, TreeNode node2) {
        if (node1 != null && node2 != null) {
            if (node1.val == node2.val) {
                return validate(node1.left, node2.left) && validate(node1.right, node2.right);
            }
            return false;
        }
        return node1 == null && node2 == null;
    }
}
