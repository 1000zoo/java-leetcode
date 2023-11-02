//https://leetcode.com/problems/root-equals-sum-of-children/
//2022-09-14

package tree;

public class RootEqualsSumOfChildren {
    public boolean solution1(TreeNode root) {
        return root.val == root.left.val + root.right.val;
    }
}
