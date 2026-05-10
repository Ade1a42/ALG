// TASK 1
// Graph adjacency:
// A: C, B, D
// B: A, C, E, G
// C: A, B, D
// D: C, A
// E: G, F, B
// F: G, E
// G: F, B

// DFS steps (recursive, start at A)
//1) A -> C
//2) C -> B
//3) B -> E
//4) E -> G
//5) G -> F | back to G |
//6) in G | back to E |
//7) in E | back to B |
//8) in B | back to C |
//9) C -> D
//10) in D | back to C |
//11) in C | back A |
//12) done all visited
//
//DFS order: A, C, B, E, G, F, D

// TASK 2
// Graph adjacency:
// A: C, B, D
// B: A, C, E, G
// C: A, B, D
// D: C, A
// E: G, F, B
// F: G, E
// G: F, B

// BFS steps (queue, start at A)
//1) visit A, enqueue its unvisited neighbors: C, B, D → queue: [C, B, D]
//2) visit C, neighbors A,B,D already visited/in queue → queue: [B, D]
//3) visit B, enqueue E, G → queue: [D, E, G]
//4) visit D, no new neighbors → queue: [E, G]
//5) visit E, enqueue F → queue: [G, F]
//6) visit G, no new neighbors → queue: [F]
//7) visit F, no new neighbors → queue: []
// done all visited
//
//BFS order: A, C, B, D, E, G, F

// TASK 4
// Scottish road network:
// Edinburgh – Stirling : 60
// Stirling – Perth      : 40
// Perth – Dundee        : 50
// Edinburgh – Glasgow   : 70   (Glasgow isolated from the route to Dundee)
//
// Dijkstra's algorithm – start at Edinburgh
// Initial distances: Edinburgh=0, all others=∞
//
// 1) Pick Edinburgh (0). Update neighbours:
//    Stirling: 0+60=60 < ∞ → set 60
//    Glasgow:  0+70=70 < ∞ → set 70
//    Visited: Edinburgh
//
// 2) Pick smallest unvisited: Stirling (60). Update its neighbours:
//    Perth: 60+40=100 < ∞ → set 100
//    Edinburgh already visited → skip
//    Visited: Edinburgh, Stirling
//
// 3) Pick smallest unvisited: Glasgow (70). Update its neighbours:
//    Only Edinburgh (visited) → no change
//    Visited: Edinburgh, Stirling, Glasgow
//
// 4) Pick smallest unvisited: Perth (100). Update its neighbours:
//    Dundee: 100+50=150 < ∞ → set 150
//    Visited: Edinburgh, Stirling, Glasgow, Perth
//
// 5) Pick smallest unvisited: Dundee (150). Destination reached.
//
// Shortest path (trace back):
//    Dundee ← Perth ← Stirling ← Edinburgh
// Total distance: 150 miles

package assignment4;

import java.util.*;

public class main4 {
    public static void main(String[] args) {
        String[] labels = {"A", "B", "C", "D", "E", "F", "G"};
        Graph1 g = new Graph1(labels);

        g.addEdge("A", "C");
        g.addEdge("A", "B");
        g.addEdge("A", "D");

        g.addEdge("B", "A");
        g.addEdge("B", "C");
        g.addEdge("B", "E");
        g.addEdge("B", "G");

        g.addEdge("C", "A");
        g.addEdge("C", "B");
        g.addEdge("C", "D");

        g.addEdge("D", "C");
        g.addEdge("D", "A");

        g.addEdge("E", "G");
        g.addEdge("E", "F");
        g.addEdge("E", "B");

        g.addEdge("F", "G");
        g.addEdge("F", "E");

        g.addEdge("G", "F");
        g.addEdge("G", "B");



        System.out.println("DFS from A: " + g.dfs("A"));
        System.out.println("BFS from A: " + g.bfs("A"));




//        ------------------------------------
        WeightedGraph roads = new WeightedGraph();
        roads.addEdge("Edinburgh", "Stirling", 60);
        roads.addEdge("Stirling", "Perth", 40);
        roads.addEdge("Perth", "Dundee", 50);
        roads.addEdge("Edinburgh", "Glasgow", 70);

        roads.dijkstra("Edinburgh", "Dundee");
    }
}
