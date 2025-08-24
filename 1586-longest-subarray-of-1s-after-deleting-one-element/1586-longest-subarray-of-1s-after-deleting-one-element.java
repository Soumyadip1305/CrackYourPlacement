class Solution {
    public int longestSubarray(int[] nums) {
        int low = 0,high = 0,zeroCnt = 0,maxi = 0;

        while (high < nums.length) {
            if (nums[high] == 0) {
                zeroCnt++;
            }

            while (zeroCnt > 1) {
                if (nums[low] == 0) {
                    zeroCnt--;
                }
                low++;
            }

            maxi = Math.max(maxi, high - low);
            high++;
        }

        return maxi;
    }
}