class Solution {
    public long maximumTripletValue(int[] nums) {
         int n = nums.length;
        long ans = 0;
        int max_i = nums[0];

        for (int j = 1; j < n - 1; j++) {
            int max_k = 0;
            for (int k = j + 1; k < n; k++) {
                max_k = Math.max(max_k, nums[k]);
            }
            ans = Math.max(ans, (long)(max_i - nums[j]) * max_k);
            max_i = Math.max(max_i, nums[j]);
        }

        return ans;
    }
}