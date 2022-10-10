//https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
//2022-09-21

package tree;

import java.util.ArrayList;
import java.util.Collections;

public class SumOfBinaryNumbers {

    //solution1
    //recursive
    //==============================================================================================================
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Sum of Root To Leaf Binary Numbers.
    //Memory Usage: 41.7 MB, less than 92.79% of Java online submissions for Sum of Root To Leaf Binary Numbers.
    public static int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0, 0);
    }

    public static int dfs(TreeNode node, int sum, int num) {
        num = (num << 1) | node.val;
        if (node.left == null && node.right == null) {
            return num;
        } else if (node.left == null) {
            sum += dfs(node.right, sum, num);
        } else if (node.right == null) {
            sum += dfs(node.left, sum, num);
        } else {
            sum += dfs(node.left, sum, num) + dfs(node.right, sum, num);
        }

        return sum;
    }
    //==============================================================================================================
}
