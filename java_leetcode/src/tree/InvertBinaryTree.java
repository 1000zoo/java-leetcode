//https://leetcode.com/problems/invert-binary-tree/
//2022-09-21

package tree;

import java.util.ArrayList;
import java.util.Collections;

public class InvertBinaryTree {

    //solution1
    //recursive
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Invert Binary Tree.
    //Memory Usage: 41.6 MB, less than 48.75% of Java online submissions for Invert Binary Tree.
    public static TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }

    private static void dfs(TreeNode node) {
        if (node.right == null && node.left == null) {
            return;
        }
        if (node.left != null) {
            dfs(node.left);
        }
        if (node.right != null) {
            dfs(node.right);
        }
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}
