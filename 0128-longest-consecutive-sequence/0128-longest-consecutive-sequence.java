class Solution {
static class DisjointSet {
         List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        public DisjointSet(int n) {
            for (int i = 0; i <= n; i++) {
                parent.add(i);
                size.add(1);
            }
        }

        public int findULTPar(int node) {
            if (node == parent.get(node)) {
                return node;
            }
            int ulp = findULTPar(parent.get(node));
            parent.set(node, ulp);
            return parent.get(node);
        }

        public void unionBySize(int u, int v) {
            int ultP_u = findULTPar(u);
            int ultP_v = findULTPar(v);
            if (ultP_u == ultP_v) return;

            if (size.get(ultP_u) < size.get(ultP_v)) {
                parent.set(ultP_u, ultP_v);
                size.set(ultP_v, size.get(ultP_v) + size.get(ultP_u));
            } else {
                parent.set(ultP_v, ultP_u);
                size.set(ultP_u, size.get(ultP_u) + size.get(ultP_v));
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

        for (int it : map.keySet()) {
            if (map.containsKey(it - 1)) {
                ds.unionBySize(map.get(it), map.get(it - 1));
            }
            if (map.containsKey(it + 1)) {
                ds.unionBySize(map.get(it), map.get(it + 1));
            }
        }

        int[] groups = new int[n];
        for (int it : map.keySet()) {
            ++groups[ds.findULTPar(map.get(it))];
        }

        return Arrays.stream(groups).max().orElse(0);
    }
}