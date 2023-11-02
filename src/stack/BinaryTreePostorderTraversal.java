//https://leetcode.com/problems/binary-tree-postorder-traversal/submissions/
//2022-08-05

package stack;

import java.util.ArrayList;
        import java.util.List;
        import java.util.Stack;


public class BinaryTreePostorderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {

        }

        TreeNode(int val) {
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //Runtime: 1 ms, faster than 52.37% of Java online submissions for Binary Tree Postorder Traversal.
    //Memory Usage: 40.8 MB, less than 86.11% of Java online submissions for Binary Tree Postorder Traversal.
    public static List<Integer> PostorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if (root == null) return ans;
        if (root.left == null && root.right == null) {
            ans.add(root.val);
            return ans;
        }

        Stack<TreeNode> st = new Stack<>();

        TreeNode curr = root;
        TreeNode dummy = null;
        int lastVal = 0;

        do {
            if (curr.left != null) {
                st.push(curr);
                dummy = curr.left;
                curr.left = null;
                curr = dummy;
            } else if (curr.right != null) {
                st.push(curr);
                dummy = curr.right;
                curr.right = null;
                curr = dummy;
            } else {
                ans.add(curr.val);
                curr = st.pop();
                lastVal = curr.val;
            }
        } while (!st.isEmpty() || (curr.left != null || curr.right != null));
        ans.add(lastVal);
        return ans;
    }
}