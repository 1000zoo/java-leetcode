//2023-11-24
//https://leetcode.com/problems/most-profitable-path-in-a-tree/description/

package dfs;

import java.util.*;

public class MostProfitablePathInATree {

    private Map<Integer, List<Integer>> graph;
    private Map<Integer, Integer> parentMap;
    private Map<Integer, List<Integer>> tree;
    private Stack<Integer> bobToGo;
    private Stack<Integer> bobPath;
    private Set<Integer> bobVisited;
    private int answer;

    //Runtime: 160ms Beats 23.60%
    //Memory: 149.16MB Beats 5.58%
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        answer = Integer.MIN_VALUE;
        init(edges, bob);
        dfs(0, 0, amount);
        return answer;
    }

    private void dfs(int currNode, int cost, int[] amount) {
        int currAmount = amount[currNode];
        int currBobNode = forward();

        if (currBobNode == currNode) currAmount /= 2;
        else if (bobVisited.contains(currNode)) currAmount = 0;
        cost += currAmount;

        if (isLeafNode(currNode)) {
            answer = Math.max(answer, cost);
            backward();
            return;
        }

        for (int childNode : tree.get(currNode)) {
            dfs(childNode, cost, amount);
        }

        backward();
    }

    private int forward() {
        if (bobToGo.isEmpty()) {
            bobPath.push(-1);
            return - 1;
        }
        int currBobNode = bobToGo.pop();
        bobVisited.add(currBobNode);
        bobPath.push(currBobNode);
        return currBobNode;
    }

    private void backward() {
        if (bobPath.isEmpty()) return;
        int curr = bobPath.pop();
        bobToGo.push(curr);
        bobVisited.remove(curr);
    }

    private boolean isLeafNode(int node) {
        return tree.get(node).isEmpty();
    }

    private void init(int[][] edges, int bob) {
        bobVisited = new HashSet<>();
        initGraph(edges);
        initTree(edges);
        initToGo(bob);
    }

    private void initGraph(int[][] edges) {
        graph = new HashMap<>();

        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            if (!graph.containsKey(node1)) {
                List<Integer> list = new ArrayList<>();
                list.add(node2);
                graph.put(node1, list);
            } else {
                graph.get(node1).add(node2);
            }
            if (!graph.containsKey(node2)) {
                List<Integer> list = new ArrayList<>();
                list.add(node1);
                graph.put(node2, list);
            } else {
                graph.get(node2).add(node1);
            }
        }
    }

    private void initTree(int[][] edges) {
        parentMap = new HashMap<>();
        tree = new HashMap<>();

        setTree(0, -1);
    }

    private void setTree(int curr, int parentNode) {
        parentMap.put(curr, parentNode);
        tree.put(curr, new ArrayList<>());

        for (int nextNode : graph.get(curr)) {
            if (nextNode == parentNode) continue;
            tree.get(curr).add(nextNode);
            setTree(nextNode, curr);
        }
    }

    private void initToGo(int bob) {
        List<Integer> list = new ArrayList<>();
        bobToGo = new Stack<>();
        bobPath = new Stack<>();
        int curr = bob;
        while (curr != -1) {
            list.add(curr);
            curr = parentMap.get(curr);
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            bobToGo.push(list.get(i));
        }
    }
}
