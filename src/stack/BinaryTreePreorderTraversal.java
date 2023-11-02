// https://leetcode.com/problems/binary-tree-preorder-traversal/
// 2022-08-24

package stack;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.HashMap;

public class BinaryTreePreorderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {}

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //Runtime: 1 ms, faster than 51.68% of Java online submissions for Binary Tree Preorder Traversal.
    //Memory Usage: 41.7 MB, less than 82.64% of Java online submissions for Binary Tree Preorder Traversal.
    public static List<Integer> solution1(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<TreeNode, Integer> hm = new HashMap<>();
        if (root == null) return ans;
        if (root.left == null && root.right == null) {
            ans.add(root.val);
            return ans;
        }
        Stack<TreeNode> st = new Stack<>();

        TreeNode curr = root;
        TreeNode dummy = null;

        do {
            if (hm.getOrDefault(curr, 0) == 0) {
                hm.put(curr, hm.getOrDefault(curr, 0) + 1);
                ans.add(curr.val);
            }
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
                curr = st.pop();
            }
        } while ((!st.isEmpty() || (curr.left != null || curr.right != null)));


        return ans;
    }
}
