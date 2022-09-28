//https://leetcode.com/problems/leaf-similar-trees/
//2022-09-28

package tree;

import java.util.ArrayList;

public class LeafSimilarTrees {
    //recursive (dfs)
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Leaf-Similar Trees.
    //Memory Usage: 40.1 MB, less than 94.59% of Java online submissions for Leaf-Similar Trees.
    public static boolean solution(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> leafs1 = new ArrayList<>();
        ArrayList<Integer> leafs2 = new ArrayList<>();
        getLeafs(root1, leafs1);
        getLeafs(root2, leafs2);

        return leafs1.equals(leafs2);
    }

    private static void getLeafs(TreeNode node, ArrayList<Integer> leafs) {
        if (node.left == null && node.right == null) {
            leafs.add(node.val);
            return;
        }
        if (node.left != null) {
            getLeafs(node.left, leafs);
        }
        if (node.right != null) {
            getLeafs(node.right, leafs);
        }
    }
}
