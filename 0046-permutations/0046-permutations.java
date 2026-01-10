class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, nums, ans);
        return ans;
    }

    private static void solve(int ind, int[] nums, List<List<Integer>> ans) {
        if (ind == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int x : nums) list.add(x);
            ans.add(list);
            return;
        }

        for (int i = ind; i < nums.length; i++) {
            swap(nums, ind, i);
            solve(ind + 1, nums, ans);
            swap(nums, ind, i);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}