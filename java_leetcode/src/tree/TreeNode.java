package tree;

import java.util.*;

public class TreeNode {
    public Integer val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(){}

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(List<Integer> list) {
        Iterator<Integer> it = list.iterator();
        Queue<TreeNode> queue = new LinkedList<>();
        this.val = it.next();
        TreeNode curr = this;
        boolean leftTurn = true;

        while (it.hasNext()) {
            Integer k = it.next();

            if (curr == null) {
                throw new Error("Invalid TreeNode");
            }
            if (leftTurn) {
                leftTurn = false;
                if (k == null) {
                    continue;
                }
                curr.left = new TreeNode(k);
                queue.add(curr.left);
            } else {
                leftTurn = true;
                if (k == null) {
                    curr = queue.poll();
                    continue;
                }
                curr.right = new TreeNode(k);
                queue.add(curr.right);
                curr = queue.poll();
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(){{
            add(1);
            add(2);
            add(3);
            add(null);
            add(null);
            add(null);
            add(1);
            add(1);
            add(1);
        }};
        TreeNode root = new TreeNode(list);
    }
}
