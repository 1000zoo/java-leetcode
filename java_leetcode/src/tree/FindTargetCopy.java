//https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
//2022-09-15

package tree;

import java.util.*;

public class FindTargetCopy {

    //Runtime: 22 ms, faster than 5.10% of Java online submissions for Find a Corresponding Node of a Binary Tree in a Clone of That Tree.
    //Memory Usage: 110.1 MB, less than 5.01% of Java online submissions for Find a Corresponding Node of a Binary Tree in a Clone of That Tree.
    public static final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        TreeNode oriCurr = original;
        TreeNode cloCurr = cloned;
        Queue<TreeNode> oriQ = new LinkedList<>();
        Queue<TreeNode> cloQ = new LinkedList<>();

        while (true) {
            if (oriCurr == target) {
                return cloCurr;
            }
            if (oriCurr.left != null || oriCurr.right != null) {
                if (oriCurr.left == null) {
                    oriQ.add(oriCurr.right);
                    cloQ.add(cloCurr.right);
                } else if (oriCurr.right == null) {
                    oriQ.add(oriCurr.left);
                    cloQ.add(cloCurr.left);
                } else {
                    oriQ.add(oriCurr.left);
                    oriQ.add(oriCurr.right);
                    cloQ.add(cloCurr.left);
                    cloQ.add(cloCurr.right);
                }
            }
            if (oriQ.isEmpty()) {
                break;
            }
            oriCurr = oriQ.poll();
            cloCurr = cloQ.poll();
        }
        return null;
    }

    //Runtime: 17 ms, faster than 5.57% of Java online submissions for Find a Corresponding Node of a Binary Tree in a Clone of That Tree.
    //Memory Usage: 108.3 MB, less than 5.01% of Java online submissions for Find a Corresponding Node of a Binary Tree in a Clone of That Tree.
    public static final TreeNode solution2(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(cloned);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp.val == target.val) {
                return temp;
            }
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
        return null;
    }
}
