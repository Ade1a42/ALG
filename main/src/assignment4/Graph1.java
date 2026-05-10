package assignment4;

import java.util.*;

public class Graph1 {
    int V;
    LinkedList<Integer>[] adj;
    String[] labels;
    Map<String, Integer> labelToIndex;

    public Graph1(String[] vertexLabels) {
        V = vertexLabels.length;
        labels = vertexLabels;
        labelToIndex = new HashMap<>();

        adj = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
            labelToIndex.put(labels[i], i);
        }
    }

    public void addEdge(String u, String v) {
        int i = labelToIndex.get(u);
        int j = labelToIndex.get(v);
        adj[i].add(j);
        adj[j].add(i);
    }

    public void printGraph() {
        for (int i = 0; i < V; i++) {
            System.out.print(labels[i] + " -> ");
            for (int w : adj[i]) {
                System.out.print(labels[w] + " ");
            }
            System.out.println();
        }
    }

    // DFS
    private void dfsRec(int v, boolean[] visited, List<String> result) {
        visited[v] = true;
        result.add(labels[v]);
        for (int w : adj[v]) {
            if (!visited[w]) {
                dfsRec(w, visited, result);
            }
        }
    }

    public List<String> dfs(String start) {
        List<String> result = new ArrayList<>();
        boolean[] visited = new boolean[V];
        dfsRec(labelToIndex.get(start), visited, result);
        return result;
    }

    // BFS
    public List<String> bfs(String start) {
        List<String> result = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        int startIdx = labelToIndex.get(start);
        visited[startIdx] = true;
        queue.add(startIdx);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            result.add(labels[v]);
            for (int w : adj[v]) {
                if (!visited[w]) {
                    visited[w] = true;
                    queue.add(w);
                }
            }
        }
        return result;
    }
}