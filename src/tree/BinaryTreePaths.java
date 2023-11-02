//https://leetcode.com/problems/binary-tree-paths/
//2022-09-28

package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        String s = "";
        ArrayList<String> answer = new ArrayList<>();

        dfs(root, s, answer);

        return answer;
    }

    private void dfs(TreeNode node, String s, ArrayList<String> list) {
        s += node.val;
        if (node.left == null && node.right == null) {
            list.add(s);
            return;
        }
        if (node.left != null) {
            s += "->";
            dfs(node.left, s, list);
            s = s.substring(0, s.length() - 2);
        }
        if (node.right != null) {
            s += "->";
            dfs(node.right, s, list);
        }
    }
}
