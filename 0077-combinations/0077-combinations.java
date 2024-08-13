class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        // int[] candidates = new int[n];
        // for (int i = 1; i <= n; i++) {
        //     candidates[i - 1] = i;
        // }
        solve(1, n, k, ans, new ArrayList<>());
        return ans;
    }

    private static void solve(int i, int n, int len, List<List<Integer>> ans, List<Integer> list) {
        if (len == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (i > n || len < 0) {
            return;
        }
        list.add(i);
        solve(i + 1, n, len - 1, ans, list);
        list.remove(list.size() - 1);

        solve(i + 1, n, len, ans, list);
    }
}