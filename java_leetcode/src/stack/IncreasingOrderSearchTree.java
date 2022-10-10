//https://leetcode.com/problems/increasing-order-search-tree/
//2022-08-30

package stack;

import java.util.Stack;

public class IncreasingOrderSearchTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(){}

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Increasing Order Search Tree.
    //Memory Usage: 39.8 MB, less than 97.02% of Java online submissions for Increasing Order Search Tree.
    public static TreeNode solution1(TreeNode root) {
        TreeNode ans = new TreeNode();
        TreeNode dummy = ans;
        Stack<TreeNode> st = new Stack<>();

        TreeNode curr = root;
        TreeNode tmp;

        while (!st.isEmpty() || curr.left != null || curr.right != null) {
            if (curr.left != null) {
                st.push(curr);
                tmp = curr.left;
                curr.left = null;
                curr = tmp;
            } else if (curr.right != null) {
                ans.right = new TreeNode(curr.val);
                ans = ans.right;
                curr = curr.right;
            } else {
                ans.right = new TreeNode(curr.val);
                ans = ans.right;
                curr = st.pop();
            }
        }
        ans.right = new TreeNode(curr.val);
        return dummy.right;
    }
}
