//https://leetcode.com/problems/symmetric-tree/
//2022-10-17

package tree;

import java.util.*;

public class SymmetricTree {
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Symmetric Tree.
    //Memory Usage: 40.1 MB, less than 98.07% of Java online submissions for Symmetric Tree.
    public boolean isSymmetric(TreeNode root) {
        return root == null || isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;

        if (node1 == null || node2 == null) return false;

        if (!node1.val.equals(node2.val)) return false;
        return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
    }
}

