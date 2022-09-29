//https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
//2022-09-29

/*
0653 문제를 잘 못 이해한 풀이
두 원소의 합이 k 가 되도록 모든 원소를 짝지을 수 있다면 true 아니면 false 로 이해함
원래 문제 풀이는 TwoSumIsK
 */

package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class AllTwoSumIsK {

    public static boolean solution1(TreeNode root, int k) {
        int count = 0;
        HashSet<Integer> hs = new HashSet<>();

        count = dfs(root, hs, k, count);

        return hs.size() * 2 == count;

        //같은 원소끼리도 더할수 있을때
//*        if ((hs.size() - 1) * 2 == count - 1) {
//            for (int a : hs) {
//                if (a * 2 == k) {
//                    return true;
//                }
//            }
//        }
    }

    public static int dfs(TreeNode node, HashSet<Integer> hs, int k, int count) {
        count++;

        if (!hs.contains(node.val)) {
            hs.add(k - node.val);
        }

        if (node.left == null && node.right == null) {
            return count;
        }

        if (node.left != null) {
            count = dfs(node.left, hs, k, count);
        }
        if (node.right != null) {
            count = dfs(node.right, hs, k, count);
        }
        return count;
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        Integer[] al = new Integer[]{2,1,3};
        Collections.addAll(a, al);
        TreeNode root = new TreeNode(a);
        solution1(root, 3);
    }

}
