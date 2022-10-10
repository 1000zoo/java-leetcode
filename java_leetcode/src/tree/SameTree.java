//https://leetcode.com/problems/same-tree/
//2022-10-10

package tree;

public class SameTree {

    //solution
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Same Tree.
    //Memory Usage: 41.7 MB, less than 38.39% of Java online submissions for Same Tree.
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p != null && q != null) {
            return dfs(p, q);
        } else {
            return false;
        }
    }
    public static boolean dfs(TreeNode p, TreeNode q) {
        boolean temp = p.val == q.val;
        if (p.left == null && q.left != null) {
            temp = false;
        }
        if (p.left != null && q.left == null) {
            temp = false;
        }
        if (p.right == null && q.right != null) {
            temp = false;
        }
        if (p.right != null && q.right == null) {
            temp = false;
        }
        if (p.left != null && q.left != null) {
            temp = temp && dfs(p.left, q.left);
        }
        if (p.right != null && q.left != null) {
            temp = temp && dfs(p.right, q.right);
        }
        return temp;
    }
}
