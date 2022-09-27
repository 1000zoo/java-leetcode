//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
//2022-09-27

package tree;

public class ConvertSortedArrayToBST {

    //solution1
    //recursion (dfs)
    //Runtime: 1 ms, faster than 34.90% of Java online submissions for Convert Sorted Array to Binary Search Tree.
    //Memory Usage: 43.2 MB, less than 81.33% of Java online submissions for Convert Sorted Array to Binary Search Tree.
    public static TreeNode solution1(int[] num) {
        if (num.length == 0) {
            return null;
        }
        TreeNode node = new TreeNode();
        int mid = num.length / 2;
        node.val = num[mid];
        node.left = solution1(subArray(num, 0, mid));
        node.right = solution1(subArray(num, mid + 1, num.length));
        return node;
    }

    private static int[] subArray(int[] num, int start, int end) {
        int[] res = new int[end - start];
        int index = 0;
        for (int i = start; i < end; i++) {
            res[index++] = num[i];
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = {-10, -3, 0, 5, 9};
        TreeNode root = solution1(arr);
        System.out.println(root);
    }
}
