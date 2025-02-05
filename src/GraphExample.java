import java.util.*;

public class GraphExample {

    // Representing a graph using an adjacency list
    static class Graph {
        private final Map<Integer, List<Integer>> adjList;

        public Graph() {
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

        // Remove an edge from the graph
        public void removeEdge(int src, int dest) {
            List<Integer> srcList = adjList.get(src);
            List<Integer> destList = adjList.get(dest);

            if (srcList != null) {
                srcList.remove(Integer.valueOf(dest));
            }
            if (destList != null) {
                destList.remove(Integer.valueOf(src));
            }
        }

        // Remove a vertex from the graph
        public void removeVertex(int vertex) {
            adjList.values().forEach(e -> e.remove(Integer.valueOf(vertex)));
            adjList.remove(vertex);
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
    }

    public static void main(String[] args) {
        // Create a graph
        Graph graph = new Graph();

        // Add vertices
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);

        // Add edges
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

        // Print the graph
        System.out.println("Graph Representation (Adjacency List):");
        graph.printGraph();

        // Perform DFS (Depth-First Search)
        System.out.println("\nDFS Traversal starting from vertex 1:");
        graph.dfs(1);

        // Perform BFS (Breadth-First Search)
        System.out.println("\n\nBFS Traversal starting from vertex 1:");
        graph.bfs(1);

        // Remove an edge and print the graph again
        graph.removeEdge(1, 3);
        System.out.println("\n\nGraph after removing edge (1, 3):");
        graph.printGraph();

        // Remove a vertex and print the graph again
        graph.removeVertex(5);
        System.out.println("\n\nGraph after removing vertex 5:");
        graph.printGraph();
    }
}
