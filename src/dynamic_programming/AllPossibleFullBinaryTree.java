//https://leetcode.com/problems/all-possible-full-binary-trees/
//2022-10-19

package dynamic_programming;

import tree.TreeNode;

import java.util.*;

public class AllPossibleFullBinaryTree {

    //refer: https://leetcode.com/problems/all-possible-full-binary-trees/discuss/167402/CC%2B%2BJavaPython-Recursive-and-iterative-solutions.-Doesn't-create-Frankenstein-trees
    //Runtime: 7 ms, faster than 47.30% of Java online submissions for All Possible Full Binary Trees.
    //Memory Usage: 61.7 MB, less than 25.07% of Java online submissions for All Possible Full Binary
    public static List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> cases = new ArrayList<>();
        if (n == 1) {
            cases.add(new TreeNode(0));
        } else if (n % 2 != 0) {
            for (int i = 2; i <= n; i += 2) {
                List<TreeNode> leftCase = allPossibleFBT(i - 1);
                List<TreeNode> rightCase = allPossibleFBT(n - i);
                for (Iterator<TreeNode> leftIter = leftCase.iterator(); leftIter.hasNext(); ) {
                    TreeNode left = leftIter.next();
                    for (Iterator<TreeNode> rightIter = rightCase.iterator(); rightIter.hasNext(); ) {
                        TreeNode right = rightIter.next();

                        TreeNode node = new TreeNode();
                        node.left = rightIter.hasNext() ? clone(left) : left;
                        node.right = leftIter.hasNext() ? clone(right) : right;
                        cases.add(node);
                    }
                }
            }
        }
        return cases;
    }

    private static TreeNode clone(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode tree = new TreeNode(node.val);
        tree.left = clone(node.left);
        tree.right = clone(node.right);
        return tree;
    }
}
