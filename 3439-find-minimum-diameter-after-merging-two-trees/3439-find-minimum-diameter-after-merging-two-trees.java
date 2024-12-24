class Solution {
    public int getDiameter(int[][] graph, int nodes) {
        return bfs(graph, nodes, bfs(graph, nodes, 0)[0])[1];
    }

    private int[] bfs(int[][] graph, int nodes, int start) {
        int[] dist = new int[nodes];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dist[start] = 0;
        int farNode = start;

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int next : graph[curr]) {
                if (dist[next] == -1) {
                    dist[next] = dist[curr] + 1;
                    q.add(next);
                    if (dist[next] > dist[farNode]) {
                        farNode = next;
                    }
                }
            }
        }
        return new int[]{farNode, dist[farNode]};
    }

    public int minimumDiameterAfterMerge(int[][] tree1, int[][] tree2) {
        int n = tree1.length + 1;
        int m = tree2.length + 1;
        List<List<Integer>> g1 = new ArrayList<>();
        List<List<Integer>> g2 = new ArrayList<>();
        for (int i = 0; i < n; i++) g1.add(new ArrayList<>());
        for (int i = 0; i < m; i++) g2.add(new ArrayList<>());
        for (int[] edge : tree1) {
            g1.get(edge[0]).add(edge[1]);
            g1.get(edge[1]).add(edge[0]);
        }
        for (int[] edge : tree2) {
            g2.get(edge[0]).add(edge[1]);
            g2.get(edge[1]).add(edge[0]);
        }
        int[][] adj1 = convertToAdjArray(g1, n);
        int[][] adj2 = convertToAdjArray(g2, m);
        int d1 = getDiameter(adj1, n);
        int d2 = getDiameter(adj2, m);
return Math.max(d1, Math.max(d2, (d1 + 1) / 2 + (d2 + 1) / 2 + 1));
    }

    private int[][] convertToAdjArray(List<List<Integer>> graph, int nodes) {
        int[][] adj = new int[nodes][];
        for (int i = 0; i < nodes; i++) {
            adj[i] = graph.get(i).stream().mapToInt(Integer::intValue).toArray();
        }
        return adj;
    }
}