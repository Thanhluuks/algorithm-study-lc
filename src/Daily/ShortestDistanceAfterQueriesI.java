package Daily;

import java.util.*;

public class ShortestDistanceAfterQueriesI {
    static int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<Integer> answer = new ArrayList<>();
        List<List<Integer>> adjList = new ArrayList<>(n);

        // Initialize the adjacency list for the graph
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Initialize the graph with edges between consecutive nodes
        for (int i = 0; i < n - 1; i++) {
            adjList.get(i).add(i + 1);
        }

        // Process each query to add new roads
        for (int[] road : queries) {
            int u = road[0];
            int v = road[1];
            adjList.get(u).add(v); // Add road from u to v
            // Perform BFS to find the shortest path after adding the new road
            answer.add(myBfs(n, adjList));
        }

        // Convert List<Integer> to int[]
        return answer.stream().mapToInt(i -> i).toArray();
    }

    // Helper function to perform BFS and find the number of edges in the shortest path from node 0 to node n-1
    static int bfs(int n, List<List<Integer>> adjList) {
        boolean[] visited = new boolean[n];
        Queue<Integer> nodeQueue = new LinkedList<>();

        // Start BFS from node 0
        nodeQueue.add(0);
        visited[0] = true;

        // Track the number of nodes in the current layer and the next layer
        int currentLayerNodeCount = 1;
        int nextLayerNodeCount = 0;
        // Initialize layers explored count
        int layersExplored = 0;

        // Perform BFS until the queue is empty
        while (!nodeQueue.isEmpty()) {
            // Process nodes in the current layer
            for (int i = 0; i < currentLayerNodeCount; i++) {
                int currentNode = nodeQueue.poll();

                // Check if we reached the destination node
                if (currentNode == n - 1) {
                    return layersExplored; // Return the number of edges in the shortest path
                }

                // Explore all adjacent nodes
                for (int neighbor : adjList.get(currentNode)) {
                    if (visited[neighbor]) continue;
                    nodeQueue.add(neighbor); // Add neighbor to the queue for exploration
                    nextLayerNodeCount++; // Increment the count of nodes in the next layer
                    visited[neighbor] = true;
                }
            }

            // Move to the next layer
            currentLayerNodeCount = nextLayerNodeCount;
            nextLayerNodeCount = 0; // Reset next layer count
            layersExplored++; // Increment the layer count after processing the current layer
        }

        return -1; // Algorithm will never reach this point
    }

    static int myBfs(int n, List<List<Integer>> adjList) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
//        initial explore from node 0
        queue.add(0);
        visited[0] = true;
        int currentLayerNodes = 1;
        int nextLayerNodes = 0;
        int layerCount = 0;
        int currentNode;
        while (!queue.isEmpty()) {
            for (int i = 0; i < currentLayerNodes; i++) {
                currentNode = queue.poll();
                if (currentNode == n-1) {
                    return layerCount;
                }
                for(int node : adjList.get(currentNode)) {
                    if (visited[node]) continue;
                    visited[node] = true;
                    queue.add(node);
                    nextLayerNodes++;
                }
            }
            currentLayerNodes = nextLayerNodes;
            nextLayerNodes = 0;
            layerCount++;
        }
        return -1;
    }

    static int[] solution(int n, int[][] queries) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            adjList.add(new ArrayList<>());
            adjList.get(i-1).add(i);
        }

        int[] ans = new int[queries.length];
        int index =0;
        for(int[] query : queries) {
            int u = query[0];
            int v = query[1];
            adjList.get(u).add(v);
            ans[index++] = myBfs(n,adjList);
        }

        return ans;
    }
    public static void main(String[] args) {
//        int[][] queries = {{2,4},{0,2},{0,4}};
        int[][] queries = {{0,3},{0,2}};
        System.out.println(Arrays.toString(solution(4, queries)));
    }
}
