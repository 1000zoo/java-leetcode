//https://leetcode.com/problems/binary-tree-tilt/
//2022-10-05

package tree;

import java.util.ArrayList;
import java.util.Collections;

public class BinaryTreeTilt {


    //solution1
    //recursive / dfs (stack)
    //Runtime: 1 ms, faster than 83.50% of Java online submissions for Binary Tree Tilt.
    //Memory Usage: 45.6 MB, less than 26.95% of Java online submissions for Binary Tree Tilt.
    public static int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return sumAll(root, 0);
    }

    public static int sumAll(TreeNode root, int sum) {
        sum += root.val;
        if (root.left != null) {
            sum = sumAll(root.left, sum);
        }
        if (root.right != null) {
            sum = sumAll(root.right, sum);
        }
        return sum;
    }

    public static int dfs(TreeNode root) {
        int leftSum = 0;
        int rightSum = 0;

        if (root.left != null) {
            leftSum += dfs(root.left);
        }
        if (root.right != null) {
            rightSum += dfs(root.right);
        }
        int temp = root.val;
        root.val = Math.abs(leftSum - rightSum);
        return temp + leftSum + rightSum;
    }

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        Collections.addAll(al, 21, 7, 14, 1, 1, 2, 2, 3, 3);
        TreeNode root = new TreeNode(al);
        findTilt(root);
    }
}
