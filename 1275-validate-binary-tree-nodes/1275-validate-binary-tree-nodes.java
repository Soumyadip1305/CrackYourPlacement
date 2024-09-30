class Solution {
    static class DisjointSet {
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        public DisjointSet(int n) {
            for (int i = 0; i < n; i++) {
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

        public boolean unionBySize(int u, int v) {
            int ultP_u = findULTPar(u);
            int ultP_v = findULTPar(v);
            if (ultP_u == ultP_v) return false;
            if (size.get(ultP_u) < size.get(ultP_v)) {
                parent.set(ultP_u, ultP_v);
                size.set(ultP_v, size.get(ultP_v) + size.get(ultP_u));
            } else {
                parent.set(ultP_v, ultP_u);
                size.set(ultP_u, size.get(ultP_u) + size.get(ultP_v));
            }
            return true;
        }

        public boolean isValid() {
            int cntRoot = 0;
            for (int i = 0; i < parent.size(); i++) {
                if (parent.get(i) == i) {
                    cntRoot++;
                }
            }
            return cntRoot == 1;
        }
    }

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        DisjointSet ds = new DisjointSet(n);
        boolean[] hasParent = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                if (!ds.unionBySize(i, leftChild[i])) {
                    return false;
                }
                hasParent[leftChild[i]] = true;
            }
            if (rightChild[i] != -1) {
                if (!ds.unionBySize(i, rightChild[i])) {
                    return false;
                }
                hasParent[rightChild[i]] = true;
            }
        }

        int cnt = 0;
        for (boolean parent : hasParent) {
            if (!parent) cnt++;
        }

        return cnt == 1 && ds.isValid();
    }
}