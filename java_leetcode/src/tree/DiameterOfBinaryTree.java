//https://leetcode.com/problems/diameter-of-binary-tree/
//2022-10-10

package tree;

import java.util.ArrayList;
import java.util.Collections;

public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftDiameter = diameterOfBinaryTree(root.left);
        int leftHeight = heightOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);
        int rightHeight = heightOfBinaryTree(root.right);

        int selfDiameter = leftHeight + rightHeight;
        return Math.max(selfDiameter, Math.max(leftDiameter, rightDiameter));
    }

    public int heightOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftHeight = heightOfBinaryTree(root.left);
        int rightHeight = heightOfBinaryTree(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
