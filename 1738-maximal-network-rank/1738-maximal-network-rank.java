class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] inDeg = new int[n];
        boolean[][] isConnected = new boolean[n][n];

        for (int[] road : roads) {
            int u = road[0], v = road[1];
            inDeg[u]++;
            inDeg[v]++;
            // undirected 
            isConnected[u][v] = true;
            isConnected[v][u] = true;
        }

        int maxi = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int rank = inDeg[i] + inDeg[j];
                if (isConnected[i][j]) {
                    rank--;
                }
                maxi = Math.max(maxi, rank);
            }
        }

        return maxi;
    }
}