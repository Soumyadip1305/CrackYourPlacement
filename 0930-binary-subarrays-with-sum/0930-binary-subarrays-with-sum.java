class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
       return solve(nums,goal)-solve(nums,goal-1); 
    }
    public static int solve(int[] nums, int goal) {
        if (goal < 0) return 0;

        int i = 0, sum = 0, cnt = 0;

        for (int j = 0; j < nums.length; j++) {

            sum += nums[j];

            while (sum > goal) {
                sum -= nums[i];
                i++;
            }

            cnt += (j - i + 1);
        }
        return cnt;
    }
}