package main.java.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphBase {

    private List<GraphVertex> vertices;

    private Map<GraphVertex, List<GraphEdge>> adjacencyList;

    public List<GraphVertex> getVertices() {
        return vertices;
    }

    public Map<GraphVertex, List<GraphEdge>> getAdjacencyList() {
        return adjacencyList;
    }


    GraphBase(List<GraphVertex> vertices) {
        this.vertices = vertices;
        adjacencyList = new HashMap<>();
        for (GraphVertex vertex : vertices) {
            adjacencyList.put(vertex, new ArrayList<>());
        }
    }

    public void addEdge(GraphVertex from, GraphVertex to, int weight) {
        List<GraphEdge> edges = adjacencyList.get(from);
        GraphEdge newEdge = new GraphEdge(from, to, weight);
        edges.add(newEdge);
    }
}
