import java.util.*;

public class GraphTraversal {

    public static void main(String[] args) {
        // Example graph representation using an adjacency list
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(0, 3, 4));
        graph.put(2, Arrays.asList(0, 4));
        graph.put(3, Arrays.asList(1));
        graph.put(4, Arrays.asList(1, 2));

        System.out.println("==== Depth-First Search (DFS) ====");
        dfs(graph, 0);  // DFS starting from vertex 0

        System.out.println("\n==== Breadth-First Search (BFS) ====");
        bfs(graph, 0);  // BFS starting from vertex 0

        System.out.println("\n==== Topological Sort ====");
        Map<Integer, List<Integer>> dag = new HashMap<>();
        dag.put(5, Arrays.asList(2, 0));
        dag.put(4, Arrays.asList(0, 1));
        dag.put(2, Arrays.asList(3));
        dag.put(3, Arrays.asList(1));

        topologicalSort(dag);

        System.out.println("\n==== Dijkstra’s Algorithm ====");
        Map<Integer, Map<Integer, Integer>> weightedGraph = new HashMap<>();
        weightedGraph.put(0, Map.of(1, 2, 2, 4));
        weightedGraph.put(1, Map.of(0, 2, 3, 5));
        weightedGraph.put(2, Map.of(0, 4, 3, 1));
        weightedGraph.put(3, Map.of(1, 5, 2, 1));

        dijkstra(weightedGraph, 0);  // Dijkstra starting from vertex 0

        System.out.println("\n==== Floyd-Warshall Algorithm ====");
        int[][] graphMatrix = {
                {0, 3, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {3, 0, 1, 4},
                {Integer.MAX_VALUE, 1, 0, 2},
                {Integer.MAX_VALUE, 4, 2, 0}
        };
        floydWarshall(graphMatrix);

        System.out.println("\n==== Bellman-Ford Algorithm ====");
        bellmanFord(weightedGraph, 0);  // Bellman-Ford starting from vertex 0

        System.out.println("\n==== Prim’s Algorithm ====");
        primMST(weightedGraph);

        System.out.println("\n==== Kruskal’s Algorithm ====");
        kruskalMST(weightedGraph);
    }

    // ===================== Depth-First Search (DFS) =====================
    public static void dfs(Map<Integer, List<Integer>> graph, int start) {
        Set<Integer> visited = new HashSet<>();
        dfsHelper(graph, start, visited);
    }

    private static void dfsHelper(Map<Integer, List<Integer>> graph, int vertex, Set<Integer> visited) {
        if (visited.contains(vertex)) return;
        visited.add(vertex);
        System.out.print(vertex + " ");
        for (int neighbor : graph.get(vertex)) {
            dfsHelper(graph, neighbor, visited);
        }
    }

    // ===================== Breadth-First Search (BFS) =====================
    public static void bfs(Map<Integer, List<Integer>> graph, int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");
            for (int neighbor : graph.get(vertex)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    // ===================== Topological Sort (For Directed Acyclic Graphs) =====================
    public static void topologicalSort(Map<Integer, List<Integer>> dag) {
        Map<Integer, Integer> inDegree = new HashMap<>();
        for (int vertex : dag.keySet()) {
            inDegree.put(vertex, 0);
        }

        // Calculate in-degrees
        for (List<Integer> neighbors : dag.values()) {
            for (int neighbor : neighbors) {
                inDegree.put(neighbor, inDegree.get(neighbor) + 1);
            }
        }

        // Use a queue to perform topological sort
        Queue<Integer> queue = new LinkedList<>();
        for (int vertex : inDegree.keySet()) {
            if (inDegree.get(vertex) == 0) {
                queue.add(vertex);
            }
        }

        List<Integer> sortedList = new ArrayList<>();
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            sortedList.add(vertex);
            for (int neighbor : dag.get(vertex)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    queue.add(neighbor);
                }
            }
        }

        System.out.println("Topologically Sorted Order: " + sortedList);
    }

