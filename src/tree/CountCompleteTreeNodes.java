//2023-12-12
//https://leetcode.com/problems/count-complete-tree-nodes/

package tree;

public class CountCompleteTreeNodes {

    int answer = 0;

    //Runtime: 0.ms (100.00%), Memory: 46.37MB (8.47%)
    public int countNodes(TreeNode root) {
        dfs(root);
        return answer;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        answer++;
        dfs(node.left);
        dfs(node.right);
    }
}
