class Solution {
    public int longestSubarray(int[] nums) {
        int maxi = Arrays.stream(nums).max().getAsInt();
        int maxLen = 0, currLen = 0;
        for (int it : nums) {
            if (it == maxi) {
                currLen++;
                maxLen = Math.max(maxLen, currLen);
            } else {
                currLen = 0;
            }
        }

        return maxLen;
    }
}