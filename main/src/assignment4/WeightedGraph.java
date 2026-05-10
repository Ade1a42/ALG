package assignment4;

import java.util.*;

public class WeightedGraph {
    private Map<String, Map<String, Integer>> adj = new LinkedHashMap<>();


    public void addEdge(String u, String v, int weight) {
        adj.putIfAbsent(u, new LinkedHashMap<>());
        adj.putIfAbsent(v, new LinkedHashMap<>());
        adj.get(u).put(v, weight);
        adj.get(v).put(u, weight);
    }


    public Map<String, String> dijkstra(String start, String end) {
        Map<String, Integer> dist = new HashMap<>();
        Map<String, String> prev = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparing(dist::get));
        Set<String> visited = new HashSet<>();

        for (String node : adj.keySet()) {
            dist.put(node, Integer.MAX_VALUE);
        }
        dist.put(start, 0);
        pq.add(start);

        while (!pq.isEmpty()) {
            String u = pq.poll();
            if (!visited.add(u)) continue;
            if (u.equals(end)) break;

            for (Map.Entry<String, Integer> entry : adj.get(u).entrySet()) {
                String v = entry.getKey();
                int weight = entry.getValue();
                if (!visited.contains(v)) {
                    int newDist = dist.get(u) + weight;
                    if (newDist < dist.get(v)) {
                        dist.put(v, newDist);
                        prev.put(v, u);
                        pq.add(v);
                    }
                }
            }
        }

        LinkedList<String> path = new LinkedList<>();
        String at = end;
        while (at != null) {
            path.addFirst(at);
            at = prev.get(at);
        }
        if (!path.getFirst().equals(start)) {
            System.out.println("No path exists.");
            return null;
        }
        System.out.println("Shortest path: " + path + " (distance: " + dist.get(end) + " miles)");
        return prev;
    }
}