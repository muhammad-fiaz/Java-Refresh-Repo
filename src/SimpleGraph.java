import java.util.*;

public class SimpleGraph {

    // Graph representation using an adjacency list
    private Map<Integer, List<Integer>> adjList;

    public SimpleGraph() {
        adjList = new HashMap<>();
    }

    // Add a vertex to the graph
    public void addVertex(int vertex) {
        adjList.putIfAbsent(vertex, new ArrayList<>());
    }

    // Add an edge to the graph (undirected)
    public void addEdge(int src, int dest) {
        adjList.putIfAbsent(src, new ArrayList<>());
        adjList.putIfAbsent(dest, new ArrayList<>());
        adjList.get(src).add(dest);
        adjList.get(dest).add(src);
    }

    // Perform Depth-First Search (DFS)
    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        dfsUtil(start, visited);
    }

    private void dfsUtil(int vertex, Set<Integer> visited) {
        visited.add(vertex);
        System.out.print(vertex + " ");
        for (int neighbor : adjList.get(vertex)) {
            if (!visited.contains(neighbor)) {
                dfsUtil(neighbor, visited);
            }
        }
    }

    // Perform Breadth-First Search (BFS)
    public void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");
            for (int neighbor : adjList.get(vertex)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    // Print the graph (adjacency list representation)
    public void printGraph() {
        for (Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            for (Integer neighbor : entry.getValue()) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SimpleGraph graph = new SimpleGraph();

        // Add vertices
        graph.addVertex(1); // Adds vertex 1
        graph.addVertex(2); // Adds vertex 2
        graph.addVertex(3); // Adds vertex 3
        graph.addVertex(4); // Adds vertex 4
        graph.addVertex(5); // Adds vertex 5

        // Add edges
        graph.addEdge(1, 2); // Adds edge between 1 and 2
        graph.addEdge(1, 3); // Adds edge between 1 and 3
        graph.addEdge(2, 4); // Adds edge between 2 and 4
        graph.addEdge(3, 5); // Adds edge between 3 and 5
        graph.addEdge(4, 5); // Adds edge between 4 and 5

        // Print the graph
        System.out.println("Graph Representation (Adjacency List):");
        graph.printGraph();
        // Expected Output:
        // 1 -> 2 3
        // 2 -> 1 4
        // 3 -> 1 5
        // 4 -> 2 5
        // 5 -> 3 4

        // Perform DFS (Depth-First Search)
        System.out.println("\nDFS Traversal starting from vertex 1:");
        graph.dfs(1);
        // Expected Output: 1 2 4 5 3 (DFS explores as deep as possible from vertex 1)

        // Perform BFS (Breadth-First Search)
        System.out.println("\n\nBFS Traversal starting from vertex 1:");
        graph.bfs(1);
        // Expected Output: 1 2 3 4 5 (BFS explores all neighbors level by level)
    }
}
