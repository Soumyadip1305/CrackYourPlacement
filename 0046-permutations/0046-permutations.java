class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int[] freq = new int[nums.length];
        solve(0, nums, freq, new ArrayList<>(), list);
        return list;
    }

    private static void solve(int ind, int[] nums, int[] freq, List<Integer> list, List<List<Integer>> ans) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (freq[i] != 1) {
                list.add(nums[i]);
                freq[i] = 1;
                solve(i, nums, freq, list, ans);
                freq[i] = 0;
                list.remove(list.size() - 1);
            }
        }
    }
}
