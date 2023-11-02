//https://leetcode.com/problems/search-in-a-binary-search-tree/
//2022-09-20

package tree;

public class SearchInBinarySearchTree {
    //solution1
    //recursive
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in a Binary Search Tree.
    //Memory Usage: 51.7 MB, less than 36.25% of Java online submissions for Search in a Binary Search Tree.
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val > val) {
            return searchBST(root.left, val);
        } else if (root.val < val) {
            return searchBST(root.right, val);
        } else {
            return root;
        }
    }
}
