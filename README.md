# IPAC-exercise

## Details on implementation

### Classes

1. <b>GraphBase</b>: Base Graph that represents a basic graph with vertices and adjaceny list representation of a Graph
2. <b>GraphVertex</b>: Vertex class to hold the id of each vertex
3. <b>GraphEdge</b>: Vertex class to hold the id of each vertex
4. <b>DirectedAcyclicGraph</b>: An extended class of the GraphBase that contains operations specific to a DAG

### Algorithm

```
Given DAG G and source vertex s
1. Initialize distances[] = {0, MIN, MIN, MIN} for all vertices in G. 0 is for source vertex s
2. DO Topological sort of all vertices
3. FOR EVERY vertex u in topological order
     FOR EVERY adjacent vertex v of u 
        IF (distances[u] + edge_weight(u->v) > distances[v])
            DO distances[v] = distances[u] + edge_weight(u->v)
```
Why Topological sort?
Because having a linear order of vertices where each source vertex with a directed edge comes before its destination vertex,
we have an optimal subproblem to calculate longest distance in order of the traversal.

Referred Stack Overflow thread: https://stackoverflow.com/questions/10712495/longest-path-in-a-dag

## Questions

1. <b>Does the solution work for larger graphs?</b>
- The current solution works for larger graphs as the solution is optimal. I am using an adjacency list representation for graph with a simple depth first search. However, if the size of the graph is too large to fit in the main memory, then this solution may not work. We may have to slightly alter the algorithm to split the graph.

2. <b>Can you think of any optimizations?</b>
- We can alter the algorithm slightly to compute the distances parallely as well as make sure our graphs are small enough to run our operations on main memory. Here's a promising idea to start - 
  - Identify critical vertices in the graph that split it into 2 separate graphs (One way to find critical vertices by backtracking approach)
  - Split the graphs at critical vertices and generate smaller graphs
  - Apply the same algorithm for the smaller graphs and this can even be done <b>parallely</b>
  - Once we calculate distances for the smaller graphs, we can merge our computations since our problem as an optimal subproblem property.

3. <b>What’s the computational complexity of your solution?</b>
- Topological sorting with DFS
  - Time complexity - <b>O(V+E)</b> - Every edge and vertex is visited once
  - Space complexity - <b>O(V)</b> - Recursive backstack call for every vertex and also to store the order
- Longest path
  - Time complexity - <b>O(V+E)</b> - The longest path to each vertex is calculated once for every edge directing to the vertex
  - Space complexity - <b>O(V)</b> - Distance to every vertex is saved in 1 place

4. <b>Are there any unusual cases that aren’t handled?</b>
- The current solution covers basice edge cases for graphs like empty graph, disconnected graphs
- Considering the given prompt is for DAGs I have assumed the given graphs are acyclic by definition. However, it is possible that in real world directed graphs can be cyclic. In that case this solution may run infinitely. For that we can try the following approach
  - Check if graph has cycle, this can be done by a simple dfs or fast-slow pointer approach
  - Identify and remove the cycles, this can be done by a simple dfs or fast-slow pointer approach
  - Removing the cycle should be done carefully to make sure the graph is still connected

5. <b>What are some things you don’t like about Java?</b>
- Verbosity: I like and dislike this at the same time. While the code has good readability, it just takes more time to write/implement solutions
- Concurrency: Thread management in java is still complicated and difficult to use. 

6. <b>If you could choose any language/framework/technology stack, what would you choose and why?</b>
- With the newer Java versions and frameworks like Spring, Java is still a very powerful language to build applications. With Spring support for annotations and dependency injection, the size and verbosity of codebases have reduced. With support for reactive components like Flux, non-blocking concurrent programming is slightly easier
- Another language I would prefer is Kotlin, Kotlin's coroutines and flow APIs are a big win to reactive programming. Kotlin also supports core functional programming concepts like immutability and higher order functions. Kotlin's type inference and null-safety are very good to reduce verbosity. Kotlin is a JVM language, interoperable with Java and almost all major frameworks including Spring also support Kotlin. 