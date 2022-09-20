//https://leetcode.com/problems/evaluate-boolean-binary-tree/
//2022-09-20

package tree;

import java.util.Collections;
import java.util.Stack;
import java.util.ArrayList;

public class EvaluateBooleanBinaryTree {

    // solution1. tree 를 변경하며 풀기
    // Time : <O(n^2) (n = 노드 개수)
    // space:
    //=========================================================================================================
    //Runtime: 10 ms, faster than 55.13% of Java online submissions for Evaluate Boolean Binary Tree.
    //Memory Usage: 46.9 MB, less than 19.32% of Java online submissions for Evaluate Boolean Binary Tree.
    public static boolean solution1(TreeNode root) {
        if (root.val == 0 || root.val == 1) {
            return root.val == 1;
        } else if (isBoolean(root.left.val) && isBoolean(root.right.val)) {
            return eval(trans(root.left.val), trans(root.right.val), root.val);
        }
        Stack<TreeNode> next = new Stack<>(){{push(root);}};
        TreeNode curr;

        while (!next.isEmpty()) {
            curr = next.pop();
            System.out.println("hh");
            if (isBoolean(curr.left.val) && isBoolean(curr.right.val)) {
                curr.val = inverse(eval(trans(curr.left.val), trans(curr.right.val), curr.val));
            } else if (isBoolean(curr.left.val)) {
                next.push(curr);
                next.push(curr.right);
            } else if (isBoolean(curr.right.val)) {
                next.push(curr);
                next.push(curr.left);
            } else {
                next.push(curr);
                next.push(curr.right);
                next.push(curr.left);
            }
        }
        return trans(root.val);
    }

    private static boolean isBoolean(int n) {
        return n == 1 || n == 0;
    }

    // op = 2 (or), 3(and)
    private static boolean eval(boolean b1, boolean b2, int op) {
        if (op == 2) return b1 || b2;
        else return b1 && b2;
    }

    private static int inverse(boolean b) {
        return b ? 1 : 0;
    }

    // n = 0 (false), 1 (true)
    private static boolean trans(int n) {
        if (n > 1) {
            System.out.println("error");
            System.exit(1);
        }
        return n == 1;
    }
    //=========================================================================================================

    // solution2. recursive
    //https://leetcode.com/problems/evaluate-boolean-binary-tree/discuss/2584007/JAVA-Easy-to-understand-solution-with-0ms-execution-time
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Evaluate Boolean Binary Tree.
    //Memory Usage: 42.1 MB, less than 96.87% of Java online submissions for Evaluate Boolean Binary Tree.
    public static boolean solution2(TreeNode root) {
        if (root == null) {
            return false;
        }
        if (root.val == 0) {
            return false;
        }
        if (root.val == 1) {
            return true;
        }
        if (root.val == 2) {
            return solution2(root.left) || solution2(root.right);
        } else {
            return solution2(root.left) && solution2(root.right);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
//        Integer[] arr = new Integer[]{3, 2, 2, 2, 2, 3, 2, 0, 0, 0, 1, 1, 2, 1, 1, null, null, null, null, null, null, null, null, null, null, 3, 2, null, null, null, null, 2, 3, 0, 0, 1, 1, 0, 3, null, null, null, null, null, null, null, null, null, null, 3, 0, 3, 3, null, null, 0, 0, 1, 0, null, null, null, null, null, null, null, null};
        Integer[] arr = new Integer[]{3, 3, 2, 0, 0, 3, 2, null, null, null, null, 1, 3, 1, 1, null, null, 2, 1, null, null, null, null, 1, 1};
        Collections.addAll(al, arr);
        TreeNode root = new TreeNode(al);
        solution1(root);
    }
}
