class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;
        int[] ltr = new int[n];
        int[] rtl = new int[n];
        Arrays.fill(ltr, 1);
        Arrays.fill(rtl, 1);
        List<Integer> ans = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            if (nums[i - 1] >= nums[i]) {
                ltr[i] = ltr[i - 1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] <= nums[i + 1]) {
                rtl[i] = rtl[i + 1] + 1;
            }
        }

        for (int i = k; i < n - k; i++) {
            if (ltr[i - 1] >= k && rtl[i + 1] >= k) {
                ans.add(i);
            }
        }

        return ans;
    }
}