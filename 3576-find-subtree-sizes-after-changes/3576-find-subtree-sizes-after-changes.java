class Solution {
      public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        int[] deg = new int[n];
        for (int i = 1; i<n; i++) {
            deg[parent[i]]++;
        }

        int[] parent2 = new int[n];
        for (int i = 0; i<n; i++) {
            parent2[i] = parent[i];
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i<n; i++) {
            if (deg[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()) {
            int i = q.poll();
            int p = parent[i];
            while (p != -1 && s.charAt(p) != s.charAt(i)) {
                p = parent[p];
            }
            if (p != -1 && s.charAt(p) == s.charAt(i)) {
                parent[i] = p;
            }
            if (parent2[i] != -1) {
                deg[parent2[i]]--;
                if (deg[parent2[i]] <= 0) q.offer(parent2[i]);
            }
        }

        ArrayList[] adj = new ArrayList[n];
        for (int i = 0; i<n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 1; i<n; i++) {
            adj[parent[i]].add(i);
        }

        int[] res = new int[n];
        dfs(res, adj, 0);
       // System.out.println(res);
        return res;
    }

    private int dfs(int[] res, ArrayList<Integer>[] adj, int node) {
        int size = 1;
        for (int neighbor : adj[node]) {
            size += dfs(res, adj, neighbor);
        }
        res[node] = size;
        return size;
    }
}