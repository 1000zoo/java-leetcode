//https://leetcode.com/problems/merge-two-binary-trees/
//2022-09-20

package tree;

import java.util.*;

public class MergeTwoBinaryTrees {

    // solution1
    // root1 쪽 노드 (curr1) 가 left 가 없을 때 => answer.left = curr2.left;
    // 총 16가지 케이스
    //Runtime: 3 ms, faster than 5.16% of Java online submissions for Merge Two Binary Trees.
    //Memory Usage: 43.5 MB, less than 85.82% of Java online submissions for Merge Two Binary Trees.
    //==============================================================================================================
    public static TreeNode solution1(TreeNode root1, TreeNode root2) {
        TreeNode curr1, curr2;
        TreeNode answer = new TreeNode(0);
        TreeNode dummy = answer;
        Stack<TreeNode> st1 = new Stack<>() {{
            push(root1);
        }};
        Stack<TreeNode> st2 = new Stack<>() {{
            push(root2);
        }};
        Stack<TreeNode> ansStack = new Stack<>() {{
            push(dummy);
        }};
        boolean twoTwins;
        boolean isTwins1;
        boolean isTwins2;

        while (!st1.isEmpty() && !st2.isEmpty()) {
            curr1 = st1.pop();
            curr2 = st2.pop();
            answer = ansStack.pop();
            answer.val = curr1.val + curr2.val;
            isTwins1 = curr1.left != null && curr1.right != null;
            isTwins2 = curr2.left != null && curr2.right != null;
            twoTwins = isTwins1 && isTwins2;

            if (twoTwins) {
                push(st1, curr1);
                push(st2, curr2);
                answer.left = new TreeNode(0);
                answer.right = new TreeNode(0);
                push(ansStack, answer);
            } else {
                if (isTwins1) {
                    if (curr2.left == null && curr2.right == null) {
                        merge(answer, curr1, null);
                    } else if (curr2.left == null) {
                        st1.push(curr1.right);
                        st2.push(curr2.right);
                        answer.right = new TreeNode(0);
                        ansStack.push(answer.right);
                        merge(answer, curr1, true);
                    } else {
                        st1.push(curr1.left);
                        st2.push(curr2.left);
                        answer.left = new TreeNode(0);
                        ansStack.push(answer.left);
                        merge(answer, curr1, false);
                    }
                } else if (isTwins2) {
                    if (curr1.left == null && curr1.right == null) {
                        merge(answer, curr2, null);
                    } else if (curr1.left == null) {
                        st1.push(curr1.right);
                        st2.push(curr2.right);
                        answer.right = new TreeNode(0);
                        ansStack.push(answer.right);
                        merge(answer, curr2, true);
                    } else {
                        st1.push(curr1.left);
                        st2.push(curr2.left);
                        answer.left = new TreeNode(0);
                        ansStack.push(answer.left);
                        merge(answer, curr2, false);
                    }
                } else {
                    if (curr1.left != null) {
                        if (curr2.left != null) {
                            st1.push(curr1.left);
                            st2.push(curr2.left);
                            answer.left = new TreeNode(0);
                            ansStack.push(answer.left);
                        } else if (curr2.right != null) {
                            answer.left = curr1.left;
                            answer.right = curr2.right;
                        } else {
                            answer.left = curr1.left;
                        }
                    } else if (curr1.right != null) {
                        if (curr2.right != null) {
                            st1.push(curr1.right);
                            st2.push(curr2.right);
                            answer.right = new TreeNode(0);
                            ansStack.push(answer.right);
                        } else if (curr2.left != null) {
                            answer.left = curr2.left;
                            answer.right = curr1.right;
                        } else {
                            answer.right = curr1.right;
                        }
                    } else {
                        if (curr2.left != null) {
                            answer.left = curr2.left;
                        } else if (curr2.right != null) {
                            answer.right = curr2.right;
                        }
                    }
                }
            }
        }
        return dummy;
    }

    private static void merge(TreeNode n1, TreeNode n2, Boolean left) {
        if (left == null) {
            n1.left = n2.left;
            n1.right = n2.right;
        } else {
            if (left) {
                n1.left = n2.left;
            } else {
                n1.right = n2.right;
            }
        }
    }

    private static void push(Stack<TreeNode> st, TreeNode n) {
        st.push(n.right);
        st.push(n.left);
    }
    //==============================================================================================================



    public static void main(String[] args) {
        ArrayList<Integer> al1 = new ArrayList<>();
        ArrayList<Integer> al2 = new ArrayList<>();
        Integer[] l1 = new Integer[]{1, 3, 2, 5};
        Integer[] l2 = new Integer[]{2, 1, 3, null, 4, null, 7};
        Collections.addAll(al1, l1);
        Collections.addAll(al2, l2);

        solution1(new TreeNode(al1), new TreeNode(al2));
    }
}
