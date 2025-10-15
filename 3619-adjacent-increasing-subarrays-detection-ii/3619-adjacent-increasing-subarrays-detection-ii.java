class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size(), inc = 1, prev = 0, ans = 0;
        for (int i = 1; i < n; ++i) {
            if (nums.get(i) > nums.get(i - 1)) {
                inc++;
            } else {
                prev = inc;
                inc = 1;
            }
            ans = Math.max(ans, Math.max(inc / 2, Math.min(prev, inc)));
        }
        return ans;
    }
}