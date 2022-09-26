//https://leetcode.com/problems/average-of-levels-in-binary-tree/
//2022-09-26

package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
    //solution1
    //queue (bfs)
    //Runtime: 5 ms, faster than 35.50% of Java online submissions for Average of Levels in Binary Tree.
    //Memory Usage: 47.6 MB, less than 51.01% of Java online submissions for Average of Levels in Binary Tree.
    public List<Double> solution1(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Double> answer = new ArrayList<>();
        TreeNode curr = root;
        TreeNode endNode = root;
        TreeNode tempNode = root;
        Queue<TreeNode> queue = new LinkedList<>(){{
            add(root);
        }};
        double sum = 0.0;
        int count = 0;

        while (!queue.isEmpty()) {
            curr = queue.poll();
            count++;
            sum += curr.val;
            if (curr == endNode) {
                if (isLeaf(curr)) {
                    endNode = tempNode;
                } else {
                    endNode = curr.right == null ? curr.left : curr.right;
                }
                answer.add(sum / count);
                sum = 0.0;
                count = 0;
            } else {
                if (!isLeaf(curr)) {
                    tempNode = curr.right == null ? curr.left : curr.right;
                }
            }
            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
        return answer;
    }

    //solution2
    //recursive (dfs)
    //=================================================================================================================
    //Runtime: 3 ms, faster than 78.88% of Java online submissions for Average of Levels in Binary Tree.
    //Memory Usage: 48.1 MB, less than 20.51% of Java online submissions for Average of Levels in Binary Tree.
    public List<Double> solution2(TreeNode root) {
        List<Integer> count = new ArrayList<>();
        List<Double> result = new ArrayList<>();
        dfs(root, 0, result, count);
        for (int i = 0; i < result.size(); i++) {
            result.set(i, result.get(i) / count.get(i));
        }
        return result;
    }

    private void dfs(TreeNode node, int i, List<Double> sum, List<Integer> count) {
        if (node == null) {
            return;
        }
        if (i < sum.size()) {
            sum.set(i, sum.get(i) + node.val);
            count.set(i, count.get(i) + 1);
        } else {
            sum.add(1.0 * node.val);
            count.add(1);
        }
        dfs(node.left, i + 1, sum, count);
        dfs(node.right, i + 1, sum, count);
    }
    //=================================================================================================================

    //solution3
    //one queue (bfs)
    //https://leetcode.com/problems/average-of-levels-in-binary-tree/solution/
    //Runtime: 2 ms, faster than 98.27% of Java online submissions for Average of Levels in Binary Tree.
    //Memory Usage: 43.3 MB, less than 99.54% of Java online submissions for Average of Levels in Binary Tree.
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        double sum = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = q.poll();
                sum += node.val;
                if (node.left != null) {
                    q.add(node.left);
                }

                if (node.right != null) {
                    q.add(node.right);
                }
            }

            result.add(sum / size);
            sum = 0;
        }

        return result;
    }

}
