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
    public String toString() {
        if (this == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        TreeNode curr;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(this);
        sb.append(this.val).append(", ");

        while (!queue.isEmpty()) {
            curr = queue.poll();

            if (curr.left != null && curr.right != null) {
                sb.append(curr.left.val).append(", ");
                sb.append(curr.right.val).append(", ");
                queue.add(curr.left);
                queue.add(curr.right);
            } else if (curr.left != null) {
                sb.append(curr.left.val).append(", ");
                sb.append("null, ");
                queue.add(curr.left);
            } else if (curr.right != null) {
                sb.append("null, ");
                sb.append(curr.right.val).append(", ");
                queue.add(curr.right);
            } else {
                sb.append("null, null, ");
            }
        }
        sb.setLength(sb.length() - 2);
        return sb.toString();
    }
}
