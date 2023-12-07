//2023-12-07
//https://leetcode.com/problems/find-mode-in-binary-search-tree/

package dfs;

import _util.TreeNode;
import java.util.*;

public class FindModeInBST {

    private final Map<Integer, Integer> map = new HashMap<>();

    //Runtime: 7.ms (37.59%), Memory: 45.03MB (9.26%)
    public int[] findMode(TreeNode root) {
        dfs(root);
        List<Integer> list = new ArrayList<>();



        int max = -1;
        for (int key : map.keySet()) {
            if (max == map.get(key)) {
                list.add(key);
            } else if (max < map.get(key)) {
                list = new ArrayList<>();
                list.add(key);
                max = map.get(key);
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        if (root.left != null) dfs(root.left);
        if (root.right != null) dfs(root.right);
    }
}
