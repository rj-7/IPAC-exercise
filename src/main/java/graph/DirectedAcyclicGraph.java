package main.java.graph;

import java.util.*;

public class DirectedAcyclicGraph extends GraphBase {
    public DirectedAcyclicGraph(List<GraphVertex> vertices) {
        super(vertices);
    }


    public Map<GraphVertex, Integer> longestPaths(GraphVertex source) {
        //initialize a data structure to track distances
        Map<GraphVertex, Integer> distances = new HashMap<>();
        //get the topological order of the vertices
        List<GraphVertex> topologicalOrder = topologicalSort();

        //initialize first distances
        for (GraphVertex vertex : getVertices()) {
            distances.put(vertex, Integer.MIN_VALUE);
        }
        distances.put(source, 0);

        //for each vertex in order
        for (GraphVertex vertex : topologicalOrder) {
            //for each edge from the vertex
            for (GraphEdge edge : getAdjacencyList().get(vertex)) {
                //distance to dest vertex = dist from source vertex + edge weight
                int newDistance = distances.get(vertex) + edge.getWeight();
                // update the distance if its higher
                if (newDistance > distances.get(edge.getTo())) {
                    distances.put(edge.getTo(), newDistance);
                }
            }
        }
        return distances;
    }

    private List<GraphVertex> topologicalSort() {
        List<GraphVertex> sortedOrder = new ArrayList<>();
        // set for tracking what vertices were visted
        Set<GraphVertex> visited = new HashSet<>();
        for (GraphVertex v : getVertices()) {
            if (!visited.contains(v)) {
                // A recursive dfs method to traverse through the order
                topologicalSortHelper(v, visited, sortedOrder);
            }
        }
        // After the recursive dfs, we would have a reverse order from backstack, re-reverse it
        Collections.reverse(sortedOrder);
        return sortedOrder;
    }

    private void topologicalSortHelper(GraphVertex vertex,
                                       Set<GraphVertex> visited,
                                       List<GraphVertex> sortedOrder) {
        visited.add(vertex);
        for (GraphEdge e : getAdjacencyList().get(vertex)) {
            if (!visited.contains(e.getTo())) {
                topologicalSortHelper(e.getTo(), visited, sortedOrder);
            }
        }
        sortedOrder.add(vertex);
    }
}
