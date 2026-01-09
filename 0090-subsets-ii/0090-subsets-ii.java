class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
         List<List<Integer>> list = new ArrayList<>();
        //List<List<Integer>> set = new ArrayList<>();
        Arrays.sort(nums);
        solve(0, nums, new ArrayList<>(), list);
        return list;
    }

    private static void solve(int ind, int[] nums, List<Integer> list, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(list));
        for (int i = ind; i < nums.length; i++) {
            if (i > ind && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            solve(i + 1, nums, list, ans);
            list.remove(list.size() - 1);
            //solve(i + 1, n, nums, list, ans);
    }
    }
}