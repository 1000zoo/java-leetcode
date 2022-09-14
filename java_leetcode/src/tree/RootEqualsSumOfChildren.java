package tree;

public class RootEqualsSumOfChildren {
    public boolean solution1(TreeNode root) {
        return root.val == root.left.val + root.right.val;
    }
}
