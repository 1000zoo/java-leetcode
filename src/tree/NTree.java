package tree;

import java.util.*;

// N-ary Tree 관련 문제를 위한 클래스

public class NTree {
    public int val;
    public List<NTree> children;

    public NTree() {}

    public NTree(int _val) {
        val = _val;
    }

    public NTree(int _val, List<NTree> _children) {
        val = _val;
        children = _children;
    }

    public NTree(List<Integer> list) {
        if (list.size() == 0) {
            return;
        }
        NTree curr = this;
        Queue<NTree> q = new LinkedList<>();
        List<NTree> temp = new ArrayList<>();
        for (Integer i : list) {
            if (i == null) {
                if (curr == null) {
                    return;
                }
                curr.children = temp;
                q.addAll(curr.children);
                temp = new ArrayList<>();
                curr = q.poll();
                continue;
            }
            temp.add(new NTree(i));
        }
        if (curr == null) {
            return;
        }
        curr.children = temp;
        q.addAll(curr.children);
    }
}
