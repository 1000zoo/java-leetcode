//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
//2022-09-14

package tree;

import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {

    //Runtime: 2 ms, faster than 15.27% of Java online submissions for Flatten Binary Tree to Linked List.
    //Memory Usage: 43.4 MB, less than 10.19% of Java online submissions for Flatten Binary Tree to Linked List.
    public static void solution1(TreeNode root) {
        if (root == null) {
            return;
        } else if (root.right == null && root.left == null) {
            return;
        }
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null && curr.right != null) {
                st.push(curr.right);
                curr.right = curr.left;
                TreeNode temp = curr.left;
                curr.left = null;
                curr = temp;
            } else if (curr.left == null && curr.right == null) {
                break;
            } else if (curr.left != null) {
                curr.right = curr.left;
                curr.left = null;
                curr = curr.right;
            } else {
                curr = curr.right;
            }
        }
        curr = root;
        while (curr != null) {
            if (curr.left != null) {
                solution1(curr);
            }
            curr = curr.right;
        }
        curr = root;
        while (!st.isEmpty()) {
            TreeNode temp = st.pop();
            TreeNode tempCurr = temp;
            while (tempCurr != null) {
                if (tempCurr.left != null) {
                    solution1(tempCurr);
                }
                tempCurr = tempCurr.right;
            }
            while (curr.right != null) {
                if (curr.left != null) {
                    solution1(curr);
                }
                curr = curr.right;
            }
            curr.right = temp;
        }
    }
}
