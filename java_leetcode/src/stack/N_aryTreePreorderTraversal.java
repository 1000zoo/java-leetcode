//https://leetcode.com/problems/n-ary-tree-preorder-traversal/
//2022-08-29

package stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class N_aryTreePreorderTraversal {
    public class Node {
        public int val;
        public List<Node> children;

        public Node(){}

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, List<Node> children) {
            this.children = children;
        }
    }
//----------------------------------------------------------------------------------------------------
//Runtime: 2 ms, faster than 59.03% of Java online submissions for N-ary Tree Preorder Traversal.
//Memory Usage: 46.5 MB, less than 20.59% of Java online submissions for N-ary Tree Preorder Traversal.
    public List<Integer> solution1(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        if (root.children.isEmpty()) {
            ans.add(root.val);
            return ans;
        }
        ans = recursive(root, ans);
        ans.add(root.val);
        return ans;
    }
    public List<Integer> recursive(Node root, List<Integer> ans) {
        for (Node child : root.children) {
            ans.add(child.val);
            ans = recursive(child, ans);
        }
        return ans;
    }

    //----------------------------------------------------------------------------------------------------
    //Stack
    //Runtime: 6 ms, faster than 11.51% of Java online submissions for N-ary Tree Preorder Traversal.
    //Memory Usage: 46.6 MB, less than 20.59% of Java online submissions for N-ary Tree Preorder Traversal.
    public List<Integer> solution2(Node root) {
        List<Integer> ans = new ArrayList<>();
        List<Node> temp;
        if (root == null) return ans;
        if (root.children.isEmpty()) {
            ans.add(root.val);
            return ans;
        }

        Stack<Node> st = new Stack<>(){{push(root);}};
        Node curr;

        while (!st.isEmpty()) {
            curr = st.pop();
            ans.add(curr.val);

            temp = curr.children;
            Collections.reverse(temp);

            for (Node c : temp) {
                st.push(c);
            }
        }
        return ans;
    }

    //----------------------------------------------------------------------------------------------------
    //https://leetcode.com/problems/n-ary-tree-preorder-traversal/discuss/2498717/Java-or-0ms-or-100-Faster-or-Simple-DFS
    //Runtime: 2 ms, faster than 59.03% of Java online submissions for N-ary Tree Preorder Traversal.
    //Memory Usage: 46.2 MB, less than 39.73% of Java online submissions for N-ary Tree Preorder Traversal.
    public List<Integer> solution3(Node root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }

    public void dfs(Node root, List<Integer> ans) {
        if (root == null) return;
        ans.add(root.val);

        for (Node node : root.children) {
            dfs(node, ans);
        }
    }

}
