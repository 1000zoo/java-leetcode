//https://leetcode.com/problems/n-ary-tree-postorder-traversal/
//number : 590
//2022-08-24

package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class N_aryTreePostorderTraversal {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    //------------------------------------------------------------------------------------------------------------
    //Runtime: 2 ms, faster than 54.20% of Java online submissions for N-ary Tree Postorder Traversal.
    //Memory Usage: 46.3 MB, less than 41.53% of Java online submissions for N-ary Tree Postorder Traversal.
    public static List<Integer> solution1(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        } else if (root.children.isEmpty()) {
            ans.add(root.val);
            return ans;
        }
        ans = recursive(root, ans);
        ans.add(root.val);
        return ans;
    }

    public static List<Integer> recursive(Node root, List<Integer> ans) {
        for (Node child : root.children) {
            ans = recursive(child, ans);
            ans.add(child.val);
        }
        return ans;
    }
    //------------------------------------------------------------------------------------------------------------

    //Runtime: 8 ms, faster than 6.00% of Java online submissions for N-ary Tree Postorder Traversal.
    //Memory Usage: 46.8 MB, less than 10.94% of Java online submissions for N-ary Tree Postorder Traversal.
    public static List<Integer> solution2(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        } else if (root.children.isEmpty()) {
            ans.add(root.val);
            return ans;
        }
        Stack<Node> st1 = new Stack<>(){{push(root);}};
        Stack<Node> st2 = new Stack<>();

        Node curr = root;

        while (!st1.isEmpty()) {
            curr = st1.pop();
            st2.push(curr);

            for (Node child : curr.children) {
                st1.push(child);
            }
        }

        while (!st2.isEmpty()) {
            ans.add(st2.pop().val);
        }

        return ans;
    }

    public static void main(String[] args) {
    }
}