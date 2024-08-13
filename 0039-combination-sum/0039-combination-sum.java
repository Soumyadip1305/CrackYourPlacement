class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       List<List<Integer>> ans = new ArrayList<>();
        solve(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }

    private static void solve(int ind, int[] candidates, int target, List<List<Integer>> ans, List<Integer> list) {
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (ind == candidates.length || target < 0) {
            return;
        }

        list.add(candidates[ind]);
        solve(ind, candidates, target - candidates[ind], ans, list);
        list.remove(list.size() - 1);

        solve(ind + 1, candidates, target, ans, list);
    }
}