package main.java.graph;

public class GraphEdge {

    private GraphVertex from;
    private GraphVertex to;
    private int weight;

    public GraphEdge(GraphVertex from, GraphVertex to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public GraphVertex getFrom() {
        return from;
    }

    public GraphVertex getTo() {
        return to;
    }

    public int getWeight() {
        return weight;
    }
}
