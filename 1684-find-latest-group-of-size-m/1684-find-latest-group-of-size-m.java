class Solution {
    static class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int []arr){
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
        public void unionBySize(int u, int v) {
            int ultP_u = findULTPar(u);
            int ultP_v = findULTPar(v);
            if(ultP_u == ultP_v) return;
            if(size.get(ultP_u) < size.get(ultP_v)) {
                parent.set(ultP_u, ultP_v);
                size.set(ultP_v, size.get(ultP_v) + size.get(ultP_u));
            }
            else {
                parent.set(ultP_v, ultP_u);
                size.set(ultP_u, size.get(ultP_u) + size.get(ultP_v));
            }
    }
    public int[] getSize() {
        return size.stream().mapToInt(Integer::intValue).toArray();
    }
    }
    public int findLatestStep(int[] arr, int m) {
      int n = arr.length;
        if (m == n) return n;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        set.add(n + 1);
        
        for (int i = n - 1; i >= 0; --i) {
            int l = set.lower(arr[i]);
            int h = set.higher(arr[i]);
            if (arr[i] - l - 1 == m || h - arr[i] - 1 == m) 
                return i;
            set.add(arr[i]);
        }
        return -1;
    }
}