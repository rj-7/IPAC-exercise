package main.java;

import main.java.graph.DirectedAcyclicGraph;
import main.java.graph.GraphVertex;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {


    public static void printResult(Map<GraphVertex, Integer> distances) {
        for (Map.Entry<GraphVertex, Integer> entry : distances.entrySet()) {
            System.out.println("Longest path distance to vertex " + entry.getKey().getId() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        //Graph 1
        List<GraphVertex> vertices = new ArrayList<>();
        GraphVertex v0 = new GraphVertex(0);
        GraphVertex v1 = new GraphVertex(1);
        GraphVertex v2 = new GraphVertex(2);
        GraphVertex v3 = new GraphVertex(3);
        vertices.add(v0);
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);

        DirectedAcyclicGraph graph = new DirectedAcyclicGraph(vertices);
        graph.addEdge(v0, v1, 5);
        graph.addEdge(v0, v2, 3);
        graph.addEdge(v1, v2, 2);
        graph.addEdge(v1, v3, 6);
        graph.addEdge(v2, v3, 7);

        Map<GraphVertex, Integer> longestPaths = graph.longestPaths(v0);
        printResult(longestPaths);
    }
}
