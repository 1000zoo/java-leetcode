package dfs;

import _util.TreeNode;

public class ConstructStringFromBinaryTree {

    //Runtime: 16.ms (14.85%), Memory: 44.77MB (11.35%)
    public String tree2str(TreeNode root) {
        if (root == null) return "";
        return dfs(root);
    }

    private String dfs(TreeNode node) {
        if (node.left == null && node.right == null) {
            return "" + node.val;
        } else if (node.left != null && node.right == null) {
            return node.val + "(" + dfs(node.left) + ")";
        } else if (node.left == null && node.right != null) {
            return node.val + "()(" + dfs(node.right) + ")";
        }
        return node.val + "(" + dfs(node.left) + ")(" + dfs(node.right) + ")";
    }

    // =======================================================================

    //Runtime: 1.ms (100.00%), Memory: 43.71MB (61.35%)
    public String solution2(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }

    private void dfs(TreeNode node, StringBuilder sb) {
        if (node == null) return;
        sb.append(node.val);

        if (node.left == null && node.right == null) return;
        wrapper(node.left, sb);

        if (node.right == null) return;
        wrapper(node.right, sb);
    }

    private void wrapper(TreeNode node, StringBuilder sb) {
        sb.append("(");
        dfs(node, sb);
        sb.append(")");
    }
}
