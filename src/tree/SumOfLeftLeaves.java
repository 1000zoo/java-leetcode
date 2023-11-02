//https://leetcode.com/problems/sum-of-left-leaves/submissions/
//2022-10-10

package tree;

public class SumOfLeftLeaves {

    //solution
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Sum of Left Leaves.
    //Memory Usage: 39.9 MB, less than 96.08% of Java online submissions for Sum of Left Leaves.
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, 0);
    }
    public int dfs(TreeNode root, int sum) {
        int lv = 0;
        if (root == null) {
            return 0;
        }
        if (root.left != null && isLeaf(root)) {
            lv = root.left.val;
        }
        return lv + dfs(root.left, sum) + dfs(root.right, sum);
    }
    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
