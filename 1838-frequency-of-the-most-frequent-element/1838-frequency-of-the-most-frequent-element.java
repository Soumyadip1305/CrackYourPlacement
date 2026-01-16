class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        long sum = 0;
        int i = 0, ans = 0;

        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];

            while ((long) nums[j] * (j - i + 1) - sum > k) {
                sum -= nums[i];
                i++;
            }

            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}