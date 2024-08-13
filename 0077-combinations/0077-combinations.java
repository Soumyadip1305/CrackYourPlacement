class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int[]candidates=new int[n];
        for (int i = 1; i <=n ; i++) {
            candidates[i-1]=i;
        }
        solve(0, candidates, k, ans, new ArrayList<>());
        return ans;
    }

    private static void solve(int ind, int[] candidates, int len, List<List<Integer>> ans, List<Integer> list) {
        if (len == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (ind == candidates.length || len < 0) {
            return;
        }
        list.add(candidates[ind]);
        solve(ind+1, candidates, len -1, ans, list);
        list.remove(list.size() - 1);

        solve(ind + 1, candidates, len, ans, list);
    }
}