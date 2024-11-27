class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            if (i < n - 1) {
                adj.get(i).add(i + 1);
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            adj.get(u).add(v);

            ans[i] = bfs(adj, n);
        }
        return ans;
    }

    private static int bfs(List<List<Integer>> adj, int n) {
        Queue<Integer> queue = new LinkedList<>();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        queue.offer(0);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int it : adj.get(node)) {
                if (dist[node] + 1 < dist[it]) {
                    dist[it] = dist[node] + 1;
                    queue.offer(it);
                }
            }
        }

        return dist[n - 1];
    }
}