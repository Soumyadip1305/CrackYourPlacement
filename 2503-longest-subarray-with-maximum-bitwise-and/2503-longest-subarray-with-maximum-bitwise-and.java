class Solution {
    public int longestSubarray(int[] nums) {
        int maxi = Integer.MIN_VALUE, maxLen = 0, curLen = 0;

        for (int num : nums) {
            if (num > maxi) {
                maxi = num;
                maxLen = curLen = 1;
            } else if (num == maxi) {
                curLen++;
                maxLen = Math.max(maxLen, curLen);
            } else {
                curLen = 0;
            }
        }

        return maxLen;
    }
}