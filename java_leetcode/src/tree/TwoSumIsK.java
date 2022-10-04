//https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
//2022-09-29

package tree;

import java.util.HashSet;

public class TwoSumIsK {

    //solution1
    //HashSet
    //============================================================================================================
    //Runtime: 11 ms, faster than 16.92% of Java online submissions for Two Sum IV - Input is a BST.
    //Memory Usage: 54.7 MB, less than 5.24% of Java online submissions for Two Sum IV - Input is a BST.
    public static boolean solution1(TreeNode root, int k) {
        HashSet<Integer> hs = new HashSet<>();

        return dfs(root, hs, k, false);
    }

    public static boolean dfs(TreeNode node, HashSet<Integer> hs, int k, boolean ans) {
        if (!hs.contains(node.val)) {
            hs.add(k - node.val);
        } else {
            ans = true;
        }

        if (node.left == null && node.right == null) {
            return ans;
        }

        if (node.left != null) {
            ans |= dfs(node.left, hs, k, ans);
        }
        if (node.right != null) {
            ans |= dfs(node.right, hs, k, ans);
        }
        return ans;
    }
    //============================================================================================================
}
