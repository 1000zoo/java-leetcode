//https://leetcode.com/problems/minimum-distance-between-bst-nodes/
//2022-10-10

package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumDistanceBetweenBST {

    //solution1
    //BST 를 정렬한 후, 바로 다음 원소와 차이를 비교하여 최솟값을 찾는 방식
    //BST 를 중위탐색하면 정렬
    //==================================================================================================================
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Distance Between BST Nodes.
    //Memory Usage: 40 MB, less than 88.03% of Java online submissions for Minimum Distance Between BST Nodes.
    public int solution1(TreeNode root) {
        ArrayList<Integer> sort = new ArrayList<>();
        toList(root, sort);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < sort.size() - 1; i++) {
            min = Math.min(min, sort.get(i + 1) - sort.get(i));
        }
        return min;
    }

    public static void toList(TreeNode node, List<Integer> list) {
        if (node.left != null) {
            toList(node.left, list);
        }
        list.add(node.val);
        if (node.right != null) {
            toList(node.right, list);
        }
    }
    //==================================================================================================================
}
