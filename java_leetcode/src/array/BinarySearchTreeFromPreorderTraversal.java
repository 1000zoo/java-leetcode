//https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/submissions/
//2022-12-11

package array;

import tree.TreeNode;

public class BinarySearchTreeFromPreorderTraversal {
    private TreeNode root;
    private int[] preorder;
    private int index;


    //Runtime
    //1 ms
    //75.71%
    //Memory
    //42.2 MB
    //42.62%
    public TreeNode bstFromPreorder(int[] p) {
        preorder = p;
        root = new TreeNode(preorder[0]);
        index = 1;
        if (p.length == 1) return root;
        dfs(root);
        return root;
    }

    private void dfs(TreeNode curr) {
        if (curr.val < preorder[index]) {
            if (curr.right == null) {
                curr.right = new TreeNode(preorder[index++]);
                if (index < preorder.length) dfs(root);
            } else {
                dfs(curr.right);
            }
        } else {
            if (curr.left == null) {
                curr.left = new TreeNode(preorder[index++]);
                if (index < preorder.length) dfs(root);
            } else {
                dfs(curr.left);
            }
        }
    }
}
