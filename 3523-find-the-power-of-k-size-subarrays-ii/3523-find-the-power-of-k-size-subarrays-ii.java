class Solution {
    public int[] resultsArray(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }
        int[] ans = new int[nums.length + 1 -k];
        Arrays.fill(ans, -1);
        int i = 0;
        int cnt = 1;
        while (i < nums.length -1) {
            if (nums[i + 1] - nums[i] == 1) {
                cnt++;
            } else {
                cnt = 1;
            }
            if (cnt >= k) {
                ans[i - k + 2] = nums[i + 1];
            }
            i++;
        }
        return ans;
    }
}