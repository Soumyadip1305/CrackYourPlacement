class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int sum = 0, ans = 0, i = 0;
        int[] freq = new int[10001];

        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            freq[nums[j]]++;

            while (freq[nums[j]] > 1) {
                freq[nums[i]]--;
                sum -= nums[i];
                i++;
            }

            ans = Math.max(ans, sum);
        }
        return ans;
    }
}