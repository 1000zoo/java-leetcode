//2022-04-26
//https://leetcode.com/problems/binary-tree-inorder-traversal/submissions/

package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //Runtime: 1 ms, faster than 40.89% of Java online submissions for Binary Tree Inorder Traversal.
    //Memory Usage: 42.7 MB, less than 10.29% of Java online submissions for Binary Tree Inorder Traversal.
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root.left == null && root.right == null) {
            ans.add(root.val);
            return ans;
        }

        Stack<TreeNode> tmpStack = new Stack<>();
        TreeNode curr = root;
        TreeNode tmp = new TreeNode();

        while (true) {
            if (curr.left != null) {
                tmpStack.push(curr);
                tmp = curr.left;
                curr.left = null;
                curr = tmp;
            } else if (curr.right != null) {
                ans.add(curr.val);
                curr = curr.right;
            } else {
                ans.add(curr.val);
                if ((root != curr || root.right == null) && tmpStack.empty()) {
                    break;
                }
                curr = tmpStack.pop();
            }
        }
        return ans;
    }
}