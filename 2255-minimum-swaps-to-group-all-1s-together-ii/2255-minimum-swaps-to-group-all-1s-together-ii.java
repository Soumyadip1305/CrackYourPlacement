class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int totalOnes = 0;
        for (int num : nums) {
            totalOnes += num;
        }
        if (totalOnes == 0) {
            return 0;
        }
        int curr = 0;
        for (int i = 0; i < totalOnes; i++) {
            curr += nums[i];
        }

        int maxi = curr;
        for (int i = totalOnes; i < n + totalOnes; i++) {
            curr += nums[i % n] - nums[i - totalOnes];
            maxi = Math.max(maxi, curr);
        }

        return totalOnes - maxi;
    }
}