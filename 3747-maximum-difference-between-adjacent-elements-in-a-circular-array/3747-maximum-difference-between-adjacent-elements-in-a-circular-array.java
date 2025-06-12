class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        if (n == 2) return Math.abs(nums[0] - nums[1]);
        if (n == 3) {
            return Math.max(Math.max(Math.abs(nums[0] - nums[1]), 
                                     Math.abs(nums[1] - nums[2])), 
                            Math.abs(nums[2] - nums[0]));
        }
        int maxDiff = Math.abs(nums[n - 1] - nums[0]);
        for (int i = 1; i < n; i++) {
            maxDiff = Math.max(maxDiff, Math.abs(nums[i] - nums[i - 1]));
        }
        return maxDiff;
    }
}
