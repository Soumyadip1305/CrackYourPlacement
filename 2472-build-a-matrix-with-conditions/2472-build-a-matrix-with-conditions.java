class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
       int[][] matrix = new int[k][k];
        List<List<Integer>> rowGraph = new ArrayList<>();
        List<List<Integer>> colGraph = new ArrayList<>();

        for (int i = 0; i <= k; i++) {
            rowGraph.add(new ArrayList<>());
            colGraph.add(new ArrayList<>());
        }

        int[] rowInDeg = new int[k + 1];
        int[] colInDeg = new int[k + 1];

        for (int[] it : rowConditions) {
            rowGraph.get(it[0]).add(it[1]);
            rowInDeg[it[1]]++;
        }

        for (int[] it : colConditions) {
            colGraph.get(it[0]).add(it[1]);
            colInDeg[it[1]]++;
        }

        List<Integer> rows = topologicalSort(rowGraph, rowInDeg, k);
        List<Integer> columns = topologicalSort(colGraph, colInDeg, k);

        if (rows.size() < k || columns.size() < k) {
            return new int[0][0];
        }

        int[] rowPos = new int[k + 1];
        int[] colPos = new int[k + 1];

        for (int i = 0; i < k; i++) {
            rowPos[rows.get(i)] = i;
            colPos[columns.get(i)] = i;
        }

        for (int i = 1; i <= k; i++) {
            matrix[rowPos[i]][colPos[i]] = i;
        }
        return matrix;
    }

    private static List<Integer> topologicalSort(List<List<Integer>> adj, int[] inDeg, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= k; i++) {
            if (inDeg[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> topo = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topo.add(node);
            for (int it : adj.get(node)) {
                inDeg[it]--;
                if (inDeg[it] == 0) {
                    queue.add(it);
                }
            }
        }

        return topo; 
    }
}