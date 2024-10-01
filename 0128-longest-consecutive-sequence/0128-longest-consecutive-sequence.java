class Solution {
static class DisjointSet {
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        public DisjointSet(int[] arr) {
            for (int j : arr) {
                parent.add(j);
                rank.add(1);
            }
        }

        public DisjointSet(int n) {
            for (int i = 0; i <= n; i++) {
                rank.add(0);
                parent.add(i);
                size.add(1);
            }
        }

        public int findULTPar(int node) {
            if (node == parent.get(node)) {
                return node;
            }
            // Path Compression
            int ulp = findULTPar(parent.get(node));
            parent.set(node, ulp);
            return parent.get(node);
        }

        public void unionByRank(int u, int v) {
            int ultP_u = findULTPar(u);
            int ultP_v = findULTPar(v);
            if (ultP_u == ultP_v) return;
            if (rank.get(ultP_u) < rank.get(ultP_v)) {
                parent.set(ultP_u, ultP_v);
            } else if (rank.get(ultP_v) < rank.get(ultP_u)) {
                parent.set(ultP_v, ultP_u);
            } else {
                parent.set(ultP_v, ultP_u);
                int rankU = rank.get(ultP_u);
                rank.set(ultP_u, rankU + 1);
            }
        }
    }
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            map.put(nums[i], i);
        }

        DisjointSet ds = new DisjointSet(n);

        for (int num : map.keySet()) {
            if (map.containsKey(num - 1)) {
                ds.unionByRank(map.get(num), map.get(num - 1));
            }
            if (map.containsKey(num + 1)) {
                ds.unionByRank(map.get(num), map.get(num + 1));
            }
        }

        int[] groups = new int[n];
        for (int num : map.keySet()) {
            ++groups[ds.findULTPar(map.get(num))];
        }

        return Arrays.stream(groups).max().orElse(0);
    }
}