class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        solve(0, nums.length, nums, new ArrayList<>(), list);
        return list;
    }

    private void solve(int ind, int n, int[] nums, List<Integer> list, List<List<Integer>> ans) {
        if (ind == n) {
            ans.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[ind]);
        solve(ind + 1, n, nums, list, ans);
        list.remove(list.size() - 1);
        solve(ind + 1, n, nums, list, ans);       
    }
}