class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(1, 9, n, k, ans, new ArrayList<>());
        return ans;
    }

    private static void solve(int i, int n,int target, int len, List<List<Integer>> ans, List<Integer> list) {
        if (len == 0) {
            if (target==0) {
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        if (i > n || len < 0) {
            return;
        }
        list.add(i);
        solve(i + 1, n, target-i, len - 1, ans, list);
        list.remove(list.size() - 1);

        solve(i + 1, n, target, len, ans, list);
    }
}