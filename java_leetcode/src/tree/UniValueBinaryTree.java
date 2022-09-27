//https://leetcode.com/problems/univalued-binary-tree/
//2022-09-27

package tree;

import java.util.ArrayList;
import java.util.Collections;

public class UniValueBinaryTree {

    //solution1
    //recursive
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Univalued Binary Tree.
    //Memory Usage: 42.2 MB, less than 15.78% of Java online submissions for Univalued Binary Tree.
    public static boolean solution1(TreeNode root) {
        return dfs(root, root.val);
    }
    private static boolean dfs(TreeNode node, int val) {
        if (node.left == null && node.right == null) {
            return node.val == val;
        }
        boolean answer = true;
        if (node.left != null) {
            answer = node.val == val && dfs(node.left, val);
        }
        if (node.right != null) {
            answer = answer && node.val == val && dfs(node.right, val);
        }
        return answer;
    }

    //solution2
    //leetcode solution (recursion)
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Univalued Binary Tree.
    //Memory Usage: 40.1 MB, less than 87.34% of Java online submissions for Univalued Binary Tree.
    public boolean solution2(TreeNode root) {
        boolean left_correct = (root.left == null ||
                (root.val == root.left.val && solution2(root.left)));
        boolean right_correct = (root.right == null ||
                (root.val == root.right.val && solution2(root.right)));
        return left_correct && right_correct;
    }

    public static void main(String[] args) {
        ArrayList<Integer> i = new ArrayList<>();
        Integer[] k = {1, 1, 1, 2, 1};
        Collections.addAll(i, k);
        TreeNode n = new TreeNode(i);
        System.out.println(n);
        solution1(n);
    }
}
