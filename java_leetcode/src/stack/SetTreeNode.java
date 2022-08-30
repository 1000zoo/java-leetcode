package stack;

import java.util.*;

public class SetTreeNode {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public void draw() {        //확인용, Inorder Traversal
            TreeNode root = this;
            ArrayList<Integer> ans = new ArrayList<>();
            HashMap<TreeNode, Integer> hm = new HashMap<>();
            Stack<TreeNode> st = new Stack<>();

            TreeNode curr = root;
            TreeNode dummy = null;

            do {
                if (hm.getOrDefault(curr, 0) == 0) {
                    hm.put(curr, hm.getOrDefault(curr, 0) + 1);
                    ans.add(curr.val);
                }
                if (curr.left != null) {
                    st.push(curr);
                    dummy = curr.left;
                    curr.left = null;
                    curr = dummy;
                } else if (curr.right != null) {
                    st.push(curr);
                    dummy = curr.right;
                    curr.right = null;
                    curr = dummy;
                } else {
                    curr = st.pop();
                }
            } while ((!st.isEmpty() || (curr.left != null || curr.right != null)));

            System.out.println(ans);
        }

    }

    public static TreeNode treeNode(List<Integer> tnArray) {
        Iterator<Integer> it = tnArray.iterator();
        TreeNode root = new TreeNode(it.next());
        TreeNode curr = root;
        Queue<TreeNode> queue = new LinkedList<>(); //PriorityQueue X
        Integer k;
        boolean leftTurn = true;

        while (it.hasNext()) {
            k = it.next();
            if (curr == null) {
                return null;
            }
            if (leftTurn && curr.left == null) {
                leftTurn = false;
                if (k == null) continue;
                curr.left = new TreeNode(k);
                queue.add(curr.left);
            } else if (!leftTurn && curr.right == null) {
                leftTurn = true;
                if (k == null) {
                    curr = queue.poll();
                    continue;
                }
                curr.right = new TreeNode(k);
                queue.add(curr.right);
                curr = queue.poll();
            } else {
                leftTurn = true;
                curr = queue.poll();
            }
        }
        return root;
    }

    public static TreeNode setTreeNode(List<Integer> tnArray) {
        try {
            return treeNode(tnArray);
        } catch (Exception e) {
            System.out.println("Invalid TreeNode!");
            System.exit(1);
        }
        return null;
    }

    public static void test() {
        List<Integer> list = new ArrayList<>();
        Integer[] li = {5,null,null,4};
//        Integer[] li = {5,null,3,6,2,4,null,8,1,null,null,null,null,7,9};
        list = Arrays.stream(li).toList();
        System.out.println(list);
        TreeNode n = setTreeNode(list);
        n.draw();
    }

    public static void main(String[] args) {
        test();
    }

}
