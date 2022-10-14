//https://leetcode.com/problems/cousins-in-binary-tree/
//2022-10-13

package tree;

public class CousinNode {
    TreeNode xParent = null;
    TreeNode yParent = null;
    int xDepth = -1, yDepth = -1;

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Cousins in Binary Tree.
    //Memory Usage: 42.2 MB, less than 21.75% of Java online submissions for Cousins in Binary Tree.
    public boolean isCousins(TreeNode root, int x, int y) {
        getDepthAndParent(root, x, y, 0, null);
        return xDepth == yDepth && xParent != yParent;
    }

    public void getDepthAndParent(TreeNode root, int x, int y, int depth, TreeNode parent){
        if(root == null){
            return;
        }
        if(root.val == x){
            xParent = parent;
            xDepth = depth;
        }else if(root.val == y){
            yParent = parent;
            yDepth = depth;
        }
        getDepthAndParent(root.left, x, y, depth + 1, root);
        getDepthAndParent(root.right, x, y, depth + 1, root);
    }
}