    // ===================== Dijkstra’s Algorithm =====================
    public static void dijkstra(Map<Integer, Map<Integer, Integer>> graph, int start) {
        Map<Integer, Integer> distances = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        for (int vertex : graph.keySet()) {
            distances.put(vertex, Integer.MAX_VALUE);
        }
        distances.put(start, 0);
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int vertex = node[0];
            int distance = node[1];

            for (Map.Entry<Integer, Integer> entry : graph.get(vertex).entrySet()) {
                int neighbor = entry.getKey();
                int edgeWeight = entry.getValue();

                if (distance + edgeWeight < distances.get(neighbor)) {
                    distances.put(neighbor, distance + edgeWeight);
                    pq.add(new int[]{neighbor, distances.get(neighbor)});
                }
            }
        }

        System.out.println("Dijkstra’s Shortest Paths: " + distances);
    }

    // ===================== Floyd-Warshall Algorithm =====================
    public static void floydWarshall(int[][] graph) {
        int n = graph.length;

        // Run Floyd-Warshall
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][k] != Integer.MAX_VALUE && graph[k][j] != Integer.MAX_VALUE) {
                        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                    }
                }
            }
        }

        System.out.println("Floyd-Warshall All-Pairs Shortest Paths:");
        for (int[] row : graph) {
            System.out.println(Arrays.toString(row));
        }
    }

    // ===================== Bellman-Ford Algorithm =====================
    public static void bellmanFord(Map<Integer, Map<Integer, Integer>> graph, int start) {
        Map<Integer, Integer> distances = new HashMap<>();
        for (int vertex : graph.keySet()) {
            distances.put(vertex, Integer.MAX_VALUE);
        }
        distances.put(start, 0);

        for (int i = 0; i < graph.size() - 1; i++) {
            for (Map.Entry<Integer, Map<Integer, Integer>> entry : graph.entrySet()) {
                int u = entry.getKey();
                for (Map.Entry<Integer, Integer> edge : entry.getValue().entrySet()) {
                    int v = edge.getKey();
                    int weight = edge.getValue();
                    if (distances.get(u) != Integer.MAX_VALUE && distances.get(u) + weight < distances.get(v)) {
                        distances.put(v, distances.get(u) + weight);
                    }
                }
            }
        }

        System.out.println("Bellman-Ford Shortest Paths: " + distances);
    }

    // ===================== Prim’s Algorithm =====================
    public static void primMST(Map<Integer, Map<Integer, Integer>> graph) {
        Set<Integer> inMST = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int start = graph.keySet().iterator().next();
        inMST.add(start);
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int u = edge[0];
            int weight = edge[1];

            for (Map.Entry<Integer, Integer> entry : graph.get(u).entrySet()) {
                int v = entry.getKey();
                int newWeight = entry.getValue();
                if (!inMST.contains(v)) {
                    inMST.add(v);
                    pq.add(new int[]{v, newWeight});
                    System.out.println("Edge in MST: " + u + " -> " + v + " with weight " + newWeight);
                }
            }
        }
    }

    // ===================== Kruskal’s Algorithm =====================
    public static void kruskalMST(Map<Integer, Map<Integer, Integer>> graph) {
        List<int[]> edges = new ArrayList<>();
        for (Map.Entry<Integer, Map<Integer, Integer>> entry : graph.entrySet()) {
            int u = entry.getKey();
            for (Map.Entry<Integer, Integer> e : entry.getValue().entrySet()) {
                int v = e.getKey();
                int weight = e.getValue();
                edges.add(new int[]{u, v, weight});
            }
        }

        edges.sort(Comparator.comparingInt(a -> a[2]));

        DisjointSetUnion dsu = new DisjointSetUnion(graph.size());
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            if (dsu.find(u) != dsu.find(v)) {
                System.out.println("Edge in MST: " + u + " -> " + v + " with weight " + weight);
                dsu.union(u, v);
            }
        }
    }

    // Disjoint Set Union (DSU) for Kruskal's Algorithm
    static class DisjointSetUnion {
        private final int[] parent;

        public DisjointSetUnion(int n) {
            parent = new int[n];
            Arrays.fill(parent, -1);
        }

        public int find(int x) {
            if (parent[x] == -1) return x;
            return parent[x] = find(parent[x]);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                parent[rootX] = rootY;
            }
        }
    }
}
